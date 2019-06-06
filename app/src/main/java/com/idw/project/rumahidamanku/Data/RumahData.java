package com.idw.project.rumahidamanku.Data;

import com.idw.project.rumahidamanku.Model.Rumah;

import java.util.ArrayList;

public class RumahData {
    public static String[][] data = new String[][]{
            {"Perumahan Gaia Residence", "Kota Semarang", "https://propertisemarang.com/wp-content/uploads/2018/11/tipe-69.jpg", "300.000.000", "Perumahan gaia residance tipe 54 dua kamar tidur satu lantai semarang kota", "1", "54", "Unnamed", "https://st2.depositphotos.com/5255311/9644/v/950/depositphotos_96444100-stock-illustration-man-in-suit-secret-service.jpg"},
            {"Perumahan Griya Punie", "Aceh Utara", "https://apollo-singapore.akamaized.net/v1/files/1c9onmcjj7391-ID/image;s=966x691;olx-st/_1_.jpg", "330.000.000", "Rumah type 54 yang terletak di perumahan. Rumah baru belum ditempati. disamping rumah masih ada halaman samping sekitar 4 m² dan halaman depan sekitar 3 m². 2 KT, 2 KM (1 kamar mandi terletak didalam kamar utama), Ruang Tamu, Ruang Keluarga dan Dapur. Jika berminat bisa telpon atau WA ke no yang tertera. Nego bisa ketemuan langsung. ", "1", "54", "Unnamed", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvbEzYlz8bDqrw26xXrURLaliumdaRBZw0S77xnyPi11cuedh8"},
            {"Perumahan Tuah Bumi Permai Residence", "Padang", "https://apollo-singapore.akamaized.net/v1/files/qft3dc51b1dx1-ID/image;s=966x691;olx-st/_1_.jpg", "130.000.000", "Rumah subsidi rasa komersil..hanya ada di Perumahan Tuah Bumi Permai Residence..silahkan di booking sekarang, unit terbatas!!", "1", "36", "Unnamed", "https://tr.seaicons.com/wp-content/uploads/2016/08/Users-User-Female-icon-1.png"}
    };

    public static ArrayList<Rumah> getListData(){
        Rumah rumah = null;
        ArrayList<Rumah> list = new ArrayList<>();
        for (String[] aData : data) {
            rumah = new Rumah();
            rumah.setName(aData[0]);
            rumah.setRemarks(aData[1]);
            rumah.setPhoto(aData[2]);
            rumah.setHarga(aData[3]);
            rumah.setDeskripsi(aData[4]);
            rumah.setStok(aData[5]);
            rumah.setTipe(aData[6]);
            rumah.setNamaPenjual(aData[7]);
            rumah.setPhotoPenjual(aData[8]);

            list.add(rumah);
        }

        return list;
    }
}
