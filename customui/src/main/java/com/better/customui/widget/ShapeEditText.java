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

public class ShapeEditText extends android.support.v7.widget.AppCompatEditText {

    private float radius;
    private float stroke;
    private ColorStateList colors;

    public ShapeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShapeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShapeButton);
        radius = typedArray.getDimension(R.styleable.ShapeButton_radius, 0);
        stroke = typedArray.getDimension(R.styleable.ShapeButton_stroke, 0);
        colors = typedArray.getColorStateList(R.styleable.ShapeButton_buttonColor);

        StateListDrawable selector = getSelector();

        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(selector);
        } else {
            setBackground(selector);
        }
    }

    public GradientDrawable getDrawable(int state) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);

        int color_pressed = colors.getColorForState(new int[]{android.R.attr.state_pressed}, 0);
        int color_disable = colors.getColorForState(new int[]{-android.R.attr.state_enabled}, 0);
        int color_normal = colors.getColorForState(new int[]{android.R.attr.state_enabled}, 0);

        switch (state) {
            case android.R.attr.state_pressed:
                gradientDrawable.setColor(stroke == 0 ? color_pressed : Color.parseColor("#0C000000"));//设置颜色
                gradientDrawable.setStroke(dp2px(stroke), color_pressed);//描边
                break;

            case -android.R.attr.state_enabled:
                gradientDrawable.setColor(stroke == 0 ? color_disable : Color.parseColor("#06000000"));//设置颜色
                gradientDrawable.setStroke(dp2px(stroke), color_disable);//描边
                break;

            case android.R.attr.state_enabled:
                gradientDrawable.setColor(stroke == 0 ? color_normal : Color.parseColor("#00000000"));//设置颜色
                gradientDrawable.setStroke(dp2px(stroke), color_normal);//描边
                break;
        }
        gradientDrawable.setCornerRadius(dp2px(radius));//设置圆角的半径
        return gradientDrawable;
    }

    public StateListDrawable getSelector() {

        StateListDrawable stateListDrawable = new StateListDrawable();

        //注意该处的顺序，只要有一个状态与之相配，背景就会被换掉
        //所以不要把大范围放在前面了，如果sd.addState(new[]{},normal)放在第一个的话，就没有什么效果了
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, getDrawable(android.R.attr.state_pressed));
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, getDrawable(-android.R.attr.state_enabled));
        stateListDrawable.addState(new int[]{}, getDrawable(android.R.attr.state_enabled));

        return stateListDrawable;
    }

    /**
     * dp转px
     *
     * @param dpValue dp值
     * @return px值
     */
    public int dp2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
