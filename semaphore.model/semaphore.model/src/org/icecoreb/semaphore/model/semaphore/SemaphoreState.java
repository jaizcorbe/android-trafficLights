package org.icecoreb.semaphore.model.semaphore;

import org.icecoreb.semaphore.model.light.Light;
import org.icecoreb.semaphore.model.light.SwitchState;

public abstract class SemaphoreState {
	public abstract void setState(Semaphore semaphore);

	public abstract SwitchState getState();

	public abstract void switchLight();

	public static SemaphoreState getStateOn() {
		return new SemaphoreStateOn();
	}

	public static SemaphoreState getStateOff() {
		return new SemaphoreStateOff();
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
