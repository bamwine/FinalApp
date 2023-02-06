package love_music;

import java.util.ArrayList;
import java.util.HashMap;

import love_corner.Love_tips;
import love_corner.Love_tips.ListViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import app.Constants;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.valetine.R;
import com.squareup.picasso.Picasso;


public class Love_songs extends Activity {
	
private ListView list;
//
JSONObject jsonobject;
JSONArray jsonarray;
//
//ListViewAdapter adapter;
ProgressDialog mProgressDialog;
ArrayList<HashMap<String, String>> arraylist;
//
static String      SPEECHTITLE ="speechTitle";	
static String	    FILEREFERENCE ="fileReference";	
static String 		FLAG  ="flag";
//
//
private Custom_mp4v adapter;
private RequestQueue requestQueue;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.love_tips);
	getActionBar().setDisplayHomeAsUpEnabled(true);
	getActionBar().setHomeButtonEnabled(true);
	getActionBar().setTitle("");
	requestQueue = Volley.newRequestQueue(getApplication());
		
	fextdata();
    loadlist();
    
 }
 
 
public class Custom_mp4v extends  BaseAdapter {
//
	// Declare Variables
	Context context;
	LayoutInflater inflater;
	ArrayList<HashMap<String, String>> data;	
	HashMap<String, String> resultp = new HashMap<String, String>();
//
	public Custom_mp4v(Context context,	ArrayList<HashMap<String, String>> arraylist) {
		this.context = context;
		data = arraylist;
		//imageLoader = new ImageLoader(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@SuppressLint("ViewHolder")
	public View getView(final int position, View convertView, ViewGroup parent) {
		// Declare Variables
		TextView title,fileref;			
		String 	speechdate,filereference,imageview;
		ImageView flag;

		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	View itemView = inflater.inflate(R.layout.tadaptor, parent, false);
		// Get the position
		resultp = data.get(position);

		// Locate the TextViews in listview_item.xml
		title = (TextView) itemView.findViewById(R.id.title);		
		fileref=(TextView) itemView.findViewById(R.id.likes);
		flag = (ImageView) itemView.findViewById(R.id.flag);
		
		
		fileref.setText(resultp.get("fileReference"));
		title.setText(resultp.get("title"));		
		filereference=resultp.get("fileReference");
		
		Picasso.with(getApplication())
	     .load(resultp.get("flag"))        
	     .placeholder(R.drawable.ic_launcher)   // optional        
	     .error(R.drawable.ic_launcher)      // optional        
//	     .resize(250, 200)                        // optional        
//	     .rotate(90)                             // optional        
	     .into(flag);
		
	
		
	

		// Capture ListView item click
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
			resultp = data.get(position);
			Intent intent = new Intent(context, Play_love.class);
//				
				intent.putExtra("title", resultp.get("title"));
//			
				intent.putExtra("fileReference", resultp.get("fileReference"));
				
				intent.putExtra("imageurl", resultp.get("flag"));
			
				// Pass all data flag
			
				context.startActivity(intent);

			}
		});
		return itemView;
	}
}



public void fextdata() {
	
	// Create an array
	arraylist = new ArrayList<HashMap<String, String>>();
	
       
JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, Constants.LOVE_SONGS, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
 
                        try{
 
                            JSONArray jsonarray = response.getJSONArray("mp4");
                            
                            Log.d("Error  jsonarray",response+"");
 
                            for(int i=0; i < jsonarray.length(); i++){
                            	HashMap<String, String> map = new HashMap<String, String>();
                            	response = jsonarray.getJSONObject(i);
                             	
           					
           					map.put("Id", response.getString("id"));
           					
           					map.put("title", response.getString("name"));				
           					map.put("fileReference", Constants.URL_MP4+response.getString("file_name"));
           					map.put("flag", Constants.URL_MP4+response.getString("icon"));
           					
           			     Log.d("image fladg",Constants.URL_MP4+response.getString("icon"));
           					
           					arraylist.add(map);
                            
                            }
                            
                           
                            
 
                            Log.d("Error  jsonarray",arraylist.size()+"");
                        }catch(JSONException e){e.printStackTrace();}
                        
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley","Error");
 
                    }
                }
        );
requestQueue.add(jor);
}


public void loadlist() {
	// Locate the listview in listview_main.xml
			list = (ListView)findViewById(R.id.listView);
			// Pass the results into ListViewAdapter.java
			adapter = new Custom_mp4v(Love_songs.this, arraylist);
			// Set the adapter to the ListView
			list.setAdapter(adapter);

}

}