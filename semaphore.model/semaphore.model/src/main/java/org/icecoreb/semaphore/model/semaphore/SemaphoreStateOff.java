package org.icecoreb.semaphore.model.semaphore;

import org.icecoreb.semaphore.model.light.SwitchState;

public class SemaphoreStateOff extends SemaphoreState {

	@Override
	public void setState(Semaphore semaphore) {
		semaphore.setSemaphoreState(this);
		this.turnAllLightsOff(semaphore);
	}

	@Override
	public SwitchState getState() {
		return SwitchState.off;
	}

	@Override
	public void switchLight(Semaphore semaphore) {
		// TODO Auto-generated method stub

	}

}
