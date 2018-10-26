package com.example.asus.makeup;

public class ModelMakeup {
    private int id;
    private String nama,jenis,harga,deskripsi;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModelMakeup(int id, String nama, String jenis, String harga, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;

        this.deskripsi = deskripsi;
    }
    public ModelMakeup( String nama, String jenis, String harga, String deskripsi) {
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;

        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
