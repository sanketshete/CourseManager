package com.example.sanket.hw6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by sanket on 10/23/2017.
 */

public class DatabaseDataManager {

   private Context context;
    private DatabaseOpenHelper databaseOpenHelper;
    private SQLiteDatabase db;
    private RegisterinfoDAO registerinfoDAO;
    private InstructorInfoDAO instructorInfoDAO;

    public DatabaseDataManager(Context context){
        this.context=context;
        databaseOpenHelper = new DatabaseOpenHelper(this.context);
        db= databaseOpenHelper.getWritableDatabase();
        registerinfoDAO=new RegisterinfoDAO(db);
        instructorInfoDAO = new InstructorInfoDAO(db);
    }

    public void close(){
        if(db!=null){
            db.close();
        }
    }

    public long saveUser(Registerinfo registerinfo){
        return this.registerinfoDAO.save(registerinfo);
    }

    public boolean checkRegisterDAO(String uname,String password){
        return this.registerinfoDAO.get(uname,password);
    }

    public long saveInstructor(InstructorInfo instructorInfo){
        return this.instructorInfoDAO.saveinstructor(instructorInfo);
    }

    public InstructorInfo getinstructor(int id){
        return this.instructorInfoDAO.getInstructor(id);
    }
    public List<InstructorInfo> getAll(){
        return this.instructorInfoDAO.getAll();
    }

}
