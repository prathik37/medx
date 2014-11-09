package com.example.breastcancerdetection;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class ActivityWithMenuBar extends ActionBarActivity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		MenuInflater mif=getMenuInflater();
		mif.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		//
		switch(item.getItemId())
		{
		case R.id.ic_action_overflow :
			Intent i=new Intent(this,LoginActivity.class);
			startActivity(i);
			return true;
			//break;
		}

		return super.onOptionsItemSelected(item);
	}


}
