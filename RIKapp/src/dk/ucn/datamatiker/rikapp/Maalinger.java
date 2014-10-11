package dk.ucn.datamatiker.rikapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Maalinger extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_maalinger);
		
		Button createBtn = (Button)findViewById(R.id.Save_btn);
        createBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView mlInput = (TextView) findViewById(R.id.mlInput);
				TextView noteInput = (TextView) findViewById(R.id.noteInput);
				if(mlInput.length() > 0)
				{
				SimpleDateFormat df = new SimpleDateFormat("dd/M");
				SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
				Calendar c = Calendar.getInstance();
				MySQLiteHelper db = new MySQLiteHelper(v.getContext());
				String date = df.format(c.getTime());
				String time = tf.format(c.getTime());
				String note = noteInput.getText().toString().trim();
				Maaling m = new Maaling(time,date, Integer.parseInt(mlInput.getText().toString()),note);
				
				db.insertMaaling(m);
				mlInput.setText(null);
				mlInput.clearFocus();
				noteInput.setText(null);
				noteInput.clearFocus();
				
				//KUN FOR TEST SKAL SLETTES!!!!
				ArrayList<Maaling> testList = db.getAllMaalinger();
				System.out.println(testList.get(testList.size() -1).getDate() + " kl " + testList.get(testList.size() -1).getTime() + " note " + testList.get(testList.size() -1).getNote());
				//HER TIL!!
				
				Context context = getApplicationContext();
				CharSequence text = "Måling for " + m.getDate() + " kl" + m.getTime() +" er logget";
				int duration = Toast.LENGTH_LONG;
				
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				finish();
				}else{
					String needMLInput = "FEJL: Intast ML";
					Toast toast = Toast.makeText(getApplicationContext(), needMLInput, Toast.LENGTH_LONG);
					toast.show();
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
