package com.trinity.eprescribe;

import com.hope.hopeuni.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Options extends Activity {
	Button bEdit, bProfile;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.option);
		update();
	}
	


	private void update() {
		bEdit = (Button) findViewById(R.id.bEdit);
		bProfile = (Button) findViewById(R.id.bProfile);
		bEdit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent openTermsActivity = new Intent("com.trinity.eprescribe.Register");
				startActivity(openTermsActivity);
			}
		});

		bProfile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent openProfile1 = new Intent("com.trinity.eprescribe.LogIn");
				startActivity(openProfile1);
			}
		});
	}

}
