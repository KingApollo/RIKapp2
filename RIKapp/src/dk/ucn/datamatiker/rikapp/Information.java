package dk.ucn.datamatiker.rikapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
       
        TextView tvWhenBladderQuestion = (TextView)findViewById(R.id.tvWhenBladderQuestion);
        tvWhenBladderQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, WhenInBladder.class);
				startActivity(intent);
			
				
			}
		});
        
        TextView tvDoesItHurtQuestion = (TextView)findViewById(R.id.tvDoesItHurtQuestion);
        tvDoesItHurtQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, DoesItHurt.class);
				startActivity(intent);
			
				
			}
		});
        
        TextView tvHowHandWashQuestion = (TextView)findViewById(R.id.tvHowHandWashQuestion);
        tvHowHandWashQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, HowWashHands.class);
				startActivity(intent);
			
				
			}
		});
        
        TextView tvWhenHandWashQuestion = (TextView)findViewById(R.id.tvWhenHandWashQuestion);
        tvWhenHandWashQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, WhenWashHands.class);
				startActivity(intent);
			
				
			}
		});
        
        TextView tvWhyBloodQuestion = (TextView)findViewById(R.id.tvWhyBloodQuestion);
        tvWhyBloodQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, WhyBlood.class);
				startActivity(intent);
			
				
			}
		});
        
        TextView tvWhenToWashQuestion = (TextView)findViewById(R.id.tvWhenToWashQuestion);
        tvWhenToWashQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, WhenToWash.class);
				startActivity(intent);
			
				
			}
		});
        
        TextView tvWhereToTouchQuestion = (TextView)findViewById(R.id.tvWhereToTouchQuestion);
        tvWhereToTouchQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, WhereToTouch.class);
				startActivity(intent);
			
				
			}
		});
        
        TextView tvWhichSymptomsQuestion = (TextView)findViewById(R.id.tvWhichSymptomsQuestion);
        tvWhichSymptomsQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, WhichSymptoms.class);
				startActivity(intent);
			
				
			}
		});    
    
        TextView tvIfInfectedQuestion = (TextView)findViewById(R.id.tvIfInfectedQuestion);
        tvIfInfectedQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, IfInfected.class);
				startActivity(intent);
			
				
			}
		});
        
        TextView tvAvoidInfectionQuestion = (TextView)findViewById(R.id.tvAvoidInfectionQuestion);
        tvAvoidInfectionQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, AvoidInfection.class);
				startActivity(intent);
			
				
			}
		});

        TextView tvWhenOutQuestion = (TextView)findViewById(R.id.tvWhenOutQuestion);
        tvWhenOutQuestion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Information.this, WhenOut.class);
				startActivity(intent);
			
				
			}
		});

    }
}
