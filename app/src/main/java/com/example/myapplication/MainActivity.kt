package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var airplaneModeChangedReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        /*          CREATING THE BROADCAST RECEIVER     */
        airplaneModeChangedReceiver = AirplaneModeBR()
        Log.d(TAG, "created airplaneModeChangedReceiver in onResume()")

        /*          REGISTER THE BROADCAST RECEIVER     */
        // Intent Filter specifies the type of intents that the component would like to receive (by action)
        registerReceiver(
            airplaneModeChangedReceiver,
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )
        Log.d(TAG, "registerReceiver - airplaneModeChangedReceiver in onResume()")
    }

    override fun onPause() {
        super.onPause()
        /*          UNREGISTER THE BROADCAST RECEIVER     */
        unregisterReceiver(airplaneModeChangedReceiver)
        Log.d(TAG, "UnregisterReceiver - airplaneModeChangedReceiver in onPause()")
    }
}