package com.idw.project.rumahidamanku.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Rumah implements Parcelable {
    private String name;
    private String remarks;
    private String photo;
    private String harga;
    private String deskripsi;
    private String stok;
    private String tipe;
    private String namaPenjual;
    private String photoPenjual;

    public String getNamaPenjual() {
        return namaPenjual;
    }

    public void setNamaPenjual(String namaPenjual) {
        this.namaPenjual = namaPenjual;
    }

    public String getPhotoPenjual() {
        return photoPenjual;
    }

    public void setPhotoPenjual(String photoPenjual) {
        this.photoPenjual = photoPenjual;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);

    }

    public Rumah() {
    }
    protected Rumah(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
    }
    public static final Parcelable.Creator<Rumah> CREATOR = new Parcelable.Creator<Rumah>() {
        @Override
        public Rumah createFromParcel(Parcel source) {
            return new Rumah(source);
        }
        @Override
        public Rumah[] newArray(int size) {
            return new Rumah[size];
        }
    };
}
