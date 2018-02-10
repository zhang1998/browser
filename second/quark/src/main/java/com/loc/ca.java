package com.loc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: ProGuard */
final class ca extends BroadcastReceiver {
    final /* synthetic */ cb a;

    private ca(cb cbVar) {
        this.a = cbVar;
    }

    public final void onReceive(Context context, Intent intent) {
        int i = 4;
        if (context != null && intent != null) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    co a = this.a.s;
                    if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                        if (a != null) {
                            Collection collection = null;
                            collection = a.a();
                            if (collection != null) {
                                synchronized (this.a.h) {
                                    this.a.v.clear();
                                    this.a.v.addAll(collection);
                                }
                            }
                            this.a.G = dm.b();
                        }
                    } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                        if (this.a.s != null) {
                            try {
                                if (a.a != null) {
                                    i = a.a.getWifiState();
                                }
                            } catch (Throwable th) {
                                cq.a(th, "APS", "onReceive part");
                            }
                            if (this.a.v == null) {
                                this.a.v = new ArrayList();
                            }
                            switch (i) {
                                case 0:
                                    this.a.p();
                                    return;
                                case 1:
                                    this.a.p();
                                    return;
                                case 4:
                                    this.a.p();
                                    return;
                                default:
                                    return;
                            }
                        }
                    } else if (action.equals("android.intent.action.SCREEN_ON")) {
                        this.a.o = true;
                    } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                        this.a.o = false;
                        if (this.a.c != null) {
                            this.a.g();
                        }
                    } else if (!action.equals("android.intent.action.AIRPLANE_MODE") && !action.equals("android.location.GPS_FIX_CHANGE") && action.equals("android.net.conn.CONNECTIVITY_CHANGE") && this.a.v()) {
                        cb.g(this.a);
                    }
                }
            } catch (Throwable th2) {
                cq.a(th2, "APS", "onReceive");
            }
        }
    }
}
