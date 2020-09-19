package com.example.practical3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private EditText et_firstname,et_lastname,et_email,et_pass,et_c_pass,et_mobile;
    private DatePicker birthdate;
    private Spinner s_gender;
    private AutoCompleteTextView auto_location;
    private Button btn_signin;

    private String[] arr = { "Andhra Pradesh","Arunachal Pradesh","Assam",
            "Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur",
            "Meghalaya","Mizoram","Nagaland","Nagaland","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal",
            "Andaman and Nicobar Islands","Chandigarh","Dadra Nagar Haveli and Daman Diu","Delhi","Jammu and Kashmir","Lakshadweep","Puducherry","Ladakh"};

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        setContentView(R.layout.activity_main);
        init();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, arr);

        auto_location.setThreshold(3);
        auto_location.setAdapter(adapter);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });
    }

    private void validation() {
        String first_name = et_firstname.getText().toString();
        String last_name = et_lastname.getText().toString();
        String email = et_email.getText().toString();
        String pass = et_pass.getText().toString();
        String re_pass = et_c_pass.getText().toString();
        String mob = et_mobile.getText().toString();
        String bdate = birthdate.getDayOfMonth() +" - "+(birthdate.getMonth()+1)+" - "+birthdate.getYear();
        String gender = s_gender.getSelectedItem().toString();
        String location = auto_location.getText().toString();

        if (first_name.isEmpty()){
            et_firstname.setError("First name is require");
            et_firstname.requestFocus();
        }else if(last_name.isEmpty()){
            et_lastname.setError("Last name is require");
            et_lastname.requestFocus();
        }else if (email.isEmpty()){
            et_email.setError("email is require");
            et_email.requestFocus();
        }else if (pass.isEmpty()){
            et_pass.setError("password is require");
            et_pass.requestFocus();
        }else if (pass.length()<6){
            et_pass.setError("password must be 6 character");
            et_pass.requestFocus();
        }else if (pass.length()>6){
            et_pass.setError("password must be 6 character");
            et_pass.requestFocus();
        }else if (re_pass.isEmpty()){
            et_c_pass.setError("Re-enter password is require");
            et_c_pass.requestFocus();
        }else if (!pass.equals(re_pass)){
            et_c_pass.setError("Re-enter password not match with password field");
            et_c_pass.requestFocus();
        }else if (mob.isEmpty()){
            et_mobile.setError("Mobile number is require");
            et_mobile.requestFocus();
        }else if (mob.length() != 10){
            et_mobile.setError("Mobile number should be 10 digits");
            et_mobile.requestFocus();
        }else if (location.isEmpty()){
            auto_location.setError("location is require");
            auto_location.requestFocus();
        }else{
            processData(first_name,last_name,email,pass,re_pass,mob,bdate,gender,location);
        }
    }

    private void processData(String first_name,String last_name,String email,String pass,String re_pass,String mob,String bdate,String gender,String location) {
        startActivity(new Intent(MainActivity.this,HomeActivity.class)
                .putExtra("fname", first_name)
                .putExtra("lname", last_name)
                .putExtra("email", email)
                .putExtra("pass", pass)
                .putExtra("mob", mob)
                .putExtra("loc", location)
                .putExtra("bdate", bdate)
                .putExtra("gen", gender));
    }

    private void init() {
        et_firstname = findViewById(R.id.et_firstname);
        et_lastname = findViewById(R.id.et_lastname);
        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        et_c_pass = findViewById(R.id.et_c_pass);
        et_mobile = findViewById(R.id.et_mobile);
        birthdate = findViewById(R.id.birthdate);
        s_gender = findViewById(R.id.s_gender);
        auto_location = findViewById(R.id.auto_location);
        btn_signin = findViewById(R.id.btn_signin);
    }
}