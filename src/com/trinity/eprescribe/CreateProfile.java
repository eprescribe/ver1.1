package com.trinity.eprescribe;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hope.hopeuni.R;

public class CreateProfile extends Activity {
	Button bNext;
	EditText userName, age, dementia, disorder, sex, stroke, education,
			language;
	String userNameStr, ageStr, dementiaStr, disorderStr, sexStr, strokeStr,
			educationStr, languageStr;
	String filename = "UserSaved";
	SharedPreferences userData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_profile);
		getTextViewReferences();
		getStringsFromFields();
		setNextButtonListener();
	}

	private void getTextViewReferences() {
		userName = (EditText) findViewById(R.id.etUsername);
		age = (EditText) findViewById(R.id.etAge);
		dementia = (EditText) findViewById(R.id.etDementia);
		disorder = (EditText) findViewById(R.id.etPsych);
		sex = (EditText) findViewById(R.id.etSex);
		stroke = (EditText) findViewById(R.id.etStroke);
		education = (EditText) findViewById(R.id.etEducation);
		language = (EditText) findViewById(R.id.etLanguage);
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

	private void setNextButtonListener() {
		bNext = (Button) findViewById(R.id.bNext);
		bNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				saveUser();
				Intent openTestActivity = new Intent(
						"com.trinity.eprescribe.LogIn");
				startActivity(openTestActivity);
			}
		});
	}

	private void saveUser() {
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
