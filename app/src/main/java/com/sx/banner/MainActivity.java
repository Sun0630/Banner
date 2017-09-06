package com.sx.banner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sx.banner.adapter.BannerAdapter;
import com.sx.banner.banner.BannerView;

public class MainActivity extends AppCompatActivity {

    private BannerView mBannerView;

    // 图片宽高为  498/623
    String[] imgs = {
            "https://ws1.sinaimg.cn/large/610dc034ly1fj78mpyvubj20u011idjg.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fj3w0emfcbj20u011iabm.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fitcjyruajj20u011h412.jpg"
    };

    String[] desc = {
            "Invincible",
            "Concert",
            "Tour"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBannerView = (BannerView) findViewById(R.id.bannerView);
        mBannerView.setAdapter(new BannerAdapter() {
            @Override
            public View getView(int position, View convertView) {
                ImageView bannerIv = null;
                if (convertView == null) {
                    bannerIv = new ImageView(MainActivity.this);
                } else {
                    bannerIv = (ImageView) convertView;
                }

                Glide
                        .with(MainActivity.this)
                        .load(imgs[position])
                        .centerCrop()
                        .placeholder(R.mipmap.ic_launcher_round)
                        .into(bannerIv);


                return bannerIv;
            }

            @Override
            public int getCount() {
                return imgs.length;
            }

            public String getBannerDesc(int position) {
                return desc[position];
            }
        });

        //自动轮播
        mBannerView.startRoll();
        //设置图片切换的速率
        mBannerView.setScrollerDuration(1000);

    }


}
