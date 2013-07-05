package org.icecoreb.semaphore.model;

import org.icecoreb.semaphore.model.light.SwitchState;

public interface SwitchableDevice {
	public void turnOn();

	public void turnOff();

	public void setState(SwitchState state);

	public void switchState();
}
