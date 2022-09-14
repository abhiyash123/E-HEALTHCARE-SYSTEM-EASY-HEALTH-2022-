package com.abhiyash.easyhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {

   Spinner spinner1 , spinner2;
   List<String> subCategories = new ArrayList<>();
   Button prd;
   FirebaseDatabase database;
   DatabaseReference reference;
   Member member;
   int maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        prd = findViewById(R.id.prd);
        member = new Member();
        reference = database.getInstance().getReference().child("Spinner");





        List<String> categories = new ArrayList<>();
        categories.add("Lucknow");
        categories.add("Delhi");
        categories.add("Noida");
        categories.add("Ghaziabad");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).equals("Lucknow")){
                    subCategories.clear();
                    subCategories.add("Dr. Yasha Singh");subCategories.add("Om Shree Clinic");
                    subCategories.add("Dr Vivek Agarwal");subCategories.add("Dr. Prasoon Kant");
                    fillSpinner();
                }
                else if (adapterView.getItemAtPosition(i).equals("Delhi")){

                    subCategories.clear();
                    subCategories.add("Dr. Pradeep Tara");subCategories.add("Dr. Anand Narender Kumar");subCategories.add("Dr. Arora Puneet");
                    subCategories.add("Dr. Arora Sowrabh Kumar");subCategories.add("Dr. Arora Vanita");
                    fillSpinner();
                }
                else if (adapterView.getItemAtPosition(i).equals("Noida")){

                    subCategories.clear();
                    subCategories.add("Dr.Ankit Gupta");subCategories.add("Dr. Anuja Porwal");subCategories.add("Dr Ajay Agarwal's Clinic");subCategories.add("Dr. Anil Bhatia");subCategories.add("Dr. Shikha Sharma");
                    fillSpinner();
                }

                else if (adapterView.getItemAtPosition(i).equals("Ghaziabad")){

                    subCategories.clear();
                    subCategories.add("Dr. Chopra Arvind");subCategories.add("Dr. Kumar Arun");subCategories.add("Dr Amrita Pradipti,");subCategories.add("Dr Omkar Singh");
                    fillSpinner();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    maxid = (int)dataSnapshot.getChildrenCount();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        prd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                member.setSpinner(spinner1.getSelectedItem().toString());
                Toast.makeText(Home.this, "booked", Toast.LENGTH_SHORT).show();


                reference.child(String.valueOf(maxid+1)).setValue(member);
            }
        });



    }


    public void fillSpinner(){
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,subCategories);
        adapter2.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner2.setAdapter(adapter2);
    }





}