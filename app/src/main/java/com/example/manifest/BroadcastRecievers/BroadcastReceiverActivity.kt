package com.example.manifest.BroadcastRecievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.manifest.R

class BroadcastReceiverActivity : AppCompatActivity() {
    lateinit var receiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)

        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED) // зарядка подключена
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)// зарядка отключена
         receiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?,intent: Intent?) {
                Toast.makeText(context,intent?.action,Toast.LENGTH_SHORT).show() // вывод смс
            }
        }
        registerReceiver(receiver,filter)
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}