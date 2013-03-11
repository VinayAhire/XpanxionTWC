package com.weather.Weather.Objects;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;
import com.weather.Weather.R;
import com.weather.Weather.view.VideoViewWithMidpoint;

public class VideoModuleObjects {
	
	public VideoViewWithMidpoint getVideoView(Solo solo) {
		VideoViewWithMidpoint videoView = (VideoViewWithMidpoint) solo
				.getView(R.id.video_view);
		return videoView;
	}
	
	public ImageView getImageViewPlayButton(Solo solo) {
		ImageView playButton = (ImageView) solo.getView(R.id.play_button);
		return playButton;
	}
	
	public TextView getTextViewVideoLoading(Solo solo) {
		TextView videoLoading = (TextView) solo.getView(R.id.video_loading);
		return videoLoading;
	}
	
	public Button getMustSeeButton(Solo solo){
		Button mustSeeBtn = (Button)solo.getView(R.id.btn_must_see);
		return mustSeeBtn;

	}
	
	public Button getLocalUSButton(Solo solo) {
		Button localVideos = (Button) solo.getView(R.id.btn_local_us);
		return localVideos;
	}
	
	public Button getWorldButton(Solo solo) {
		Button worldVideos = (Button) solo.getView(R.id.btn_world);
		return worldVideos;
	}
	
	public Button getOnTVButton(Solo solo) {
		Button onTVVideos = (Button) solo.getView(R.id.btn_on_tv);
		return onTVVideos;
	}
	
	public ImageView getLearnMoreImage(Solo solo) {
		ImageView learnMore = (ImageView) solo.getView(R.id.learn_more);
		return learnMore;
	}
}
