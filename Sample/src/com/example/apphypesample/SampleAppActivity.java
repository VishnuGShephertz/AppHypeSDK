package com.example.apphypesample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.painless.pc.R;
import com.shephertz.android.apphype.sdk.AppHypeAPI;

import com.shephertz.android.apphype.sdk.AppHypeAPI.AppHypeListener;
import com.shephertz.android.apphype.sdk.FullScreenAd;
import com.shephertz.android.apphype.sdk.VideoAd;

public class SampleAppActivity extends Activity implements AppHypeListener {
	private boolean isFullScreenAuto = true;
	private boolean isVideoAuto = true;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			AppHypeAPI
			.intialize(
					this,
					"<Apphype Api Keys>",
					"Apphype Secret Key",
					this);
		AppHypeAPI.enableLogs();
		setContentView(R.layout.activity_main);
	}
	

	public void onFullScreenLoad(View view) {
	AppHypeAPI.loadFullScreenAd();
	}
	public void onVideoLoad(View view) {
		AppHypeAPI.loadVideoAd();
	}
	public final void onFullScreenShow(View view) {
		if(AppHypeAPI.isFullScreenAvailable())
		AppHypeAPI.showFullScreenAd(this);
		
	}

	public void onAutoVideo(View view){
		isVideoAuto=((CheckBox) view).isChecked();
		if(!isVideoAuto)
			((Button) findViewById(R.id.showVideo)).setVisibility(View.VISIBLE);
		else
			((Button) findViewById(R.id.showVideo)).setVisibility(View.GONE);
	}
	public void onAutoFullScreen(View view){
		isFullScreenAuto=((CheckBox) view).isChecked();
		if(!isFullScreenAuto)
			((Button) findViewById(R.id.showFullScreen)).setVisibility(View.VISIBLE);
		else
			((Button) findViewById(R.id.showFullScreen)).setVisibility(View.GONE);
	}
	

	public void onVideoShow(View view) {

		if (AppHypeAPI.isVideoAvailable()) {
			AppHypeAPI.showVideoAd(this);
		}
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
				if (AppHypeAPI.isFullScreenAvailable() && notify) {
					Toast.makeText(SampleAppActivity.this,
							"FullScreen ad is available.You can show it",
							Toast.LENGTH_SHORT).show();
					if(isFullScreenAuto)
						AppHypeAPI.showFullScreenAd(SampleAppActivity.this);;
				} 
				else if (AppHypeAPI.isVideoAvailable() && notify) {
					Toast.makeText(SampleAppActivity.this,
							"Video ad is available, You can show it",
							Toast.LENGTH_SHORT).show();
					if(isVideoAuto)
						AppHypeAPI.showVideoAd(SampleAppActivity.this);
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
