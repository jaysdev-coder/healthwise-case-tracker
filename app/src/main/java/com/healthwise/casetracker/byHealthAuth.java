package com.healthwise.casetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;

public class byHealthAuth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_by_health_auth);

        Intent intent = getIntent();
        HashMap<String, Integer> regions = (HashMap<String, Integer>) intent.getSerializableExtra("Region");

        StringBuilder result = new StringBuilder();

        for (String key : regions.keySet()) {
            result.append(key).append(": ").append(regions.get(key)).append("\n");
        }

        TextView txt_c_healthAuth = findViewById(R.id.txt_c_healthAuth);
        txt_c_healthAuth.setText(result.toString());

    }
}