package com.example.sanket.hw6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hrishikesh Deshpande on 07-Nov-17.
 */

public class CourseManagerAdapter extends RecyclerView.Adapter<CourseManagerAdapter.CourseManagerViewHolder> {
    public Context context ;
    public List<courseInformation> courseList ;

    @Override
    public CourseManagerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CourseManagerViewHolder holder, int position) {
    courseInformation course = courseList.get(position) ;
        holder.courseTitle.setText(course.getTitle()) ;
        holder.courseInstructor.setText(course.getInstructorName());
        holder.courseTime.setText(course.getDay() + " " + course.getTime());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class CourseManagerViewHolder extends RecyclerView.ViewHolder {
        TextView courseTitle,courseInstructor,courseTime ;
        ImageView courseImage ;

        public CourseManagerViewHolder(View view) {
            super(view) ;
            courseTitle = (TextView) view.findViewById(R.id.courseTitle) ;
            courseInstructor = (TextView) view.findViewById(R.id.courseInstructor) ;
            courseTime = (TextView) view.findViewById(R.id.courseTime) ;
            courseImage = (ImageView)view.findViewById(R.id.courseImage) ;
        }
    }

    public CourseManagerAdapter(Context context, List<courseInformation> courseList) {
        this.context = context ;
        this.courseList = courseList ;
    }
}
