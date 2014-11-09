package com.example.breastcancerdetection;

import com.parse.Parse;


public class ParseInitApplication extends android.app.Application {

  public ParseInitApplication() {
  }

  @Override
  public void onCreate() {
    super.onCreate();

	// Initialize the Parse SDK.
    String appId = getResources().getString(R.string.parse_app_id);
    String clientId = getResources().getString(R.string.parse_client_id);
	Parse.initialize(this, appId, clientId); 	
  }
}