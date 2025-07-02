package com.healthwise.casetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class byGender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_by_gender);

        Intent intent = getIntent();
        HashMap<String, Integer> genders = (HashMap<String, Integer>) intent.getSerializableExtra("Gender");

        String result = "";
        result += "Male: " + genders.get("M") + "\n";
        result += "Female: " + genders.get("F") + "\n";
        result += "Unknown: " + genders.get("U") + "\n";

        TextView txt_c_byGender = findViewById(R.id.txt_c_byGender);
        txt_c_byGender.setText(result);


    }
}