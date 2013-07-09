package org.icecoreb.semaphore.controls;

import org.icecoreb.semaphore.LayoutSelector;
import org.icecoreb.semaphore.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ControlsFragment extends Fragment {

	// Container Activity must implement this interface
	public interface TrafficLightsListener {
		public void turnOnOff(View view);

		public void switchLight(View view);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		int layout = LayoutSelector.getLayout(R.layout.controls,
				R.layout.controls_landscape, this.getActivity());

		return inflater.inflate(layout, container, false);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// This makes sure that the container activity has implemented
		// the callback interface. If not, it throws an exception
		if (!TrafficLightsListener.class.isInstance(activity)) {
			throw new ClassCastException(activity.toString()
					+ " must implement TrafficLightsListener");
		}
	}

}
