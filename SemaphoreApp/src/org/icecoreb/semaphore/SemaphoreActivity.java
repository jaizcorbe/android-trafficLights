package org.icecoreb.semaphore;

import org.icecoreb.semaphore.model.light.Light;
import org.icecoreb.semaphore.model.light.SwitchState;
import org.icecoreb.semaphore.model.semaphore.Semaphore;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class SemaphoreActivity extends Activity {

	private static final String SEMAPHORE_STATE = "SEMAPHORE_STATE";

	private Semaphore semaphore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_semaphore);
		this.semaphore = new Semaphore();
		this.semaphore.turnOff();
		this.setViewColors();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.semaphore, menu);
		return true;
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		SemaphoreStateMapper.saveSemaphoreState(this.semaphore,
				savedInstanceState);
		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		SemaphoreStateMapper.restoreSemaphoreState(savedInstanceState,
				this.semaphore);
		this.setViewColors();
	}

	/** Called when the user clicks the Send button */
	public void switchOnOff(View view) {
		if (this.semaphore.getState() == SwitchState.on) {
			this.semaphore.turnOff();
		} else {
			this.semaphore.turnOn();
		}
		this.setViewColors();
	}

	public void switchLight(View view) {
		this.semaphore.switchLight();
		this.setViewColors();
	}

	private void setViewColors() {
		View redLight = findViewById(R.id.red_light);
		View yellowLight = findViewById(R.id.yellow_light);
		View greenLight = findViewById(R.id.green_light);
		this.setLight(redLight, semaphore.getRedLight());
		this.setLight(yellowLight, semaphore.getYellowLight());
		this.setLight(greenLight, semaphore.getGreenLight());
	}

	private void setLight(View view, Light light) {
		if (view != null && light != null) {
			view.setBackgroundColor(ColorMapper.getColorCode(light.getColor(),
					this.getResources()));
			view.refreshDrawableState();
		}
	}

}
