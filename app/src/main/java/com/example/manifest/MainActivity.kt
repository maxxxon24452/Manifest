package com.example.manifest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.manifest.BroadcastRecievers.BroadcastReceiverActivity
import com.example.manifest.Contentproviders.ContentProvidersActivity
import com.example.manifest.Service.ServiceActivity
import com.example.manifest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun Services(view:View){ //переход на сервисы активити
        val intent_services = Intent(this,ServiceActivity::class.java)
        startActivity(intent_services)
    }

    fun BroadcastReceiver(view:View){//переход на броадкаст
        val intent_broadcast = Intent(this,BroadcastReceiverActivity::class.java)
        startActivity(intent_broadcast)
    }
    fun ContentProvider(view:View){//переход на контент провайдер
        val intent_content_provider = Intent(this,ContentProvidersActivity::class.java)
        startActivity(intent_content_provider)
    }
}