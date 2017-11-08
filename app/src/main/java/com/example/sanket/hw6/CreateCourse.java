package com.example.sanket.hw6;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link createCourseFragmentInteraction} interface
 * to handle interaction events.
 */
public class CreateCourse extends Fragment {

    private createCourseFragmentInteraction mListener;
    public List<InstructorInfo> instructorList ;
    public InstructorAdapter adapter ;
    public CreateCourse() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_course, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.ChooseInstructorRv) ;
        recyclerView.setHasFixedSize(true);
        instructorList = new ArrayList<InstructorInfo>() ;
        adapter = new InstructorAdapter(getActivity(),instructorList) ;
        LinearLayoutManager llm = new LinearLayoutManager(getActivity()) ;
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        return view ;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof createCourseFragmentInteraction) {
            mListener = (createCourseFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement createCourseFragmentInteraction");
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
    public interface createCourseFragmentInteraction {
        // TODO: Update argument type and name
        void interactWithCreateCourse(String username);
    }
}
