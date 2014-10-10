package dk.ucn.datamatiker.rikapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class Maalinger extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_maalinger);
		
		Button getAll = (Button)findViewById(R.id.getAll);
		getAll.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Button getAll = (Button)findViewById(R.id.getAll);
				getAll.setSelected(true);
				MySQLiteHelper db = new MySQLiteHelper(v.getContext());
				ArrayList<Maaling> mList = new ArrayList<Maaling>();
				mList = db.getAllMaalinger();
				for(int i = 0; i < mList.size(); i++)
				{
					System.out.println("TIME= " + mList.get(i).getTime() + " DATE= " + mList.get(i).getDate());
				}
			}
		});
		
		Button createBtn = (Button)findViewById(R.id.Save_btn);
        createBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView mlInput = (TextView) findViewById(R.id.mlInput);
				if(mlInput.length() > 0)
				{
				SimpleDateFormat df = new SimpleDateFormat("dd/M");
				SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
				Calendar c = Calendar.getInstance();
				MySQLiteHelper db = new MySQLiteHelper(v.getContext());
				String date = df.format(c.getTime());
				String time = tf.format(c.getTime());
				Maaling m = new Maaling(time,date, Integer.parseInt(mlInput.getText().toString()));
				
				db.insertMaaling(m);
				mlInput.setText(null);
				mlInput.clearFocus();
				}
				}
		});
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
