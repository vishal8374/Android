package com.example.conbook

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {

    private lateinit var Animat:Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Animat = AnimationUtils.loadAnimation(this,R.anim.ani)
        findViewById<TextView>(R.id.text5).animation = Animat
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, 6000)
}}