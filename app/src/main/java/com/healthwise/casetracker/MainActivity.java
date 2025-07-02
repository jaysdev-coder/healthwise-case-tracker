package com.healthwise.casetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    private final int GENDER = 0;
    private final int AGE = 1;
    private final int DATE = 2;
    private final int REGION = 3;

    FirebaseAuth fAuth;
    DatabaseReference cases;
    ArrayList<HashMap<String, Integer>> caseBy;
    ProgressDialog loading;


    private ArrayList<HashMap<String, Integer>> initCases() {
        ArrayList<HashMap<String, Integer>> init = new ArrayList<>();
        HashMap<String, Integer> gender = new HashMap<>();
        HashMap<String, Integer> age = new HashMap<>();
        HashMap<String, Integer> date = new HashMap<>();
        HashMap<String, Integer> region = new HashMap<>();
        init.add(gender);
        init.add(age);
        init.add(date);
        init.add(region);
        return init;
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (caseBy == null) {
            caseBy = initCases();
            cases.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    dataSnapshot.getChildren().forEach(child -> {
                        Case _case = child.getValue(Case.class);
                        caseBy.get(GENDER).merge(_case.getSex(), 1, Integer::sum);
                        caseBy.get(AGE).merge(_case.getAge_Group(), 1, Integer::sum);
                        caseBy.get(DATE).merge(_case.getReported_Date().substring(0, 7), 1, Integer::sum);
                        caseBy.get(REGION).merge(_case.getHA(), 1, Integer::sum);
                    });
                    loading.dismiss();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView toLogin = findViewById(R.id.btn_to_loginPg);
        TextView toRegister = findViewById(R.id.cTxt_register);
        TextView toLogout = findViewById(R.id.toLogout);

        if (fAuth.getCurrentUser() != null) {
            toLogin.setVisibility(View.INVISIBLE);
            toRegister.setVisibility(View.INVISIBLE);
            toLogout.setVisibility(View.VISIBLE);
        } else {
            toLogout.setVisibility(View.INVISIBLE);
            toLogin.setVisibility(View.VISIBLE);
            toRegister.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        loading = new ProgressDialog(this);
        loading.setCancelable(false);
        loading.show();
        TextView toLogin = findViewById(R.id.btn_to_loginPg);
        TextView toRegister = findViewById(R.id.cTxt_register);
        TextView toLogout = findViewById(R.id.toLogout);

        fAuth = FirebaseAuth.getInstance();
        cases = FirebaseDatabase.getInstance().getReference();

        if (fAuth.getCurrentUser() != null) {
            toLogin.setVisibility(View.INVISIBLE);
            toRegister.setVisibility(View.INVISIBLE);
            toLogout.setVisibility(View.VISIBLE);
        } else {
            toLogout.setVisibility(View.INVISIBLE);
            toLogin.setVisibility(View.VISIBLE);
            toRegister.setVisibility(View.VISIBLE);
        }

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        toLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fAuth.signOut();
                toLogout.setVisibility(View.INVISIBLE);
                toLogin.setVisibility(View.VISIBLE);
                toRegister.setVisibility(View.VISIBLE);
            }
        });
    }

    public void btnOnClickByGender(View view) {
        Intent intent = new Intent(this, byGender.class);
        intent.putExtra("Gender", caseBy.get(GENDER));
        startActivity(intent);

    }

    public void btnOnClickByAge(View view) {
        Intent intent = new Intent(this, byAge.class);
        intent.putExtra("Age", caseBy.get(AGE));
        startActivity(intent);
    }

    public void btnOnClickByMoYear(View view) {
        Intent intent = new Intent(this, byMoYear.class);
        intent.putExtra("Date", caseBy.get(DATE));
        startActivity(intent);

    }

    public void btnOnClickByHealthAuth(View view) {
        Intent intent = new Intent(this, byHealthAuth.class);
        intent.putExtra("Region", caseBy.get(REGION));
        startActivity(intent);

    }


}