package com.trinity.eprescribe;

import com.hope.hopeuni.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Terms extends Activity {
	Button bAccept,bDecline;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.terms);
		update();
	}


	private void update() {
		bAccept = (Button) findViewById(R.id.bAccept);
		bAccept.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent openCreateProfileActivity = new Intent("com.trinity.eprescribe.CreateProfile");
				startActivity(openCreateProfileActivity);
			}
		});		
		bDecline = (Button) findViewById(R.id.bDecline);
		bDecline.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();

			}
		});		

	}


}
