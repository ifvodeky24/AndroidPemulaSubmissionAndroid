package com.idw.project.rumahidamanku.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.idw.project.rumahidamanku.DetailRumahIdamanActivity;
import com.idw.project.rumahidamanku.Model.Rumah;
import com.idw.project.rumahidamanku.R;

import java.util.ArrayList;

public class ListRumahAdapter extends RecyclerView.Adapter<ListRumahAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Rumah> listRumah;


    public ListRumahAdapter(Context context) {
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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_rumah, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int position) {
        categoryViewHolder.tvName.setText(getListRumah().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListRumah().get(position).getRemarks());
        Glide.with(context)
                .load(getListRumah().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return getListRumah().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
