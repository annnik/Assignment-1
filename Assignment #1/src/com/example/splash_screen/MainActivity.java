package com.example.splash_screen;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_splash);
		
			
			new Handler().postDelayed(new Runnable() {
	            @Override
	            public void run() {
	            	startActivity(new Intent(
							"com.example.splash_screen.HomeScreenActivity"));
	            	finish();	           
	            }
	        }, 2000);
			
	
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}



	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

	}

}
