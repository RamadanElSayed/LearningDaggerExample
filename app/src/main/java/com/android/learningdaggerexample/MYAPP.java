package com.android.learningdaggerexample;

import android.app.Application;

public class MYAPP extends Application {

    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
