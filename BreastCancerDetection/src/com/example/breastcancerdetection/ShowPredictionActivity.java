package com.example.breastcancerdetection;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ShowPredictionActivity extends Activity {

	private boolean prediction;
	private String type; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bc_data_entry);
		prediction = getIntent().getExtras().getBoolean("prediction");
		type = getIntent().getExtras().getString("type");
	}
	
	
	public void onClickMainMenuButton(View v) {
	
		Intent mIntent = new Intent(this, MainActivity.class);
		startActivity(mIntent);
	}
	
	public void onClickSavePatientButton(View v) {
		Intent mIntent = new Intent(this, ShowPredictionActivity.class);
		mIntent.putExtra( "prediction", prediction );
		mIntent.putExtra("type", type);
		Log.i("main menu","Starting activity");
		startActivity(mIntent);
	}
	
}
