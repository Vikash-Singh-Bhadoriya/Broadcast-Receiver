package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

private const val TAG = "AirplaneModeBR"

class AirplaneModeBR : BroadcastReceiver() {

    // this function will be executed when the user changes his airplane mode
    override fun onReceive(context: Context, intent: Intent) {
        // intent contains the information about the broadcast
        // in our case broadcast is change of airplane mode in "state"
        val isAirplaneModeEnabled = intent.getBooleanExtra("state", false)

        if (isAirplaneModeEnabled) {
            Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Airplane Mode Enabled")
        } else {
            Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Airplane Mode Disabled")
        }
    }
}