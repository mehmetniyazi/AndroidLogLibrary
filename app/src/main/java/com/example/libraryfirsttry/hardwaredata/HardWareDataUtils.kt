package com.example.libraryfirsttry.hardwaredata

import android.app.Activity
import android.content.Context.BATTERY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.BatteryManager
import android.os.Build
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class HardWareDataUtils(app: Activity?) {

    val TYPE_WIFI = "WIFI"
    val TYPE_MOBILE = "MOBILE DATA"
    val UNDIFINED = "UNDIFNED"

    private var activity: Activity? = null

    private var networkType:String=this.UNDIFINED
    private var bataryLevel:String=""

    init {
        this.activity = app
        networkType=checkConnection()
        bataryLevel=batarryLevel()
    }

    /**
     * Bu method network ün değiştiğini dinliyor.
     * Kullanıcı uygulama içerisindeyken wifi 'den mobil dataya gecerse
     * yanlıs bilgi gonderilmemesi için ekledim
     */
    fun netoworkCallBackListener(){
        val networkCallback: ConnectivityManager.NetworkCallback =
                object : ConnectivityManager.NetworkCallback() {
                    override fun onAvailable(network: Network) {
                        networkType=checkConnection()
                        Log.d("logLibrary", "Netowrk changed")
                    }

                    override fun onLost(network: Network) {
                        Log.d("logLibrary", "Netowork lost")

                    }
                }

        val connectivityManager =
                activity?.getSystemService(AppCompatActivity.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(networkCallback)
        } else {
            val request = NetworkRequest.Builder()
                    .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build()
            connectivityManager.registerNetworkCallback(request, networkCallback)
        }
    }

    /**
     * Developer gerektiği takdirde direk cagırabilir.
     */
    fun checkConnection(): String {
        val connMgr = activity?.getSystemService(AppCompatActivity.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connMgr != null) {
            val activeNetworkInfo = connMgr.activeNetworkInfo
            if (activeNetworkInfo != null) { // connected to the internet
                // connected to the mobile provider's data plan
                return if (activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI) {
                    // connected to wifi
                   TYPE_WIFI
                } else if(activeNetworkInfo.type == ConnectivityManager.TYPE_MOBILE){
                    TYPE_MOBILE
                }else{
                    UNDIFINED
                }
            }
        }
        return UNDIFINED
    }


    /**
     * Developer gerektiği takdirde direk cagırabilir.
     */
    fun batarryLevel():String{
        val bm= activity?.getSystemService(BATTERY_SERVICE) as BatteryManager
        val batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        return batLevel.toString()
    }

}