package com.example.manifest.Service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.manifest.R

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = Intent(this, MyService::class.java) //записываю в переменную от куда будет браться сервис
        startService(service)// запуск сервиса
        setContentView(R.layout.activity_service)
    }
}