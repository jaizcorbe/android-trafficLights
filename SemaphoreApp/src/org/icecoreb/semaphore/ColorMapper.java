package org.icecoreb.semaphore;

import org.icecoreb.semaphore.model.semaphore.SemaphoreColor;

import android.content.res.Resources;

public class ColorMapper {
	public static int getColorCode(SemaphoreColor color, Resources res) {
		int colorCode = 0;
		if (color == SemaphoreColor.redOn) {
			colorCode = R.color.red_on;
		} else if (color == SemaphoreColor.redOff) {
			colorCode = R.color.red_off;
		} else if (color == SemaphoreColor.yellowOn) {
			colorCode = R.color.yellow_on;
		} else if (color == SemaphoreColor.yellowOff) {
			colorCode = R.color.yellow_off;
		} else if (color == SemaphoreColor.greenOn) {
			colorCode = R.color.green_on;
		} else if (color == SemaphoreColor.greenOff) {
			colorCode = R.color.green_off;
		} else {
			colorCode = R.color.gray;
		}
		return res.getColor(colorCode);
	}
}
