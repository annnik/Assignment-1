package com.assignment1.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

public class SplashScreenActivity extends Activity {
	private long timeOfRealWaiting = 0L;
	private long start = 0L;
	private static final int timeOfWaiting = 2000;
	private boolean orientationFlag = true;
	final Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_splashscreen);
		if (savedInstanceState != null)
			orientationFlag = savedInstanceState.getBoolean("orientationFlag");
		if (orientationFlag) {
			handler.postDelayed(new Runnable() {
				public void run() {
					if (start == 0L)
						start = SystemClock.uptimeMillis();
					Intent mInHome = new Intent(SplashScreenActivity.this,
							HomeScreenActivity.class);
					SplashScreenActivity.this.startActivity(mInHome);

					finish();

				}
			}, timeOfWaiting);
		}
		timeOfRealWaiting = SystemClock.uptimeMillis() - start;
	}

	@Override
	protected void onPause() {
		super.onPause();
		SplashScreenActivity.this.finish();

	}

	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean("orientationFlag", false);
	}

}