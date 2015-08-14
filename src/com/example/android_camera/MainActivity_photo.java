package com.example.android_camera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity_photo extends Activity {

	private Button button;
	private ImageView view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 去掉信息栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// 去掉标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_photo);
		button = (Button) findViewById(R.id.button1);
		view = (ImageView) findViewById(R.id.imageView1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, 1);
			}
		});
	}

	@SuppressLint("SdCardPath")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {
			String sdStatus = Environment.getExternalStorageState();
			// 检测sd是否可用
			if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
				Log.i("TestFile",
						"SD card is not avaiable/writeable right now.");
				Toast.makeText(MainActivity_photo.this, "sd卡不能使用", 1).show();
				return;
			}
			new DateFormat();
			String name = DateFormat.format("yyyyMMdd_hhmmss",
					Calendar.getInstance(Locale.CHINA))
					+ ".jpg";
			Toast.makeText(this, name, Toast.LENGTH_LONG).show();
			Bundle bundle = data.getExtras();
			// 获取相机返回的数据，并转换为Bitmap图片格式
			Bitmap bitmap = (Bitmap) bundle.get("data");
			FileOutputStream b = null;
			File file = new File("/sdcard/Image/");
			// 创建文件夹
			file.mkdirs();
			String fileName = "/sdcard/Image/" + name;

			try {
				b = new FileOutputStream(fileName);
				// 把数据写入文件
				bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					b.flush();
					b.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				// 将图片显示在ImageView里
				view.setImageBitmap(bitmap);
			} catch (Exception e) {
				Log.e("error", e.getMessage());
			}

		}
	}

}
