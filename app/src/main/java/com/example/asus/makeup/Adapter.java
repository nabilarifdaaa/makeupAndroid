package com.example.asus.makeup;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private List<ModelMakeup> mList;

    Adapter ( List<ModelMakeup> list){
        mList = list;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ModelMakeup makeupItem = mList.get(position);
        ImageView image = holder.item_image;

        TextView nama,jenis,harga,deskripsi;
        nama = holder.item_nama;
        jenis = holder.item_jenis;
        harga = holder.item_harga;

        nama.setText(makeupItem.getNama());
        jenis.setText(makeupItem.getJenis());
        harga.setText(makeupItem.getHarga());

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext,DetailActivity.class);
//                intent.putExtra("nama",mList.get(position).getNama());
//                intent.putExtra("jenis",mList.get(position).getJenis());
//                intent.putExtra("harga",mList.get(position).getHarga());
//                intent.putExtra("image",mList.get(position).getImage());
//
//                mContext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_nama, item_jenis, item_harga,item_deskripsi;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image);
            item_nama = itemView.findViewById(R.id.item_nama);
            item_jenis = itemView.findViewById(R.id.item_jenis);
            item_harga = itemView.findViewById(R.id.item_harga);
            item_deskripsi = itemView.findViewById(R.id.txtDeskripsi);
            cardView = itemView.findViewById(R.id.cardView_id);
        }
    }
}
