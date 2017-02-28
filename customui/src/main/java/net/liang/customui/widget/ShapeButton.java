package net.liang.customui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

import net.liang.customui.R;

import static android.R.attr.radius;

/**
 * Created by lenovo on 2017/2/28.
 */

public class ShapeButton extends Button {

    public ShapeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShapeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ShapeButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(context, attrs);
    }

    void init(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShapeButton);
        int normalColor = typedArray.getColor(R.styleable.ShapeButton_normalColor, Color.parseColor("#00000000"));//内部填充颜色
        int pressColor = typedArray.getColor(R.styleable.ShapeButton_pressColor, Color.parseColor("#00000000"));//内部填充颜色
        int strokeNormalColor = typedArray.getColor(R.styleable.ShapeButton_stroke_normalColor, Color.parseColor("#00000000"));//内部填充颜色
        int strokePressColor = typedArray.getColor(R.styleable.ShapeButton_stroke_pressColor, Color.parseColor("#00000000"));//内部填充颜色
        float radius = typedArray.getDimension(R.styleable.ShapeButton_radius, 0);
        float stroke = typedArray.getDimension(R.styleable.ShapeButton_stroke, 0);

        GradientDrawable normalDrawable = getDrawable(context,  normalColor, strokeNormalColor, radius, stroke);
        GradientDrawable pressDrawable = getDrawable(context,  pressColor, strokePressColor, radius, stroke);
        StateListDrawable selector = getSelector(normalDrawable, pressDrawable);

        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(selector);
        } else {
            setBackground(selector);
        }
    }

    public static GradientDrawable getDrawable(Context context , int rgb, int strokeRgb, float radius, float stroke) {

        GradientDrawable gradientDrawable = new GradientDrawable();

        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(rgb);//设置颜色
        gradientDrawable.setCornerRadius(dp2px(context, radius));//设置圆角的半径
        gradientDrawable.setStroke(dp2px(context, stroke), strokeRgb);//描边

        return gradientDrawable;
    }

    public static StateListDrawable getSelector(Drawable normalDrawable, Drawable pressDrawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        //给当前的颜色选择器添加选中图片指向状态，未选中图片指向状态
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed}, pressDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, normalDrawable);
        //设置默认状态
        stateListDrawable.addState(new int[]{}, normalDrawable);
        return stateListDrawable;
    }

    /**
     * dp转px
     *
     * @param context 上下文
     * @param dpValue dp值
     * @return px值
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
