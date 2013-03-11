package com.weather.Weather.Utility;

import junit.framework.Assert;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;
import com.weather.Weather.R;
import com.weather.Weather.Constants.WeatherConstants;

public class UtilityClass {

	/**
	 * This is reusable method which will open particular Tab based on text sent as parameter.
	 * @param menuItem
	 */
	
	
	public void  launchUiTab(final String menuItem,final Solo solo){
		solo.waitForText(menuItem);
		solo.clickOnText(menuItem);
		
		if (menuItem.equals(WeatherConstants.NOW_FRAGEMENT)) {
			verifyNowFragment(solo);
		} else if (menuItem.equals(WeatherConstants.VIDEOS_FRAGMENT)) {
			//verifyVideosFragment(solo);
		} else if (menuItem.equals(WeatherConstants.MAP_FRAGEMENT)) {
			
		} else if (menuItem.equals(WeatherConstants.FORECAST_FRAGEMENT)) {
			
		}
		
		solo.sleep(2000);

	}
	
	
	public void clickonNowCircularImage(final Solo solo){
		LinearLayout circleRect = (LinearLayout)solo.getView(R.id.circle_rect);
		solo.waitForView(circleRect);
		solo.clickOnView(circleRect);
		solo.sleep(2000);
	}
	
	public TextView getTextViewLabel(final int id,final Solo solo){
		TextView textObj = (TextView) solo.getView(id);
		return textObj;
		
	}
	
	public boolean isInteger(String input)
	{
		try
		{
			Integer.parseInt(input);
			return true;
		}
		catch (Exception e)
		{
			return false;
			
		}
	}
	
	public void verifyNowFragment(final Solo solo) {
		LinearLayout circleRect = (LinearLayout)solo.getView(R.id.circle_rect);
		solo.waitForView(circleRect);
		Assert.assertTrue(circleRect.isShown());
	}
	
	public void verifyVideosFragment(final Solo solo) {
		Button mustSeeVideos = (Button) solo.getButton(R.id.btn_must_see);
		solo.waitForView(mustSeeVideos);
		Assert.assertTrue(mustSeeVideos.isShown());
	}

}
