package com.example.sanket.hw6;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 */
public class instructorDetail extends Fragment {

    private OnInstructorDetailInteraction mListener;

    public instructorDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_instructor_detail, container, false);

        TextView instr_fname =(TextView)view.findViewById(R.id.Ifname);
        TextView instr_lname =(TextView)view.findViewById(R.id.LFname);
        TextView instr_email =(TextView)view.findViewById(R.id.IEmail);
        TextView instr_website =(TextView)view.findViewById(R.id.IPersonalWeb);
        ImageView iv = (ImageView)view.findViewById(R.id.instructor_image);
        InstructorInfo info = mListener.onInteraction() ;
        instr_fname.setText(info.getInstructor_fname());
        instr_lname.setText(info.getInstructor_lname());
        instr_email.setText(info.getInstructor_email());
        instr_website.setText(info.getInstructor_website());
        iv.setImageBitmap(info.getImage());
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInstructorDetailInteraction) {
            mListener = (OnInstructorDetailInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnInstructorDetailInteraction {
        // TODO: Update argument type and name
        InstructorInfo onInteraction();
    }
}
