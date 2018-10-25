package com.example.asus.makeup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.Snackbar;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyDataHelper datamakeup;
    RecyclerView rcv;
    RecyclerView.Adapter adap;
    public static MainActivity layarutama;
    List<ModelMakeup> makeupList;
    protected Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layarutama = this;
        //button add
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, Create.class);
                startActivity(myintent);
            }
        });
        //button logout
        FloatingActionButton fab2 = findViewById(R.id.buttonLogout);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPreference();
                Intent i = new Intent(getApplicationContext(), Login.class);
                i.putExtra("msg", "Logout Success");
                startActivity(i);
            }
        });

        rcv = findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;
        rcv.setLayoutManager(rvLiLayoutManager);

        Tampil();

        rcv.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rcv, new ClickListener() {

            @Override
            public void onClick(View v, int position) {
                final ModelMakeup make = makeupList.get(position);
                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
                i.putExtra("nama", ""+make.getNama());
                startActivity(i);
            }

            @Override
            public void onLongClick(View v, int position) {
                final ModelMakeup make = makeupList.get(position);
                final CharSequence[] dialogitem = {"Detail produk","Edit Produk","Delete Produk"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which){
                            case 0 :
                                Intent detail = new Intent(getApplicationContext(), DetailActivity.class);
                                detail.putExtra("nama", ""+make.getNama());
                                startActivity(detail);
                                break;
                            case 1 :
                                Intent update = new Intent(getApplicationContext(),Update.class);
                                update.putExtra("nama",""+make.getNama());
                                startActivity(update);
                                break;
                            case 2 :
                                SQLiteDatabase db = datamakeup.getWritableDatabase();
                                int id = make.getId();
                                String nama = make.getNama();
                                db.execSQL("DELETE FROM wardah WHERE nama = '"+nama+"'");
//                                Snackbar.make(v,"Produk "+make.getNama()+" Telah Terhapus",Snackbar.LENGTH_LONG).show();
                                Tampil();
                                break;
                        }
                    }
                });
                builder.show();
            }
        }));
    }

    public void Tampil() {
        this.makeupList= new ArrayList<>();
        makeupList.addAll(All());
        adap = new Adapter(makeupList);
        rcv.setAdapter(adap);
    }

    public List<ModelMakeup> All(){
        List<ModelMakeup> makeupList = new ArrayList<>();

        datamakeup = new MyDataHelper(this);
        SQLiteDatabase db = datamakeup.getReadableDatabase();
        cursor = db.rawQuery(" SELECT * FROM wardah ", null);

        if (cursor.moveToFirst()){
            do {
                ModelMakeup menu = new ModelMakeup(cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),
                        cursor.getString(4));
                makeupList.add(menu);
            } while (cursor.moveToNext());
        }
        return makeupList;
    }

    private void resetPreference() {
        SharedPreferences handler = getSharedPreferences("Login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = handler.edit();

        editor.remove("username");
        editor.remove("password");
        editor.apply();
    }


}
