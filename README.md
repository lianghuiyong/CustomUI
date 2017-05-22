[![](https://img.shields.io/badge/moven%20center-1.2.0-brightgreen.svg?style=flat)](https://bintray.com/betterliang/Android/customui)
![](https://img.shields.io/badge/minSdk-15-blue.svg)
[![](https://img.shields.io/github/stars/lianghuiyong/CustomUI.svg)](https://github.com/lianghuiyong/CustomUI/stargazers)
[![](https://img.shields.io/github/forks/lianghuiyong/CustomUI.svg)](https://github.com/lianghuiyong/CustomUI/network)

# Android自定义UI

```gradle
    compile 'com.better.android:customui:x.y.z'
```

Name | Explain | Sample
--- | --- | ---
ShapeEditText | 继承于AppCompatEditText <br> app:stroke :细线宽度(不设置时，背景色会铺满按钮) <br> app:radius :拐角半径 <br> app:buttonColor: 按钮颜色（支持Color style）| 
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
ShapeButton | 继承于AppCompatTextView <br> app:stroke :细线宽度(不设置时，背景色会铺满按钮) <br> app:radius :拐角半径 <br> app:buttonColor: 按钮颜色（支持Color style） |  
