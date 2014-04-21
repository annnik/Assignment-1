package com.example.splash_screen;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_splash);
		Thread logoTimer = new Thread() {
			public void run() {
				try {
					int logoTimer = 0;
					while (logoTimer < 2000) {
						sleep(100);
						logoTimer = logoTimer + 100;
					}
					;

					startActivity(new Intent(
							"com.example.splash_screen.HomeScreenActivity"));
				} catch (InterruptedException e) {
					// TODO:
					e.printStackTrace();
				} finally {
					finish();
				}
			}
		};
		logoTimer.start();
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
