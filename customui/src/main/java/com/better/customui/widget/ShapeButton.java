package com.better.customui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;

import com.better.customui.R;

/**
 * Created by lenovo on 2017/2/28.
 */

public class ShapeButton extends android.support.v7.widget.AppCompatTextView {

    private float radius;
    private float stroke;
    private ColorStateList colors;
    private ColorStateList strokeColors;
    private int color_normal;
    private int color_pressed;
    private int color_disable;
    private int strokecolor_normal;
    private int strokecolor_pressed;
    private int strokecolor_disable;

    public ShapeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShapeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    void init(Context context, AttributeSet attrs) {
        getPaint().setAntiAlias(true);
        setClickable(true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShapeButton);
        radius = typedArray.getDimension(R.styleable.ShapeButton_radius, 0);
        stroke = typedArray.getDimension(R.styleable.ShapeButton_stroke, 0);
        colors = typedArray.getColorStateList(R.styleable.ShapeButton_buttonColor);
        strokeColors = typedArray.getColorStateList(R.styleable.ShapeButton_strokeColor);
        typedArray.recycle();

        initColor();

        StateListDrawable selector = getSelector();

        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(selector);
        } else {
            setBackground(selector);
        }

        setGravity(Gravity.CENTER);
    }

    private void initColor(){
        if(colors != null){
            color_normal = colors.getColorForState(new int[]{android.R.attr.state_enabled}, 0);
            color_pressed = colors.getColorForState(new int[]{android.R.attr.state_pressed}, color_normal);
            color_disable = colors.getColorForState(new int[]{-android.R.attr.state_enabled}, color_normal);
        }else {
            color_normal = Color.parseColor("#ffff0000");
            color_pressed = Color.parseColor("#0cff0000");
            color_disable = Color.parseColor("#06ff0000");
        }

        if(strokeColors != null){
            strokecolor_normal = strokeColors.getColorForState(new int[]{android.R.attr.state_enabled}, 0);
            strokecolor_pressed = strokeColors.getColorForState(new int[]{android.R.attr.state_pressed}, strokecolor_normal);
            strokecolor_disable = strokeColors.getColorForState(new int[]{-android.R.attr.state_enabled}, strokecolor_normal);
        }else {
            strokecolor_normal = Color.parseColor("#00000000");
            strokecolor_pressed = Color.parseColor("#00000000");
            strokecolor_disable = Color.parseColor("#00000000");
        }
    }

    public GradientDrawable getDrawable(int state) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);

        switch (state) {
            case android.R.attr.state_pressed:
            case android.R.attr.state_selected:
                gradientDrawable.setColor(color_pressed);//设置颜色
                gradientDrawable.setStroke((int)stroke, strokecolor_pressed);//描边
                break;

            case -android.R.attr.state_enabled:
                gradientDrawable.setColor(color_disable);//设置颜色
                gradientDrawable.setStroke((int)stroke, strokecolor_disable);//描边
                break;

            case android.R.attr.state_enabled:
                gradientDrawable.setColor(color_normal);//设置颜色
                gradientDrawable.setStroke((int)stroke, strokecolor_normal);//描边
                break;
        }
        gradientDrawable.setCornerRadius(radius);//设置圆角的半径
        return gradientDrawable;
    }

    public StateListDrawable getSelector() {

        StateListDrawable stateListDrawable = new StateListDrawable();

        //注意该处的顺序，只要有一个状态与之相配，背景就会被换掉
        //所以不要把大范围放在前面了，如果sd.addState(new[]{},normal)放在第一个的话，就没有什么效果了
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, getDrawable(-android.R.attr.state_enabled));
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, getDrawable(android.R.attr.state_pressed));
        stateListDrawable.addState(new int[]{android.R.attr.state_selected, android.R.attr.state_enabled}, getDrawable(android.R.attr.state_selected));
        stateListDrawable.addState(new int[]{}, getDrawable(android.R.attr.state_enabled));

        return stateListDrawable;
    }

}
