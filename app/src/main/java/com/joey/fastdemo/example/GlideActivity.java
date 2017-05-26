package com.joey.fastdemo.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.joey.fastdemo.R;
import com.joey.fastdemo.config.Urls;
import com.joey.fastdemo.library.glide.ShowImageUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class GlideActivity extends AppCompatActivity {
    RelativeLayout relativelayout;
    LinearLayout layout;
    ImageView cirview,img,imgs,imgs2,imgs3;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        relativelayout = (RelativeLayout) findViewById(R.id.relativelayout);
        layout = (LinearLayout) findViewById(R.id.layout);
        cirview = (ImageView) findViewById(R.id.cirview);
        img = (ImageView) findViewById(R.id.img);
        imgs = (ImageView) findViewById(R.id.imgs);
        imgs2 = (ImageView) findViewById(R.id.imgs2);
        imgs3 = (ImageView) findViewById(R.id.imgs3);
        tvResult = ((TextView) findViewById(R.id.tv_result));
        initView();
    }


    public String url1 = "http://img5.imgtn.bdimg.com/it/u=3691544771,740678494&fm=23&gp=0.jpg";
    public String url2 = "http://a.hiphotos.baidu.com/image/h%3D200/sign=7f12fce71630e924d0a49b317c096e66/d52a2834349b033b23af1d351cce36d3d539bd3e.jpg";
    public String url3 = "http://www.5068.com/uploads/allimg/160401/1-160401145114-50.jpg";

    private void initView() {
        //高斯模糊
        ShowImageUtils.showImageViewBlur(this, R.mipmap.ic_launcher, url1, layout);
        //圆角
        ShowImageUtils.showImageViewToCircle(getApplication(), R.mipmap.ic_launcher, url2, cirview);
        //relaytiveLay
        ShowImageUtils.showImageView(this, R.mipmap.ic_launcher, url1, relativelayout);
        //一般图片，支持imageview，layout
        ShowImageUtils.showImageView(this, R.mipmap.ic_launcher, url2, img);
        //多种特效高斯模糊+圆角
        ShowImageUtils.showImageViewToCircleAndBlur(getApplication(), R.mipmap.ic_launcher, url2, imgs);
        //矩形圆角
        ShowImageUtils.showImageViewToRoundedCorners(getApplication(), R.mipmap.ic_launcher, url2, imgs2);
        //四周黑边
        //ShowImageUtils.showImageViewToVignette(this, R.mipmap.ic_launcher, url3, imgs3);
        //Sketch
        //ShowImageUtils.showImageViewToSketch(this,R.mipmap.ic_launcher,url2,imgs3);
        //遮罩
        ShowImageUtils.showImageViewToMsak(this,R.mipmap.ic_launcher,url2,imgs3,R.mipmap.ic_launcher);//mask是什么样子的，图片最终就会转换为什么样子的
    }

    public void btnClick(View view) {
        switch (view.getId()){
            case R.id.request:
                OkGo.get(Urls.URL_MAIN)     // 请求方式和请求url
                        .tag(this)                       // 请求的 tag, 主要用于取消对应的请求
                        .cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                        .cacheMode(CacheMode.DEFAULT)    // 缓存模式，详细请看缓存介绍
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                Log.i("123456", "onSuccess: "+s);
                                tvResult.setText(s);
                            }

                            @Override
                            public void onError(Call call, Response response, Exception e) {
                                super.onError(call, response, e);
                                Log.i("123456", "err: "+response.body().toString());
                            }
                        });

                break;
            default:
                break;
        }
    }
}
