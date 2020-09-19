package com.example.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView f_name,l_name,email,pass,mob,state,birth_date,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        f_name = findViewById(R.id.f_name);
        l_name = findViewById(R.id.l_name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        mob = findViewById(R.id.mob);
        state = findViewById(R.id.state);
        birth_date = findViewById(R.id.birth_date);
        gender = findViewById(R.id.gender);

        Intent i = getIntent();
        f_name.setText(i.getStringExtra("fname"));
        l_name.setText(i.getStringExtra("lname"));
        email.setText(i.getStringExtra("email"));
        pass.setText(i.getStringExtra("pass"));
        mob.setText(i.getStringExtra("mob"));
        state.setText(i.getStringExtra("loc"));
        birth_date.setText(i.getStringExtra("bdate"));
        gender.setText(i.getStringExtra("gen"));
    }
}