package com.example.asus.makeup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    protected Cursor cursor;
    MyDataHelper dbHelper;
    Button btn1;
    TextView namatxt,jenistxt,hargatxt,deskripsitxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dbHelper = new MyDataHelper(this);
        namatxt     = findViewById(R.id.txtNama);
        jenistxt    = findViewById(R.id.txtJenis);
        hargatxt    = findViewById(R.id.txtHarga);
        deskripsitxt= findViewById(R.id.txtDeskripsi);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM wardah WHERE nama = '"+
                getIntent().getStringExtra(("nama")) + "'",null);

        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            namatxt.setText(cursor.getString(1));
            jenistxt.setText(cursor.getString(2));
            hargatxt.setText(cursor.getString(3));
            deskripsitxt.setText(cursor.getString(4));
        }

    }

}
