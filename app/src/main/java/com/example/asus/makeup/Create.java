package com.example.asus.makeup;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create extends AppCompatActivity {
    MyDataHelper dbHelper;
    Button btn1;
    EditText namatxt,jenistxt,hargatxt,deskripsitxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        dbHelper    = new MyDataHelper(this);
        namatxt     = findViewById(R.id.edit_nama);
        jenistxt    = findViewById(R.id.edit_jenis);
        hargatxt    = findViewById(R.id.edit_harga);
        deskripsitxt= findViewById(R.id.edit_deskripsi);


        btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL(" INSERT INTO wardah (nama, jenis, harga, deskripsi) values('" +
                        namatxt.getText().toString()+ "','"+
                        jenistxt.getText().toString()+ "','"+
                        hargatxt.getText().toString()+ "','"+
                        deskripsitxt.getText().toString()+ "')");
                Toast.makeText(getApplicationContext(), "berhasil ditambahkan",
                        Toast.LENGTH_LONG).show();
                MainActivity.layarutama.Tampil();
                finish();
            }
        });


    }
}
