package org.icecoreb.semaphore.model.light;

public enum SwitchState {
	on, off;

	public SwitchState switchState() {
		if (this.equals(on)) {
			return off;
		}
		return on;
	}
}
