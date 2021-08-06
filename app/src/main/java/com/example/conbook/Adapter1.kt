import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.conbook.NserList
import com.example.conbook.R
import com.example.conbook.Users

class Adapter1(context: Context, val UserList : ArrayList<Users>) : RecyclerView.Adapter<Adapter1.ViewHolder>() {



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name =  itemView.findViewById<TextView>(R.id.Name1)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v : View = LayoutInflater.from(parent.context).inflate(R.layout.users,parent,false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return UserList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var name1 = UserList.get(position).Name
        holder.name.text = name1
    }
}