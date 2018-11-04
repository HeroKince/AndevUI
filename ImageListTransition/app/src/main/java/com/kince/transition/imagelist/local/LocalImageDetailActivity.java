package com.kince.transition.imagelist.local;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.kince.transition.imagelist.R;

public class LocalImageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 延迟共享动画的执行
        postponeEnterTransition();

        setContentView(R.layout.activity_local_image_detail);

        Intent intent = getIntent();
        ImageEntity imageEntity = intent.getParcelableExtra("image");

        Glide.with(this)
                .asBitmap()
                .load(imageEntity.url)
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        startPostponedEnterTransition();
                        return false;
                    }
                })
                .into((ImageView) findViewById(R.id.imageview));
    }

    @Override
    public void onBackPressed() {
        // 5.0以上自动实现
        supportFinishAfterTransition();
    }

}
