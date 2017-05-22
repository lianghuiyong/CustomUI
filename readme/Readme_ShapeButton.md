# 自定义shape按钮

# 开发时，为了一个简单的按钮要写一堆的样式代码，我表示我在写假代码。

## 可定制属性

```
    app:stroke :细线宽度(不设置时，背景色会铺满按钮)
    app:radius :拐角半径
    app:buttonColor: 按钮颜色（支持Color style）
```

```xml
    <selector xmlns:android="http://schemas.android.com/apk/res/android">
        <!--pressed-->
        <item android:color="#CC3835" android:state_pressed="true" />
        
        <!--disable-->
        <item android:color="#1ACC3835" android:state_enabled="false" />
        
        <!--normal-->
        <item android:color="#EE2420"/>
    </selector>
```
## 示例
```xml
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        
        <com.better.customui.widget.ShapeButton
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:padding="20dp"
            android:textColor="@color/green"
            android:text="stroke"
            app:radius="3dp"
            app:stroke="1dip"
            app:buttonColor="@color/green"/>
            
        <com.better.customui.widget.ShapeButton
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:padding="20dp"
            android:text="stroke"
            app:radius="3dp"
            app:buttonColor="@color/red"/>

        <com.better.customui.widget.ShapeButton
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:padding="20dp"
            android:enabled="false"
            android:text="disable"
            app:radius="3dp"
            app:buttonColor="@color/red"/>
    </LinearLayout>

```
![](http://oeqej1j2m.bkt.clouddn.com/ShapeButton_1.png)
