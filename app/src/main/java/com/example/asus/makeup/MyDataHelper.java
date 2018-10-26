package com.example.asus.makeup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataHelper extends SQLiteOpenHelper {
    private static final String NAMA_DB = "makeup.db";
    private static final String NAMA_TABEL = "wardah";
    private static final int VERSI_DB =1;

    private static final String ID = "id";
    private static final String NAMA = "nama";
    private static final String JENIS = "jenis";
    private static final String HARGA = "harga";
    private static final String DESKRIPSI = "deskripsi";

    private static final String CREATE_TABLE =
            " CREATE TABLE "
                    + NAMA_TABEL
                    + " ( "
                    + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NAMA + " VARCHAR (255), "
                    + JENIS + " VARCHAR (255), "
                    + HARGA + " VARCHAR (255), "
                    + DESKRIPSI + " TEXT "
                    + " ); ";

    private  static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NAMA_TABEL;

    public MyDataHelper(Context context){
        super(context, NAMA_DB, null, VERSI_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
