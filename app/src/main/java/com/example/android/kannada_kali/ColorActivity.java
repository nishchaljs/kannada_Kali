package com.example.android.kannada_kali;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    public MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("red", "ಕೆಂಪು", R.drawable.color_red, R.raw.color_red));
        words.add(new word("mustard yellow", "ಸಾಸಿವೆ ಹಳದಿ", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new word("dusty yellow", "ಧೂಳಿನ ಹಳದಿ", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new word("green", "ಹಸಿರು", R.drawable.color_green, R.raw.color_green));
        words.add(new word("brown", "ಕಂದು", R.drawable.color_brown, R.raw.color_brown));
        words.add(new word("gray", "ಬೂದು", R.drawable.color_gray, R.raw.color_gray));
        words.add(new word("black", "ಕಪ್ಪು", R.drawable.color_black, R.raw.color_black));
        words.add(new word("white", "ಬಿಳಿ", R.drawable.color_white, R.raw.color_white));

        ListView rootview = (ListView) findViewById(R.id.root_view);
        rootview.setBackgroundColor(ContextCompat.getColor(this, R.color.category_colors));
        wordadapter itemsAdapter =
                new wordadapter(this, words);
        rootview.setAdapter(itemsAdapter);
        rootview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (audio != null) {
                    audio.release();
                    audio = null;
                }
                word Words = words.get(position);
                audio = MediaPlayer.create(ColorActivity.this, Words.getaudio());
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (audio != null) {
            audio.release();
            audio = null;
        }
    }
}