package com.deniz.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAnaekran = (Button)findViewById(R.id.btn_anasayfa);
        TextView anaekranUyari = (TextView)findViewById(R.id.txtAnaEkranUyari);

        anaekranUyari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.sorumlulukBeani, Toast.LENGTH_SHORT).show();
            }
        });
        btnAnaekran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yonlendir = new Intent(getApplicationContext(),islem.class);
                startActivity(yonlendir);
            }
        });
    }
}