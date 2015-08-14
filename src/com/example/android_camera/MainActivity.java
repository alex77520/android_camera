package com.example.android_camera;

import com.example.Video_play.MainActivity_video;
import com.example.android_camera.R;
import com.example.android_camera.R.id;
import com.example.android_camera.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button bt_video;
	private Button bt_photo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		bt_photo = (Button) findViewById(R.id.bt_photo);
		bt_video = (Button) findViewById(R.id.bt_video);
		bt_photo.setOnClickListener(this);
		bt_video.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_photo:
			Intent intent = new Intent(MainActivity.this,
					MainActivity_photo.class);
			startActivity(intent);
			break;
		case R.id.bt_video:
			Intent intent2 = new Intent(MainActivity.this,
					MainActivity_video.class);
			startActivity(intent2);
			break;
		default:
			break;
		}

	}
}
