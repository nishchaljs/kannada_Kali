package com.example.android.kannada_kali;

import android.widget.ImageView;

public class word { String dtext,ktext;
    int image; int audio;

    public word(String def,String trans,int im, int aud)
    {dtext=def;
     ktext=trans;
     image=im;
     audio=aud;
    }
    public String getdefault()
    {
    return dtext;}
    public String getkannada()
    {
    return ktext;}

    public int getimage()
    {return image;}

    public boolean hasimage()
    {if(image==0)
     return false; else return  true; }
     public int getaudio()
     {return audio;}
}
