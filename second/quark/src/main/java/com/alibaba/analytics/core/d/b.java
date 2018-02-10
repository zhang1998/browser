package com.alibaba.analytics.core.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alibaba.analytics.a.ae;

/* compiled from: ProGuard */
final class b implements Runnable {
    Context a;

    private b() {
    }

    public final void run() {
        if (this.a != null) {
            try {
                ae.a();
                if (this.a.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.a.getPackageName()) != 0) {
                    e.a[0] = "Unknown";
                    return;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
                if (connectivityManager == null) {
                    e.a[0] = "Unknown";
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    e.a[0] = "Unknown";
                    e.a[1] = "Unknown";
                } else if (1 == activeNetworkInfo.getType()) {
                    e.a[0] = "Wi-Fi";
                } else if (activeNetworkInfo.getType() == 0) {
                    e.a[0] = "2G/3G";
                    e.a[1] = activeNetworkInfo.getSubtypeName();
                }
            } catch (Exception e) {
            }
        }
    }
}
