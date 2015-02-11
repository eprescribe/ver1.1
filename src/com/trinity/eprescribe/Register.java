package com.trinity.eprescribe;

import com.hope.hopeuni.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	EditText userName, age, dementia, disorder, sex, stroke, education,
			language;
	String userNameStr, ageStr, dementiaStr, disorderStr, sexStr, strokeStr,
			educationStr, languageStr;
	Button next;
	String filename = "UserSaved";
	SharedPreferences userData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		getTextViewReferences();
		loadUser();
		setHint();
		getStringsFromFields();
		showToast();
		setNextButton();
	}

	private void showToast() {
		Context context = getApplicationContext();
		CharSequence text = "Please File In All Details";
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
		
	}

	private void getTextViewReferences() {
		userName = (EditText) findViewById(R.id.etedUsername);
		age = (EditText) findViewById(R.id.etedAge);
		dementia = (EditText) findViewById(R.id.etedDementia);
		disorder = (EditText) findViewById(R.id.etedPsych);
		sex = (EditText) findViewById(R.id.etedSex);
		stroke = (EditText) findViewById(R.id.etedStroke);
		education = (EditText) findViewById(R.id.etedEducation);
		language = (EditText) findViewById(R.id.etedLanguage);
	}

	private void loadUser() {
		userData = getSharedPreferences(filename, 0); 
	}

	private void setNextButton() {
		next = (Button) findViewById(R.id.bedSave);
		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				saveUpdatedDetails();
				Intent openChooseProfileActivity = new Intent(
						"com.trinity.eprescribe.ChooseProfile");
				startActivity(openChooseProfileActivity);
			}
		});
	}

	private void setHint() {
		userName.setHint(userData.getString("userName",
				"Please Enter New UserName"));
		age.setHint(userData.getString("userAge", "Please Enter New Age"));
		dementia.setHint(userData
				.getString("userDem", "Please Enter Yes OR No"));
		disorder.setHint(userData
				.getString("userDis", "Please Enter Yes OR No"));
		sex.setHint(userData
				.getString("userSex", "Please Enter Male OR Female"));
		stroke.setHint(userData.getString("userStr", "Please Enter Yes OR No"));
		education.setHint(userData.getString("userEdu",
				"Please Enter Number of Years"));
		language.setHint(userData.getString("userLang",
				"Please Enter Yes OR No"));
	}

	private void getStringsFromFields() {

		userName.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				userNameStr = s.toString();
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});

		age.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				ageStr = s.toString();
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});

		dementia.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				dementiaStr = s.toString();
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});

		disorder.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				disorderStr = s.toString();
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});

		sex.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				sexStr = s.toString();
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});

		stroke.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				strokeStr = s.toString();
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});

		education.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				educationStr = s.toString();
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});
		language.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				languageStr = s.toString();
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});
	}

	private void saveUpdatedDetails() {
		userData = getSharedPreferences(filename, 0); 											
		SharedPreferences.Editor editor = userData.edit();
		editor.putString("userName", userNameStr);
		editor.putString("userAge", ageStr);
		editor.putString("userDem", dementiaStr);
		editor.putString("userDis", disorderStr);
		editor.putString("userSex", sexStr);
		editor.putString("userStr", strokeStr);
		editor.putString("userEdu", educationStr);
		editor.putString("userLang", languageStr);
		editor.commit();

	}

}
