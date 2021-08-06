package com.example.conbook

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import layout.DataBase

class Register : AppCompatActivity(){

    private lateinit var UserName:String
    private lateinit var ConfirmPassword:String
    private lateinit var Password:String

    var DB = DataBase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var registerButt = findViewById<Button>(R.id.register2)
        registerButt.setOnClickListener(View.OnClickListener {
            AddtoDb()
        })

    }

    private fun AddtoDb() {

        UserName = findViewById<TextInputLayout>(R.id.UserName).getEditText()?.getText().toString()
        Password = findViewById<TextInputLayout>(R.id.Password).getEditText()?.getText().toString()
        ConfirmPassword = findViewById<TextInputLayout>(R.id.ConfirmPassword).getEditText()?.getText().toString()

        if(!Password.equals(ConfirmPassword)){
            Toast.makeText(this, "Passwords Doesn't match!", Toast.LENGTH_SHORT).show()
            return
        }
        if(UserName == "" || Password ==""){}else{
            if(DB.check(UserName, Password!!))
            {
                Toast.makeText(this, "User Already Exists!", Toast.LENGTH_SHORT).show()
            }else{
                var res = DB.insert(UserName!!,Password!!)
                Toast.makeText(this, "Successfully Registered with UserName : ${UserName} ", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
            }

    }






        findViewById<TextInputLayout>(R.id.UserName).getEditText()?.setText("")
        findViewById<TextInputLayout>(R.id.Password).getEditText()?.setText("")
        findViewById<TextInputLayout>(R.id.ConfirmPassword).getEditText()?.setText("")

    }


}