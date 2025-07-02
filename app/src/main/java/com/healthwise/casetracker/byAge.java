package com.healthwise.casetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Hashtable;

public class byAge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_by_age);

        Intent intent = getIntent();
        HashMap<String, Integer> ages = (HashMap<String, Integer>) intent.getSerializableExtra("Age");

        String result = "";
        result += "<10: " + ages.get("<10") + "\n";
        result += "20-29: " + ages.get("20-29") + "\n";
        result += "30-39: " + ages.get("30-39") + "\n";
        result += "40-49: " + ages.get("40-49") + "\n";
        result += "50-59: " + ages.get("50-59") + "\n";
        result += "60-69: " + ages.get("60-69") + "\n";
        result += "70-79: " + ages.get("70-79") + "\n";
        result += "80-89: " + ages.get("80-89") + "\n";
        result += "90+: " + ages.get("90+") + "\n";
        result += "Unknown: " + ages.get("Unknown") + "\n";


        TextView txt_c_byAgeGroup = findViewById(R.id.txt_c_byAgeGroup);
        txt_c_byAgeGroup.setText(result);
    }
}