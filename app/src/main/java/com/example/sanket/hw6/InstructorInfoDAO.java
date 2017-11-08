package com.example.sanket.hw6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by sanket on 11/7/2017.
 */

public class InstructorInfoDAO {
    private SQLiteDatabase db;
    public InstructorInfoDAO(SQLiteDatabase db){

        this.db=db;
    }

    public long saveinstructor(InstructorInfo instructorInfo)
    {
        byte[] data = getBitmapAsByteArray(instructorInfo.getImage());
        ContentValues values = new ContentValues();
        values.put(InstructorTable.FIRST_NAME,instructorInfo.getInstructor_fname());
        values.put(InstructorTable.LAST_NAME,instructorInfo.getInstructor_lname());
        values.put(InstructorTable.EMAIL,instructorInfo.getInstructor_email());
        values.put(InstructorTable.WEBSITE,instructorInfo.getInstructor_website());
        values.put(InstructorTable.INSTR_IMAGE,data);
        return db.insert(InstructorTable.TABLENAME,null,values);
    }

    public InstructorInfo getInstructor(String fname, String lname){

        Registerinfo instructorInfo=null;
        Cursor c=db.rawQuery("SELECT * FROM "+InstructorTable.TABLENAME + "WHERE "+InstructorTable.FIRST_NAME+"=?" +" & "+ InstructorTable.LAST_NAME +"=?",new String[]{fname,lname});
        if(c!=null && c.moveToFirst()){
            InstructorInfo instructorInfo1 =buildNoteFromCursor(c);
            if(!c.isClosed())
                c.close();
            return instructorInfo1;
        }
        return null;
    }

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    private InstructorInfo buildNoteFromCursor(Cursor c){
        InstructorInfo instructorInfo=null;
        if(c!=null){
            instructorInfo=new InstructorInfo();
            instructorInfo.setInstructor_fname(c.getString(0));
            instructorInfo.setInstructor_lname(c.getString(1));
            instructorInfo.setInstructor_email(c.getString(2));
            instructorInfo.setInstructor_website(c.getString(3));
            instructorInfo.setImage(getImage(c.getBlob(4)));
        }
        return instructorInfo;
    }

}
