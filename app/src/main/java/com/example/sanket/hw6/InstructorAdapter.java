package com.example.sanket.hw6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hrishikesh Deshpande on 08-Nov-17.
 */

public class InstructorAdapter extends RecyclerView.Adapter<InstructorAdapter.InstructorViewHolder> {
    public Context context ;
    public List<InstructorInfo> instructorList ;

    public InstructorAdapter(Context context,List<InstructorInfo> instructorList ){
        this.context = context ;
        this.instructorList = instructorList ;
    }

    @Override
    public InstructorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(InstructorViewHolder holder, int position) {
    final InstructorInfo instructorInfo = instructorList.get(position) ;
        holder.instructorName.setText(instructorInfo.getInstructor_fname()+" "+instructorInfo.getInstructor_lname()) ;
        holder.instructorImage.setImageBitmap(instructorInfo.getImage());
        holder.isSelected.setChecked(instructorInfo.isChecked());
        holder.isSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                instructorInfo.setChecked(b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return instructorList.size();
    }


    public class InstructorViewHolder extends RecyclerView.ViewHolder {
        ImageView instructorImage ;
        TextView instructorName ;
        RadioButton isSelected ;
        InstructorViewHolder(View view){
            super(view) ;
            instructorImage = (ImageView)view.findViewById(R.id.instructorImgRv) ;
            instructorName=(TextView)view.findViewById(R.id.instructorNameRv) ;
            isSelected=(RadioButton)view.findViewById(R.id.instructorSelectedRv) ;
        }

    }
}
