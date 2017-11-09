package com.example.sanket.hw6;

import android.content.Context;
import android.net.Uri;
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
 * {@link CourseDetail.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CourseDetail extends Fragment {

    private OnFragmentInteractionListener mListener;

    public CourseDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course_detail, container, false);
        TextView title =(TextView) view.findViewById(R.id.titleVal);
        TextView instrName =(TextView) view.findViewById(R.id.instrName);
        TextView day =(TextView) view.findViewById(R.id.Dayval);
        TextView time =(TextView) view.findViewById(R.id.timeVal);
        TextView credithr =(TextView) view.findViewById(R.id.creditHr);
        TextView semister =(TextView) view.findViewById(R.id.semister);
        ImageView iv = (ImageView)view.findViewById(R.id.instrImage);

        title.setText("");
        instrName.setText("");
        day.setText("");
        time.setText("");
        credithr.setText("");
        semister.setText("");
        iv.setImageBitmap(null);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
