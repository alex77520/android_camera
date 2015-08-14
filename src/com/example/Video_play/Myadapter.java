package com.example.Video_play;

import java.util.List;

import com.example.android_camera.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("ViewHolder")
public class Myadapter extends BaseAdapter {
	private List<Data> list;
	private Context myContext;
	private LinearLayout layout;

	public Myadapter(Context myContext, List<Data> list) {
		this.myContext = myContext;
		this.list = list;
	}

	@Override
	public int getCount() {

		return list.size();
	}

	@Override
	public Object getItem(int position) {

		return list.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(myContext);
		layout = (LinearLayout) inflater.inflate(R.layout.listviev_item, null);
		TextView tv_title = (TextView) layout.findViewById(R.id.tv_title);
		TextView tv_time = (TextView) layout.findViewById(R.id.tv_time);
		TextView tv_filepath = (TextView) layout.findViewById(R.id.tv_filepath);
		tv_title.setText(list.get(position).getTitle());
		tv_time.setText(list.get(position).getTime());
		tv_filepath.setText(list.get(position).getFilePath());
		return layout;

	}

}
