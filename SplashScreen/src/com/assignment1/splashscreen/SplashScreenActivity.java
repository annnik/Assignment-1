package com.assignment1.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.app.Activity;
import android.content.Intent;

public class SplashScreenActivity extends Activity {
	private long timeOfRealWaiting = 0L;
	private long startingTime = 0L;
	private static final int timeOfWaiting = 2000;
	private final Handler handler = new Handler();
	private Runnable runnableActivityStart = new Runnable() {
		public void run() {
			Intent mInHome = new Intent(SplashScreenActivity.this,
					HomeScreenActivity.class);
			SplashScreenActivity.this.startActivity(mInHome);

			finish();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_splashscreen);

	}

	@Override
	protected void onStop() {
		super.onStop();
		handler.removeCallbacks(runnableActivityStart);
	}

	@Override
	protected void onStart() {
		super.onStart();
		timeOfRealWaiting = timeOfWaiting - (startingTime);
		if (timeOfRealWaiting > 0) {
			handler.postDelayed(runnableActivityStart, timeOfRealWaiting);
		} else
			handler.post(runnableActivityStart);
	}



	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (startingTime == 0L)
			startingTime = SystemClock.uptimeMillis();
		outState.putBoolean("orientationFlag", false);
	}

}