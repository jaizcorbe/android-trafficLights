package org.icecoreb.semaphore.model.semaphore;

import static org.junit.Assert.*;

import org.icecoreb.semaphore.model.light.SwitchState;
import org.junit.Test;

public class SemaphoreUnitTest {

	@Test
	public void testTurnOn_AllValuesOn() {
		Semaphore semaphore = new Semaphore();
		semaphore.getRedLight().turnOn();
		semaphore.getYellowLight().turnOn();
		semaphore.getGreenLight().turnOn();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.getRedLight().turnOn();
		expectedSemaphore.getYellowLight().turnOff();
		expectedSemaphore.getGreenLight().turnOff();
		expectedSemaphore.setSemaphoreState(new SemaphoreStateOn());

		semaphore.turnOn();
		assertEquals("wrong semaphore", expectedSemaphore, semaphore);
		assertEquals("wrong semaphore state", SwitchState.on,
				semaphore.getState());
	}

	@Test
	public void testTurnOn_AllValuesOff() {
		Semaphore semaphore = new Semaphore();
		semaphore.getRedLight().turnOff();
		semaphore.getYellowLight().turnOff();
		semaphore.getGreenLight().turnOff();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.getRedLight().turnOn();
		expectedSemaphore.getYellowLight().turnOff();
		expectedSemaphore.getGreenLight().turnOff();
		expectedSemaphore.setSemaphoreState(new SemaphoreStateOn());

		semaphore.turnOn();
		assertEquals("wrong semaphore", expectedSemaphore, semaphore);
		assertEquals("wrong semaphore state", SwitchState.on,
				semaphore.getState());
	}

	@Test
	public void testTurnOff_AllValuesOn() {
		Semaphore semaphore = new Semaphore();
		semaphore.getRedLight().turnOn();
		semaphore.getYellowLight().turnOn();
		semaphore.getGreenLight().turnOn();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.getRedLight().turnOff();
		expectedSemaphore.getYellowLight().turnOff();
		expectedSemaphore.getGreenLight().turnOff();
		expectedSemaphore.setSemaphoreState(new SemaphoreStateOff());

		semaphore.turnOff();
		assertEquals("wrong semaphore", expectedSemaphore, semaphore);
		assertEquals("wrong semaphore state", SwitchState.off,
				semaphore.getState());
	}

	@Test
	public void testTurnOff_AllValuesOff() {
		Semaphore semaphore = new Semaphore();
		semaphore.getRedLight().turnOff();
		semaphore.getYellowLight().turnOff();
		semaphore.getGreenLight().turnOff();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.getRedLight().turnOff();
		expectedSemaphore.getYellowLight().turnOff();
		expectedSemaphore.getGreenLight().turnOff();
		expectedSemaphore.setSemaphoreState(new SemaphoreStateOff());

		semaphore.turnOff();
		assertEquals("wrong semaphore", expectedSemaphore, semaphore);
		assertEquals("wrong semaphore state", SwitchState.off,
				semaphore.getState());
	}

	@Test
	public void testSwitchLight_StateOff() {
		Semaphore semaphore = new Semaphore();
		semaphore.turnOff();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.turnOff();

		semaphore.switchLight();
		assertEquals("Wrong semaphore", expectedSemaphore, semaphore);
	}

	@Test
	public void testOneSwitchLight_StateOn() {
		Semaphore semaphore = new Semaphore();
		semaphore.turnOn();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.setSemaphoreState(SemaphoreState.getStateOn());
		expectedSemaphore.getRedLight().turnOff();
		expectedSemaphore.getYellowLight().turnOn();
		expectedSemaphore.getGreenLight().turnOff();

		semaphore.switchLight();

		assertEquals("wrong semaphore", expectedSemaphore, semaphore);
	}

	@Test
	public void testTwoSwitchLight_StateOn() {
		Semaphore semaphore = new Semaphore();
		semaphore.turnOn();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.setSemaphoreState(SemaphoreState.getStateOn());
		expectedSemaphore.getRedLight().turnOff();
		expectedSemaphore.getYellowLight().turnOff();
		expectedSemaphore.getGreenLight().turnOn();

		semaphore.switchLight();
		semaphore.switchLight();

		assertEquals("wrong semaphore", expectedSemaphore, semaphore);
	}

	@Test
	public void testTreeSwitchLight_StateOn() {
		Semaphore semaphore = new Semaphore();
		semaphore.turnOn();

		Semaphore expectedSemaphore = new Semaphore();
		expectedSemaphore.turnOn();

		semaphore.switchLight();
		semaphore.switchLight();
		semaphore.switchLight();

		assertEquals("wrong semaphore", expectedSemaphore, semaphore);
	}

}
