package com.example.android.kannada_kali;

import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity { public MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        final ArrayList<word> words= new ArrayList<word>();
        words.add(new word("father", "ತಂದೆ",R.drawable.family_father,R.raw.family_father));
        words.add(new word("mother", "ತಾಯಿ",R.drawable.family_mother,R.raw.family_mother));
        words.add(new word("son", "ಮಗ",R.drawable.family_son,R.raw.family_son));
        words.add(new word("daughter", "ಮಗಳು",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new word("elder brother", "ಅಣ್ಣ",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new word("younger brother", "ತಮ್ಮ",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new word("elder sister", "ಅಕ್ಕ",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new word("younger sister", "ತಂಗಿ",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new word("grandmother ", "ಅಜ್ಜಿ",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new word("grandfather", "ಅಜ್ಜ",R.drawable.family_grandfather,R.raw.family_grandfather));

        ListView rootview=(ListView) findViewById(R.id.root_view);
        rootview.setBackgroundColor(ContextCompat.getColor(this, R.color.category_family));
        wordadapter itemsAdapter =
                new wordadapter(this, words);
        rootview.setAdapter(itemsAdapter);
        rootview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if (audio != null)
                    {  audio.release();
                        audio = null;
                }
                word Words = words.get(position);
                audio = MediaPlayer.create(FamilyActivity.this, Words.getaudio());

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
