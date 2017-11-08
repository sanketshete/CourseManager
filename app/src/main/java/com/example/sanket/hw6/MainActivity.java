package com.example.sanket.hw6;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Login.OnFragmentInteractionListener{

    public  static DatabaseDataManager databaseDataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseDataManager = new DatabaseDataManager(this);
        getSupportFragmentManager().beginTransaction().add(R.id.container,new Login(),"first")
                .commit();
    }

    @Override
    public void gotoCourseManager(String Username) {
        courseManager courseManager1 = new courseManager();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,courseManager1,"first")
                .addToBackStack(null)
                .commit();
    }

    public void RegisterFunction(View view) {
        Register f = new Register();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,f,"second")
                .addToBackStack(null)
                .commit();
    }
    @Override
    protected void onDestroy() {
        databaseDataManager.close();
        super.onDestroy();

    }

}
