package com.example.candidateevaluationsystemandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class educational_details extends AppCompatActivity {
    Spinner institute,course,newSpiner;
    Button next2;
    TextInputLayout instituteInputLayout, collegeInputLayout, offieldInputLayout;
    String courseString;
    EditText startyr,passyr,cpi,experience;
    String instituteText,newspinnerText,startyrText,passyrText,cpiText,experienceText;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_details);
        findViewsById();
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    Map<String, Object> edudetails= new HashMap<>();
                    edudetails.put("Institute",instituteText);
                    edudetails.put("Branch",courseString);
                    if(instituteText.equals("Dim University")){
                        newspinnerText = newSpiner.getSelectedItem().toString();
                        edudetails.put("College",newspinnerText);
                    }
                    edudetails.put("CPI",cpiText);
                    edudetails.put("Start_Year",startyrText);
                    edudetails.put("Pass_Year",passyrText);
                    edudetails.put("Experience",experienceText);
                    Intent intent = new Intent(educational_details.this, Skills_Specialities.class);
                    intent.putExtra("str", courseString);
                    String str = getIntent().getStringExtra("phonenumber");
                    db.collection("Resumes").document(str).collection("EducationalDetails").document("1").set(edudetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                           if(task.isSuccessful()) {
                               Toast.makeText(educational_details.this, "Added", Toast.LENGTH_SHORT).show();
                           }
                           else{
                               Toast.makeText(educational_details.this, "Added", Toast.LENGTH_SHORT).show();
                           }
                        }
                    });
                    startActivity(intent);
                }
                else{
                    Toast.makeText(educational_details.this, "Enter Required Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                courseString = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<String> institutes = new ArrayList<String>();
        institutes.add("Gujarat Technological University");
        institutes.add("Gujarat University");
        institutes.add("Dim University");
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,institutes);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        institute.setAdapter(arrayAdapter);

        //MADE BY R∆VI

        //For spinner visibility [VISIBLE or GONE]
        institute.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                // String selectedItemText = (String) parent.getItemAtPosition(position);

                if (position == 2){
                    newSpiner.setVisibility(View.VISIBLE);
                    toSlide(view);
                }
                else {
                    newSpiner.setVisibility(View.GONE);

                    //ITS JUST LAYOUT_BELOW PROGRAMMATICALLY
                    RelativeLayout.LayoutParams lp3 = (RelativeLayout.LayoutParams) offieldInputLayout.getLayoutParams();
                    lp3.addRule(RelativeLayout.BELOW, instituteInputLayout.getId());
                    offieldInputLayout.setLayoutParams(lp3);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        List<String> offield = new ArrayList<String>();
        offield.add("Computer Engineering");
        offield.add("Mechanical Engineering");
        offield.add("Automobile Engineering");
        ArrayAdapter offieldAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,offield);
        offieldAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course.setAdapter(offieldAdapter);


        List<String> college = new ArrayList<String>();
        college.add("Nirma");
        college.add("Indus");
        college.add("LD");
        ArrayAdapter collegeAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,college);
        collegeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        newSpiner.setAdapter(collegeAdapter);
    }

    //FUNCTION FOR SLIDE ANIMATION ON SPINNER
    public void toSlide(View view){

        //ITS JUST LAYOUT_BELOW PROGRAMMATICALLY
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) collegeInputLayout.getLayoutParams();
        lp.addRule(RelativeLayout.BELOW, instituteInputLayout.getId());
        collegeInputLayout.setLayoutParams(lp);

        RelativeLayout.LayoutParams lp2 = (RelativeLayout.LayoutParams) offieldInputLayout.getLayoutParams();
        lp2.addRule(RelativeLayout.BELOW, collegeInputLayout.getId());
        offieldInputLayout.setLayoutParams(lp2);

        //FOR ANIMATION
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.spinner_slide_animation);
        newSpiner.startAnimation(animation);
    }

    public void findViewsById(){
        institute = (Spinner) findViewById(R.id.input_institute);
        course = (Spinner) findViewById(R.id.input_studyoffield);
        next2 = (Button) findViewById(R.id.next2);
        startyr = findViewById(R.id.startingyear);
        passyr = findViewById(R.id.passingyear);
        cpi = findViewById(R.id.input_cpi);
        experience = findViewById(R.id.yearexperience);
        db = FirebaseFirestore.getInstance();
        //MADE BY R∆VI
        newSpiner = (Spinner) findViewById(R.id.newSpinner);
        instituteInputLayout = (TextInputLayout) findViewById(R.id.input_layout_institute);
        collegeInputLayout = (TextInputLayout) findViewById(R.id.layout_newSpinner);
        offieldInputLayout = (TextInputLayout) findViewById(R.id.input_layout_studyoffield);
    }
    public boolean validate(){
        instituteText = institute.getSelectedItem().toString();
        courseString = course.getSelectedItem().toString();
        startyrText = startyr.getText().toString();
        passyrText = passyr.getText().toString();
        cpiText = cpi.getText().toString().trim();
        experienceText = experience.getText().toString();
        if(startyrText.isEmpty()){
            startyr.setError("Required");
            return false;
        }
        if(passyrText.isEmpty()){
            passyr.setError("Required");
            return false;
        }
        if(cpiText.isEmpty()){
            cpi.setError("Required");
            return false;
        }
        if(experienceText.isEmpty()){
            experience.setError("Required");
            return false;
        }
        return true;
    }
}
