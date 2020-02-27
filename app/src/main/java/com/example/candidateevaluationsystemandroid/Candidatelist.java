package com.example.candidateevaluationsystemandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Candidatelist extends AppCompatActivity {

    RecyclerView recyclerView;
    recycleradapter myadapter;

    public static final String[] name = {"Sarth Patel","Shalin shah","shreyal","Ravi"};
    public static final String[] email = {"sarth@gmail.com","shalin@gmail.com","shreyal@gmail.com","ravi@gmail.com"};
    public static final String[] address = {"Hirawadi","Vasna","Ambawadi","Naroda"};
    public static final String[] contact = {"9081104897","8323435452","6384727543","9087654565"};
    public static final  String[] score = {"100","90","80","70"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidatelist);

        recyclerView = findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myadapter = new recycleradapter(this,getMyList());
        recyclerView.setAdapter(myadapter);
    }

    private ArrayList<ModelData> getMyList(){
        ArrayList<ModelData> models = new ArrayList<>();
        int len = name.length;

        for (int i=0;i<len;i++)
        {
            ModelData m = new ModelData();
            m.setMname(name[i]);
            m.setMemail(email[i]);
            m.setMadderess(address[i]);
            m.setMcontact(address[i]);
            m.setMscore(score[i]);
            models.add(m);
        }
        return models;
    }
}
