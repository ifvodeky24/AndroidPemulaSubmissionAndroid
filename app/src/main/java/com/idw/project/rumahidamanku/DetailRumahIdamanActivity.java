package com.idw.project.rumahidamanku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailRumahIdamanActivity extends AppCompatActivity {

    public static final String TAG_NAME= "name";
    public static final String TAG_REMARKS= "remarks";
    public static final String TAG_PHOTO= "photo";
    public static final String TAG_HARGA= "harga";
    public static final String TAG_DESKRIPSI= "deskripsi";
    public static final String TAG_STOK= "stok";
    public static final String TAG_TIPE= "tipe";
    public static final String TAG_NAMA_PENJUAL= "nama_penjual";
    public static final String TAG_PHOTO_PENJUAL= "photo_penjual";

    String name, remarks, photo, harga, deskripsi, stok, tipe, nama_penjual, photo_penjual;

    Intent intent;

    TextView tv_nama, tv_harga, tv_deskripsi, tv_stok, tv_tipe, tv_nama_penjual;
    CircleImageView iv_gambar, iv_penjual;
    Button btn_booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rumah_idaman);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Rumah Idaman");
        }

        tv_nama = findViewById(R.id.tv_nama);
        iv_gambar = findViewById(R.id.iv_gambar);
        iv_penjual = findViewById(R.id.iv_penjual);
        tv_harga = findViewById(R.id.tv_harga);
        tv_deskripsi = findViewById(R.id.tv_deskripsi);
        tv_stok = findViewById(R.id.tv_stok);
        tv_tipe = findViewById(R.id.tv_tipe);
        tv_nama_penjual = findViewById(R.id.tv_nama_penjual);
        btn_booking = findViewById(R.id.btn_booking);

        intent = getIntent();

        name = intent.getStringExtra(TAG_NAME);
        remarks = intent.getStringExtra(TAG_REMARKS);
        photo = intent.getStringExtra(TAG_PHOTO);
        harga = intent.getStringExtra(TAG_HARGA);
        deskripsi = intent.getStringExtra(TAG_DESKRIPSI);
        stok = intent.getStringExtra(TAG_STOK);
        tipe = intent.getStringExtra(TAG_TIPE);
        nama_penjual = intent.getStringExtra(TAG_NAMA_PENJUAL);
        photo_penjual = intent.getStringExtra(TAG_PHOTO_PENJUAL);

        tv_nama.setText(name);
        Glide.with(DetailRumahIdamanActivity.this)
                .load(photo)
                .apply(new RequestOptions().override(350, 350))
                .into(iv_gambar);
        tv_harga.setText("Rp. "+ harga);
        tv_deskripsi.setText(deskripsi);
        tv_stok.setText("Stok Tersisa: " +stok);
        tv_tipe.setText("Tipe :" +tipe);
        tv_nama_penjual.setText(nama_penjual);
        Glide.with(DetailRumahIdamanActivity.this)
                .load(photo_penjual)
                .into(iv_penjual);

        btn_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailRumahIdamanActivity.this, "Kamu Memesan " + name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goToMainActivity() {
        //Fungsi kembali ke main activity dan tidak kembali lagi ke activity ini
        Intent intent = new Intent(DetailRumahIdamanActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goToMainActivity();
    }
}
