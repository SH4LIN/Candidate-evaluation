package com.example.candidateevaluationsystemandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Requirement extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    EditText datedeadline,nocandidate,eskills;
    DatePickerDialog datePickerDialog;
    Calendar mcalender;
    int day,month,year;
    ImageView imgadd;
    ArrayList<String> skilldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirement);

        eskills = (EditText) findViewById(R.id.edtskills);
        imgadd = (ImageView) findViewById(R.id.imageViewadd);
        datedeadline = (EditText) findViewById(R.id.edtdeadline);
        mcalender = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(Requirement.this,this,day ,month,year);

        datedeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day = mcalender.get(Calendar.DAY_OF_MONTH);
                year = mcalender.get(Calendar.YEAR);
                month = mcalender.get(Calendar.MONTH);
                datePickerDialog.show();
            }
        });

        imgadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skilldata=new ArrayList<String>();
                String sk = eskills.getText().toString();
                skilldata.add(sk);
                eskills.setText(null);
                Toast.makeText(getApplicationContext(),"data : "+skilldata,Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int myear, int mmonth, int mdayofMonth) {
        mmonth = mmonth +1;
        datedeadline.setText(mdayofMonth + " / "+ mmonth + " / "+ myear);

    }
}
