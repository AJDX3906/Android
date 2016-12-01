package cn.zengmingyang.mobile.recyclerviewcourse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RvActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        //实例化RecyclerView，注意要在Gradle里导包
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        //设置LayoutManager，它决定了怎么来布局
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置Adapter，Adapter的构造方法一般会传ArrayList进去
        recyclerView.setAdapter(new MyAdapter(itemData));
    }
}
