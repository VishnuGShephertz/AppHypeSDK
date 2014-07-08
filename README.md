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


__2 Modify Android Manifest__ 
Add permissions 
```
 <uses-permission android:name="android.permission.INTERNET"></uses-permission>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
 <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
   <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
```

Add Activities

```
  <activity android:name="com.shephertz.android.apphype.sdk.FullScreenAdActivity" android:configChanges="keyboardHidden|orientation|screenSize|smallestScreenSize" />
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
AppHypeAPI
			.intialize(
					this,
					"<Apphype Api Keys>",
					"Apphype Secret Key");
```

__4 Enable Logs__ While integrating AppHype Sdk you can also enable Sdk logs.

```
AppHypeAPI.enableLogs();

```
__4 Set AppHypeListener__ AppHype allow to handle callback event by adding AppHypeListener.

```
AppHypeAPI.setAppHypeListener(appHypeLister);

```

__4 Reset\Remove AppHypeListener__ You can also remove calback appHypeListener by using following code.

```
AppHypeAPI.resetAppHypeListener();

```
__5 Set Max App Launch without Ad__ You can also set maximum no. of application launch till you don’t want any Ad. This is an interesting feature to engage users in your app.
```
AppHypeAPI.setLaunchNoAd(maxLaunch);

```

__6 FullScreen Ad__ You can request FullScreen Ad by using the following code.

```
AppHypeAPI.loadFullScreenAd();

```
Showing an Ad on an event: If you want to show it on an event then you can use the following code.

```
  if(AppHypeAPI.isFullScreenAvailable())
		AppHypeAPI.showFullScreenAd(activity);
				
```
__7 Video Ad__ You can request Video Ad by using the following code.

```
AppHypeAPI.loadVideoAd()

```
Showing an Ad on an event: If you want to show it on an event then you can use the following code.

```
   if(AppHypeAPI.isVideoAvailable())
		AppHypeAPI.showVideoAd(activity);
				
				
```
__7 Handling AppHype Callback Events__ If you want to track an event or a message from SDK, you can add AppHypeLisener and gets callBack in following method.
``` 
    //Callback when Ad is shown
    public abstract void onShow(String paramString);
    
    //Callback when Ad is hide
		public abstract void onHide(String paramString);
		
   //Callback when Ad is Failed to show
		public abstract void onFailedToShow(String paramString);
		
     //Callback when Ad is Available and you can call show function to implement Auto Show here
		public abstract void onAdAvailable(String paramString);

    //Callback when Ad Failed to Load
		public abstract void onFailedToLoad(String paramString);
    
    //CallBack when there is SDK integration errors
		public abstract void onIntegrationError(String error);
				
```



