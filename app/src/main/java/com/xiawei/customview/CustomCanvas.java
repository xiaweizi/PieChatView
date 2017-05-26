package com.xiawei.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 功能描述：    自定义Canvas
 * 类名：       com.xiawei.customview.CustomCanvas
 * 创建者：      xiaweizi
 * 创建时间：    2017/5/26 11:45
 * 项目名称：    CustomView
 */
public class CustomCanvas extends View {

    private Paint mPaint;

    public CustomCanvas(Context context) {
        this(context, null);
    }

    public CustomCanvas(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomCanvas(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context, attrs, defStyle);
    }

    private void initView(Context context, AttributeSet attrs, int defStyle) {
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2);
        mPaint.setAntiAlias(true);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        RectF rectF = new RectF(20,20,800,500);
//        canvas.drawRoundRect(rectF, 40,100, mPaint);
        canvas.drawArc(rectF, 0, 100, true, mPaint);
    }
}