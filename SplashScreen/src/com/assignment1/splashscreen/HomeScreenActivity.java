package com.assignment1.splashscreen;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeScreenActivity extends Activity {

	private String[] names = new String[20];

	private void initNamesArray() {
		for (int i = 0; i < names.length; i++) {
			names[i] = "Element #" + String.valueOf(i + 1);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initNamesArray();

		super.onCreate(savedInstanceState);

		setContentView(R.layout.a_homescreen);

		ListView ListOfNames = (ListView) findViewById(R.id.listofelementsnames);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, names);

		ListOfNames.setAdapter(adapter);

	}

	@Override
	protected void onPause() {
		super.onPause();
		HomeScreenActivity.this.finish();

	}
	public void onConfigurationChanged(Configuration newConfig) {
		 super.onConfigurationChanged(newConfig);		
		 }

}