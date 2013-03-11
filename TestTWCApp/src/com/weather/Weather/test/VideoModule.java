package com.weather.Weather.test;

import android.util.Log;
import android.widget.ImageView;
import android.widget.MediaController;

import com.weather.Weather.R;
import com.weather.Weather.Constants.WeatherConstants;
import com.weather.Weather.Objects.VideoModuleObjects;
import com.weather.Weather.Utility.UtilityClass;
import com.weather.Weather.view.VideoViewWithMidpoint;

public class VideoModule extends SetUpApplication {

	UtilityClass util = new UtilityClass();
	VideoModuleObjects videoObj = new VideoModuleObjects();

	public void checkVideoPlayButton() {
		util.launchUiTab(WeatherConstants.VIDEOS_FRAGMENT, solo);
		solo.sleep(20000);

		VideoViewWithMidpoint videoView = (VideoViewWithMidpoint) solo
				.getView(R.id.video_view);

		ImageView playButton = (ImageView) solo.getView(R.id.play_button);
		assertTrue(playButton.isShown());

		solo.clickOnView(playButton);
		solo.sleep(20000);
		assertTrue(videoView.isPlaying());

		videoView.pause();
		System.out
				.println("Current Position:" + videoView.getCurrentPosition());

		System.out.println("Duration :" + videoView.getDuration());
		solo.sleep(10000);
		assertFalse(videoView.isPlaying());
	}

	public void checkVideoIsPlaying() {
		util.launchUiTab(WeatherConstants.VIDEOS_FRAGMENT, solo);
		playVideo();
	}

	public void checkVideoIsPaused() {
		util.launchUiTab(WeatherConstants.VIDEOS_FRAGMENT, solo);
		pauseVideo();
	}
	
	public void playVideo() {
		int flagVideoLoaded = 0;
		
		solo.waitForView(videoObj.getVideoView(solo));
		
		if((videoObj.getImageViewPlayButton(solo)).isShown()){
			solo.clickOnView(videoObj.getImageViewPlayButton(solo));
			
			for (int i = 0; i < 30; i++) {
				if (!(videoObj.getTextViewVideoLoading(solo).isShown())) {
					flagVideoLoaded = 1;
					break;
				} else {
					solo.sleep(2000);
				}
			}
		} else {
			videoObj.getVideoView(solo).start();
			flagVideoLoaded = 1;
		}
		
		
		if (flagVideoLoaded == 1) {
			Log.i(WeatherConstants.TAG_WEATHERCONTROLLER,
					"Flag is now 1");
			solo.sleep(2000);
			assertTrue((videoObj.getVideoView(solo)).isPlaying());
			//videoView.pause();
			solo.sleep(2000);
		} else {
			Log.i(WeatherConstants.TAG_WEATHERCONTROLLER,
					"Video is talking more than expected time to load.");
		}
	}
	
	public void pauseVideo() {
		solo.waitForView(videoObj.getVideoView(solo));

		if ((videoObj.getVideoView(solo)).isPlaying()) {
			(videoObj.getVideoView(solo)).pause();
			assertFalse((videoObj.getVideoView(solo)).isPlaying());
			Log.i(WeatherConstants.TAG_WEATHERCONTROLLER,
					"Video is paused sucessfully");
		} else {
			playVideo();
			(videoObj.getVideoView(solo)).pause();
			assertFalse((videoObj.getVideoView(solo)).isPlaying());
			Log.i(WeatherConstants.TAG_WEATHERCONTROLLER,
					"Video is paused");
		}
	}
	
	/**
	 * Work in progress.
	 */
	public void getHeightOfVideo() {
		util.launchUiTab(WeatherConstants.VIDEOS_FRAGMENT, solo);
		solo.sleep(3000);
		MediaController mc = new MediaController (solo.getCurrentActivity());
		//mc.setAnchorView(videoObj.getVideoView(solo));
		//(videoObj.getVideoView(solo)).setMediaController(mc);
		System.out.println("b4 visibility" +mc.isShown());
		playVideo();
		solo.sleep(3000);
		solo.clickOnView(videoObj.getVideoView(solo));
		solo.sleep(3000);
		System.out.println("after visibility" +mc.isShown());
		//mc.show();
		solo.sleep(3000);
	}
	
	public void checkVideoPlayingAndNavToOtherCategories() {
		util.launchUiTab(WeatherConstants.VIDEOS_FRAGMENT, solo);
		playVideo();
		navigateVideoModuleCategories(WeatherConstants.VIDEO_WORLD);
		assertTrue((videoObj.getVideoView(solo)).isPlaying());
	}
	
	public void navigateVideoModuleCategories(final String videoCategories) {
		if (videoCategories.contains("MUST")) {
			solo.clickOnView(videoObj.getMustSeeButton(solo));
		} else if (videoCategories.contains("LOCAL")){
			solo.clickOnView(videoObj.getLocalUSButton(solo));
		} else if (videoCategories.contains("WORLD")){
			solo.clickOnView(videoObj.getWorldButton(solo));
		} else if (videoCategories.contains("ON TV")){
			solo.clickOnView(videoObj.getOnTVButton(solo));
		}
		solo.sleep(3000);
	}
	
	public int getVideoLength() {
		solo.sleep(2000);
		return videoObj.getVideoView(solo).getDuration();
	}
	
}
