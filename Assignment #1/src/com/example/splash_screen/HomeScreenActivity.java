package com.example.splash_screen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeScreenActivity extends Activity {
	String[] names = { "Element #1", "Element #2", "Element #3", "Element #4",
			"Element #5", "Element #6", "Element #7", "Element #8",
			"Element #9", "Element #10", "Element #11", "Element #12",
			"Element #13", "Element #14", "Element #15", "Element #16",
			"Element #17", "Element #18", "Element #19", "Element #20" };

	/*
	 * String[] names = new String[20]; void InputArray() { for( int
	 * i=1;i<21;i++) { names[i]="Element #"+String.valueOf(i); } }
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// InputArray();
		// TODO com.example.ClearScreen
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_main);

		ListView ListOfElements = (ListView) findViewById(R.id.ListOfElements);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, names);

		ListOfElements.setAdapter(adapter);

	}
}