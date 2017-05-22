# 做按钮，用shape画样式，NO，简单点

[![](https://img.shields.io/badge/moven%20center-1.1.0-brightgreen.svg?style=flat)](https://bintray.com/betterliang/Android/customui)
![](https://img.shields.io/badge/minSdk-15-blue.svg)
[![](https://img.shields.io/github/stars/lianghuiyong/CustomUI.svg)](https://github.com/lianghuiyong/CustomUI/stargazers)
[![](https://img.shields.io/github/forks/lianghuiyong/CustomUI.svg)](https://github.com/lianghuiyong/CustomUI/network)

```gradle
    compile 'com.better.android:customui:x.y.z'
```

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
<div align="center">
  	<img src="http://oeqej1j2m.bkt.clouddn.com/ShapeButton_1.png" width="300">
</div>