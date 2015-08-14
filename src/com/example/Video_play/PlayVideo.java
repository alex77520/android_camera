package com.example.Video_play;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.android_camera.R;

public class PlayVideo extends Activity {

	private ListView listView;
	private Myadapter myadapter;
	private Cursor cursor;
	private ArrayList<Data> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.playvideo);
		listView = (ListView) findViewById(R.id.listView1);
		init();

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String filepath = list.get(position).getFilePath();
				Intent intent = new Intent(PlayVideo.this, Play.class);
				Bundle bundle = new Bundle();
				bundle.putString("filepath", filepath);
				intent.putExtras(bundle);
				startActivity(intent);

			}
		});
	}

	@SuppressWarnings("deprecation")
	public void init() {

		String[] mediaColumns = new String[] { MediaStore.Video.Media.DATA,
				MediaStore.Video.Media.TITLE, MediaStore.Video.Media.MIME_TYPE };

		// 首先检索SDcard上所有的video
		cursor = this.managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
				mediaColumns, null, null, null);

		list = new ArrayList<Data>();

		if (cursor.moveToFirst()) {
			do {
				Data data = new Data();

				String filepath = cursor.getString(cursor
						.getColumnIndexOrThrow(MediaStore.Video.Media.DATA));
				String time = cursor
						.getString(cursor
								.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE));
				String title = cursor.getString(cursor
						.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE));
				data.setFilePath(filepath);
				data.setTime(time);
				data.setTitle(title);

				list.add(data);

			} while (cursor.moveToNext());
		}

		myadapter = new Myadapter(PlayVideo.this, list);
		listView.setAdapter(myadapter);
	}

}
