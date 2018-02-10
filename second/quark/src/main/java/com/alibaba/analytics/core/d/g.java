package com.alibaba.analytics.core.d;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.analytics.a.af;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ProGuard */
public final class g {
    private static g f = new g();
    private Handler a = null;
    private HandlerThread b = null;
    private c c = new c(this);
    private List<a> d = new LinkedList();
    private String[] e = null;
    private f g = new f();

    public final synchronized void a(Context context) {
        if (context != null) {
            if (context != null) {
                this.e = b(context);
                if (this.e != null) {
                    for (a a : this.d) {
                        a.a(this.e[0]);
                    }
                }
                if (this.a == null && this.b == null) {
                    this.b = new HandlerThread("ut_network_check");
                    this.b.start();
                    this.a = new Handler(this.b.getLooper());
                }
            }
            try {
                context.registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Throwable th) {
                af.b("UTNetWorkStatusChecker", th, new Object[0]);
            }
        }
    }

    public static g a() {
        return f;
    }

    private g() {
    }

    public final synchronized g a(a aVar) {
        if (aVar != null) {
            if (!this.d.contains(aVar)) {
                this.d.add(aVar);
            }
        }
        return this;
    }

    public static String[] b(Context context) {
        String[] strArr = new String[]{"Unknown", "Unknown"};
        if (context == null) {
            return strArr;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return strArr;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                strArr[0] = "Unknown";
                strArr[1] = "Unknown";
                return strArr;
            }
            if (1 == activeNetworkInfo.getType()) {
                strArr[0] = "Wi-Fi";
            } else if (activeNetworkInfo.getType() == 0) {
                strArr[0] = "2G/3G";
                strArr[1] = activeNetworkInfo.getSubtypeName();
            }
            return strArr;
        } catch (Exception e) {
        }
    }
}
