package com.deniz.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EsyaKaybettim extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esya_kaybettim);

        //esyalarList.add(new Esyalar())
        final TextView tur = (TextView)findViewById(R.id.textViewEsyaListeEsyaTur);
        final TextView yer = (TextView)findViewById(R.id.textViewEsyaListeBulunduguYer);
        final TextView kisi = (TextView)findViewById(R.id.textViewEsyaBulanKisiAdSoayad);
        final Button verial = (Button)findViewById(R.id.btnverial) ;

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference dbRef = db.getReference("message");

        // Read from the database

        verial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        Log.d("TAG", "Value is: " + value);
                        tur.setText(value);
                    }


                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });
            }
        });


    }
}