package com.example.demobroacastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BroadcastCalculation() : BroadcastReceiver() {

    lateinit var listener: OnSendDataListener

    constructor(listener: OnSendDataListener) : this() {
        this.listener = listener
    }

    override
    fun onReceive(context: Context?, intent: Intent?) {
        var result = intent?.getIntExtra("result", 0)
        if (result != null) {
            listener.sendData(result)
        }
    }

    interface OnSendDataListener {
        fun sendData(result: Int)
    }

}