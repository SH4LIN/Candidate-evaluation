package com.example.candidateevaluationsystemandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Requirement extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    EditText datedeadline,nocandidate,eskills;
    DatePickerDialog datePickerDialog;
    Calendar mcalender;
    int day,month,year;
    ImageView imgadd;
    Button btnubmit;
    String stdeadline,stnocandidate,stskills;
    CheckBox chandroid,chjava,chcpluse,chPHP,chpython,chreactnative;
    ArrayList<String> skilldata;

    FirebaseUser user;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirement);

        eskills = (EditText) findViewById(R.id.edtskills);
        imgadd = (ImageView) findViewById(R.id.imageViewadd);
        datedeadline = (EditText) findViewById(R.id.edtdeadline);
        nocandidate = (EditText) findViewById(R.id.edtnocandidate);
        btnubmit = (Button) findViewById(R.id.buttonsubmit);

        mcalender = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(Requirement.this,this,day ,month,year);


        stdeadline = datedeadline.getText().toString().trim();
        stnocandidate = nocandidate.getText().toString().trim();
        stskills = eskills.getText().toString().trim();

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

        btnubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> requirements = new HashMap<>();


            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int myear, int mmonth, int mdayofMonth) {
        mmonth = mmonth +1;
        datedeadline.setText(mdayofMonth + " / "+ mmonth + " / "+ myear);

    }
}
