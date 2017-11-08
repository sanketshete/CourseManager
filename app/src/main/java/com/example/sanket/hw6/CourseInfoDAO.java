package com.example.sanket.hw6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanket on 11/8/2017.
 */

public class CourseInfoDAO {
    private SQLiteDatabase db;
    public CourseInfoDAO(SQLiteDatabase db){
        this.db=db;
    }

    public long saveCourse(CourseInfo courseInfo)
    {
        ContentValues values = new ContentValues();
        values.put(courseTable.TITLE,courseInfo.getTitle());
        values.put(courseTable.INSTR_ID,courseInfo.getInstructor_id());
        values.put(courseTable.DAY,courseInfo.getDay());
        values.put(courseTable.TIME,courseInfo.getTime());
        values.put(courseTable.AMPM,courseInfo.getAmpm());
        values.put(courseTable.CREDIT_HR,courseInfo.getCredithr());
        values.put(courseTable.SEMESTER,courseInfo.getSemister());

        return db.insert(courseTable.TABLENAME,null,values);
    }

    public CourseInfo getCourse(Integer id){
        CourseInfo courseInfo = null;
        Cursor c=db.rawQuery("SELECT * FROM "+courseTable.TABLENAME+" WHERE "+courseTable.COLUMN_ID +"="+id,null);
        if(c!=null && c.moveToFirst()){
               courseInfo =buildCourseInfoFromCursor(c);

            if(!c.isClosed())
                c.close();
        }
        return courseInfo;
    }

    public List<CourseInfo> getAllCourse(){
        List<CourseInfo> courseInfo1 = new ArrayList<CourseInfo>();
        Cursor c=db.query(courseTable.TABLENAME,new String[]{courseTable.TITLE,
                courseTable.INSTR_ID,courseTable.DAY,courseTable.TIME,courseTable.AMPM,courseTable.CREDIT_HR,courseTable.SEMESTER},null,null,null,null,null);
        if(c!=null && c.moveToFirst()){
            do{
                CourseInfo courseInfo =buildCourseInfoFromCursor(c);
                if(courseInfo!=null){
                    courseInfo1.add(courseInfo);
                }
            }while (c.moveToNext());
            if(!c.isClosed())
                c.close();

        }
        return courseInfo1;
    }
    private CourseInfo buildCourseInfoFromCursor(Cursor c){
        CourseInfo courseInfo=null;
        if(c!=null){
            courseInfo=new CourseInfo();
            courseInfo.setTitle(c.getString(0));
            courseInfo.setInstructor_id(c.getString(1));
            courseInfo.setDay(c.getString(2));
            courseInfo.setTitle(c.getString(3));
            courseInfo.setAmpm(c.getString(4));
            courseInfo.setCredithr(c.getString(5));
            courseInfo.setSemister(c.getString(6));
        }
        return courseInfo;
    }

}