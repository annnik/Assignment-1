package com.assignment1.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class SplashScreenActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//getScreenOrientation();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_splashscreen);
		

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(
						"com.example.splash_screen.HomeScreenActivity"));
				
			}
		}, 2000);

		

	}

	

	
}