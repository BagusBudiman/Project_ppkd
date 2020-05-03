package com.example.project_ppkd;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] no_pesanan;
    private final String[] tanggal;
    private final String[] jam;
    private final Integer[] imgid;

    public MyListAdapter(Activity context, String[] no_pesanan, String[] tanggal, Integer[] imgid, String[] jam) {
        super(context, R.layout.mylist, no_pesanan);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.no_pesanan=no_pesanan;
        this.tanggal=tanggal;
        this.jam=jam;
        this.imgid=imgid;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
        TextView subtitletittleText = (TextView) rowView.findViewById(R.id.subtitletittle);

        titleText.setText(no_pesanan[position]);
        imageView.setImageResource(imgid[position]);
        subtitleText.setText(tanggal[position]);
        subtitletittleText.setText(jam[position]);


        return rowView;

    };
}