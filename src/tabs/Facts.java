package tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.valetine.R;

public class Facts extends Fragment {

	 private ListView list;
	private facts memb;

	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	        View rootView = inflater.inflate(R.layout.tab_listview, container, false);
	        list=(ListView)rootView.findViewById(R.id.listView);
	   		memb = new facts(getActivity());
	   		list.setAdapter(memb);
	   		getActivity().setTitle(null);
	        return rootView;
	    }
	    
	 public class facts extends BaseAdapter{
			
			private Context context;
			
			
			 private String  names[]={
	        		 "It stars with you",
	        		 "Only one female for one man",
	        		 "Goods once sold not returned",
	        		 "One heart for oneself",
	        		 "Love goes for those who seek it",
	        		 "Man eats what he saws",
	        		 "Bye bye"
	        		};
			 
			 private int  icon[]={R.drawable.ic_launcher,R.drawable.ic_launcher,
					 R.drawable.ic_launcher,R.drawable.ic_launcher,
					 R.drawable.ic_launcher,R.drawable.ic_launcher ,R.drawable.ic_launcher,R.drawable.ic_launcher};


			private String sublist[];
			 
			
			  private facts(Context context) {
				super();
				this.context=context;
				sublist =context.getResources().getStringArray(R.array.sublist);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return names.length;
			}

			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return names[arg0];
			}

			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}

			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				// TODO Auto-generated method stub
				
				View rows =null;
				if(arg1==null){
					LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					rows =inflater.inflate(R.layout.tadaptor, arg2,false);
				}
				else{rows=arg1;}
				
				ImageView ima =	(ImageView)rows.findViewById(R.id.flag);
				TextView pos =(TextView)rows.findViewById(R.id.title);
				TextView pos2 =(TextView)rows.findViewById(R.id.likes);
				
					pos.setText(names[arg0]);
					pos2.setText(sublist[arg0]);
					//ima.setImageResource(icon[arg0]);
					ima.setImageResource(R.drawable.facts);	
				
				return rows;
			}
			
	}
	 
}
