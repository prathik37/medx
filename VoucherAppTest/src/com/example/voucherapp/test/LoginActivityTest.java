package com.example.voucherapp.test;

import org.junit.Test;

import junit.framework.TestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.voucherapp.LoginActivity;
import com.example.voucherapp.R;
	
	public class LoginActivityTest extends 
	ActivityInstrumentationTestCase2<LoginActivity> {
		private LoginActivity tLoginActivity;
		private EditText tUsernameText;
		private EditText tPasswordText;
		private Button tlogin;
		private Button tclear;
		String pkg = "com.example.voucherapp";
		
		public LoginActivityTest() {
			super(LoginActivity.class);
		}
		
		 @Override
		    protected void setUp() throws Exception {
		        super.setUp();
		        tLoginActivity = getActivity();
		        tUsernameText = (EditText) tLoginActivity.findViewById(R.id.edTxtUsername);
		        tPasswordText = (EditText) tLoginActivity.findViewById(R.id.edTxtPassword);
		        tlogin = (Button) tLoginActivity.findViewById(R.id.btnLogin);
		        tclear = (Button) tLoginActivity.findViewById(R.id.btnClear);		        
		    }
		 
		 @Test
		 public void testPreconditions() {
			    assertNull("Initially tLoginActivity is null", tLoginActivity);
			    assertNull("Initially tUsername is null", tUsernameText);
			    assertNull("Initially tPassword is null", tPasswordText);
			}
		 
		 @Test
		 public void testFirstTestTextView() {
			    final String expected = "User Name";
			    final String actual = tLoginActivity.getText(0).toString();
			    System.out.println(actual);
			    assertEquals(expected, actual);
			}

		
	}

		