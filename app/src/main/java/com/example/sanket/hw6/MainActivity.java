package com.example.sanket.hw6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Login.OnFragmentInteractionListener,
        CreateCourse.createCourseFragmentInteraction,
courseManager.CourseManagerFragmentInteraction{

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater() ;
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuHome) {

        }else if(item.getItemId() == R.id.menuAddInstructor) {

        }else if(item.getItemId() == R.id.menuExit) {

        }else if(item.getItemId() == R.id.menuInstructor) {

        }else if(item.getItemId() == R.id.menuLogout) {

        }
        return super.onOptionsItemSelected(item);
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

    @Override
    public void interactWithCreateCourse(String username) {

    }

    @Override
    public void onFragmentInteractionWithCourseManager(String username) {

    }

    @Override
    public void addCourseOnClick() {
        CreateCourse ccFragment = new CreateCourse();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,ccFragment,"createCourse")
                .addToBackStack(null)
                .commit();
    }
}
