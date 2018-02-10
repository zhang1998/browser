package com.taobao.weex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.a;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;

/* compiled from: ProGuard */
public class WXGlobalEventReceiver extends BroadcastReceiver {
    private ac a;

    public WXGlobalEventReceiver(ac acVar) {
        this.a = acVar;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            this.a.a(intent.getStringExtra("eventName"), (HashMap) a.a(intent.getStringExtra("eventParams"), HashMap.class));
        } catch (Throwable e) {
            WXLogUtils.e("global-receive", e);
        }
    }
}
