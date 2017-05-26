package com.xiawei.customview;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private PieChatView        mPieChatView;
    private ArrayList<PieBean> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPieChatView = (PieChatView) findViewById(R.id.pcv);
        mList = new ArrayList<>();

        // 初始化数据
        PieBean bean = new PieBean("d", 100);
        mList.add(bean);
        mPieChatView.setDatas(mList);

        // 添加数据
        findViewById(R.id.bt_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });

        // 删除数据
        findViewById(R.id.bt_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
    }

    /**
     * 随机添加数据
     */
    private void addData() {
        Random add = new Random();
        // 随机添加 50-150 的数据
        PieBean bean = new PieBean("d", add.nextInt(100) + 50);
        mList.add(bean);
        mPieChatView.setDatas(mList);
    }

    /**
     * 随机删除数据
     */
    private void deleteData() {
        Random delete = new Random();
        int size = mList.size();
        // 如果数据只剩一个，直接返回
        if (size <= 1) {
            return;
        }
        mList.remove(delete.nextInt(size - 1));
        mPieChatView.setDatas(mList);
    }
}
