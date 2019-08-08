package com.example.pinbasket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.home);
    }
    public MainActivity()
    {}


    public void playLevel1(View view) {
        setContentView(R.layout.level1);
    }

    public void exit(View view) {
        System.exit(0);
    }

    public void btnBack(View view) {
        setContentView(R.layout.home);
    }

    public void playLevel2()
    {
        setContentView(R.layout.level2);
    }
}
