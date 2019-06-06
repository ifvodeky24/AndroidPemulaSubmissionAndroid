package com.idw.project.rumahidamanku.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.idw.project.rumahidamanku.CustomOnItemClickListener;
import com.idw.project.rumahidamanku.DetailRumahIdamanActivity;
import com.idw.project.rumahidamanku.Model.Rumah;
import com.idw.project.rumahidamanku.R;

import java.util.ArrayList;

public class CardViewRumahAdapter extends RecyclerView.Adapter<CardViewRumahAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Rumah> listRumah;

    public CardViewRumahAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Rumah> getListRumah() {
        return listRumah;
    }

    public void setListRumah(ArrayList<Rumah> listRumah) {
        this.listRumah = listRumah;
    }


    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_rumah, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, final int position) {
        Rumah rumah = getListRumah().get(position);

        Glide.with(context)
                .load(rumah.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);
        cardViewViewHolder.tvName.setText(rumah.getName());
        cardViewViewHolder.tvRemarks.setText(rumah.getRemarks());

        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Anda memilih "+getListRumah().get(position).getName()+ " Sebagai Favorit", Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Anda membagikan "+getListRumah().get(position).getName() , Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
        return getListRumah().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
