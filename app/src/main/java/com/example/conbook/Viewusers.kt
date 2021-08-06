package com.example.conbook

import Adapter1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import layout.DataBase

class Viewusers : AppCompatActivity() {

    var userList:ArrayList<Users> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewusers)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
            initiate()
            initRecycler()
        }
    fun initiate() {
            var cursor = DataBase(this).disp1()
            while (cursor.moveToNext()){
                val name = cursor.getString(0)
                userList.add(Users(name))
            }
        }
    fun initRecycler() {
            var recycle : RecyclerView = findViewById(R.id.recycler1)
            var LLM : LinearLayoutManager = LinearLayoutManager(this)
            LLM.orientation = RecyclerView.VERTICAL
            recycle.layoutManager = LLM
            var adapter = Adapter1(this,userList)
            recycle.adapter = adapter
        }
    }

