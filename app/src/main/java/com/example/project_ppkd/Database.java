package com.example.project_ppkd;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Database extends AppCompatActivity {
    String[] daftar;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static Database ma;

    String[] no_pesanan={};
    String[] tanggal={};
    String[] jam={};

    Integer[] imgid={
            R.drawable.ic_arrow,R.drawable.ic_arrow,
            R.drawable.ic_arrow,R.drawable.ic_arrow,
            R.drawable.ic_arrow,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Button btn=(Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent inte = new Intent(Database.this, BuatDatabase.class);
                startActivity(inte);
            }
        });

        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pesanan",null);
        no_pesanan = new String[cursor.getCount()];
        tanggal = new String[cursor.getCount()];
        jam= new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            no_pesanan[cc] = cursor.getString(0).toString();
            tanggal[cc] = cursor.getString(1).toString();
            jam[cc] = cursor.getString(2).toString();
        }

        final MyListAdapter adapter = new MyListAdapter(this, no_pesanan, tanggal, imgid, jam);
        ListView01 = (ListView) findViewById(R.id.listView1);
        ListView01.setAdapter(adapter);
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=adapter.getItem(position);


                Toast.makeText(getApplicationContext(), " Judul "+value , Toast.LENGTH_SHORT).show();

                final String selection = adapter.getItem(position); //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Lihat Database", "Update Database", "Hapus Database"};
                AlertDialog.Builder builder = new AlertDialog.Builder(Database.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), LihatDatabase.class);
                                i.putExtra("no_pesanan", selection);
                                startActivity(i);
                                break;
                            case 1 :
                                Intent in = new Intent(getApplicationContext(), UpdateDatabase.class);
                                in.putExtra("no_pesanan", selection);
                                startActivity(in);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from pesanan where no_pesanan = '"+selection+"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}