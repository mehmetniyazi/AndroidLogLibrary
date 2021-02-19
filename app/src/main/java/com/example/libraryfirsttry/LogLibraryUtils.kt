package com.example.libraryfirsttry

import android.app.Activity
import android.app.Application
import com.example.libraryfirsttry.errorUtils.ErrorUtils
import com.example.libraryfirsttry.hardwaredata.HardWareDataUtils
import com.example.libraryfirsttry.navigationlistener.NavigationListener

class LogLibraryUtils {
    private  var activity=Activity()
    private var application=Application()

    private  var hardWareDataUtils=HardWareDataUtils(null)

    private var errorUtils=ErrorUtils(null)

    private lateinit var navigationListener:NavigationListener
    fun initialiseApplication(app:Application){
        this.application=app
        this.navigationListener=NavigationListener(application)
    }

    fun initialiseActivity(activity: Activity){
        this.activity=activity
        this.errorUtils=ErrorUtils(this.activity)
        this.hardWareDataUtils=HardWareDataUtils(this.activity)
    }


    fun getBatteryLevel():String{
        return hardWareDataUtils.batteryLevel()
    }

    fun getNetworkType():String{
        return hardWareDataUtils.getNetworkType()
    }

    fun getNavigationReport():String{
        return navigationListener.getReport()
    }


}