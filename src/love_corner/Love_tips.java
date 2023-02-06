package love_corner;

import java.util.ArrayList;
import java.util.HashMap;

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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.valetine.R;
import com.squareup.picasso.Picasso;

public class Love_tips extends Activity {

	JSONObject jsonobject;
	JSONArray jsonarray;
	ListView listview;
	ListViewAdapter adapter;
	ProgressDialog mProgressDialog;
	ArrayList<HashMap<String, String>> arraylist;
	private RequestQueue requestQueue;
	static String ID  = "id";
	static String PERSON  = "person";
	static String CONTENT  = "content";
	static String FLAG = "flag";	
	
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.love_tips);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setTitle("LOVE TIPS");
		requestQueue = Volley.newRequestQueue(getApplication());

		fextdata();
	    loadlist();
		
	}
	
	

	public void fextdata() {
		
		// Create an array
		arraylist = new ArrayList<HashMap<String, String>>();
		
		
	
		
JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, Constants.LOVE_TIPS, null,
	                new Response.Listener<JSONObject>() {
	                    @Override
	                    public void onResponse(JSONObject response) {
	 
	                        try{
	 
	                            JSONArray jsonarray = response.getJSONArray("love");
	                            
	                            Log.d("Error  jsonarray",response+"");
	 
	                            for(int i=0; i < jsonarray.length(); i++){
	                            HashMap<String, String> map = new HashMap<String, String>();
	                            	response = jsonarray.getJSONObject(i);
	                               map.put("id", response.getString("id"));
	           					map.put("person", response.getString("aurthor"));
	           					map.put("content", response.getString("content"));					
	           					
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
		listview = (ListView) findViewById(R.id.listView);
		// Pass the results into ListViewAdapter.java
		adapter = new ListViewAdapter(Love_tips.this, arraylist);
		// Set the adapter to the ListView
		listview.setAdapter(adapter);
		//adapter.notifyDataSetChanged();
		// Close the progressdialog

	}
	
	
	public class ListViewAdapter extends BaseAdapter {

		// Declare Variables
		Context context;
		LayoutInflater inflater;
		ArrayList<HashMap<String, String>> data;
		ImageLoader imageLoader;
		HashMap<String, String> resultp = new HashMap<String, String>();

		public ListViewAdapter(Context context,	ArrayList<HashMap<String, String>> arraylist) {
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
			TextView person;
			TextView content;
			String  id;
			ImageView flag;
			
			
			
			

			inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View itemView = inflater.inflate(R.layout.love_list, parent, false);
			// Get the position
			resultp = data.get(position);

			// Locate the TextViews in listview_item.xml
			person = (TextView) itemView.findViewById(R.id.textView1);
			content = (TextView) itemView.findViewById(R.id.textView2);			
			flag = (ImageView) itemView.findViewById(R.id.flag);
			
			// Capture position and set results to the TextViews
			person.setText(resultp.get(Love_tips.PERSON));			
			content.setText(resultp.get(Love_tips.CONTENT));
			
			
			id=resultp.get(Love_tips.ID);
			
			Log.d("image", id);
			// Capture position and set results to the ImageView
			// Passes flag images URL into ImageLoader.class
//imageLoader.DisplayImage(resultp.get(Love_tips.FLAG), flag);
			// Capture ListView item click
			
			//  load image url
			
			Picasso.with(getApplicationContext())
		     .load("YOUR IMAGE URL HERE")        
		     .placeholder(R.drawable.lovetips)   // optional        
		     .error(R.drawable.lovetips)      // optional        
		     .resize(250, 200)                        // optional        
		     .rotate(90)                             // optional        
		     .into(flag);
			
			itemView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// Get the position
					resultp = data.get(position);
					
					Intent intent = new Intent(context, Love_Read.class);
					
					intent.putExtra("id",resultp.get(Love_tips.ID));
					
					intent.putExtra("author", resultp.get(Love_tips.PERSON));
				
					intent.putExtra("content", resultp.get(Love_tips.CONTENT));
				
					
					// Pass all data flag
					//intent.putExtra("flag", resultp.get(Love_tips.FLAG));
					// Start SingleItemView Class
					
					//Log.d("image", resultp.get(Love_tips.FLAG));
					context.startActivity(intent);

				}
			});
			return itemView;
		}
	}

	
	
}
