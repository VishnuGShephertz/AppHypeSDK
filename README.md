AppHypeSDK
==========

# About AppHype Ad SDK Version 1.0

1. Opens an easy gateway for Android developers to serve a quality Video & FullScreen Ads.
2. Leads a developer to earn stacks of money by serving a targeted ad that a user wants to see.
3. Offers a solution to the Advertiser by showcasing their Ads to an app user.
4. Read complete [API Documentation](http://50.112.109.96:8080/docs) on AppHype Ad Network Guide.
5. A complete [Turtorial](http://50.112.109.96:8080/tutorial-android), How you can integrate it in your Existing Android Application.

# Running Ad Sample

1. [Register/Login](http://50.112.109.96:8080/login) with AppHype Ad Network.
2. After signing up, Create your app that you want to promote by entering your app's package name to the [Create App](http://50.112.109.96:8080/App42Hype/app/apps#/addApp) page.
3. Now You can create Cross Promo Campaign of this App to promote it in Other App.Create [Cross Promotion Campaign](http://50.112.109.96:8080/App42Hype/app/apps#/createPromo) page. 
4. Create your App(s) by entering the name of your App's package to [Create App](http://50.112.109.96:8080/App42Hype/app/apps#/addApp) page.
5. Now you can get Your [Application Keys](http://50.112.109.96:8080/App42Hype/app/apps#/all) on By clicking Key of app, that are require for Ad SDK integration.
6. Download  AppHype Android [SDK] (https://github.com/VishnuGShephertz/AppHypeSDK/tree/AppHype-Version-1.0/archive/master.zip) with Sample Application.
7. Change Sample Application Package with your application package in AndroidManifest.xml file created in step 4. 
8.  Import Sample Application in Your IDE e.g Eclipse.
9. Put your API as well as Secret Key in SampleAppActivity.java file,generated in step 5 at line no 24..

10. Build your Android Application and run it on your device.
11. By Clicking Load button of sample application, you are able to get Ad of App that campaign create in step 3.

# Android AppHype SDK Integration



__1 Download  AppHype Android [SDK] (https://github.com/VishnuGShephertz/AppHypeSDK/tree/AppHype-Version-1.0/archive/master.zip)__

__2 Add apphype.jar and android-support-v4.jar in your__

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

__4 Intialize AppHype__ At your Launcher Activty intialize AppHype SDK by providing your Api and Secret key got in step 5.
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

__8 Load Ad__ You can request Ad by using the following code.

```
AppHype.loadAd(AdCode.Interstitial);
AppHype.loadAd(AdCode.Video);

```
__9 Show Ad__ If you want to show it on an event then you can use the following code.

```
  if(AppHype.isAvailable(AdCode.Interstitial))
		AppHype.showAd(activity,AdCode.Interstitial
		if(AppHype.isAvailable(AdCode.Video))
		AppHype.showAd(activity,AdCode.Video);
				
```
__10 Close Ad__  If you want to close this by using Api you can use following code.

```

	AppHype.closeAd();
				
```

			
__11 Handling AppHype Callback Events__ If you want to track an event or a message from SDK, you can add AppHypeLisener and gets callBack in following method.
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



