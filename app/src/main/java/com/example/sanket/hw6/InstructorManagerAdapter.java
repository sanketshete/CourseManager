package com.example.sanket.hw6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by sanket on 11/8/2017.
 */

public class InstructorManagerAdapter  extends RecyclerView.Adapter<InstructorManagerAdapter.InstructorManagerViewHolder> {
    public Context context ;

    public List<InstructorInfo> instructorList ;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<InstructorInfo> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<InstructorInfo> instructorList) {
        this.instructorList = instructorList;
    }

    @Override
    public InstructorManagerAdapter.InstructorManagerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.instructoritem, parent, false);

        return new InstructorManagerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(InstructorManagerAdapter.InstructorManagerViewHolder holder, int position) {
        InstructorInfo instructorInfo = instructorList.get(position) ;
        holder.fullName.setText(instructorInfo.getInstructor_fname()+ " "+ instructorInfo.getInstructor_lname()) ;
        holder.EmailofInstructor.setText(instructorInfo.getInstructor_email());
        holder.PersonalWebOfInstr.setText(instructorInfo.getInstructor_website());
        holder.instructorImage1.setImageBitmap(instructorInfo.getImage());
    }

    @Override
    public int getItemCount() {
        return this.instructorList.size();
    }

    public class InstructorManagerViewHolder extends RecyclerView.ViewHolder {
        TextView fullName,EmailofInstructor,PersonalWebOfInstr ;
        ImageView instructorImage1 ;

        public InstructorManagerViewHolder(View view) {
            super(view) ;
            fullName = (TextView) view.findViewById(R.id.fullName) ;
            EmailofInstructor = (TextView) view.findViewById(R.id.EmailofInstructor) ;
            PersonalWebOfInstr = (TextView) view.findViewById(R.id.PersonalWebOfInstr) ;
            instructorImage1 = (ImageView)view.findViewById(R.id.instructorImage1) ;
        }
    }

    public InstructorManagerAdapter(Context context, List<InstructorInfo> instructorList) {
        this.context = context ;
        this.instructorList = instructorList ;
    }
}
