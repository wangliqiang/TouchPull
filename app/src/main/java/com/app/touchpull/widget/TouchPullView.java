package com.app.touchpull.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 王立强 on 2018-01-25.
 */

public class TouchPullView extends View {

    // 圆的画笔
    private Paint mCirclePaint;
    // 圆的半径
    private int mCircleRadius = 150;

    public TouchPullView(Context context) {
        super(context);
        init();
    }

    public TouchPullView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TouchPullView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TouchPullView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    /**
     * 初始化方法
     */
    private void init() {
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        // 设置抗锯齿
        p.setAntiAlias(true);
        // 设置防抖动
        p.setDither(true);
        // 设置为填充方式
        p.setStyle(Paint.Style.FILL);
        p.setColor(0xFF000000);

        mCirclePaint = p;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float x = getWidth() >> 1;
        float y = getHeight() >> 1;
        canvas.drawCircle(x, y, mCircleRadius, mCirclePaint);
    }
}
