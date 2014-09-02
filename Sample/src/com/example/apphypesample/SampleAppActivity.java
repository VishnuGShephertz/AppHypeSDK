package com.example.apphypesample;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.shephertz.android.apphype.connector.AppHypeException;
import com.shephertz.android.apphype.sdk.AppHype;
import com.shephertz.android.apphype.sdk.AppHype.AppHypeListener;
import com.shephertz.android.apphype.util.AdCode;
import com.test.app.R;

public class SampleAppActivity extends Activity implements AppHypeListener {
	private boolean isInterstitialAuto = true;
	private boolean isVideoAuto = true;
	private TextView adStatus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_main);
		adStatus=(TextView)findViewById(R.id.ad_Status);
		AppHype.setAppHypeListener(this);
		AppHype.intialize(this, "Your AppHype API Key", "Your AppHype Secret Key");
		AppHype.enableLogs();
		adStatus.setText("intializing.....AppHype");
	}

	public void onInterstitialLoad(View view) {
		adStatus.setText("Loading.....Interstitial Ad");
		AppHype.preLoadAd(AdCode.Interstitial);
	}

	public void onVideoLoad(View view) {
		adStatus.setText("Loading.....Video Ad");
		AppHype.preLoadAd(AdCode.Video);
	}

	public final void onInterstitialShow(View view) {
		if (AppHype.isAvailable(AdCode.Interstitial)){
		
			AppHype.showAd(this, AdCode.Interstitial);
		}
		else
			adStatus.setText("Interstitial Ad is not available");
		
	}

	public void onAutoVideo(View view) {
		isVideoAuto = ((CheckBox) view).isChecked();
		if (!isVideoAuto)
			((Button) findViewById(R.id.showVideo)).setVisibility(View.VISIBLE);
		else
			((Button) findViewById(R.id.showVideo)).setVisibility(View.GONE);
	}

	public void onAutoInterstitial(View view) {
		isInterstitialAuto = ((CheckBox) view).isChecked();
		if (!isInterstitialAuto)
			((Button) findViewById(R.id.showInterstitial))
					.setVisibility(View.VISIBLE);
		else
			((Button) findViewById(R.id.showInterstitial))
					.setVisibility(View.GONE);
	}

	public void onVideoShow(View view) {
		if (AppHype.isAvailable(AdCode.Video))
			AppHype.showAd(this, AdCode.Video);
		else
			adStatus.setText("Video Ad is not available");
		
	}

	@Override
	public void onAdAvailable(AdCode adcode) {
		String message="onAdAvailable :  ";
		if(adcode==AdCode.Interstitial)
			message+="Interstitial Ad is Available";
		else if(adcode==AdCode.Video)
			message+="Video Ad is Available";
		displayMessage(message);
		displayAd();
	}

	@Override
	public void onShow(AdCode adcode) {
		String message="onShow :  ";
		if(adcode==AdCode.Interstitial)
			message+="Interstitial Ad is showing";
		else if(adcode==AdCode.Video)
			message+="Video Ad is showing";
		displayMessage(message);
	}

	@Override
	public void onHide(AdCode adcode) {
		String message="onHide :  ";
		if(adcode==AdCode.Interstitial)
			message+="Interstitial Ad is Hide";
		else if(adcode==AdCode.Video)
			message+="Video Ad is Hide";
		displayMessage(message);
	}

	@Override
	public void onFailedToShow(AppHypeException appHypeEx) {
		displayMessage("onFailedToShow :  "+appHypeEx.toString());
	}

	@Override
	public void onIntegrationError(AppHypeException appHypeEx) {
		displayMessage("onFailedToShow :  "+appHypeEx.toString());

	}

	private void displayMessage(final String error) {
		
		SampleAppActivity.this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				adStatus.setText(error);
			}
		});
	}
	

	private void displayAd() {
		SampleAppActivity.this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (AppHype.isAvailable(AdCode.Interstitial)) {
					if (isInterstitialAuto)
						AppHype.showAd(SampleAppActivity.this,
								AdCode.Interstitial);
				} else if (AppHype.isAvailable(AdCode.Video)) {
					if (isVideoAuto)
						AppHype.showAd(SampleAppActivity.this, AdCode.Video);
				}
			}
		});
	}

	@Override
	public void onFailedToLoad(AppHypeException appHypeEx) {
		displayMessage("onFailedToLoad :  "+appHypeEx.toString());
	}

}
