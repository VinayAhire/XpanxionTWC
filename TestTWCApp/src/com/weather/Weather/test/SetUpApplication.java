package com.weather.Weather.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.jayway.android.robotium.solo.Solo;
import com.weather.Weather.R;
import com.weather.Weather.Constants.WeatherConstants;
import com.weather.Weather.activity.WeatherController;

public class SetUpApplication extends ActivityInstrumentationTestCase2<WeatherController> {
	
	public Solo solo;
	
	public SetUpApplication() {
		super(WeatherController.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
		//solo = new Solo(getInstrumentation(), getActivity());
		//Integer counter=handleInitialPopUps();
		//if(counter!=0){
		//	enterCityInTextBox(WeatherConstants.CITY_ATLANTA);
		//}
		//solo.sleep(2000);
		
		//handleDismissPopup(WeatherConstants.DISMISS_TEXT);
		//checkForNoLocation();

	}

	public Integer handleInitialPopUps(){
		int counter=0;
		if (solo.searchText(WeatherConstants.FIND_MY_LOCATION, true)) {
			solo.clickOnText(WeatherConstants.LATER_TEXT);
			counter++;
		}
		
		if (solo.searchText(WeatherConstants.APPLICATION_POLICY_POPUP, true)) {
			solo.clickOnText(WeatherConstants.AGREE_TEXT);
			counter++;
		}
		
		if (solo.searchText(WeatherConstants.LOCATION_ENABLE_POPUP, true)) {
			solo.clickOnText(WeatherConstants.DISABLE_TEXT);
			counter++;
		}
		return counter;
	}
	
	public void enterCityInTextBox(final String city) throws InterruptedException{
		enterCity(city);
		solo.clickOnScreen(100, 100);
		//solo.sleep(3000);
		solo.clickOnScreen(50, 50);
	}

	public void enterCity(final String city) throws InterruptedException {
		EditText textObj = (EditText) solo.getView(R.id.abs__search_src_text);
		solo.enterText(textObj, city);
		Thread.sleep(3000);
		solo.waitForText(city, 2, 3000);
		solo.clickLongOnText(city, 1);
		//solo.sleep(5000);
	}
	
	public void handleDismissPopup(final String dismissPopup){
		if (solo.searchText(WeatherConstants.UPDATE_POPUP, true)) {
			solo.waitForText(dismissPopup, 1, 1000);
			solo.clickOnText(dismissPopup);
		}	
	}
	
	public void checkForNoLocation() throws InterruptedException{
		if (solo.searchText(WeatherConstants.NO_LOCATION_TEXT, true) || solo.searchText(WeatherConstants.NOT_APPLICABLE, true)){
			solo.clickOnActionBarItem(R.id.search);
			//solo.sleep(1000);
			enterCity(WeatherConstants.CITY_ATLANTA);
		}
	}
	
	
	
	
	/*protected void tearDown() throws Exception {
		try {
			solo.finalize();

		} catch (Throwable e) {
			e.printStackTrace();

		}
		getActivity().finish();

		super.tearDown();

	}*/

}
