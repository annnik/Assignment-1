package com.assignment1.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import java.util.Date;

public class SplashScreenActivity extends Activity {

	private long timeOfRealWaiting = 0L;
	private long startingTime = 0;
	private long activityStartingTimeMilliseconds;
	private final Handler handler = new Handler();
	private static final int timeOfWaiting = 10000;
	private static final Date appStartingTime = new Date();
	private static final long appStartingTimeMilliseconds = appStartingTime
			.getTime();

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
		if (savedInstanceState != null)
			startingTime = savedInstanceState.getLong("startingTime");
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

	@Override
	protected void onSaveInstanceState(Bundle outState) {

		Date activityStartingTime = new Date();
		activityStartingTimeMilliseconds = activityStartingTime.getTime();
		startingTime = activityStartingTimeMilliseconds
				- appStartingTimeMilliseconds;

		outState.putLong("startingTime", startingTime);

		super.onSaveInstanceState(outState);
	}

}