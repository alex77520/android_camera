package com.example.Video_play;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.android_camera.R;

public class MainActivity_video extends Activity implements OnClickListener {

	private Button bt_gaoqing;
	private Button bt_biaoqing;
	private Button bt_play;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_video);
		bt_gaoqing = (Button) findViewById(R.id.bt_gaoqing);
		bt_biaoqing = (Button) findViewById(R.id.bt_biaoqing);
		bt_play = (Button) findViewById(R.id.bt_play);
		bt_gaoqing.setOnClickListener(this);
		bt_biaoqing.setOnClickListener(this);
		bt_play.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.bt_gaoqing:
			Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
			// 限制时长 s
			intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 50);
			// 限制大小
			intent.putExtra(MediaStore.EXTRA_SIZE_LIMIT, 1024 * 1024);
			// 设置质量
			intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
			// 设置输出位置
			// intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);--
			startActivityForResult(intent, 11);
			break;
		case R.id.bt_biaoqing:
			Intent intent1 = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
			// 限制时长 s
			intent1.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 50);
			// 限制大小
			intent1.putExtra(MediaStore.EXTRA_SIZE_LIMIT, 320*240);
			// 设置质量
			intent1.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
			// 设置输出位置
			// intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
			startActivityForResult(intent1, 11);
			break;
		case R.id.bt_play:
			Intent intent2 = new Intent(MainActivity_video.this,
					PlayVideo.class);
			startActivity(intent2);
			break;

		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

	}

}
