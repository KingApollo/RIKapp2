package dk.ucn.datamatiker.rikapp;

import android.app.Activity;
import android.content.res.Resources;

import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Kontakt extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kontakt);
		
		//setText();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kontakt, menu);
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
	
	public void setText()
	{
		Resources res = getResources();
		String text = String.format(res.getString(R.string.kontakt_text));
		CharSequence styledText = Html.fromHtml(text);
		TextView kontaktTxt = (TextView) findViewById(R.id.kontaktTxt);
		kontaktTxt.setText(styledText);
		
	}
	
}
