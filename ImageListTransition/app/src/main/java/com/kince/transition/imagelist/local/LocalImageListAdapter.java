package com.kince.transition.imagelist.local;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kince.transition.imagelist.R;

import java.util.ArrayList;

public class LocalImageListAdapter extends RecyclerView.Adapter<LocalImageListAdapter.LocalImageViewHolder> {

    private ArrayList<ImageEntity> mImageList;
    private Activity mActivity;

    public LocalImageListAdapter(Activity activity,ArrayList<ImageEntity> imageList) {
        mImageList = imageList;
        mActivity = activity;
    }

    @NonNull
    @Override
    public LocalImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_item_local_image, viewGroup, false);
        return new LocalImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalImageViewHolder viewHolder, int i) {
        ImageEntity imageEntity = mImageList.get(i);

        viewHolder.textView.setText(imageEntity.title);
        Glide.with(viewHolder.textView.getContext()).load(imageEntity.url).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }

    class LocalImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;

        public LocalImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(mActivity, imageView, "imageview");
            Intent intent = new Intent(textView.getContext(), LocalImageDetailActivity.class);
            intent.putExtra("image",mImageList.get(getAdapterPosition()));
            mActivity.startActivity(intent, transitionActivityOptions.toBundle());
        }
    }

}
