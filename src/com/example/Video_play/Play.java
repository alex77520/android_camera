package com.example.Video_play;

import java.io.File;

import com.example.android_camera.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Play extends Activity {

	private VideoView videoView;
	private String filePath;
	private MediaController controller;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.play);
		videoView = (VideoView) findViewById(R.id.video);

		Intent intent = this.getIntent();
		Bundle bundle = intent.getExtras();
		filePath = bundle.getString("filepath");
		File file = new File(filePath);

		controller = new MediaController(this);
		// Toast.makeText(Play.this, filePath, 1).show();
		if (!file.exists()) {
			Toast.makeText(Play.this, "视频文件路径错误", 1).show();
			return;
		}
		videoView.setVideoPath(file.getAbsolutePath());
		// Toast.makeText(Play.this, file.getAbsolutePath(), 1).show();
		// 让VideoView获取焦点
		videoView.setMediaController(controller);
		controller.setMediaPlayer(videoView);
		videoView.requestFocus();
		videoView.start();

	}
}
