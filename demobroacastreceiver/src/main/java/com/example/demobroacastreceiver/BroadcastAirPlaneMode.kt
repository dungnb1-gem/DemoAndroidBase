package com.example.demobroacastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class BroadcastAirPlaneMode : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(Settings.System.getInt(context?.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0){
            Toast.makeText(context, "Air Plane mode ON", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Air Plane mode OFF", Toast.LENGTH_LONG).show()
        }

    }

}