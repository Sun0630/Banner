## 自定义View - 无限轮播图
> 自定义无限轮播BannerView,使用ViewPager+Handler实现，支持自定义属性，支持设置图片切换的速率，另外还对内存进行了优化，包括对Handler的管理和Activity生命周期的管理，还进行了View的复用。最后根据图片的宽高比设置ViewPager自适应高度，能够适应不同屏幕大小的设备。
### 效果
<img src="banner.gif"/>

### 使用
1. 布局文件中

```xml
   <com.sx.banner.banner.BannerView
        android:id="@+id/bannerView"
        android:layout_width="wrap_content"
        android:layout_height="0dp"
        app:withRatio="8"
        app:heightRatio="5"
        app:bottomColor="@color/banner_bottom_bar_bg"
        app:dotDistance="4dp"
        app:dotGravity="center"
        app:dotIndicatorFocus="@color/colorAccent"
        app:dotIndicatorNormal="@color/white"
        app:dotSize="3dp"/>
```

2. 代码中

```java

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

        //开始自动轮播
        mBannerView.startRoll();
        //设置图片切换的速率
        mBannerView.setScrollerDuration(1000);
```

**属性详解**

```xml

        app:withRatio="8"
        app:heightRatio="5"//宽高比
        app:bottomColor="@color/banner_bottom_bar_bg" // 底部bar的颜色
        app:dotDistance="4dp"// 点之间的距离
        app:dotGravity="center"//点的位置
        app:dotIndicatorFocus="@color/colorAccent" //选中的点的颜色
        app:dotIndicatorNormal="@color/white"//普通点的颜色
        app:dotSize="3dp"// 点的大小

```