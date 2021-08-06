
package com.example.conbook

import android.app.ProgressDialog.show
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputLayout
import layout.DataBase


class MainActivity : AppCompatActivity() {


    private lateinit var name : String
    var password : String? =null
    var DB = DataBase(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)




        val login:Button = findViewById(R.id.login)
        val register:Button = findViewById(R.id.register)


        login.setOnClickListener(View.OnClickListener {

            openTab()
        })

        register.setOnClickListener(View.OnClickListener {
            openRegister()
        })


    }

    override fun onRestart() {
        super.onRestart()
        if(name.equals("") || name.equals(null) || name.equals("null")) { }else{
            Toast.makeText(this, "Welcome Back ${name}", Toast.LENGTH_SHORT).show()

        }
    }

    private fun openRegister() {

        val i: Intent = Intent(this, Register::class.java)
        startActivity(i)
    }


    fun openTab(){


        name = findViewById<TextInputLayout>(R.id.name).getEditText()?.getText().toString()
        password = findViewById<TextInputLayout>(R.id.password).getEditText()?.getText().toString()




        if(name == ""  && password == ""){
            Toast.makeText(this, "Please,Enter Name and Password", Toast.LENGTH_SHORT).show()
        }

        else if(name == ""){
            Toast.makeText(this, "Please,Enter Name", Toast.LENGTH_SHORT).show()
            return
        }

        else if(password == ""){
            Toast.makeText(this, "Please,Enter Password", Toast.LENGTH_SHORT).show()
            return
        }else {
            var checking = DB.check(name, password!!)

                if(checking) {
                    val i: Intent = Intent(this, MainScreen::class.java)
                    i.putExtra("name", name)
                    startActivity(i)
                }else{
                    Toast.makeText(this, "User Not Found!Please Register!", Toast.LENGTH_SHORT).show()
                }
        }
        findViewById<TextInputLayout>(R.id.name).getEditText()?.setText("")
        findViewById<TextInputLayout>(R.id.password).getEditText()?.setText("")
    }


}