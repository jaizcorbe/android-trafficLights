package org.icecoreb.semaphore.model.semaphore;

import java.util.List;

import org.icecoreb.semaphore.model.light.Light;
import org.icecoreb.semaphore.model.light.SwitchState;

public class SemaphoreStateOn extends SemaphoreState {

	@Override
	public void setState(Semaphore semaphore) {
		semaphore.setSemaphoreState(this);
		this.turnAllLightsOff(semaphore);
		semaphore.getRedLight().turnOn();
	}

	@Override
	public SwitchState getState() {
		return SwitchState.on;
	}

	@Override
	public void switchLight(Semaphore semaphore) {
		Light currentLightOn = this.getCurrentOnLight(semaphore);
		Light nextLightOn = this.getNextLight(currentLightOn, semaphore);
		currentLightOn.turnOff();
		nextLightOn.turnOn();
	}

	private Light getCurrentOnLight(Semaphore semaphore) {
		Light lightOn = null;
		for (Light light : semaphore.getLights()) {
			if (SwitchState.on == light.getState()) {
				lightOn = light;
			}
		}
		return lightOn;
	}

	private Light getNextLight(Light light, Semaphore semaphore) {
		int nextLightIndex = this.getNextLightIndex(light, semaphore);
		return semaphore.getLights().get(nextLightIndex);
	}

	private int getNextLightIndex(Light light, Semaphore semaphore) {
		List<Light> lights = semaphore.getLights();
		int nextIndex;
		nextIndex = semaphore.getLights().indexOf(light);
		nextIndex = (nextIndex + 1) % lights.size();
		return nextIndex;
	}

}
