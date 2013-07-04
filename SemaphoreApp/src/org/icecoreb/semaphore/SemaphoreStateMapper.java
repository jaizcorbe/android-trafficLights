package org.icecoreb.semaphore;

import org.icecoreb.semaphore.model.light.Light;
import org.icecoreb.semaphore.model.light.SwitchState;
import org.icecoreb.semaphore.model.semaphore.Semaphore;

import android.os.Bundle;

public class SemaphoreStateMapper {

	public static final String SEMAPHORE_STATE = "SEMAPHORE_STATE";
	public static final String RED_LIGHT_STATE = "RED_LIGHT_STATE";
	public static final String YELLOW_LIGHT_STATE = "YELLOW_LIGHT_STATE";
	public static final String GREEN_LIGHT_STATE = "GREEN_LIGHT_STATE";
	public static final int STATE_ON = 1;
	public static final int STATE_OFF = 0;

	public static void saveSemaphoreState(Semaphore semaphore, Bundle bundle) {
		bundle.putString(SEMAPHORE_STATE, semaphore.getState().name());
		bundle.putString(RED_LIGHT_STATE, semaphore.getRedLight().getState()
				.name());
		bundle.putString(YELLOW_LIGHT_STATE, semaphore.getYellowLight().getState()
				.name());
		bundle.putString(GREEN_LIGHT_STATE, semaphore.getGreenLight()
				.getState().name());
	}

	public static void restoreSemaphoreState(Bundle bundle, Semaphore semaphore) {
		SwitchState semaphoreState = SwitchState.valueOf(bundle
				.getString(SEMAPHORE_STATE));
		if (semaphoreState == SwitchState.off) {
			semaphore.turnOff();
		} else {
			semaphore.turnOn();
			restoreLightState(
					SwitchState.valueOf(bundle.getString(RED_LIGHT_STATE)),
					semaphore.getRedLight());
			restoreLightState(
					SwitchState.valueOf(bundle.getString(YELLOW_LIGHT_STATE)),
					semaphore.getYellowLight());
			restoreLightState(
					SwitchState.valueOf(bundle.getString(GREEN_LIGHT_STATE)),
					semaphore.getGreenLight());
		}
	}

	private static void restoreLightState(SwitchState state, Light light) {
		if (state == SwitchState.on) {
			light.turnOn();
		} else {
			light.turnOff();
		}
	}

}
