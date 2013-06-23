package org.icecoreb.semaphore.model.light;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwitchStateUnitTests {

	@Test
	public void testSwitchOn() {
		assertEquals("Wrong sitched state", SwitchState.off,
				SwitchState.on.switchState());
	}

	@Test
	public void testSwitchOff() {
		assertEquals("Wrong sitched state", SwitchState.on,
				SwitchState.off.switchState());
	}

}
