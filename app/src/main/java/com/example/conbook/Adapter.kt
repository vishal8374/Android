package com.example.conbook
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import layout.DataBase

class Adapter( val UserList : ArrayList<NserList>,private val listener:OnClicked) : RecyclerView.Adapter<Adapter.ViewHolder>() {





    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
           var name =  itemView.findViewById<TextView>(R.id.Name)
           var number  = itemView.findViewById<TextView>(R.id.Number)
    }

    interface OnClicked {
        fun onDeleteclick(name:String?,num:String?)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var v : View = LayoutInflater.from(parent.context).inflate(R.layout.new_contacts,parent,false)
            var view = ViewHolder(v)



        v.setOnLongClickListener(View.OnLongClickListener {
            var pos = view.adapterPosition

            var name1 = UserList.get(pos).name
            var Number1 = UserList.get(pos).num
            UserList.remove(UserList.get(pos))

            listener.onDeleteclick(name1,Number1)
            notifyItemRemoved(pos)
            true
            })

            return view
    }
    override fun getItemCount(): Int {
       return UserList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            var name1 = UserList.get(position).name
            var num = UserList.get(position).num
            holder.name.text = name1
            holder.number.text = num
    }
}

