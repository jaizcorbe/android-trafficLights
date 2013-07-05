package org.icecoreb.semaphore.model.semaphore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.icecoreb.semaphore.model.light.Light;
import org.icecoreb.semaphore.model.light.SwitchState;

public abstract class SemaphoreState {

	public static final String SEMAPHORE_STATE = "SEMAPHORE_STATE";
	public static final String RED_LIGHT_STATE = "RED_LIGHT_STATE";
	public static final String YELLOW_LIGHT_STATE = "YELLOW_LIGHT_STATE";
	public static final String GREEN_LIGHT_STATE = "GREEN_LIGHT_STATE";

	public static Map<String, SwitchState> getStateMap(Semaphore semaphore) {
		Map<String, SwitchState> state = new HashMap<String, SwitchState>();
		state.put(SEMAPHORE_STATE, semaphore.getState());
		state.put(RED_LIGHT_STATE, semaphore.getRedLight().getState());
		state.put(YELLOW_LIGHT_STATE, semaphore.getYellowLight().getState());
		state.put(GREEN_LIGHT_STATE, semaphore.getGreenLight().getState());
		return state;
	}

	public static void setStateMap(Map<String, SwitchState> stateMap,
			Semaphore semaphore) {
		semaphore.setState(stateMap.get(SEMAPHORE_STATE));
		semaphore.getRedLight().setState(stateMap.get(RED_LIGHT_STATE));
		semaphore.getYellowLight().setState(stateMap.get(YELLOW_LIGHT_STATE));
		semaphore.getGreenLight().setState(stateMap.get(GREEN_LIGHT_STATE));
	}

	public static List<String> getStateKeys() {
		return Arrays.asList(SEMAPHORE_STATE, RED_LIGHT_STATE,
				YELLOW_LIGHT_STATE, GREEN_LIGHT_STATE);
	}

	public abstract void setState(Semaphore semaphore);

	public abstract SwitchState getState();

	public abstract void switchLight(Semaphore semaphore);

	public static SemaphoreState getStateOn() {
		return new SemaphoreStateOn();
	}

	public static SemaphoreState getStateOff() {
		return new SemaphoreStateOff();
	}

	public static SemaphoreState getState(SwitchState state) {
		SemaphoreState semaphoreState;
		if (SwitchState.on == state) {
			semaphoreState = getStateOn();
		} else {
			semaphoreState = getStateOff();
		}
		return semaphoreState;
	}

	protected void turnAllLightsOff(Semaphore semaphore) {
		if (semaphore != null && semaphore.getLights() != null) {
			for (Light light : semaphore.getLights()) {
				light.turnOff();
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return this.getClass() == obj.getClass();
	}

	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}
}
