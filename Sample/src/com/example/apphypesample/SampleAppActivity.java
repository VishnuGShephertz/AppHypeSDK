package com.example.apphypesample;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.apphype.test.R;
import com.shephertz.android.apphype.sdk.AppHype;
import com.shephertz.android.apphype.sdk.AppHype.AppHypeListener;
import com.shephertz.android.apphype.util.AdCode;

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
		AppHype.intialize(this, "Your API Key", "Your Secret Key");
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
	public void onAdAvailable(String response) {
		displayResponse("onAdAvailable :  "+response);
		displayAd();
	}

	@Override
	public void onShow(String response) {
		displayResponse("onShow :  "+response);
	}

	@Override
	public void onHide(String response) {
		displayResponse("onHide :  "+response);
	}

	@Override
	public void onFailedToShow(String response) {
		displayResponse("onFailedToShow :  "+response);
	}

	@Override
	public void onIntegrationError(String response) {
		displayResponse("onFailedToShow :  "+response);

	}

	private void displayResponse(final String error) {
		
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
	public void onFailedToLoad(String response) {
		displayResponse("onFailedToLoad :  "+response);
	}

}
