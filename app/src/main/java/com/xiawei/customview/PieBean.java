package com.xiawei.customview;

/**
 * 功能描述：
 * 类名：       com.xiawei.customview.PieBean
 * 创建者：      xiaweizi
 * 创建时间：    2017/5/26 13:32
 * 项目名称：    CustomView
 */
public class PieBean {
    private String name;
    private int value;
    private float percent;

    private int color;
    private float angle;

    public PieBean(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "PieBean{" +
               "name='" + name + '\'' +
               ", value=" + value +
               ", percent=" + percent +
               ", color=" + color +
               ", angle=" + angle +
               '}';
    }
}