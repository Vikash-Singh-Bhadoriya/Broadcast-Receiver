package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var airplaneModeChangedReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        airplaneModeChangedReceiver = object : BroadcastReceiver() {
            // this function will be executed when the user changes his airplane mode
            override fun onReceive(context: Context, intent: Intent) {
                // intent contains the information about the broadcast
                // in our case broadcast is change of airplane mode in "state"
                val isAirplaneModeEnabled = intent.getBooleanExtra("state", false)

                if (isAirplaneModeEnabled) {
                    Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_SHORT).show()
                    Log.d("TAG", "Airplane Mode Enabled")
                } else {
                    Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_SHORT).show()
                    Log.d("TAG", "Airplane Mode Disabled")
                }
            }
        }
        Log.d("TAG", "created airplaneModeChangedReceiver in onCreate()")
    }

    override fun onResume() {
        super.onResume()
        /*          REGISTER THE BROADCAST RECEIVER     */
        // Intent Filter specifies the type of intents that the component would like to receive (by action)
        registerReceiver(
            airplaneModeChangedReceiver,
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )
        Log.d("TAG", "registerReceiver - airplaneModeChangedReceiver in onResume()")
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(airplaneModeChangedReceiver)
        Log.d("TAG", "UnregisterReceiver - airplaneModeChangedReceiver in onPause()")
    }
}