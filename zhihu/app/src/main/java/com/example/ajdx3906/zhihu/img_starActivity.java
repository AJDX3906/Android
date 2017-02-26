package com.example.ajdx3906.zhihu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AJDX3906 on 2017/2/22.
 */

public class img_starActivity extends AppCompatActivity {
    private String img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.appstar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://news-at.zhihu.com/api/7/prefetch-launch-images/1080*1776");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer response = new StringBuffer();
                    String line;
                    while ((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    JSONObject result = new JSONObject(response.toString());
                    img = (String) result.get("img");
                    SharedPreferences.Editor editor = getSharedPreferences("start_img",MODE_PRIVATE).edit();
                    editor.putString("img",img);
                    editor.commit();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        /*设置图片放大效果*/
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,1.2f,1.0f,1.2f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(img_starActivity.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        /*从SharedPreferences中取出启动图片地址*/
        SharedPreferences preferences = getSharedPreferences("start_img",MODE_PRIVATE);
        String img_url = preferences.getString("img","http://img4.duitang.com/uploads/item/201410/06/20141006141239_e4NjY.jpeg");
        /*加载启动图片*/
        Uri uri = Uri.parse(img_url);
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.star);
        draweeView.setImageURI(uri);
        draweeView.startAnimation(scaleAnimation);
    }
}
