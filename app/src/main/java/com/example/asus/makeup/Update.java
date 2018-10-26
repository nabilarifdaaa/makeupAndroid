package com.example.asus.makeup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    protected Cursor cursor;
    MyDataHelper dbHelper;
    Button btn1;
    EditText namatxt,jenistxt,hargatxt,deskripsitxt;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbHelper    = new MyDataHelper(this);
        namatxt     = findViewById(R.id.edit_nama);
        jenistxt    = findViewById(R.id.edit_jenis);
        hargatxt    = findViewById(R.id.edit_harga);
        deskripsitxt= findViewById(R.id.edit_deskripsi);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery(" SELECT * FROM wardah WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);

        cursor.moveToFirst();

        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            id=cursor.getString(0);
            namatxt.setText(cursor.getString(1).toString());
            jenistxt.setText(cursor.getString(2).toString());
            hargatxt.setText(cursor.getString(3).toString());
            deskripsitxt.setText(cursor.getString(4).toString());
        }

        btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL(" UPDATE wardah set nama='"+
                        namatxt.getText().toString()
                        + "', jenis='"+
                        jenistxt.getText().toString()
                        + "', harga='"+
                        hargatxt.getText().toString()
                        + "', deskripsi='"+
                        deskripsitxt.getText().toString()
                        + "' where id = "+Integer.parseInt(id)+""
                );
                Toast.makeText(getApplicationContext(), "berhasil ditambahkan",
                        Toast.LENGTH_LONG).show();
                MainActivity.layarutama.Tampil();
                finish();
            }
        });
    }
}
