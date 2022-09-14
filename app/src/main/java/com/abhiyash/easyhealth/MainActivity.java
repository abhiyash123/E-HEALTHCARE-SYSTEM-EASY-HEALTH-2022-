package com.abhiyash.easyhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private  Button lg;
    private Button hospital;
    private Button profile;
    private Button record;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lg = findViewById(R.id.lg);
        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        record = findViewById(R.id.rec);

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        hospital = findViewById(R.id.hospital);

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });



        profile = findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

    }




    public void openActivity(){

        Intent intent = new Intent(this,Home.class);
        startActivity(intent);

    }

    public void openActivity1(){

        Intent intent = new Intent(this,Hospitalnear.class);
        startActivity(intent);

    }


    public void openActivity2(){

        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);

    }

    public void openActivity3(){

        Intent intent = new Intent(this,Record.class);
        startActivity(intent);

    }
}