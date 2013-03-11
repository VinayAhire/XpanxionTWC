package com.weather.Weather.test;

import android.widget.LinearLayout;

import com.weather.Weather.Objects.NowModuleObjects;

public class NowModule extends SetUpApplication {
	
	NowModuleObjects now = new NowModuleObjects();
	
	public void checkImageExpanded() {
		LinearLayout circleRect = now.getCircularImage(solo);
		solo.waitForView(circleRect);
		solo.clickOnView(circleRect);
		solo.sleep(4000);
	}
}