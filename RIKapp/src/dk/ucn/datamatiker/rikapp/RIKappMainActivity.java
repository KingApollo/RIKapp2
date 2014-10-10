package dk.ucn.datamatiker.rikapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class RIKappMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rikapp_main);
        
        Button skemaBtn = (Button)findViewById(R.id.skemabtn);
        skemaBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RIKappMainActivity.this, Skema.class);
		    	startActivity(intent);
				
			}
		});
        
        Button maalBtn = (Button)findViewById(R.id.maalbtn);
        maalBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RIKappMainActivity.this, Maalinger.class);
		    	startActivity(intent);
			}
		});
        
        Button hygBtn = (Button)findViewById(R.id.hygbtn);
        hygBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RIKappMainActivity.this, Hyg.class);
		    	startActivity(intent);
			}
		});
        
        Button btnInfo = (Button)findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RIKappMainActivity.this, Information.class);
				startActivity(intent);
			
				
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rikapp_main, menu);
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
