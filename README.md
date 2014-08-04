AppHypeSDK
==========

# About AppHype Ad SDK Version 1.0

1. Opens an easy gateway for Android developers to serve a quality Video & FullScreen Ads.
2. Leads a developer to earn stacks of money by serving a targeted ad that a user wants to see.
3. Offers a solution to the Advertiser by showcasing their Ads to an app user.

# Running Ad Sample

1. [Register](http://50.112.109.96:8080/login) with AppHype platform.
2. If you are already registered, login to [AppHype] (http://50.112.109.96:8080/login/index).
3. 3. After you have successfully logged in, create an Android App by entering app details.
4. Download  AppHype Android [SDK] (https://github.com/VishnuGShephertz/AppHypeSDK/tree/AppHype-Version-1.0/archive/master.zip)
5. Import the Sample Application in Eclipse from SDK.
5. Open the SampleAppActivity.java file of sample project and make the following changes.

```
A. Replace Apphype-Api-Keys and Apphype-Secret-Keys that you have received in step 2 or 3 at line number 28 and 29.

```
6. Build your Android Application and run it on your device.
7. Now, you will be able to see Ads in your Sample Application by making an Ad request

# Android AppHype SDK Integration

__1 Download AppHype [SDK] (https://github.com/VishnuGShephertz/AppHypeSDK/tree/AppHype-Version-1.0/archive/master.zip)__


__2 Modify Android Manifest__ Chnage the Application package name with the App Package you have created on AppHype Console on Above Step.
Add permissions 
```
 <uses-permission android:name="android.permission.INTERNET"></uses-permission>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
 <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
   <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
```

Add Activities

```
  <activity android:name="com.shephertz.android.apphype.sdk.InterstitialAdActivity" android:configChanges="keyboardHidden|orientation|screenSize|smallestScreenSize" />
        <activity android:name="com.shephertz.android.apphype.sdk.VideoAdActivity" android:screenOrientation="landscape"
             android:configChanges="keyboardHidden|orientation|screenSize|smallestScreenSize" />
```
Add Receiver

```
 <receiver android:name="com.shephertz.android.apphype.sdk.AppHypeReceiver">
            <intent-filter>
                <data android:scheme="package"/>
                <action android:name="android.intent.action.PACKAGE_ADDED"/>
            </intent-filter>
        </receiver>
```

__3 Intialize AppHype SDK__ At your Launcher Activty intialize AppHype SDK by providing your Api and Secret key.If you want to receive a CallBack event implement AppHypeListener during intialization 
```
AppHype
			.intialize(
					this,
					"Apphype Api Key",
					"Apphype Secret Key");
```

__4 Enable Logs__ While integrating AppHype Sdk you can also enable Sdk logs.

```
AppHype.enableLogs();

```
__5 Set AppHypeListener__ AppHype allow to handle callback event by adding AppHypeListener.

```
AppHype.setAppHypeListener(appHypeLister);

```

__7 Set Max App Launch without Ad__ You can also set maximum no. of application launch till you don’t want any Ad. This is an interesting feature to engage users in your app.
```
AppHype.setLaunchTillNoAd(maxLaunch);

```

__8 Load Ad__ You can request Ad by using the following code.

```
AppHype.loadAd(AdCode.Interstitial);
AppHype.loadAd(AdCode.Video);

```
Show Ad: If you want to show it on an event then you can use the following code.

```
  if(AppHype.isAdAvailable(AdCode.Interstitial))
		AppHype.showAd(activity,AdCode.Interstitial
		if(AppHype.isAdAvailable(AdCode.Video))
		AppHype.showAd(activity,AdCode.Video);
				
```
Close Ad: If you want to close this by using Api you can use following code.

```

	AppHype.closeAd();
				
```

			
__10 Handling AppHype Callback Events__ If you want to track an event or a message from SDK, you can add AppHypeLisener and gets callBack in following method.
``` 
    public interface AppHypeListener
   //Callback when Ad is shown
    public void onShow(String paramString);

    //Callback when Ad is hide
        public void onHide(String paramString);

   //Callback when Ad is Failed to show
        public void onFailedToShow(String paramString);

     //Callback when Ad is Available and you can call show function to implement Auto Show here
        public void onAdAvailable(String paramString);

    //Callback when Ad Failed to Load
        public abstract void onFailedToLoad(String paramString);

    //CallBack when there is SDK integration errors
        public void onIntegrationError(String error);
}
				
```



