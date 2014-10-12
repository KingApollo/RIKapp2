package dk.ucn.datamatiker.rikapp;

import dk.ucn.datamatiker.rikapp.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_avoid_infection);
		
		VideoView vid = (VideoView) findViewById(R.id.stepVideo);
		vid.setVideoPath("/res/raw/rik_film.MP4");
		vid.setMediaController(new MediaController(this));
	}
}
