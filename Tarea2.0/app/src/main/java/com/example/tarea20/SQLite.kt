package com.example.tarea20

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider

class SQLite
    (context: Context,
     name: String?,
     factory: SQLiteDatabase.CursorFactory?,
     version: Int)
    : SQLiteOpenHelper(context,name,factory,version) {

    companion object {
        const val TABLE_NAME = "Libro"
        const val COLUMN_ISBN = "ISBN"
        const val COLUMN_TITLE = "Titulo"
        const val COLUMN_AUTHOR = "Autor"
        const val COLUMN_PUBLISHER = "Editorial"
        const val COLUMN_START_DATE = "FechaInicio"
        const val COLUMN_END_DATE = "FechaFinal"
        const val COLUMN_OPINION = "Opinion"
        const val COLUMN_RATING = "Rating"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE $TABLE_NAME (" +
                    "$COLUMN_ISBN INTEGER PRIMARY KEY NOT NULL, " +
                    "$COLUMN_TITLE VARCHAR(40) NOT NULL, " +
                    "$COLUMN_AUTHOR VARCHAR(30) NOT NULL, " +
                    "$COLUMN_PUBLISHER VARCHAR(20) NOT NULL, " +
                    "$COLUMN_START_DATE DATETIME NOT NULL, " +
                    "$COLUMN_END_DATE DATETIME NOT NULL, " +
                    "$COLUMN_OPINION VARCHAR(100), " +
                    "$COLUMN_RATING FLOAT NOT NULL)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.i("SQLite", "Upgrading database from version $oldVersion to $newVersion")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun readDataList(): Cursor? {
        val db = this.readableDatabase // Obtén una instancia de la base de datos en modo lectura
        return if (db != null) {
            val query = """
            SELECT $COLUMN_TITLE, $COLUMN_AUTHOR, $COLUMN_START_DATE, 
                   $COLUMN_END_DATE, $COLUMN_RATING 
            FROM $TABLE_NAME
        """
            db.rawQuery(query, null) // Ejecuta la consulta y devuelve el cursor
        } else {
            null // Devuelve null si no se puede acceder a la base de datos
        }
    }

}