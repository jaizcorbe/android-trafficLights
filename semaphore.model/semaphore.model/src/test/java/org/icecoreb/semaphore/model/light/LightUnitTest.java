package org.icecoreb.semaphore.model.light;

import static org.junit.Assert.*;

import org.icecoreb.semaphore.model.semaphore.SemaphoreColor;
import org.junit.Test;

public class LightUnitTest {

	@Test
	public void testGetColor_OnState() {
		Light light = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.on);
		assertEquals("Wrong light", SemaphoreColor.greenOn, light.getColor());
	}

	@Test
	public void testGetColor_OffState() {
		Light light = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.off);
		assertEquals("Wrong light", SemaphoreColor.greenOff, light.getColor());
	}

	@Test
	public void testTurnOn_OnState() {
		Light light = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.on);
		Light expectedLight = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.on);
		light.turnOn();
		assertEquals("Wrong light", expectedLight, light);
	}

	@Test
	public void testTurnOn_OffState() {
		Light light = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.off);
		Light expectedLight = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.on);
		light.turnOn();
		assertEquals("Wrong light", expectedLight, light);
	}

	@Test
	public void testTurnOff_OnState() {
		Light light = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.on);
		Light expectedLight = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.off);
		light.turnOff();
		assertEquals("Wrong light", expectedLight, light);
	}

	@Test
	public void testTurnOff_OffState() {
		Light light = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.off);
		Light expectedLight = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.off);
		light.turnOff();
		assertEquals("Wrong light", expectedLight, light);
	}

	@Test
	public void testSwitch_OnState() {
		Light light = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.on);
		Light expectedLight = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.off);
		light.switchLight();
		assertEquals("Wrong light", expectedLight, light);
	}

	@Test
	public void testSwitch_OffState() {
		Light light = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.off);
		Light expectedLight = new Light(SemaphoreColor.greenOn,
				SemaphoreColor.greenOff, SwitchState.on);
		light.switchLight();
		assertEquals("Wrong light", expectedLight, light);
	}

}
