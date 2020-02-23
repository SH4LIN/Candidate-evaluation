package com.example.candidateevaluationsystemandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class Skills_Specialities extends AppCompatActivity {

    final String[] select_skills_CE  = {"SKILLS","AI","Machine Learning","Android","Java"};
    final String[] select_skills_ME  = {"SKILLS","1","2","3","4"};
    final String[] select_skills_AE  = {"SKILLS","A","B","C","D"};
    Spinner spinner;
    ArrayList<spinner_item> list = new ArrayList<>();
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills__specialities);
        spinner =  (Spinner) findViewById(R.id.input_skills);
        Intent intent = getIntent();
        text = intent.getStringExtra("str");

        if(text.equals("Computer Engineering")) {
            for (int i = 0; i < select_skills_CE.length; i++) {
                spinner_item spinner_item = new spinner_item();
                spinner_item.setTitle(select_skills_CE[i]);
                spinner_item.setSelected(false);
                list.add(spinner_item);
            }
        }
        else if(text.equals("Mechanical Engineering")) {
            for (int i = 0; i < select_skills_ME.length; i++) {
                spinner_item spinner_item = new spinner_item();
                spinner_item.setTitle(select_skills_ME[i]);
                spinner_item.setSelected(false);
                list.add(spinner_item);
            }
        }
        else if(text.equals("Automobile Engineering")) {
            for (int i = 0; i < select_skills_AE.length; i++) {
                spinner_item spinner_item = new spinner_item();
                spinner_item.setTitle(select_skills_AE[i]);
                spinner_item.setSelected(false);
                list.add(spinner_item);
            }
        }
        SpinnerAdapter spinnerAdapter = new Spinner_Adapter(Skills_Specialities.this,0,list);
        spinner.setAdapter(spinnerAdapter);
    }
}

