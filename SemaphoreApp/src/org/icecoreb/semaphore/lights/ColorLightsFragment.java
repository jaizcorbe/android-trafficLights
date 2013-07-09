package org.icecoreb.semaphore.lights;

import org.icecoreb.semaphore.ColorMapper;
import org.icecoreb.semaphore.R;
import org.icecoreb.semaphore.model.light.Light;
import org.icecoreb.semaphore.model.semaphore.Semaphore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ColorLightsFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.color_lights, container, false);
	}
	
	public void setViewColors(Semaphore semaphore) {
		View redLight = getView().findViewById(R.id.red_light);
		View yellowLight = getView().findViewById(R.id.yellow_light);
		View greenLight = getView().findViewById(R.id.green_light);
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
