package com.deniz.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class islem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islem);

        Button btnesyabildir = (Button)findViewById(R.id.btnEsyabuldum);
        Button btnesyaKaybettim = (Button)findViewById(R.id.buttonbtnEsyaKaybettim);



        btnesyaKaybettim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent esyaKaybettimYonlendir = new Intent(getApplicationContext(),MainActivity2.class);

                startActivity(esyaKaybettimYonlendir);
            }
        });
        btnesyabildir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent esyaBildirYonlendir = new Intent(getApplicationContext(),EsyaBuldum.class);
                startActivity(esyaBildirYonlendir);
            }
        });
    }
}