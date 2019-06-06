package com.idw.project.rumahidamanku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.idw.project.rumahidamanku.Adapter.CardViewRumahAdapter;
import com.idw.project.rumahidamanku.Adapter.GridRumahAdapter;
import com.idw.project.rumahidamanku.Adapter.ListRumahAdapter;
import com.idw.project.rumahidamanku.Data.RumahData;
import com.idw.project.rumahidamanku.Model.Rumah;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_category;
    private ArrayList<Rumah> list = new ArrayList<>();
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_category = findViewById(R.id.rv_category);
        rv_category.setHasFixedSize(true);

        if (savedInstanceState == null) {
            setActionBarTitle("Tampilan List");
            list.addAll(RumahData.getListData());
            showRecyclerList();
            mode = R.id.action_list;

        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Rumah> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showSelectedRumah(Rumah rumah) {
//        Toast.makeText(this, "Kamu memilih " + rumah.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, DetailRumahIdamanActivity.class);
        intent.putExtra(DetailRumahIdamanActivity.TAG_NAME, rumah.getName());
        intent.putExtra(DetailRumahIdamanActivity.TAG_REMARKS, rumah.getRemarks());
        intent.putExtra(DetailRumahIdamanActivity.TAG_PHOTO, rumah.getPhoto());
        intent.putExtra(DetailRumahIdamanActivity.TAG_HARGA, rumah.getHarga());
        intent.putExtra(DetailRumahIdamanActivity.TAG_DESKRIPSI, rumah.getDeskripsi());
        intent.putExtra(DetailRumahIdamanActivity.TAG_STOK, rumah.getStok());
        intent.putExtra(DetailRumahIdamanActivity.TAG_TIPE, rumah.getTipe());
        intent.putExtra(DetailRumahIdamanActivity.TAG_NAMA_PENJUAL, rumah.getNamaPenjual());
        intent.putExtra(DetailRumahIdamanActivity.TAG_PHOTO_PENJUAL, rumah.getPhotoPenjual());
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

    private void showRecyclerList() {
        rv_category.setLayoutManager(new LinearLayoutManager(this));
        ListRumahAdapter listRumahAdapter = new ListRumahAdapter(this);
        listRumahAdapter.setListRumah(list);
        rv_category.setAdapter(listRumahAdapter);

        ItemClickSupport.addTo(rv_category).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedRumah(list.get(position));
            }
        });
    }

    private void showRecyclerGrid(){
        rv_category.setLayoutManager(new GridLayoutManager(this, 2));
        GridRumahAdapter gridRumahAdapter = new GridRumahAdapter(this);
        gridRumahAdapter.setListRumah(list);
        rv_category.setAdapter(gridRumahAdapter);

        ItemClickSupport.addTo(rv_category).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedRumah(list.get(position));
            }
        });
    }

    private void showRecyclerCardView(){
        rv_category.setLayoutManager(new LinearLayoutManager(this));
        CardViewRumahAdapter cardViewRumahAdapter = new CardViewRumahAdapter(this);
        cardViewRumahAdapter.setListRumah(list);
        rv_category.setAdapter(cardViewRumahAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Tampilan List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Tampilan Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Tampilan CardView";
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
