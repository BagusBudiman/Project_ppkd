package com.example.project_ppkd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mycafe.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table pesanan(no_pesanan integer primary key, tanggal text null, jam text null, nomor_meja integer null, kode_menu text null, harga integer null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO pesanan (no_pesanan, tanggal, jam, nomor_meja, kode_menu, harga) VALUES ('1', '2019-10-09', '10:00:00', '1', 'B01', '10000');";
        db.execSQL(sql);
        sql = "create table daftarMenu(no_menu Integer Primary Key, kode_menu text null, jenis text null, nama_menu text null, penjelasan text null, harga integer null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO daftarMenu (no_menu ,kode_menu, jenis, nama_menu, penjelasan, harga) VALUES ('1', 'B01', 'Minuman', 'Kopi Hitam', 'Kopi Hitam dengan dibuat dengan teknik espresso', '10000');";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}
