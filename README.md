AppHypeSDK
==========

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
6. Download  [AppHype Android SDK] (https://github.com/VishnuGShephertz/AppHypeSDK/archive/AppHype-Version-1.0.zip) with Sample Application
7. Import sample application in your IDE e.g Eclipse
8. Change package name of Sample Application with your application package name created in step 4 
9. Put your API and Secret Key of the App created in step 4 in SampleAppActivity.java file, generated in step 5 at line no 24

10. Build your Android application and install it in your device
11. Click on Load button of sample application, you will get the ad of the App(s) created in step 2

# To use AppHype SDK in existing Android Application



__1.__ Download  [AppHype Android SDK] (https://github.com/VishnuGShephertz/AppHypeSDK/archive/AppHype-Version-1.0.zip)

__2.__ Add apphype.jar and android-support-v4.jar in your application

__3.__ In AndroidManifest.xml file, package name of your App and the App added on AppHype in which you wish to cross promote should be same

__4.__ Copy the code given below in your AndroidManifest.xml


```
		/Add Android Permissions
		<uses-permission android:name="android.permission.INTERNET"/> 
                <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
                <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/> 
                <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
	
         //Add Android Activities
    <activity android:name="com.shephertz.android.apphype.sdk.InterstitialAdActivity						android:configChanges="keyboardHidden|orientation|screenSize|smallestScreenSize"/>
    <activity android:name="com.shephertz.android.apphype.sdk.VideoAdActivity"
     android:configChanges="keyboardHidden|orientation|screenSize|smallestScreenSize"
    android:screenOrientation="landscape" />
	
    //Add Android Receiver
    <receiver android:name="com.shephertz.android.apphype.sdk.AppHypeReceiver">
        <intent-filter>
            <data android:scheme="package" />
            <action android:name="android.intent.action.PACKAGE_ADDED" />
        </intent-filter>
    </receiver>
```


__5.__ Initialize AppHype SDK with the application Keys of the App in which you are cross promoting
```
AppHype.intialize("Android application context","Apphype Api Key","Apphype Secret Key");
```

__6.__ To enable logs in application

```
AppHype.enableLogs();

```
__7.__ To handle callBack events from AppHype SDK developer should set AppHypeListener

```
AppHype.setAppHypeListener(appHypeLister);

```

__8.__ Developer can put restrictions on when to show ads in App(s)
```
AppHype.restrictAd(restricLaunch);

```

__9.__ To show ads in application, developer has to preLoad them e.g Video or Interstitial

```
AppHype.preLoadAd(AdCode.Interstitial);
AppHype.preLoadAd(AdCode.Video);

```
__10.__ Developer can show ads in application only if, they are available.

```
  if(AppHype.isAvailable(AdCode.Interstitial))
		AppHype.showAd(activity,AdCode.Interstitial
		if(AppHype.isAvailable(AdCode.Video))
		AppHype.showAd(activity,AdCode.Video);
				
```
__11.__ Developer can close Ad with API as well

```
	AppHype.closeAd();
```

			
__12.__ If you want to track an event or a message from SDK, you can add AppHypeLisener and gets callBack in following method.
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



