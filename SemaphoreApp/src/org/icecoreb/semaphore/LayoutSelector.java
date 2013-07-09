package org.icecoreb.semaphore;

import android.app.Activity;
import android.content.res.Configuration;

public class LayoutSelector {
	public static int getLayout(int portraitLayout, int landscapeLayout,
			Activity activity) {
		int orientation = activity.getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_PORTRAIT) {
			return portraitLayout;
		} else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
			return landscapeLayout;
		} else {
			return portraitLayout;
		}
	}
}
