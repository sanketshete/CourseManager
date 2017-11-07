package com.example.sanket.hw6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanket on 10/23/2017.
 */

public class RegisterinfoDAO {
private SQLiteDatabase db;
    public RegisterinfoDAO(SQLiteDatabase db){

        this.db=db;
    }

    public long save(Registerinfo registerinfo)
    {
        ContentValues values = new ContentValues();
        values.put(RegisterinfoTable.COLUMN_SUBJECT,registerinfo.getSubject());
        values.put(RegisterinfoTable.COLUMN_TEXT,registerinfo.getText());
        return db.insert(RegisterinfoTable.TABLENAME,null,values);
    }

    public boolean update(Registerinfo registerinfo)
    {
        ContentValues values = new ContentValues();
        values.put(RegisterinfoTable.COLUMN_SUBJECT,registerinfo.getSubject());
        values.put(RegisterinfoTable.COLUMN_TEXT,registerinfo.getText());
        return db.update(RegisterinfoTable.TABLENAME,values,RegisterinfoTable.COLUMN_ID +"=?",new String[]{registerinfo.get_id()+""})>0;

    }

    public boolean delete(Registerinfo registerinfo)
    {
        return db.delete(RegisterinfoTable.TABLENAME,RegisterinfoTable.COLUMN_ID +"=?",new String[]{registerinfo.get_id()+""})>0;
    }

    public Registerinfo get(long id){

        Registerinfo registerinfo=null;
        Cursor c=db.query(true,RegisterinfoTable.TABLENAME,new String[]{RegisterinfoTable.COLUMN_ID,
                RegisterinfoTable.COLUMN_SUBJECT,RegisterinfoTable.COLUMN_TEXT},RegisterinfoTable.COLUMN_ID +"=?",
                new String[]{id +""},null,null,null,null,null);


        if(c!=null && c.moveToFirst()){
            registerinfo=buildRegisterinfoFromCursor(c);
            if(!c.isClosed())
            c.close();
        }

        return registerinfo;
    }

    public List<Registerinfo> getAll(){
        List<Registerinfo> registerinfos = new ArrayList<Registerinfo>();
        Cursor c=db.query(RegisterinfoTable.TABLENAME,new String[]{RegisterinfoTable.COLUMN_ID,
                RegisterinfoTable.COLUMN_SUBJECT,RegisterinfoTable.COLUMN_TEXT},null,null,null,null,null);
        if(c!=null && c.moveToFirst()){

        do{
            Registerinfo registerinfo =buildRegisterinfoFromCursor(c);
            if(registerinfo!=null){
                registerinfos.add(registerinfo);
            }
        }while (c.moveToNext());
            if(!c.isClosed())
                c.close();

        }
        return registerinfos;
    }
    private Registerinfo buildRegisterinfoFromCursor(Cursor c){
        Registerinfo registerinfo=null;
        if(c!=null){
            registerinfo=new Registerinfo();
            registerinfo.set_id(c.getLong(0));
            registerinfo.setSubject(c.getString(1));
            registerinfo.setText(c.getString(2));
        }
        return registerinfo;
    }
}
