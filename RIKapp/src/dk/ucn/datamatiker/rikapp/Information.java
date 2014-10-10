package dk.ucn.datamatiker.rikapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Information extends Activity {
	
	
    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        

        
        TextView tvHowOftenQuestion = (TextView)findViewById(R.id.tvHowOftenQuestion);
        tvHowOftenQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, HowOften.class);
				startActivity(intent);
			
				
			}
		});
        
    }
}
