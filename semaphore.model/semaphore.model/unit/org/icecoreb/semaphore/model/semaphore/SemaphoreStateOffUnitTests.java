package org.icecoreb.semaphore.model.semaphore;

import static org.junit.Assert.*;

import org.icecoreb.semaphore.model.light.SwitchState;
import org.junit.Test;

public class SemaphoreStateOffUnitTests {

	@Test
	public void testCreate() {
		SemaphoreStateOff state = new SemaphoreStateOff();
		assertEquals("Wrong state", SwitchState.off, state.getState());
	}

	@Test
	public void testSetState_AllValuesOn() {
		SemaphoreStateOff offState = new SemaphoreStateOff();
		Semaphore semaphore = new Semaphore();
		semaphore.getRedLight().turnOn();
		semaphore.getYellowLight().turnOn();
		semaphore.getGreenLight().turnOn();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.getRedLight().turnOff();
		expectedSemaphore.getYellowLight().turnOff();
		expectedSemaphore.getGreenLight().turnOff();
		expectedSemaphore.setState(new SemaphoreStateOff());

		offState.setState(semaphore);
		assertEquals("wrong semaphore", expectedSemaphore, semaphore);
	}

	@Test
	public void testSetState_AllValuesOff() {
		SemaphoreStateOff offState = new SemaphoreStateOff();
		Semaphore semaphore = new Semaphore();
		semaphore.getRedLight().turnOff();
		semaphore.getYellowLight().turnOff();
		semaphore.getGreenLight().turnOff();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.getRedLight().turnOff();
		expectedSemaphore.getYellowLight().turnOff();
		expectedSemaphore.getGreenLight().turnOff();
		expectedSemaphore.setState(new SemaphoreStateOff());

		offState.setState(semaphore);
		assertEquals("wrong semaphore", expectedSemaphore, semaphore);
	}
	
}
