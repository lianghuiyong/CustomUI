# 自定义shape按钮

### 直接写颜色值，省去每次写shape和选中效果xml

![](http://o9or3yi8n.bkt.clouddn.com/CustomUI_shape_button.png)

```
    app:stroke :细线宽度
    app:radius :拐角宽度
    app:pressColor :按钮选中后整体覆盖颜色
    app:stroke_normalColor :细线颜色
    app:stroke_pressColor :细线选中后的颜色

    <net.liang.customui.widget.ShapeButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="123456"
        android:textColor="#FF44FF"
        app:pressColor="#2F000000"
        app:radius="3dip"
        app:stroke="0.5dip"
        app:stroke_normalColor="#553355"
        app:stroke_pressColor="#8F553355" />

```



```
    app:radius :拐角宽度
    app:normalColor :按钮颜色
    app:pressColor  :按钮选中颜色

    <net.liang.customui.widget.ShapeButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="123456"
        android:textColor="#FF44FF"
        app:normalColor="#FF3988D2"
        app:pressColor="#9F3988D2"
        app:radius="3dp" />
```

