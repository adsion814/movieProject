package com.mp.bean;

public class VideoBarrage {
	private  String text;
	private  int time;
	private int position;
	private int size;
	private String color;

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "VideoBarrage [text=" + text + ", time=" + time + ", position=" + position + ", size=" + size
				+ ", color=" + color + "]";
	}

	

}
