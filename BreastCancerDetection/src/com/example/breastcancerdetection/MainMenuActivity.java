package com.example.breastcancerdetection;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.parse.ParseObject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends ActivityWithMenuBar 
				implements android.view.View.OnClickListener{
	
	private List<ButtonAndLink> btnWithLinks = 
					new ArrayList<ButtonAndLink>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		initButtons();
	}
	
	/**
	 * Function to initialize the buttons with listeners and 
	 * updating the btnIds list with the button and the corresponding
	 */
	private void initButtons()
	{	
		Log.i("Tag Init Main Menu Buttons","Button and link initialization");
		btnWithLinks.add(new ButtonAndLink
						(R.id.btnPredictions,BCDataEntryActivity.class));
		btnWithLinks.add(new ButtonAndLink
					(R.id.btnPrevPredictions,BCPreviousActivity.class));
		
		for (ButtonAndLink bl : btnWithLinks){
			Button btnTemp = (Button)findViewById(bl.getId());
			btnTemp.setOnClickListener(this);
		}
		Log.i("Tag End Main Menu Buttons Init","Button and link initialization done");
				
	}

	@Override
	public void onClick(View v) {
		
		// Call the appropriate class activity based on which 
		// btn was pressed.
		int it = 0;
		
		
		for(ButtonAndLink btnId : btnWithLinks){
			System.out.println(btnId.getId());
			++it;
			if(v.getId() == btnId.getId() ){
				Log.i("main menu","btn "+it+" was clicked");
				Intent i=new Intent(this,btnId.getLink() );
				Log.i("main menu","Starting activity");
				startActivity(i);
			}
		}
	}
	
}
