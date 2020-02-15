package com.example.candidateevaluationsystemandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class educational_details extends AppCompatActivity {
    Spinner institute,course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_details);
        findViewsById();
        List<String> institutes = new ArrayList<String>();
        institutes.add("Gujarat Technological University");
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,institutes);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        institute.setAdapter(arrayAdapter);
    }
    public void findViewsById(){
        institute = (Spinner) findViewById(R.id.input_institute);
        course = (Spinner) findViewById(R.id.input_studyoffield);
    }
}
