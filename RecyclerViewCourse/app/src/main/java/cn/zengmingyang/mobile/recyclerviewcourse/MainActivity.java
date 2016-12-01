package cn.zengmingyang.mobile.recyclerviewcourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ItemData[] itemData = new ItemData[]{
            new ItemData("姓名：张三","年级：大一"),
            new ItemData("姓名：李四","年级：大二"),
            new ItemData("姓名：王二麻子","年级：大三"),
            new ItemData("姓名：张三 ","年级：大一"),
            new ItemData("姓名：李四","年级：大二"),
            new ItemData("姓名：王二麻子","年级：大三"),
            new ItemData("姓名：张三","年级：大一"),
            new ItemData("姓名：李四","年级：大二"),
            new ItemData("姓名：王二麻子","年级：大三"),
            new ItemData("姓名：张三 ","年级：大一"),
            new ItemData("姓名：李四","年级：大二"),
            new ItemData("姓名：王二麻子","年级：大三"),
            new ItemData("姓名：张三","年级：大一"),
            new ItemData("姓名：李四","年级：大二"),
            new ItemData("姓名：王二麻子","年级：大三"),
            new ItemData("姓名：张三 ","年级：大一"),
            new ItemData("姓名：李四","年级：大二"),
            new ItemData("姓名：王二麻子","年级：大三"),
            new ItemData("姓名：张三","年级：大一"),
            new ItemData("姓名：李四","年级：大二"),
            new ItemData("姓名：王二麻子","年级：大三"),
            new ItemData("姓名：张三 ","年级：大一"),
            new ItemData("姓名：李四","年级：大二"),
            new ItemData("姓名：王二麻子","年级：大三"),


    };

    LinearLayout mLinearLayout;
    ScrollView mScrollView;

    /*
     * 知识储备：
     * View简介
     * View与ViewGroup
     * View的生成(findViewById发生了什么)
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLinearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        mScrollView = (ScrollView) findViewById(R.id.activity_main);
        //adapter的由来: 一个recyclerView，需要什么信息(数据)，来完成任务？
        addViews(R.layout.item,  mLinearLayout);
    }

    //Recycler的由来: 一个简单的list,当添加的数量达到1000的时候就炸了，怎么办？
    private void addViews(@LayoutRes int res,  ViewGroup parent) {
        for (int i = 0; i < itemData.length; i++) {
            View view = View.inflate(this, res, null);
            //ViewHolder的由来: 重复findViewById()，造成性能的损失，怎么办？
            TextView textView = (TextView) view.findViewById(R.id.tv);
            textView.setText(itemData[i].getTitle());
            TextView textView1 = (TextView) view.findViewById(R.id.tv1);
            textView1.setText(itemData[i].getGrade());
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,RvActivity.class));
                }
            });
            parent.addView(view);
        }
    }

}
