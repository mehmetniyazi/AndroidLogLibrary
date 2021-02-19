package com.example.libraryfirsttry.navigationlistener

import android.app.Activity
import android.app.Application
import android.os.Bundle

class NavigationListener(application: Application) {
    //application classında impelent edilmeli
    //aynısı fragment içinde bulunmalı
    

    private var application:Application
    init {
        this.application=application
    }

    private fun setupActivityListener() {
        application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                var d=""
            }
            override fun onActivityStarted(activity: Activity) {
                var d=""
            }
            override fun onActivityResumed(activity: Activity) {
                var d=""
            }

            override fun onActivityPaused(activity: Activity) {
                var d=""
            }

            override fun onActivityStopped(activity: Activity) {
                var d=""
            }
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                var d=""
            }
            override fun onActivityDestroyed(activity: Activity) {
                var d=""
            }
        })
    }
}