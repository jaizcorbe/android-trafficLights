package org.icecoreb.semaphore.model.semaphore;

import java.util.Arrays;
import java.util.List;

import org.icecoreb.semaphore.model.light.Light;

public class Semaphore {
	private Light redLight;
	private Light yellowLight;
	private Light greenLight;
	private List<Light> lights;
	private SemaphoreState state;

	public Semaphore() {
		this.redLight = new Light(SemaphoreColor.redOn, SemaphoreColor.redOff);
		this.yellowLight = new Light(SemaphoreColor.yellowOn,
				SemaphoreColor.yellowOff);
		this.greenLight = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff);
		this.lights = Arrays.asList(this.redLight, this.yellowLight,
				this.greenLight);
		this.state = SemaphoreState.getStateOff();
		this.state.setState(this);
	}

	public void turnOn() {
		this.state = SemaphoreState.getStateOn();
		this.state.setState(this);
	}

	public void turnOff() {
		this.state = SemaphoreState.getStateOff();
		this.state.setState(this);
	}

	public List<Light> getLights() {
		return lights;
	}

}
