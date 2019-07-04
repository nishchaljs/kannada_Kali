package com.example.android.kannada_kali;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class wordadapter extends ArrayAdapter<word> {

    ArrayList<word> wordlist = new ArrayList<word>();

    public wordadapter(Context context, ArrayList<word> objects) {
        super(context, 0, objects);
        wordlist = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.arrayadapter, null);
        TextView Kannada = (TextView) v.findViewById(R.id.KannadaView);
        TextView English = (TextView) v.findViewById(R.id.EnglishView);
        Kannada.setText(wordlist.get(position).getkannada());
        English.setText(wordlist.get(position).getdefault());
        ImageView Image= (ImageView) v.findViewById(R.id.imageView);
        if(wordlist.get(position).hasimage())
        Image.setImageResource(wordlist.get(position).getimage());
        else
            Image.setVisibility(View.GONE);

        return v;

    }
}
