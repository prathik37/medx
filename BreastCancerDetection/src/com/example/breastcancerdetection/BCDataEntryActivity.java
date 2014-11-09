package com.example.breastcancerdetection;


import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class BCDataEntryActivity extends Activity{

	List<EditText> featureEditText = new ArrayList<EditText>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bc_data_entry);
		
		Integer[] edTextIds = {R.id.bc_entry_edit_text_field1,
				R.id.bc_entry_edit_text_field2,
				R.id.bc_entry_edit_text_field3,
				R.id.bc_entry_edit_text_field4,
				R.id.bc_entry_edit_text_field5,
				R.id.bc_entry_edit_text_field6,
				R.id.bc_entry_edit_text_field7,
				R.id.bc_entry_edit_text_field8,
				R.id.bc_entry_edit_text_field9};
		
		for (int i = 0; i<9; i++)
			featureEditText.add((EditText) findViewById(edTextIds[i]));
	}


	public void onClickSubmitButton(View v) {

		// Call the appropriate class activity based on which 
		// btn was pressed.
		Double[] feats = new Double[9];
		for (int i = 0; i<9; i++)
			feats[i] = Double.parseDouble(featureEditText.get(i).toString());
		boolean prediction = BreastCancerPrediction.predict(feats);
		Intent mIntent = new Intent(this, ShowPredictionActivity.class);
		mIntent.putExtra( "prediction", prediction );
		mIntent.putExtra("type", "bc");
		Log.i("main menu","Starting activity");
		startActivity(mIntent);
	}
}
