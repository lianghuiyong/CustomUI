package com.better.customui.widget;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.better.customui.R;

public class ImageProgress extends View {

    private Paint mPaint;//画笔

    Context context;

    int mCenterX;
    int mCenterY;

    /**
     * 进度值。
     */
    int progress = 0;

    /**
     * 进度字体的大小。
     */
    private float textSize;

    public ImageProgress(Context context) {
        this(context, null);
    }

    public ImageProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        mPaint = new Paint();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageProgress);
        textSize = typedArray.getDimension(R.styleable.ImageProgress_text_size, 15);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true); //消除锯齿
        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setColor(Color.parseColor("#70000000"));//半透明
        canvas.drawRect(0, 0, getWidth(), getHeight() - getHeight() * progress / 100, mPaint);

        mPaint.setColor(Color.parseColor("#00000000"));//全透明
        canvas.drawRect(0, getHeight() - getHeight() * progress / 100, getWidth(), getHeight(), mPaint);

        mPaint.setTextSize(textSize);
        mPaint.setColor(Color.parseColor("#FFFFFF"));
        mPaint.setStrokeWidth(2);

        canvas.translate(mCenterX, mCenterY);
        mPaint.setTextAlign(Paint.Align.CENTER);
        drawTextByCenter(progress + "%", 0, 0, canvas, mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCenterX = w / 2;
        mCenterY = h / 2;
    }

    /**
     * 居中绘制文本
     *
     * @param text
     * @param canvas
     * @param paint
     */
    public void drawTextByCenter(String text, float x, float y, Canvas canvas, Paint paint) {
        Paint tempPaint = new Paint(paint);             // 创建一个临时画笔,防止影响原来画笔的状态
        tempPaint.setTextAlign(Paint.Align.CENTER);     // 设置文本对齐方式为居中

        // 通过y计算出baseline的位置
        float baseline = y - (tempPaint.descent() + tempPaint.ascent()) / 2;

        canvas.drawText(text, x, baseline, tempPaint);  //绘制文本
    }

    /**
     * 进度
     *
     * @param progress
     */
    public void setProgress(int progress) {
        this.progress = progress;
        postInvalidate();
    }
}

