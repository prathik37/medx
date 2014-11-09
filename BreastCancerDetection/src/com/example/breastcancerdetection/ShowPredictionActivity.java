package com.example.breastcancerdetection;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ShowPredictionActivity extends Activity {

	private boolean prediction;
	private String type; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prediction);
		prediction = getIntent().getExtras().getBoolean("prediction");
		type = getIntent().getExtras().getString("type");
		TextView tvPred= (TextView)findViewById(R.id.tvPred);
		Log.i("rand", tvPred.toString());
		if (prediction)
			tvPred.setText("Yes");
		else
			tvPred.setText("No");
	}
	
	
	public void onClickMainMenuButton(View v) {
	
		Intent mIntent = new Intent(this, MainActivity.class);
		startActivity(mIntent);
	}
	
	public void onClickSavePatientButton(View v) {
		
		
		Intent mIntent = new Intent(this, SaveToDb.class);
		startActivity(mIntent);
	}
	
}
