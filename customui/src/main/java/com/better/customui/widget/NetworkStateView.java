package com.better.customui.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.better.customui.R;
import com.better.customui.utils.NetworkUtils;

/**
 * Created by yuzhihua on 2017/7/10.
 */

public class NetworkStateView extends FrameLayout {

    private View view;
    private Context context;
    private NetWorkStateReceiver mReceiver;

    public NetworkStateView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public NetworkStateView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NetworkStateView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.view_network_state, this);

        if (view.isInEditMode()) {
            return;
        }

        startNetReceiver(context);
    }

    //动态启动网络监听广播
    private void startNetReceiver(Context context){
        IntentFilter mFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        mReceiver = new NetWorkStateReceiver();
        context.registerReceiver(mReceiver, mFilter);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mReceiver != null){
            context.unregisterReceiver(mReceiver);
        }
    }

    /**
     * Created by Liang on 2017/4/5.
     */
    public class NetWorkStateReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (NetworkUtils.isConnected(context)) {
                showView(false);
            } else {
                showView(true);
            }
        }

        private void showView(boolean isShow) {
            if (view != null) {
                setVisibility(isShow ? VISIBLE : GONE);
            }
        }
    }
}
