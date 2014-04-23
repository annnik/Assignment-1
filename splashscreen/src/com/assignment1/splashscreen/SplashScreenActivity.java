package com.assignment1.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class SplashScreenActivity extends Activity {
	
	private static final int timeOfWaiting=2000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_splashscreen);
		
 
		final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
               
                Intent mInHome = new Intent(SplashScreenActivity.this, HomeScreenActivity.class);
                SplashScreenActivity.this.startActivity(mInHome);
                
            }
        }, timeOfWaiting);

	}

	

	
}