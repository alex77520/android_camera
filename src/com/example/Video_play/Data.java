package com.example.Video_play;

public class Data {
	private String filePath;
	private String time;
	private String title;
	
	
	private Data data;

	public Data(Data data) {
		this.data = data;
	}
	public Data(){
		
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
