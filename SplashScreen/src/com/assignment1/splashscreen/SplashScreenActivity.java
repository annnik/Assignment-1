package com.assignment1.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import java.util.Calendar;

public class SplashScreenActivity extends Activity {

	private long timeOfRealWaiting = 0L;
	private int startingTime = 0;
	private static final int timeOfWaiting = 2000;
	private final Handler handler = new Handler();
	private static final Calendar activityStartingTime = Calendar.getInstance();
	private Calendar timeRightNow;
	private int timeRightNowMilliseconds;
	private static final int activityStartingTimeMilliseconds = (activityStartingTime
			.get(Calendar.SECOND)
			+ activityStartingTime.get(Calendar.HOUR)
			* 3600 + activityStartingTime.get(Calendar.MINUTE) * 60)
			* 1000
			+ activityStartingTime.get(Calendar.MILLISECOND);;

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
			startingTime = savedInstanceState.getInt("startingTime");
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

		timeRightNow = Calendar.getInstance();
		timeRightNowMilliseconds = (timeRightNow.get(Calendar.SECOND)
				+ timeRightNow.get(Calendar.HOUR) * 3600 + timeRightNow
				.get(Calendar.MINUTE) * 60)
				* 1000
				+ timeRightNow.get(Calendar.MILLISECOND);
		startingTime = timeRightNowMilliseconds
				- activityStartingTimeMilliseconds;

		outState.putInt("startingTime", startingTime);

		super.onSaveInstanceState(outState);
	}

}