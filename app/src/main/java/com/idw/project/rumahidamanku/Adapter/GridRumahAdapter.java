package com.idw.project.rumahidamanku.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.idw.project.rumahidamanku.Model.Rumah;
import com.idw.project.rumahidamanku.R;

import java.util.ArrayList;

public class GridRumahAdapter extends RecyclerView.Adapter<GridRumahAdapter.GridViewHolder> {


    private Context context;
    private ArrayList<Rumah> listRumah;

    public GridRumahAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Rumah> getListRumah() {
        return listRumah;
    }

    public void setListRumah(ArrayList<Rumah> listRumah) {
        this.listRumah = listRumah;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_rumah, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListRumah().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListRumah().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;


        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
