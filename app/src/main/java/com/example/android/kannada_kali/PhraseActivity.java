package com.example.android.kannada_kali;

import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {public MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        final ArrayList<word> words= new ArrayList<word>();

        words.add(new word("Where are you going?", "ನೀವು ಎಲ್ಲಿಗೆ ಹೋಗುತ್ತಿದ್ದೀರಾ?",0,R.raw.phrase_where_are_you_going));
        words.add(new word("What is your name?", "ನಿನ್ನ ಹೆಸರೇನು?",0,R.raw.phrase_what_is_your_name));
        words.add(new word("My name is...", "ನನ್ನ ಹೆಸರು...",0,R.raw.phrase_my_name_is));
        words.add(new word("How are you feeling?", "ನೀವು ಹೇಗೆ ಭಾವಿಸುತ್ತೀರಿ?",0,R.raw.phrase_how_are_you_feeling));
        words.add(new word("I’m feeling good.","ನನಗೆ ಒಳ್ಳೆಯ ಅನುಭವವಿದೆ.",0,R.raw.phrase_im_feeling_good));
        words.add(new word("Are you coming?", "ನೀವು ಬರುವಿರಾ?",0,R.raw.phrase_are_you_coming));
        words.add(new word("Yes, I’m coming.", "ಹೌದು, ನಾನು ಬರುತ್ತಿದ್ದೇನೆ.",0,R.raw.phrase_yes_im_coming));
        words.add(new word("I’m coming.", "ನಾನು ಬರುತ್ತಿದ್ದೇನೆ.",0,R.raw.phrase_im_coming));
        words.add(new word("Let’s go.", "ಹೋಗೋಣ.",0,R.raw.phrase_lets_go));
        words.add(new word("Come here.", "ಇಲ್ಲಿ ಬಾ.",0,R.raw.phrase_come_here));

        ListView rootview=(ListView) findViewById(R.id.root_view);
        rootview.setBackgroundColor(ContextCompat.getColor(this, R.color.category_phrases));
        wordadapter itemsAdapter =
                new wordadapter(this, words);
        rootview.setAdapter(itemsAdapter);
        rootview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(audio!=null)
                { audio.release();
                    audio=null;}
                word Words=words.get(position);
                audio=MediaPlayer.create(PhraseActivity.this,Words.getaudio());
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
