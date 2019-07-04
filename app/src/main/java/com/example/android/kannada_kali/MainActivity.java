package com.example.android.kannada_kali;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numbers = (TextView) findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbers = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbers);
            }
        });

        TextView colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent color = new Intent(MainActivity.this, ColorActivity.class);
                startActivity(color);
            }
        });

        TextView family = (TextView) findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent family = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(family);
            }
        });

        TextView phrase = (TextView) findViewById(R.id.phrases);
        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrase = new Intent(MainActivity.this, PhraseActivity.class);
                startActivity(phrase);
            }
        });


    }




}
