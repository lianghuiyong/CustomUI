[![](https://img.shields.io/badge/moven%20center-1.2.5-brightgreen.svg?style=flat)](https://bintray.com/betterliang/Android/customui)
![](https://img.shields.io/badge/minSdk-15-blue.svg)
[![](https://img.shields.io/github/stars/lianghuiyong/CustomUI.svg)](https://github.com/lianghuiyong/CustomUI/stargazers)
[![](https://img.shields.io/github/forks/lianghuiyong/CustomUI.svg)](https://github.com/lianghuiyong/CustomUI/network)

# Gradle
```gradle
    compile 'com.better.android:customui:x.y.z'
```

# Color-Style
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

# 说明
```
    app:stroke :细线宽度(不设置时，背景色会铺满按钮)
    app:radius :拐角半径
    app:buttonColor: 按钮颜色（支持Color style
```

# 示例
ShapeButton | Explain | Sample
--- | --- | ---
Enable   | <div><img src="http://oeqej1j2m.bkt.clouddn.com/ShapeButton_2_05.gif" width="300"></div>| app:radius="1.5dp" <br>  app:stroke="0.2dp"  <br>  app:buttonColor="@color/green"
Disable  | <div><img src="http://oeqej1j2m.bkt.clouddn.com/ShapeButton_2_06.gif" width="300"></div>| android:enabled="false"  <br>  app:radius="1.5dp" <br>  app:stroke="0.2dp"  <br>  app:buttonColor="@color/green"
Enable   | <div><img src="http://oeqej1j2m.bkt.clouddn.com/ShapeButton_2_07.gif" width="300"></div>| app:radius="1.5dp"  <br>  app:buttonColor="@color/green"
Disable  | <div><img src="http://oeqej1j2m.bkt.clouddn.com/ShapeButton_2_08.gif" width="300"></div>| android:enabled="false"  <br>  app:radius="1.5dp" <br>  app:buttonColor="@color/green"

ShapeEditText | Explain | Sample
--- | --- | ---
Enable   | <div><img src="http://oeqej1j2m.bkt.clouddn.com/ShapeEditText_2_13.gif" width="300"></div>| app:radius="1.5dp" <br>  app:stroke="0.2dp"  <br>  app:buttonColor="@color/green"
Disable  | <div><img src="http://oeqej1j2m.bkt.clouddn.com/ShapeEditText_2_14.gif" width="300"></div>| android:enabled="false"  <br> app:radius="1.5dp" <br>  app:stroke="0.2dp"  <br> app:buttonColor="@color/green"