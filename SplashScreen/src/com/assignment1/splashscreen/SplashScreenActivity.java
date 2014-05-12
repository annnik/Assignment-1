package com.assignment1.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import java.util.Date;

public class SplashScreenActivity extends Activity {

	private long firstActivityStartingTime = 0;

	private final Handler handler = new Handler();
	private static final int timeOfWaiting = 2000;
	private static final String FIRST_ACTIVITY_START = "firstActivityStart";
	private Runnable runnableActivityStart = new Runnable() {
		public void run() {
			Intent inHomeScreen = new Intent(SplashScreenActivity.this,
					HomeScreenActivity.class);
			SplashScreenActivity.this.startActivity(inHomeScreen);
			finish();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (savedInstanceState != null) {
			firstActivityStartingTime = savedInstanceState.getLong(
					FIRST_ACTIVITY_START, 0);
			if (firstActivityStartingTime == 0) {
				firstActivityStartingTime = (new Date()).getTime();
			}
		} else {
			firstActivityStartingTime = (new Date()).getTime();
		}

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
		long timeRightNow = 0;
		long timeOfRealWaiting = 0;
		long timeFromStart = 0;
		timeRightNow = (new Date()).getTime();
		timeFromStart = timeRightNow - firstActivityStartingTime;
		timeOfRealWaiting = timeOfWaiting - timeFromStart;
		if (timeOfRealWaiting > 0) {

			handler.postDelayed(runnableActivityStart, timeOfRealWaiting);

		} else {
			handler.post(runnableActivityStart);
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {

		outState.putLong(FIRST_ACTIVITY_START, firstActivityStartingTime);

		super.onSaveInstanceState(outState);
	}

}