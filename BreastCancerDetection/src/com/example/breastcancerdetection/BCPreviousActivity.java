package com.example.breastcancerdetection;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class BCPreviousActivity extends ActivityWithMenuBar {
	
	private TextView details;
	private final static String PrevPredTable = "PrevPredictions";
	LinkedHashMap<String,String> prevRequests = new LinkedHashMap<String,String>();

	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_previous);
		details = (TextView) findViewById(R.id.textView1);

		ParseQuery<ParseObject> mainQuery = ParseQuery.getQuery(PrevPredTable);
		mainQuery.setLimit(10);
		List<ParseObject> results = null;
		
		try {
			results = mainQuery.find();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TableLayout container1 = (TableLayout) findViewById(R.id.container);
		int i = 0;
		
		for (ParseObject r : results) {
			
			TableRow row= new TableRow(this);
			
	        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
	        row.setLayoutParams(lp);
	        TextView Name = new TextView(this);
			Name.setText(r.getString("Name"));
			Name.setTextSize(20);
			TextView date = new TextView(this);
			date.setText(r.getString("presence"));
			date.setTextSize(20);
			row.addView(Name);
			row.addView(date);
			container1.addView(row,i);
			i++;
	}
	}

}