package dk.ucn.datamatiker.rikapp;

import dk.ucn.datamatiker.rikapp.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		VideoView vid = (VideoView) findViewById(R.id.stepVideo);
		vid.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.rik_film);
		vid.setMediaController(new MediaController(this));
		vid.requestFocus();
		vid.pause();
	}
}
