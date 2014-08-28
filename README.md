AppHypeSDK
==========

# About AppHype Ad SDK Version 1.0

1. Opens an easy gateway for Android developers to serve a quality Video & FullScreen Ads
2. Leads a developer to earn stacks of money by serving a targeted ad that a user wants to see
3. Offers a solution to the Advertiser by showcasing their Ads to an app user
4. Read complete [API Documentation](http://apphype.shephertz.com/docs) on AppHype Ad Network Guide
5. A complete [Turtorial](http://apphype.shephertz.com/tutorial-android), How you can integrate it in your Existing Android Application

# Running Ad Sample

1. [Register/Login](http://apphype.shephertz.com/login) to use AppHype.
2. After signing up, create App(s) that you want to promote by submitting App's package name on  [Create App ](http://apphype.shephertz.com/app/apps#/addApp)page.
3. Create [Cross Promotion Campaign ](http://apphype.shephertz.com/app/apps#/createPromo)of the added App(s) to promote it in other App(s) 
4. Now, create another App(s) by adding it on [Create App ](http://apphype.shephertz.com/app/apps#/addApp)in which you wish to cross promote
5. You will get [Application Keys](http://apphype.shephertz.com/app/apps#/all) after App creation for SDK integration, which will be needed to initialize AppHype SDK
6. Download  AppHype Android [SDK] (https://github.com/VishnuGShephertz/AppHypeSDK/tree/AppHype-Version-1.0/archive/master.zip) with Sample Application
7. Import sample application in your IDE e.g Eclipse
8. Change package name of Sample Application with your application package name created in step 4 
9. Put your API and Secret Key of the App created in step 4 in SampleAppActivity.java file, generated in step 5 at line no 24

10. Build your Android application and install it in your device
11. Click on Load button of sample application, you will get the ad of the App(s) created in step 2

# To use AppHype SDK in existing Android Application



__1 Download  AppHype Android [SDK] (https://github.com/VishnuGShephertz/AppHypeSDK/tree/AppHype-Version-1.0/archive/master.zip)__

__2 Add apphype.jar and android-support-v4.jar in your application__

__3 Modify Android Manifest__ Change Your Application Package with your application package in AndroidManifest.xml file created in step 4 also add:


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

__4 Intialize AppHype__ Initialize AppHype SDK with the application Keys of the App in which you are cross promoting got in step 5.
```
AppHype
			.intialize(
					this,
					"Apphype Api Key",
					"Apphype Secret Key");
```

__5 Enable Logs__ While integrating AppHype Sdk you can also enable Sdk logs.

```
AppHype.enableLogs();

```
__6 Set AppHypeListener__ AppHype allow to handle callback event by adding AppHypeListener.

```
AppHype.setAppHypeListener(appHypeLister);

```

__7 Restrict Ad in Application__ You can also set maximum no. of application launch till you don’t want any Ad. This is an interesting feature to engage users in your app.
```
AppHype.restrictAd(restricLaunch);

```

__8 LoadAd__ You can request Ad by using the following code.

```
AppHype.preLoadAd(AdCode.Interstitial);
AppHype.preLoadAd(AdCode.Video);

```
__9 ShowAd__ If you want to show it on an event then you can use the following code.

```
  if(AppHype.isAvailable(AdCode.Interstitial))
		AppHype.showAd(activity,AdCode.Interstitial
		if(AppHype.isAvailable(AdCode.Video))
		AppHype.showAd(activity,AdCode.Video);
				
```
__10 CloseAd__  If you want to close this by using Api you can use following code.

```

	AppHype.closeAd();
				
```

			
__11 Handling AppHype Callback Events__ If you want to track an event or a message from SDK, you can add AppHypeLisener and gets callBack in following method.
``` 
    public interface AppHypeListener
   //Callback when Ad is shown
    public void onShow(AdCode adCode);

    //Callback when Ad is hide
        public void onHide(AdCode adCode);

   //Callback when Ad is Failed to show
        public void onFailedToShow(AppHypeException appHypeEx);

     //Callback when Ad is Available and you can call show function to implement Auto Show here
        public void onAdAvailable(AdCode adCode);

    //Callback when Ad Failed to Load
        public abstract void onFailedToLoad(AppHypeException appHypeEx);

    //CallBack when there is SDK integration exception
        public void onIntegrationError(AppHypeException appHypeEx);
}
				
```



