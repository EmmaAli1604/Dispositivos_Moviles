package com.example.tarea20

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.lifecycle.ViewModelProvider

class SQLite
    (context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper(context,name,factory,version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table libro(ISBN int primary key not null, Titulo varchar(40) not null, Autor varchar(30)not null, Editorial varchar(20) not null,FechaInicio datetime not null,FechaFinal datetime not null,Opinion varchar(100),Categroria varchar(20),Rating Float not null) ")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}