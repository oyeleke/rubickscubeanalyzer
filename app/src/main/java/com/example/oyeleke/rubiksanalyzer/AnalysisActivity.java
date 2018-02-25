package com.example.oyeleke.rubiksanalyzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AnalysisActivity extends AppCompatActivity {

    protected int rubiksCubeValue;
    protected int defaultValue = 0;

    private static final String RUBIKS_CUBE_VALUE_KEY = "value_key";

    private RecyclerView mSmallerRubikCubeView;
    private TextView mSmallerCubesTextView, mHiddenCubesTextView, mCubesFacesTextView,mSmallerRubiksCubeTextView;
    private List<Integer> cubesList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private RubiksCubesAdapter cubesAdapter;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        intent = getIntent();
        if (savedInstanceState != null){
            if(savedInstanceState.containsKey(RUBIKS_CUBE_VALUE_KEY)){
                rubiksCubeValue = savedInstanceState.getInt(RUBIKS_CUBE_VALUE_KEY);
            }
        }else {
            rubiksCubeValue = intent.getIntExtra(getString(R.string.cube_value), defaultValue);
        }
        getSmallerRubiksCubeFromLargerOne(rubiksCubeValue);

        mSmallerCubesTextView = (TextView)findViewById(R.id.tv_no_of_cubelet_in_rubiks_cube);
        mHiddenCubesTextView = (TextView)findViewById(R.id.tv_no_of_internal_cubelet_in_rubiks_cube);
        mCubesFacesTextView = (TextView)findViewById(R.id.tv_no_of_cubes_in_rubiks_cube_face);
        mSmallerRubiksCubeTextView = (TextView)findViewById(R.id.tv_rv_title);
        mSmallerRubikCubeView = (RecyclerView)findViewById(R.id.rv_smaller_rubiks_cube);

        setValues(rubiksCubeValue);


        linearLayoutManager = new LinearLayoutManager(this);
        cubesAdapter = new RubiksCubesAdapter(cubesList);
        mSmallerRubikCubeView.setLayoutManager(linearLayoutManager);
        mSmallerRubikCubeView.setAdapter(cubesAdapter);
        cubesAdapter.notifyDataSetChanged();

    }

    public void setValues(int rubiksCubeValue){
        mSmallerCubesTextView.setText(String.valueOf(getTotalNumberOfSmallerCubesOfRubiksCube(rubiksCubeValue)));
        mHiddenCubesTextView.setText(String.valueOf(getNumberofHiddenCubes(rubiksCubeValue)));
        mCubesFacesTextView.setText(String.valueOf(getTotalNumberOfCubesThatMakeUpTheFace(rubiksCubeValue)));
        mSmallerRubiksCubeTextView.setText(String.valueOf(cubesList.size())+" "+ getString(R.string.rubiks_cube_created));
    }

    public int getTotalNumberOfSmallerCubesOfRubiksCube(int n){
        return n*n*n;
    }

    public int getNumberofHiddenCubes(int n){
        int c = n-2;
        return  c*c*c;
    }

    public int getTotalNumberOfCubesThatMakeUpTheFace(int n){
        return getTotalNumberOfSmallerCubesOfRubiksCube(n) - getNumberofHiddenCubes(n);
    }

    public void getSmallerRubiksCubeFromLargerOne(int n){
        while(n > 2){
            n = n-2;
            if(n != 0&& n!=1)
                cubesList.add(n);

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        rubiksCubeValue = intent.getIntExtra(getString(R.string.cube_value),defaultValue);
        outState.putInt(RUBIKS_CUBE_VALUE_KEY,rubiksCubeValue);

    }
}
