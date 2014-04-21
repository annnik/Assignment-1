package com.example.splash_screen;

//import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
//import android.content.res.Configuration;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	
/*	@Override
	public void onConfigurationChanged(Configuration newConfig) {

		super.onConfigurationChanged(newConfig);
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			setContentView(R.layout.a_main);
	    } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
	    	setContentView(R.layout.a_main);
	    }
		
	}
	private void getScreenOrientation(){    
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
			setContentView(R.layout.a_main);
		else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
			setContentView(R.layout.a_main);
		
	}*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//getScreenOrientation();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_splash);
		

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(
						"com.example.splash_screen.HomeScreenActivity"));
				
			}
		}, 2000);

		

	}

	/**
	 * A placeholder fragment containing a simple view.
	 */

	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

	}

	
}
