package org.icecoreb.semaphore;

import java.util.HashMap;
import java.util.Map;

import org.icecoreb.semaphore.model.light.SwitchState;
import org.icecoreb.semaphore.model.semaphore.Semaphore;
import org.icecoreb.semaphore.model.semaphore.SemaphoreState;

import android.os.Bundle;

public class SemaphoreStateMapper {

	public static void saveSemaphoreState(Semaphore semaphore, Bundle bundle) {
		Map<String, SwitchState> state = SemaphoreState.getStateMap(semaphore);
		for (Map.Entry<String, SwitchState> entry : state.entrySet()) {
			bundle.putString(entry.getKey(), entry.getValue().name());
		}
	}

	public static void restoreSemaphoreState(Bundle bundle, Semaphore semaphore) {
		Map<String, SwitchState> stateMap = new HashMap<String, SwitchState>();
		for (String key : SemaphoreState.getStateKeys()) {
			SwitchState state = SwitchState.valueOf(bundle.getString(key));
			stateMap.put(key, state);
		}
		SemaphoreState.setStateMap(stateMap, semaphore);
	}

}
