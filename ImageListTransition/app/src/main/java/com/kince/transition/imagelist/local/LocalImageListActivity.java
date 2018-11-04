package com.kince.transition.imagelist.local;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kince.transition.imagelist.R;

import java.util.ArrayList;

public class LocalImageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_image_list);

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new LocalImageListAdapter(this,makeData()));
    }

    private ArrayList<ImageEntity> makeData() {
        ArrayList<ImageEntity> imageEntities = new ArrayList<>();
        imageEntities.add(new ImageEntity("Kince", R.mipmap.image1));
        imageEntities.add(new ImageEntity("Kince", R.mipmap.image2));
        imageEntities.add(new ImageEntity("Kince", R.mipmap.image3));
        imageEntities.add(new ImageEntity("Kince", R.mipmap.image4));
        imageEntities.add(new ImageEntity("Kince", R.mipmap.image5));
        return imageEntities;
    }

}
