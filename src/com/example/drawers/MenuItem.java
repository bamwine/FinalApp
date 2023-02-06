package com.example.drawers;


public class MenuItem {
	
	private boolean isCounterVisible = false;
	private String count = "0";
	public boolean isCounterVisible() {
		return isCounterVisible;
	}
	public void setCounterVisible(boolean isCounterVisible) {
		this.isCounterVisible = isCounterVisible;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}

	private String title;
	private int icon;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	
	public MenuItem(String title, int icon) {
		super();
		this.title = title;
		this.icon = icon;
	}
	
	public boolean getCounterVisibility()
	{
	  return this.isCounterVisible;
	}
	
	public MenuItem(String title, int icon, boolean paramBoolean, String count)
	{super();
	  this.title = title;
	  this.icon = icon;
	  this.isCounterVisible = paramBoolean;
	  this.count = count;
	}
}
