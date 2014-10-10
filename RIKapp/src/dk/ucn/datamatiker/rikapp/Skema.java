package dk.ucn.datamatiker.rikapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Skema extends Activity {
	
	private String newestDate = "";
	private ArrayList<Maaling> maalList = new ArrayList<Maaling>();
	private ArrayList<ArrayList> maalDate = new ArrayList<ArrayList>();
	private ArrayList<Maaling> dbMaalList = new ArrayList<Maaling>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_skema);
		
		Button printAllSkema = (Button)findViewById(R.id.printAllSkema);
        printAllSkema.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				sortAllMaal(); 
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.skema, menu);
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
	
	public void sortAllMaal(){
		
		MySQLiteHelper db = new MySQLiteHelper(getApplicationContext());
		dbMaalList = db.getAllMaalinger();
		for(int i=0;i<dbMaalList.size();i++){
			if(newestDate.equals(dbMaalList.get(i).getDate())){
				
				maalList.add(dbMaalList.get(i));
				
			}else{
				
				maalDate.add(maalList);
				maalList.clear();
				newestDate = dbMaalList.get(i).getDate();
				maalList = new ArrayList<Maaling>();
				maalList.add(dbMaalList.get(i));
				
			}
		}
			
		for(int i = 0; i< maalDate.size(); i++)
		{
		      System.out.println("maalDate idex!! " + i);
		      
		      for(int k = 0; k < maalDate.get(i).size(); k++)
		      {
		           Maaling m = (Maaling) maalDate.get(i).get(k);
		           System.out.println("Målingen blev lavet den " + m.getDate() + " kl " + m.getTime());
		      }
		}
			
		}
		
		
	
	
}
