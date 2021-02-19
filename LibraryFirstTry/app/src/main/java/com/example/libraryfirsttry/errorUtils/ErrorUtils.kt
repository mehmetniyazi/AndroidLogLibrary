package com.example.libraryfirsttry.errorUtils

import android.app.Activity
import android.util.Log

class ErrorUtils(app: Activity?) : Thread.UncaughtExceptionHandler {
    private val exceptionHandler: Thread.UncaughtExceptionHandler
    private var activity: Activity? = null

    init {
        exceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        this.activity = app
    }


    override fun uncaughtException(t: Thread, error: Throwable) {
        var arr = error.stackTrace
        var report = """$error""".trimIndent()
        for (i in arr.indices) {
            report += "${arr[i]}"
        }
        report += "--------- Cause ---------\n\n"
        val cause = error.cause
        if (cause != null) {
            report += """
                $cause
                """.trimIndent()
            arr = cause.stackTrace
            for (i in arr.indices) {
                report += "${arr[i]}"
            }
        }
        report += "-------------------------------\n\n"
        Log.d("reopoorttt",report)
        exceptionHandler.uncaughtException(t, error)
    }


}