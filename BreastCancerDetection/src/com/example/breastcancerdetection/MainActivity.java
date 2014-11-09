package com.example.breastcancerdetection;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity 
	implements android.view.View.OnClickListener{
	
	private List<ButtonAndLink> btnWithLinks = 
			new ArrayList<ButtonAndLink>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        initButtons();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
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
