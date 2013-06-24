package org.icecoreb.semaphore.model.light;

import org.icecoreb.semaphore.model.semaphore.SemaphoreColor;

public class Light {

	private SemaphoreColor colorOn;
	private SemaphoreColor colorOff;
	private SwitchState state;

	public Light(SemaphoreColor colorOn, SemaphoreColor colorOff,
			SwitchState state) {
		this.colorOn = colorOn;
		this.colorOff = colorOff;
		this.state = state;
	}

	public Light(SemaphoreColor colorOn, SemaphoreColor colorOff) {
		this(colorOn, colorOff, SwitchState.on);
	}

	public void turnOn() {
		this.state = SwitchState.on;
	}

	public void turnOff() {
		this.state = SwitchState.off;
	}

	public void switchLight() {
		this.state = this.state.switchState();
	}

	public SwitchState getState() {
		return this.state;
	}

	public SemaphoreColor getColor() {
		if (SwitchState.on.equals(this.state)) {
			return this.colorOn;
		}
		return this.colorOff;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((colorOff == null) ? 0 : colorOff.hashCode());
		result = prime * result + ((colorOn == null) ? 0 : colorOn.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Light other = (Light) obj;
		if (colorOff != other.colorOff)
			return false;
		if (colorOn != other.colorOn)
			return false;
		if (state != other.state)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Light state: [" + this.state + "] colorOn: [" + this.colorOn
				+ "] colorOff: [" + this.colorOff + "]";
	}
}
