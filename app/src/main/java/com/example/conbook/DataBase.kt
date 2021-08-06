package layout
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import com.example.conbook.Adapter


class DataBase( context: Context?) : SQLiteOpenHelper(context, "Contacts.db", null, 1){
    val c:Context? = context
    private lateinit var contacts:String
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create TABLE users(name text,password text)")
        db?.execSQL("create TABLE contacts(name text,email text,umber text)")
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop Table if exists users")
        db?.execSQL("drop Table if exists contacts")
        onCreate(db)
    }
    fun  insert(name:String,password:String):Boolean {
        var db : SQLiteDatabase = this.writableDatabase
        var cv:ContentValues = ContentValues()
        cv.put("name",name)
        cv.put("password",password)
        var res = db.insert("users",null,cv)
        return res >= 0
    }




    fun disp() : Cursor{
        var db1 : SQLiteDatabase = this.writableDatabase
        var c : Cursor = db1.rawQuery("SELECT * FROM CONTACTS",null)
        return c
    }


    fun disp1() : Cursor{
        var db1 : SQLiteDatabase = this.writableDatabase
        var c : Cursor = db1.rawQuery("SELECT * FROM USERS",null)
        return c
    }


    fun  insertContact(name:String,email:String,number:String):Boolean {
        var db1 : SQLiteDatabase = this.writableDatabase
        var cv1:ContentValues = ContentValues()
        cv1.put("name",name)
        cv1.put("email",email)
        cv1.put("umber",number)
        var res1 = db1.insert("contacts",null,cv1)
        return res1 >= 0
    }
    fun check(name:String?,password: String):Boolean {
        var db : SQLiteDatabase = this.writableDatabase
        val c: Cursor = db.rawQuery("SELECT * FROM users WHERE name=? and password=?",(arrayOf(name , password) ))
        return c.getCount() > 0
    }

     fun delete(name: String?, num: String?) {
        var db : SQLiteDatabase = this.writableDatabase
        db.execSQL("DELETE FROM contacts  WHERE name=? and umber=?", arrayOf(name,num))
    }


}

