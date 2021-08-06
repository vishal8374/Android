package com.example.conbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import layout.DataBase

class Concreate : AppCompatActivity(), Adapter.OnClicked {


    var userList: ArrayList<NserList> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.concreate)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        initiate()
        initRecycler()
    }

    fun initiate() {
        var cursor = DataBase(this).disp()
        while (cursor.moveToNext()) {
            val name = cursor.getString(0)
            val num = cursor.getString(2)
            userList.add(NserList(name, num))
        }
    }

    fun initRecycler() {
        var recycle: RecyclerView = findViewById(R.id.recycler)
        var LLM: LinearLayoutManager = LinearLayoutManager(this)
        LLM.orientation = RecyclerView.VERTICAL
        recycle.layoutManager = LLM
        var adapter = Adapter(userList,this)
        recycle.adapter = adapter
    }

    override fun onDeleteclick(name: String?, num: String?) {
        var DB = DataBase(this)
        DB.delete(name,num)
    }
}


