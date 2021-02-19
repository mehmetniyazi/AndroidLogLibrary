package com.example.libraryfirsttry.errorUtils

import android.app.Activity
import android.util.Log

class ErrorUtils(app: Activity?) : Thread.UncaughtExceptionHandler {
    private val exceptionHandler: Thread.UncaughtExceptionHandler
    private var activity: Activity? = null
    private var errorReport:String=""

    init {
        exceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        this.activity = app
    }

    fun getReport():String{
        return errorReport
    }
    override fun uncaughtException(t: Thread, error: Throwable) {
        var arr = error.stackTrace
        errorReport = """$error""".trimIndent()
        for (i in arr.indices) {
            errorReport += "${arr[i]}"
        }
        errorReport += "--------- Cause ---------\n\n"
        val cause = error.cause
        if (cause != null) {
            errorReport += """
                $cause
                """.trimIndent()
            arr = cause.stackTrace
            for (i in arr.indices) {
                errorReport += "${arr[i]}"
            }
        }
        errorReport += "-------------------------------\n\n"
        Log.d("reopoorttt",errorReport)
        exceptionHandler.uncaughtException(t, error)
    }


}