package org.icecoreb.semaphore;

import org.icecoreb.semaphore.controls.ControlsFragment.TrafficLightsListener;
import org.icecoreb.semaphore.lights.ColorLightsFragment;
import org.icecoreb.semaphore.model.semaphore.Semaphore;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

public class SemaphoreActivity extends FragmentActivity implements
		TrafficLightsListener {

	private Semaphore semaphore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setOrientationLayout();
		this.semaphore = new Semaphore();
		this.semaphore.turnOff();
		this.setViewColors();
	}

	protected void setOrientationLayout() {
		int orientation = getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_PORTRAIT) {
			setContentView(R.layout.activity_semaphore);
		} else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
			setContentView(R.layout.activity_semaphore_landscape);
		} else {
			setContentView(R.layout.activity_semaphore);
		}
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

	public void turnOnOff(View view) {
		this.semaphore.switchState();
		this.setViewColors();
	}

	public void switchLight(View view) {
		this.semaphore.switchLight();
		this.setViewColors();
	}

	private void setViewColors() {
		this.getTrafficLights().setViewColors(this.semaphore);
	}

	private ColorLightsFragment getTrafficLights() {
		return (ColorLightsFragment) getSupportFragmentManager()
				.findFragmentById(R.id.color_lights_fragment);
	}

}
