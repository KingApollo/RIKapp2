package dk.ucn.datamatiker.rikapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Skema extends Activity {
	
	private String newestDate = "";
	private ArrayList<Maaling> maalList;
	private ArrayList<ArrayList> maalDate = new ArrayList<ArrayList>();
	private ArrayList<Maaling> dbMaalList = new ArrayList<Maaling>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_skema);
		drawTable();
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
	
	public ArrayList<ArrayList> sortAllMaal(){
		
		MySQLiteHelper db = new MySQLiteHelper(getApplicationContext());
		dbMaalList = db.getAllMaalinger();
		for(int i=0;i<dbMaalList.size();i++){
			if(newestDate.equals(dbMaalList.get(i).getDate())){
				
				maalList.add(dbMaalList.get(i));
				
			}else{
				if(maalList != null){
					maalDate.add(maalList);
				}
				maalList = null;
				newestDate = dbMaalList.get(i).getDate();
				maalList = new ArrayList<Maaling>();
				maalList.add(dbMaalList.get(i));
			}
		}
		maalDate.add(maalList);
		
		for(int i = 0; i< maalDate.size(); i++)
		{
			  //System.out.println("Dette er dato nr = " + i);
		      for(int k = 0; k < maalDate.get(i).size(); k++)
		      {
		           Maaling m = (Maaling) maalDate.get(i).get(k);
		           //System.out.println("Målingen blev lavet den " + m.getDate() + " kl " + m.getTime());
		      }
		}
		return this.maalDate;
		}
		
		public void drawTable()
		{
			ArrayList<ArrayList> maalList = sortAllMaal();
			TableLayout tl = (TableLayout) findViewById(R.id.skema_tableView);
			TableRow.LayoutParams pMargin = new TableRow.LayoutParams();
			pMargin.rightMargin = dpToPixel(10,getApplicationContext());
			for(int i = 0; i < maalList.size(); i++)
			{
				//Laver en ny tableRow
				TableRow tr = new TableRow(this);
				tr.setId(100+i);
				tr.setLayoutParams(new LayoutParams(
						LayoutParams.FILL_PARENT,
						LayoutParams.WRAP_CONTENT));
				tr.setPadding(30, 30, 30, 30);
				//Laver hver anden i en anden farve
	            if(i%2 == 0)
	            {
	            tr.setBackgroundColor(Color.parseColor("#E0E9FF"));
	            }else{
	            	tr.setBackgroundColor(Color.parseColor("#AAE2FF"));
	            }
				
				//Laver en ny note der fortæller hvilken dato rækken tilhører
	            Button tv = new Button(this);
	            tv.setId(300+i);
	            Maaling m = (Maaling) maalList.get(i).get(0);
	            tv.setText("D." + m.getDate());
	            tv.setBackgroundColor(Color.parseColor("#80CCFF"));
	            tr.addView(tv, pMargin);
	            
				for(int k = 0; k < maalList.get(i).size(); k++){
					m = (Maaling) maalList.get(i).get(k);
					Button b = new Button(this);
					b.setText("kl " + m.getTime());
					b.setTextColor(Color.BLUE);
					b.setId(200 +i);
					//b.setBackgroundColor(Color.parseColor("#D6EEFF"));
					b.setBackgroundColor(Color.TRANSPARENT);
					b.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							Toast toast = Toast.makeText(getApplicationContext(), "DEN VIRKER!!!", Toast.LENGTH_LONG);
							toast.show();
							
						}
					});
					tr.addView(b,pMargin);
				}
		            tl.addView(tr, new TableLayout.LayoutParams(
		                    LayoutParams.FILL_PARENT,
		                    LayoutParams.WRAP_CONTENT));
		            tl.setContentDescription("Alle målingerne gemt på telefonen");
			}
		}
		
		
		private static Float scale;
		public static int dpToPixel(int dp, Context context) {
		    if (scale == null)
		        scale = context.getResources().getDisplayMetrics().density;
		    return (int) ((float) dp * scale);
		}
	
	
}
