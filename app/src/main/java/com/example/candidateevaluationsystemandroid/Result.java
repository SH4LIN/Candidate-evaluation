package com.example.candidateevaluationsystemandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        PieChart pieChart = (PieChart) findViewById(R.id.chart);
        List<PieEntry> trueAns = new ArrayList<>();
        trueAns.add(new PieEntry(getIntent().getIntExtra("AppScore",1),0));
        trueAns.add(new PieEntry(10 - getIntent().getIntExtra("AppScore",1),1));
        PieDataSet dataSet = new PieDataSet(trueAns,"Correct Answers");
        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateXY(2000,2000);
    }
}
