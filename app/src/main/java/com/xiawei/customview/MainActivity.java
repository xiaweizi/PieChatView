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
        Paint paint = new Paint();
        mPieChatView = (PieChatView) findViewById(R.id.pcv);
        mList = new ArrayList<>();
        PieBean bean = new PieBean("d", 100);
//        PieBean bean1 = new PieBean("d", 200);
//        PieBean bean2 = new PieBean("d", 300);
//        PieBean bean3 = new PieBean("d", 100);
//        PieBean bean4 = new PieBean("d", 400);
//        PieBean bean5 = new PieBean("d", 500);
//        PieBean bean6 = new PieBean("d", 100);
        mList.add(bean);
//        mList.add(bean1);
//        mList.add(bean2);
//        mList.add(bean3);
//        mList.add(bean4);
//        mList.add(bean5);
//        mList.add(bean6);
        mPieChatView.setDatas(mList);

        findViewById(R.id.bt_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                PieBean bean = new PieBean("d", 100);
                mList.add(bean);
                mPieChatView.setDatas(mList);
            }
        });
    }
}
