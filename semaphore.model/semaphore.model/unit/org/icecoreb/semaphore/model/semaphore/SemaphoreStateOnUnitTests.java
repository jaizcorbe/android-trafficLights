package org.icecoreb.semaphore.model.semaphore;

import static org.junit.Assert.*;

import org.icecoreb.semaphore.model.light.SwitchState;
import org.junit.Test;

public class SemaphoreStateOnUnitTests {

	@Test
	public void testCreate() {
		SemaphoreStateOn state = new SemaphoreStateOn();
		assertEquals("Wrong state", SwitchState.on, state.getState());
	}

	@Test
	public void testSetState_AllValuesOn() {
		SemaphoreStateOn onState = new SemaphoreStateOn();
		Semaphore semaphore = new Semaphore();
		semaphore.getRedLight().turnOn();
		semaphore.getYellowLight().turnOn();
		semaphore.getGreenLight().turnOn();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.getRedLight().turnOn();
		expectedSemaphore.getYellowLight().turnOff();
		expectedSemaphore.getGreenLight().turnOff();
		expectedSemaphore.setState(new SemaphoreStateOn());

		onState.setState(semaphore);
		assertEquals("wrong semaphore", expectedSemaphore, semaphore);
	}

	@Test
	public void testSetState_AllValuesOff() {
		SemaphoreStateOn onState = new SemaphoreStateOn();
		Semaphore semaphore = new Semaphore();
		semaphore.getRedLight().turnOff();
		semaphore.getYellowLight().turnOff();
		semaphore.getGreenLight().turnOff();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.getRedLight().turnOn();
		expectedSemaphore.getYellowLight().turnOff();
		expectedSemaphore.getGreenLight().turnOff();
		expectedSemaphore.setState(new SemaphoreStateOn());

		onState.setState(semaphore);
		assertEquals("wrong semaphore", expectedSemaphore, semaphore);
	}

}
