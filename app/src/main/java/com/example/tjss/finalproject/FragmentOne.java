package com.example.tjss.finalproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class FragmentOne extends Fragment implements View.OnClickListener{
    private String mTitleVal;
    private String mGenreVal;
    private String mYearVal;


    private Button mButton;
    private EditText mTitle;
    private EditText mGenre;
    private EditText mYear;
    private FragmentOneInterface mCallback;
    private Context mContext;



    public FragmentOne() {
    }

    public static FragmentOne newInstance() {
        FragmentOne fragment = new FragmentOne();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;

        try {
            mCallback = (FragmentOneInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentOneInterface");
        }
    }

    // NEW FOR VERSION 2.0 - THIS FRAGMENT USES HIS N XML FILE!

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_one, container, false);

        //Gets buttons and EditTexts from XML

        mButton = rootView.findViewById(R.id.Button01);

        mTitle = rootView.findViewById(R.id.titleET);
        mGenre = rootView.findViewById(R.id.genreET);
        mYear = rootView.findViewById(R.id.yearET);

        mButton.setOnClickListener(this);


        return rootView;
    }

    public void Success_Toast(){
        CharSequence text = "New movie created. It will appear at the bottom of the list.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(mContext, text, duration);
        toast.show();


    }

public void makeToast(){
    CharSequence text = "You must put a value in all Fields";
    int duration = Toast.LENGTH_SHORT;

    Toast toast = Toast.makeText(mContext, text, duration);
    toast.show();

}

    @Override
    public void onClick(View view) {



        mTitleVal = mTitle.getText().toString();
        mGenreVal = mGenre.getText().toString();
        mYearVal = mYear.getText().toString();





        boolean fail;
        fail = (mTitleVal.equals(""))||(mGenreVal.equals(""))||(mYearVal.equals(""));
        if (fail == false) {
            Movie movie = new Movie(mTitleVal, mGenreVal, mYearVal);
            mCallback.addNewMovie(movie);
            Success_Toast();

        } else {
            makeToast();
        }

    }

    public interface FragmentOneInterface {

        void addNewMovie(Movie movie);

    }

}

