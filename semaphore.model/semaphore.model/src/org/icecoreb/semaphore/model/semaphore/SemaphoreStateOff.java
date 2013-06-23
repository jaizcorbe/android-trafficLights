package org.icecoreb.semaphore.model.semaphore;

import org.icecoreb.semaphore.model.light.SwitchState;

public class SemaphoreStateOff extends SemaphoreState {

	@Override
	public void setState(Semaphore semaphore) {
		semaphore.setState(this);
		this.turnAllLightsOff(semaphore);
	}

	@Override
	public SwitchState getState() {
		return SwitchState.off;
	}

	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}

	@Override
	public void switchLight() {
		// TODO Auto-generated method stub

	}

}
