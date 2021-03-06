package org.icecoreb.semaphore.model.semaphore;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.icecoreb.semaphore.model.light.SwitchState;
import org.junit.Test;

public class SemaphoreStateUnitTest {

	@Test
	public void testGetStateOn() {
		SemaphoreState state = SemaphoreState.getStateOn();
		assertEquals("Wrong semaphore state", SwitchState.on, state.getState());
	}

	@Test
	public void testGetStateOff() {
		SemaphoreState state = SemaphoreState.getStateOff();
		assertEquals("Wrong semaphore state", SwitchState.off, state.getState());
	}

	@Test
	public void testGetState_On() {
		SemaphoreState state = SemaphoreState.getState(SwitchState.on);
		assertEquals("Wrong semaphore state", SwitchState.on, state.getState());
	}

	@Test
	public void testGetState_Off() {
		SemaphoreState state = SemaphoreState.getState(SwitchState.off);
		assertEquals("Wrong semaphore state", SwitchState.off, state.getState());
	}

	@Test
	public void testEquals() {
		assertEquals("Wrong state", SemaphoreState.getStateOff(),
				SemaphoreState.getStateOff());
		assertEquals("Wrong state", SemaphoreState.getStateOn(),
				SemaphoreState.getStateOn());
	}

	@Test
	public void testNotEquals() {
		assertThat("Wrong state", SemaphoreState.getStateOff(),
				not(equalTo(SemaphoreState.getStateOn())));
		assertThat("Wrong state", SemaphoreState.getStateOn(),
				not(equalTo(SemaphoreState.getStateOff())));
	}
}
