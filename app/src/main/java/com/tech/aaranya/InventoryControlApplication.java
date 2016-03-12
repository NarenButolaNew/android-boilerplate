package com.tech.aaranya;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.firebase.client.Firebase;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * Created by test on 3/12/16.
 */
public class InventoryControlApplication extends Application {

    //ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
           // Fabric.with(this, new Crashlytics());
        }
    }

    public static InventoryControlApplication get(Context context) {
        return (InventoryControlApplication) context.getApplicationContext();
    }

//    public ApplicationComponent getComponent() {
//        if (mApplicationComponent == null) {
//            mApplicationComponent = DaggerApplicationComponent.builder()
//                    .applicationModule(new ApplicationModule(this))
//                    .build();
//        }
//        return mApplicationComponent;
//    }
//
//    // Needed to replace the component with a test specific one
//    public void setComponent(ApplicationComponent applicationComponent) {
//        mApplicationComponent = applicationComponent;
//    }
}
