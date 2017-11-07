package com.example.sanket.hw6;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by sanket on 10/23/2017.
 */

public class RegisterTable {
    static final String TABLENAME="registerTable";
    static final String COLUMN_ID ="_id";
    static final String COLUMN_SUBJECT ="subject";
    static final String COLUMN_TEXT ="text";


    static public void onCreate(SQLiteDatabase db){

        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE "+TABLENAME+ " (");
        sb.append(COLUMN_ID+" integer primary key autoincrement, ");
        sb.append(COLUMN_SUBJECT+" text not null, ");
        sb.append(COLUMN_TEXT+" text not null);");
        try{


            db.execSQL(sb.toString());
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    static public void onUpgrade(SQLiteDatabase db,int oldVseion,int newVersio){
        db.execSQL("DROP TABLE IF EXIST" + TABLENAME);
        RegisterTable.onCreate(db);

    }
}
