package org.icecoreb.semaphore;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SemaphoreActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_semaphore);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.semaphore, menu);
		return true;
	}

}
