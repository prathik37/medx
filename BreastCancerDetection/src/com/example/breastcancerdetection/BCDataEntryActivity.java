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

	EditText[] featureEditText = new EditText[9];

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
			featureEditText[i] = (EditText) findViewById(edTextIds[i]);
	}


	public void onClickSubmitButton(View v) {

		// Call the appropriate class activity based on which 
		// btn was pressed.
		Log.i("det","in onclick");
		Double[] feats = new Double[9];
		for (int i = 0; i<9; i++)
		{	
			Log.i("det",featureEditText[i].getText().toString());
			feats[i] = Double.parseDouble(featureEditText[i].getText().toString());
		}
		Log.i("det","done parsing");
		
		boolean prediction = BreastCancerPrediction.predict(feats);
		Log.i("det","done pred");
		Intent mIntent = new Intent(this, ShowPredictionActivity.class);
		mIntent.putExtra( "prediction", prediction );
		mIntent.putExtra("type", "bc");
		Log.i("main menu","Starting activity");
		Log.i("det","calling intent");
		startActivity(mIntent);
		Log.i("det","done onclick");
	}

}
