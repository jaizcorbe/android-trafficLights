package org.icecoreb.semaphore.model.semaphore;

import org.icecoreb.semaphore.model.light.SwitchState;

public class SemaphoreStateOff extends SemaphoreState {

	@Override
	public void setState(Semaphore semaphore) {
		// TODO Auto-generated method stub

	}

	@Override
	public SwitchState getState() {
		return SwitchState.off;
	}

	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}

}
