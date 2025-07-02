package com.healthwise.casetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.HashMap;

public class byMoYear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_by_mo_year);

        EditText tyTxt_year = findViewById(R.id.tyTxt_year);
        EditText tyTxt_mo = findViewById(R.id.tyTxt_mo);
        Button btn_moYearFind = findViewById(R.id.btn_moYearFind);
        TextView txt_c_moYear = findViewById(R.id.txt_c_moYear);

        Intent intent = getIntent();
        HashMap<String, Integer> date = (HashMap<String, Integer>) intent.getSerializableExtra("Date");

        btn_moYearFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String year = tyTxt_year.getText().toString().trim();
                String month = tyTxt_mo.getText().toString().trim();

                if (TextUtils.isEmpty(year)) {
                    tyTxt_year.setError("Year is required");
                    return;
                }

                if (TextUtils.isEmpty(month)) {
                    tyTxt_mo.setError("Month is required");
                    return;
                }

                if (Integer.parseInt(year) < 2020 || Integer.parseInt(year) > LocalDate.now().getYear()){
                    tyTxt_year.setError("Year should be between 2020 and " + LocalDate.now().getYear());
                    return;
                }

                if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12)  {
                    tyTxt_mo.setError("Month is between 1 and 12");
                    return;
                }

                if (Integer.parseInt(year) == LocalDate.now().getYear() && Integer.parseInt(month) > LocalDate.now().getMonthValue()){
                    tyTxt_mo.setError("Cannot search after " + year + "-" + LocalDate.now().getMonthValue());
                    return;
                }

                if(month.length() == 1){
                    month = "0" + month;
                }

                String key = year + "-" + month;
                String numOfCase = date.get(key) != null ? String.valueOf(date.get(key)) : "0";
                String result = key + ": " + numOfCase;
                txt_c_moYear.setText(result);
            }
        });
    }
}