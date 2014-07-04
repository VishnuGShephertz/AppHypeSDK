AppHypeSDK
==========

# AppHype Ad SDK Version 1.0


1. AppHype Ad SDK creates as easy gateway for  Android developers to server quality Video as well as FullScreen Ads
2. AppHype SDK also provide developer to earn as much money by serving desired Ad that an Mobile user is willing to see.
3. AppHype SDK also provide a way for Advertiser to serve thier Ad to appropriate user.

# Running Ad Sample 

1. [Register](http://50.112.109.96:8080/login) with AppHype platform.
2. If you are already registered, login to [AppHype] (http://50.112.109.96:8080/login/index).
3. After Successfull login create an Android App by providing app details.
4. Download the AppHype Android  from [here] (https://github.com/VishnuGShephertz/AppHypeSDK/tree/AppHype-Version-1.0/archive/master.zip)
5. import the Sample Application in Eclipse from SDK.
5. Open SampleAppActivity.java file of sample project and make following changes.

```
A. Replace Apphype-Api-Keys and Apphype-Secret-Keys that you have received in step 2 or 3 at line number 28 and 29.

```
6. Build your android application and run on your android device.
7. Now you are able to get Ad in your Sample Application by making Ad request.

# Android AppHype SDK Integration

__1 Download AppHype SDK__ Download the AppHype Android  from [here] (https://github.com/VishnuGShephertz/AppHypeSDK/tree/AppHype-Version-1.0/archive/master.zip)


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

__3 Intialize AppHype SDK__ In your Launcher Activty Intialize AppHype SDK by providing your Api and Secret keys.If you want to receive CallBack event implements AppHypeListener in intialization 
```
AppHypeAPI
			.intialize(
					this,
					"<Apphype Api Keys>",
					"Apphype Secret Key",
					new AppHypeListener() );
```

__4 Enable Logs__ While integrating AppHype Sdk you can also enable Sdk logs 

```
AppHypeAPI.enableLogs();

```
__5 Set Max App Launch without Ad__ You can also set Maximum no of application launch untill you not want any Ads in you application ,
This is interesting feature to engage user with app.

```
AppHypeAPI.setLaunchNoAd(maxLaunch);

```

__6 FullScreen Ad__ You can request FullScreen Ad by using

```
FullScreenAd.load();

```
Showing Ad on an Event : If you want to show it on An event than you can use:

```
  if (FullScreenAd.isAvailable()
			FullScreenAd.show(Activty);
				
```
__7 Video Ad__ You can request Video Ad by using

```
VideoAd.load();

```
Showing Ad on an Event : If you want to show it on An event than you can use:

```
  if (VideoAd.isAvailable()
			VideoAd.show(Activty);
				
```
__7 Handling AppHype Callback event__ If you want to show Automatically and want to track event or message coming from SDK side you can implements AppHypeListener

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



