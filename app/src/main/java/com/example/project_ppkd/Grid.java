package com.example.project_ppkd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    }

    public void Database1(View view) {
        Intent order = new Intent(Grid.this, Database.class);
        startActivity(order);
    }

    public void Email1(View view) {
        Intent email = new Intent(Grid.this, Email.class);
        startActivity(email);
    }

    public void Call1(View view) {
        String mobile = "0213106014";
        Intent calling = new Intent(Intent.ACTION_DIAL);
        calling.setData(Uri.fromParts("tel", mobile, null));
        startActivity(calling);
    }

    public void WebServices1(View view) {
        Intent webservices = new Intent(Grid.this, WebServices.class);
        startActivity(webservices);
    }

    public void Tabel1(View view) {
        Intent tabel = new Intent(Grid.this, Tabel.class);
        startActivity(tabel);
    }

    public void UserLocation1(View view) {
        Intent location = new Intent(Grid.this, Location1.class);
        startActivity(location);
    }
}