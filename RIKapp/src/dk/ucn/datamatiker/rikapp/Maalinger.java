package dk.ucn.datamatiker.rikapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.TextView;

public class Maalinger extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maalinger);
		TextView time_display = (TextView) findViewById(R.id.time_display);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
		String weekDay = dayFormat.format(c.getTime());
		SimpleDateFormat df = new SimpleDateFormat("dd/M");
		SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
		String date = df.format(c.getTime());
		String time = tf.format(c.getTime());
		String outputText = "Målling for " + weekDay + " d. " + date + " , kl " + time;
		time_display.setText(outputText);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.maalinger, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
