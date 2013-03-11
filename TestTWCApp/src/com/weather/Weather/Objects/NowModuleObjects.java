package com.weather.Weather.Objects;

import com.jayway.android.robotium.solo.Solo;
import com.weather.Weather.test.NowModule;
import com.weather.Weather.test.SetUpApplication;
import com.weather.Weather.R;

import android.widget.LinearLayout;

public class NowModuleObjects {
	
	public LinearLayout getCircularImage(Solo solo) {
		LinearLayout circleRect = (LinearLayout)solo.getView(R.id.circle_rect);
		return circleRect;
	}
	
}
