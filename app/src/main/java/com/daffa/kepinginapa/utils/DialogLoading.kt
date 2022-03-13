package com.daffa.kepinginapa.utils

import android.app.Activity
import android.app.AlertDialog
import com.daffa.kepinginapa.R

class DialogLoading(private val activity: Activity) {
    private lateinit var isdialog: AlertDialog
    fun show() {
        /**set View*/
        val infalter = activity.layoutInflater
        val dialogView = infalter.inflate(R.layout.dialog_loading, null)

        /**set Dialog*/
        val bulider = AlertDialog.Builder(activity)
        bulider.setView(dialogView)
        bulider.setCancelable(false)
        isdialog = bulider.create()
        isdialog.show()
    }

    fun dismiss() {
        isdialog.dismiss()
    }
}