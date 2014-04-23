package com.assignment1.splashscreen;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeScreenActivity extends Activity {

	String[] names = new String[20];
	
	void InputArray() {
		for (int i = 0; i < 20; i++) {
			names[i] = "Element #" + String.valueOf(i + 1);
		}
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		InputArray();
		// TODO com.example.ClearScreen
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.a_splashscreen);
		
		ListView ListOfNames = (ListView) findViewById(R.id.ListOfNames);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, names);

		ListOfNames.setAdapter(adapter);
		
	}

	
}