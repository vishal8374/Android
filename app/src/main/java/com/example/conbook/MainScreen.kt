package com.example.conbook

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import layout.DataBase
import java.nio.file.Files.size

class MainScreen : AppCompatActivity() {


    private lateinit var dialog : Dialog



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        var dynamic = findViewById<TextView>(R.id.dynamic)
        val inten = intent.getStringExtra("name")
        dynamic.setText("Welcome ${inten}")

        var ContactButton =   findViewById<FloatingActionButton>(R.id.AddContact)
     ContactButton.setOnClickListener(View.OnClickListener {
         AddConatct()
     })


        findViewById<Button>(R.id.Signout).setOnClickListener(View.OnClickListener {
            signout()
        })



        findViewById<Button>(R.id.ViewUsers).setOnClickListener(View.OnClickListener {
            viewUsers()
        })

        var displayButt = findViewById<Button>(R.id.Dispaycontact)
        displayButt.setOnClickListener(View.OnClickListener {
            showContacts()
        })
    }


    fun viewUsers(){
        startActivity(Intent(this,Viewusers::class.java))
    }

    fun signout() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }


    private fun showContacts() {
        startActivity(Intent(this,Concreate::class.java))
    }


    private fun AddConatct() {
        var db = DataBase(this)
        dialog = Dialog(this)
        dialog.setContentView(R.layout.contactadd)
        dialog.getWindow()?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.show()

        var submit = dialog.findViewById<Button>(R.id.submit)
        submit.setOnClickListener(View.OnClickListener {
            val ctcName = dialog.findViewById<EditText>(R.id.contactname).getText().toString()
            val ctcEmail = dialog.findViewById<EditText>(R.id.Email).getText().toString()
            val ctcNumber = dialog.findViewById<EditText>(R.id.Number).getText().toString()

            var res = db.insertContact(ctcName,ctcEmail,ctcNumber)
            if(res){
                Toast.makeText(this, "Successfully Inserted!  ", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Failed to Insert! ", Toast.LENGTH_SHORT).show()
            }
            dialog.dismiss()


            var i : Intent = Intent(this,Concreate::class.java)
            i.putExtra("Name",ctcName)
            i.putExtra("number",ctcNumber)
            startActivity(i)
            dialog.dismiss()

        })
    }
}