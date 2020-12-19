package com.deniz.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EsyaBuldum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esya_buldum);

        final EditText bulanadsad = (EditText)findViewById(R.id.editTextBulanAdSoyad);
        final EditText bulunduguSehir = (EditText)findViewById(R.id.editTextBulunduguSehir);
        final EditText esyatur = (EditText)findViewById(R.id.editTextEsyaTur);
        Button btnVeriekle = (Button)findViewById(R.id.btnKayipEsyaBildir);
        btnVeriekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Write a message to the database
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference dbRef = db.getReference("esyalar");

                dbRef.child("bulankisiAdSoyad").setValue(bulanadsad.getText().toString());
                dbRef.child("bulunduguSehir").setValue(bulunduguSehir.getText().toString());
                dbRef.child("esyaTur").setValue(esyatur.getText().toString());

                Toast.makeText(EsyaBuldum.this, "Kayıp eşya bulduysanız lütfen en yakın karakola gidip teslim ediniz.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}