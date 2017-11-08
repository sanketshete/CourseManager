package com.example.sanket.hw6;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CourseManagerFragmentInteraction} interface
 * to handle interaction events.
 */
public class courseManager extends Fragment {

    private CourseManagerFragmentInteraction mListener;
    ArrayList<courseInformation> courseList ;
    CourseManagerAdapter adapter ;
    public courseManager() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course_manager, container, false);
        courseList = new ArrayList<courseInformation>() ;
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.courseListRv) ;
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity()) ;
        recyclerView.setLayoutManager(llm);
        adapter = new CourseManagerAdapter(getActivity(),courseList) ;
        recyclerView.setAdapter(adapter);
        ImageView addCourseButton = (ImageView)view.findViewById(R.id.addCourseCm) ;
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Implement add course button

            }
        });
        return view ;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CourseManagerFragmentInteraction) {
            mListener = (CourseManagerFragmentInteraction) context;
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
    public interface CourseManagerFragmentInteraction {
        // TODO: Update argument type and name
        void onFragmentInteractionWithCourseManager(String username);
        void addCourseOnClick() ;
    }
}
