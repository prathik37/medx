package com.example.breastcancerdetection;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends ActivityWithMenuBar 
implements android.view.View.OnClickListener{

	private EditText usernameEditText;
	private EditText passwordEditText;
	private Button login;
	private Button clear;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		usernameEditText = (EditText) findViewById(R.id.edTxtUsername);
		passwordEditText = (EditText) findViewById(R.id.edTxtPassword);
		login = (Button)findViewById(R.id.btnLogin);
		clear = (Button)findViewById(R.id.btnClear);
		login.setOnClickListener(this);
		clear.setOnClickListener(this);
	}


	public void onClick(View v)
	{
		// TODO Auto-generated method stub

		switch(v.getId())
		{
		case R.id.btnLogin:
			login();
			break;
		case R.id.btnClear:
			usernameEditText.setText("");
			passwordEditText.setText("");
			break;
		default:
			break;
		}
	}



	private void login() {
		String username = usernameEditText.getText().toString().trim();
		String password = passwordEditText.getText().toString().trim();

		// Validate the log in data
		boolean validationError = false;
		StringBuilder validationErrorMessage = new StringBuilder(getString(R.string.error_intro));
		if (username.length() == 0) {
			validationError = true;
			validationErrorMessage.append(getString(R.string.error_blank_username));
		}
		if (password.length() == 0) {
			if (validationError) {
				validationErrorMessage.append(getString(R.string.error_join));
			}
			validationError = true;
			validationErrorMessage.append(getString(R.string.error_blank_password));
		}
		validationErrorMessage.append(getString(R.string.error_end));

		// If there is a validation error, display the error
		if (validationError) {
			Toast.makeText(LoginActivity.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
			.show();
			return;
		}

		// Set up a progress dialog
		final ProgressDialog dialog = new ProgressDialog(LoginActivity.this);
		dialog.setMessage(getString(R.string.progress_login));
		dialog.show();
		// Call the Parse login method
		ParseUser.logInInBackground(username, password, new LogInCallback() {
			public void done(ParseUser user, ParseException e) {
				dialog.dismiss();
				if (e != null) {
					// Show the error message
					Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
				} else {
					// Start an intent for the mainmenu activity
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(intent);
				}
			}
		});
	}




}



