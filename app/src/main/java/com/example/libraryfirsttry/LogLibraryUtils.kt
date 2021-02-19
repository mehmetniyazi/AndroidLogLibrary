package com.example.libraryfirsttry

import android.app.Activity
import android.app.Application
import com.example.libraryfirsttry.errorUtils.ErrorUtils
import com.example.libraryfirsttry.hardwaredata.HardWareDataUtils
import com.example.libraryfirsttry.navigationlistener.NavigationListener

class LogLibraryUtils {
    private  var activity=Activity()
    private var application=Application()


    fun initialiseApplication(app:Application){
        this.application=app
        NavigationListener(application)
    }

    fun initialiseActivity(activity: Activity){
        this.activity=activity
        ErrorUtils(this.activity)
        HardWareDataUtils(this.activity)
    }
}