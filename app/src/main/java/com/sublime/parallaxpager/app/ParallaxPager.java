package com.sublime.parallaxpager.app;

import android.app.Application;

import com.sublime.parallaxpager.BuildConfig;
import com.sublime.parallaxpager.utils.Timber;

/**
 * Created by goonerdroid
 * on 18/1/18.
 */

public class ParallaxPager extends Application {

    @Override public void onCreate() {
        super.onCreate();
        //Initializes Timber logging only on debug build :-)
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
