package com.elbazonpolisanov.myapplication.flyingball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.elbazonpolisanov.myapplication.R;

public class FlyingBallActivity extends AppCompatActivity{
    protected FlyingBallInside bounceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.flying_balls);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
