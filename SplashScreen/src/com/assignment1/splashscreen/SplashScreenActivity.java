package com.assignment1.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import java.util.Date;

public class SplashScreenActivity extends Activity {

	private long firstActivityStartingTime = 0;
	private long appStartingTimeMilliseconds = 0;
	private final Handler handler = new Handler();
	private static final int timeOfWaiting = 10000;
	private static final String APP_START = "appStart";
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

		if (savedInstanceState != null) {
			appStartingTimeMilliseconds = savedInstanceState
					.getLong(APP_START);
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
		long timeOfRealWaitingNEW = 0;
		firstActivityStartingTime = (new Date()).getTime();
		

		timeOfRealWaitingNEW = firstActivityStartingTime
				- appStartingTimeMilliseconds;
		if (timeOfRealWaitingNEW > 0) {
			if (appStartingTimeMilliseconds != 0) {
				handler.postDelayed(runnableActivityStart, timeOfWaiting
						- timeOfRealWaitingNEW);
			} else {
				handler.postDelayed(runnableActivityStart, timeOfWaiting);
			}
		} else {
			if (timeOfRealWaitingNEW < 0) {
				handler.post(runnableActivityStart);
			}
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {

		 appStartingTimeMilliseconds= (new Date()).getTime();

		outState.putLong(APP_START, appStartingTimeMilliseconds);

		super.onSaveInstanceState(outState);
	}

}