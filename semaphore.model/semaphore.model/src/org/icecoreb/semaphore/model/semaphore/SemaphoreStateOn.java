package org.icecoreb.semaphore.model.semaphore;

import org.icecoreb.semaphore.model.light.SwitchState;

public class SemaphoreStateOn extends SemaphoreState {

	@Override
	public void setState(Semaphore semaphore) {
		semaphore.setState(this);
		this.turnAllLightsOff(semaphore);
		semaphore.getRedLight().turnOn();
	}

	@Override
	public SwitchState getState() {
		return SwitchState.on;
	}

	@Override
	public void switchLight() {
		// TODO Auto-generated method stub
		
	}

}
