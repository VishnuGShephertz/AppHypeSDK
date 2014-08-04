package com.example.apphypesample;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.shephertz.android.apphype.sdk.AppHype;
import com.shephertz.android.apphype.sdk.AppHype.AppHypeListener;
import com.shephertz.android.apphype.util.AdCode;
import com.test.apppp.R;

public class SampleAppActivity extends Activity implements AppHypeListener {
	private boolean isInterstitialAuto = true;
	private boolean isVideoAuto = true;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppHype.setAppHypeListener(this);
			AppHype
			.intialize(
					this,
					"fc8e500c0a9edff730302d84eb63a90b55c45ba816d83961305ef1b5eee38331",
					"fe5d142e0e1ec9921fdc42f805100c95e4a672fd0d8e9bb7bdeb2adc2b4e3729");
		AppHype.enableLogs();
		setContentView(R.layout.activity_main);
	}
	

	public void onInterstitialLoad(View view) {
	AppHype.preLoadAd(AdCode.Interstitial);
	}
	public void onVideoLoad(View view) {
		AppHype.preLoadAd(AdCode.Video);
	}
	public final void onInterstitialShow(View view) {
		if(AppHype.isAvailable(AdCode.Interstitial))
		AppHype.showAd(this,AdCode.Interstitial);
		
	}

	public void onAutoVideo(View view){
		isVideoAuto=((CheckBox) view).isChecked();
		if(!isVideoAuto)
			((Button) findViewById(R.id.showVideo)).setVisibility(View.VISIBLE);
		else
			((Button) findViewById(R.id.showVideo)).setVisibility(View.GONE);
	}
	public void onAutoInterstitial(View view){
		isInterstitialAuto=((CheckBox) view).isChecked();
		if(!isInterstitialAuto)
			((Button) findViewById(R.id.showInterstitial)).setVisibility(View.VISIBLE);
		else
			((Button) findViewById(R.id.showInterstitial)).setVisibility(View.GONE);
	}
	

	public void onVideoShow(View view) {

		if(AppHype.isAvailable(AdCode.Video))
			AppHype.showAd(this,AdCode.Video);
	}

	@Override
	public void onAdAvailable(String tag) {
		SampleAppActivity.this.displayMessage(true);
	}

	@Override
	public void onShow(String tag) {
		SampleAppActivity.this.displayMessage(false);
	}

	@Override
	public void onHide(String tag) {
	}
	

	@Override
	public void onFailedToShow(String message) {
		SampleAppActivity.this.displayError(message);
	}
	@Override
	public void onIntegrationError(String error) {
		// TODO Auto-generated method stub
		Log.d("AppHype-Error", error);
		displayError(error);
		
	}
	
	
	private void displayError(final String error) {
		SampleAppActivity.this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				
					Toast.makeText(SampleAppActivity.this,
							error,
							Toast.LENGTH_SHORT).show();
					Toast.makeText(SampleAppActivity.this,
							error,
							Toast.LENGTH_SHORT).show();
			}
		});
	}
	private void displayMessage(final Boolean notify) {
		SampleAppActivity.this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (AppHype.isAvailable(AdCode.Interstitial) && notify) {
					Toast.makeText(SampleAppActivity.this,
							"Interstitial ad is available.You can show it",
							Toast.LENGTH_SHORT).show();
					if(isInterstitialAuto)
						AppHype.showAd(SampleAppActivity.this,AdCode.Interstitial);
				} 
				else if (AppHype.isAvailable(AdCode.Video) && notify) {
					Toast.makeText(SampleAppActivity.this,
							"Video ad is available, You can show it",
							Toast.LENGTH_SHORT).show();
					if(isVideoAuto)
						AppHype.showAd(SampleAppActivity.this,AdCode.Video);
				}
			}
		});
	}


	@Override
	public void onFailedToLoad(String message) {
		// TODO Auto-generated method stub
		displayError(message);
	}


	

	
}
