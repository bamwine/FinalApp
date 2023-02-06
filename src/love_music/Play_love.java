package love_music;


import com.example.valetine.R;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Play_love extends Activity {
	VideoView videoview;
	String	imageurl,title,fileReference;
	TextView titles;
	ImageView imgflag;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);

    	setContentView(R.layout.play_love);
    	 Intent i =getIntent();
    	getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		  title=i.getStringExtra("title");
		getActionBar().setTitle(title);
    	  getActionBar().setIcon(null);
       
        fileReference = i.getStringExtra("fileReference");     
        
        videoview = (VideoView)findViewById(R.id.videoView1); 
       
		
		
		videoview.setVideoPath(fileReference);
		//videoview.setVideoURI(uri);
    	MediaController videocontroller=new MediaController(this);
    	videocontroller.setAnchorView(videoview);
    	//Uri video = Uri.parse(fileReference);
    	videoview.setMediaController(videocontroller);
    	//videoview.setVideoURI(video);
    	
    	
    	videoview.requestFocus();
    	videoview.setOnPreparedListener(new OnPreparedListener() {			
			@Override
			public void onPrepared(MediaPlayer mp) {
				videoview.start();
				
			}
		});
        
       
    }
 
}

