package org.icecoreb.semaphore.model.semaphore;

import java.util.Arrays;
import java.util.List;

import org.icecoreb.semaphore.model.SwitchableDevice;
import org.icecoreb.semaphore.model.light.Light;
import org.icecoreb.semaphore.model.light.SwitchState;

public class Semaphore implements SwitchableDevice {
	private Light redLight;
	private Light yellowLight;
	private Light greenLight;
	private List<Light> lights;
	private SemaphoreState semaphoreState;

	public Semaphore() {
		this.redLight = new Light(SemaphoreColor.redOn, SemaphoreColor.redOff);
		this.yellowLight = new Light(SemaphoreColor.yellowOn,
				SemaphoreColor.yellowOff);
		this.greenLight = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff);
		this.lights = Arrays.asList(this.redLight, this.yellowLight,
				this.greenLight);
		this.semaphoreState = SemaphoreState.getStateOff();
		this.semaphoreState.setState(this);
	}

	public void turnOn() {
		this.setState(SwitchState.on);
	}

	public void turnOff() {
		this.setState(SwitchState.off);
	}

	public void setState(SwitchState state) {
		SemaphoreState semaphoreState = SemaphoreState.getState(state);
		semaphoreState.setState(this);
	}

	public void switchState() {
		this.setState(this.getState().switchState());
	}

	public SwitchState getState() {
		return this.semaphoreState.getState();
	}

	public void switchLight() {
		this.semaphoreState.switchLight(this);
	}

	public List<Light> getLights() {
		return lights;
	}

	public Light getRedLight() {
		return redLight;
	}

	public void setRedLight(Light redLight) {
		this.redLight = redLight;
	}

	public Light getYellowLight() {
		return yellowLight;
	}

	public void setYellowLight(Light yellowLight) {
		this.yellowLight = yellowLight;
	}

	public Light getGreenLight() {
		return greenLight;
	}

	public void setGreenLight(Light greenLight) {
		this.greenLight = greenLight;
	}

	public void setSemaphoreState(SemaphoreState state) {
		this.semaphoreState = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((greenLight == null) ? 0 : greenLight.hashCode());
		result = prime * result
				+ ((redLight == null) ? 0 : redLight.hashCode());
		result = prime * result
				+ ((semaphoreState == null) ? 0 : semaphoreState.hashCode());
		result = prime * result
				+ ((yellowLight == null) ? 0 : yellowLight.hashCode());
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
		Semaphore other = (Semaphore) obj;
		if (greenLight == null) {
			if (other.greenLight != null)
				return false;
		} else if (!greenLight.equals(other.greenLight))
			return false;
		if (redLight == null) {
			if (other.redLight != null)
				return false;
		} else if (!redLight.equals(other.redLight))
			return false;
		if (semaphoreState == null) {
			if (other.semaphoreState != null)
				return false;
		} else if (!semaphoreState.equals(other.semaphoreState))
			return false;
		if (yellowLight == null) {
			if (other.yellowLight != null)
				return false;
		} else if (!yellowLight.equals(other.yellowLight))
			return false;
		return true;
	}

}
