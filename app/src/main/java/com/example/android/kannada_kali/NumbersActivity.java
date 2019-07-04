package com.example.android.kannada_kali;

import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity { public MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        final ArrayList<word> numbers= new ArrayList<word>();
        numbers.add(new word("One","ಒಂದು",R.drawable.number_one,R.raw.number_one));
        numbers.add(new word("Two","ಎರಡು",R.drawable.number_two,R.raw.number_two));
        numbers.add(new word("Three","ಮೂರು",R.drawable.number_three,R.raw.number_three));
        numbers.add(new word("Four","ನಾಲ್ಕು",R.drawable.number_four,R.raw.number_four));
        numbers.add(new word("Five","ಐದು",R.drawable.number_five,R.raw.number_five));
        numbers.add(new word("Six","ಆರು",R.drawable.number_six,R.raw.number_six));
        numbers.add(new word("Seven","ಏಳು",R.drawable.number_seven,R.raw.number_seven));
        numbers.add(new word("Eight","ಎಂಟು",R.drawable.number_eight,R.raw.number_eight));
        numbers.add(new word("Nine","ಒಂಬತ್ತು",R.drawable.number_nine,R.raw.number_nine));
        numbers.add(new word("Ten","ಹತ್ತು",R.drawable.number_ten,R.raw.number_ten));

        ListView rootview=(ListView) findViewById(R.id.root_view);
        rootview.setBackgroundColor(ContextCompat.getColor(this, R.color.category_numbers));
        wordadapter itemsAdapter =
                new wordadapter(this, numbers);
        rootview.setAdapter(itemsAdapter);
        rootview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (audio != null)
                {  audio.release();
                    audio = null;
                }
                word words=numbers.get(position);
                audio=MediaPlayer.create(NumbersActivity.this,words.getaudio());
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
