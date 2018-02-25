package com.example.oyeleke.rubiksanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mRubiksCubeValueEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRubiksCubeValueEditText = (EditText) findViewById(R.id.et_rubiks);
    }

    public void startAnalysis(View v) {
        String valueOfRubiksCubeSides;
        int n =0 ;

        try {
            valueOfRubiksCubeSides = mRubiksCubeValueEditText.getText().toString().trim();
            n = Integer.valueOf(valueOfRubiksCubeSides);
        } catch (Exception e) {
            e.printStackTrace();
            mRubiksCubeValueEditText.setError("please use a valid number");
        }
        if (n != 0 && n!= 1) {

            Intent intent = new Intent(MainActivity.this, AnalysisActivity.class);
            intent.putExtra(getString(R.string.cube_value), n);
            startActivity(intent);
        }
        else {
            mRubiksCubeValueEditText.setError("Rubiks cube parameter must be greater than 1");
        }

    }
}
