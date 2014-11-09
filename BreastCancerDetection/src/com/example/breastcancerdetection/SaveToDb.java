package com.example.breastcancerdetection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class SaveToDb extends Activity {
		
		ParseObject po;
		private EditText PatientName;
		private EditText Presence;
		
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_save);
			PatientName = (EditText) findViewById(R.id.editText1);
			Presence = (EditText) findViewById(R.id.editText2);
		}
		
		public void onClickMainMenuButton(View v) {
			try
			{
				po = new ParseObject("PrevPredictions");
				po.put("Name", PatientName.getText().toString());
				po.put("presence", Presence.getText().toString());
				po.save();
				
			}
			catch (ParseException e)
			{			
			}
			
		}
		
}

