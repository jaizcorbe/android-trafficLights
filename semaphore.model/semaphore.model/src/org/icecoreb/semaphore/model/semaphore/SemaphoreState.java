package org.icecoreb.semaphore.model.semaphore;

import org.icecoreb.semaphore.model.light.SwitchState;

public abstract class SemaphoreState {
	public abstract void setState(Semaphore semaphore);

	public abstract SwitchState getState();

	public static SemaphoreState getStateOn() {
		return new SemaphoreStateOn();
	}

	public static SemaphoreState getStateOff() {
		return new SemaphoreStateOff();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return this.getClass() == obj.getClass();
	}
}
