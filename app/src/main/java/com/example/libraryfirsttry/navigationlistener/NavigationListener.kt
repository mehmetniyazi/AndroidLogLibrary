package com.example.libraryfirsttry.navigationlistener

import android.app.Activity
import android.app.Application
import android.os.Bundle

class NavigationListener(application: Application) {
    //application classında impelent edilmeli
    //aynısı fragment içinde bulunmalı
    


    /**bu class sayesinde tum activitylerin lifecycyclarını listenlayabiliyoruz
     * .Bu sayede yapılan her işlemi
     * kayıt edebiliriz orneğin ben report stringin ekledim tum adımlarını ve
     * bu sayede hangi sayfaları gezediğini loglayabiliriz.
     *
    **/
    private var application:Application

    private var report:String=""

    init {
        this.application=application
        setupActivityListener()
    }

    fun getReport():String{
        return report
    }

    private fun setupActivityListener() {
        application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                report+=activity.toString()+"Created +\n"
            }
            override fun onActivityStarted(activity: Activity) {
                report+=activity.toString()+"Started \n"
            }
            override fun onActivityResumed(activity: Activity) {
                report+=activity.toString()+"Resumed \n"
            }

            override fun onActivityPaused(activity: Activity) {
                report+=activity.toString()+"Paused \n"
            }

            override fun onActivityStopped(activity: Activity) {
                report+=activity.toString()+"Stopped \n"
            }
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                report+=activity.toString()+"OnSavedInstanceState \n"
            }
            override fun onActivityDestroyed(activity: Activity) {
                report+=activity.toString()+"Destroyed \n"
            }
        })
    }
}