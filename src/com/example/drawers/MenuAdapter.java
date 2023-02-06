package com.example.drawers;

import java.util.ArrayList;

import com.example.valetine.R;
import com.example.valetine.R.id;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends ArrayAdapter<MenuItem> {

	private ArrayList<MenuItem> menuItemList;
	int layout;
	LayoutInflater inflater;
	
	

	
	public MenuAdapter(Context mContext,int resource,ArrayList<MenuItem> menuItemList){
		super(mContext,resource,menuItemList);
		
		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.menuItemList = menuItemList;
		this.layout = resource;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		
		System.out.println("REACHED HERE");
		
		
		if(convertView == null){
			holder = new ViewHolder();
			convertView = inflater.inflate(layout, parent,false);
			holder.icon = (ImageView)convertView.findViewById(R.id.icon);
			holder.mTitle = (TextView)convertView.findViewById(R.id.title);
			holder.count = (TextView)convertView.findViewById(R.id.counter);
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.mTitle.setText(menuItemList.get(position).getTitle());
		holder.icon.setImageResource(menuItemList.get(position).getIcon());
		if (((MenuItem)this.menuItemList.get(position)).getCounterVisibility())
	    {
			holder.count.setText(((MenuItem)this.menuItemList.get(position)).getCount());
	      return convertView;
	    }
		holder.count.setVisibility(8);
		return convertView;
	}
	
	static class ViewHolder{
		TextView mTitle,count;
		ImageView icon;
		
	}
}
