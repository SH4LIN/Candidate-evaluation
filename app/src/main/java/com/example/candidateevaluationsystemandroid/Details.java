package com.example.candidateevaluationsystemandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class Details extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private EditText dob;
    private Calendar mcalendar;
    private DatePickerDialog datePickerDialog;
    private int day,month,year;
    Button next;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        findViewsById();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Details.this,educational_details.class));
            }
        });
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day=mcalendar.get(Calendar.DAY_OF_MONTH);
                year=mcalendar.get(Calendar.YEAR);
                month=mcalendar.get(Calendar.MONTH);
                datePickerDialog.show();
            }
        });


    }

    @Override
    public void onDateSet(DatePicker view, int myear, int mmonth, int mdayOfMonth) {
        mmonth = mmonth + 1;
        dob.setText(mdayOfMonth + " / "+ mmonth + " / "+myear);
    }

    public void findViewsById(){
        mcalendar = Calendar.getInstance();
        dob = (EditText) findViewById(R.id.input_birthdate);
        next = (Button) findViewById(R.id.next1);
        datePickerDialog = new DatePickerDialog(Details.this, this, day, month, year);
    }
}
