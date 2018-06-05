package com.elbazonpolisanov.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.elbazonpolisanov.myapplication.birthday.BirthdayMainActivity;
import com.elbazonpolisanov.myapplication.flyingball.FlyingBallActivity;
import com.elbazonpolisanov.myapplication.calculator.CalculatorActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.mainList);
        List<String> menuList = Arrays.asList("Calculator", "Birthday List", "Flying Balls");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menuList);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0) onCalculatorClicked();
                else if (i==1) onBirthdayClicked();
                else if (i==2) onFlyingClicked();
            }
        });
        list.setAdapter(arrayAdapter);

    }
    public void onCalculatorClicked() {
        startActivity(new Intent(MainActivity.this,CalculatorActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public void onBirthdayClicked() {
        startActivity(new Intent(MainActivity.this,BirthdayMainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public void onFlyingClicked() {
      startActivity(new Intent(MainActivity.this,FlyingBallActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}