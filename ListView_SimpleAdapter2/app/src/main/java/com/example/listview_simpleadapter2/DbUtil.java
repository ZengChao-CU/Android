package com.example.listview_simpleadapter2;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
public class DbUtil extends SQLiteOpenHelper{
    public DbUtil(Context context){
        super(context,"exs8.db",null,1);
    }
    public void onCreate(SQLiteDatabase db){
        String temp="create table person(_id integer primary key autoincrement,name varchar(20), no int)";
        db.execSQL(temp);
        db.execSQL("insert into person values(null,'小智',06)");
        db.execSQL("insert into person values(null,'小龙',07)");
        db.execSQL("insert into person values(null,'小涛',08)");
        db.execSQL("insert into person values(null,'小冬',04)");
        db.execSQL("insert into person values(null,'小超',31)");
        db.execSQL("insert into person values(null,'小宫',51)");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("drop table if exists person");
    }
    public Cursor allQuery(SQLiteDatabase db){
        return db.query("person",null,null,null,null,null,"_id ASC");
    }
}
