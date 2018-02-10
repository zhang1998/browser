package com.bumptech.glide.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: ProGuard */
final class g implements d {
    final c a;
    boolean b;
    private final Context c;
    private boolean d;
    private final BroadcastReceiver e = new f(this);

    public g(Context context, c cVar) {
        this.c = context.getApplicationContext();
        this.a = cVar;
    }

    static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void c() {
    }

    public final void a() {
        if (!this.d) {
            this.b = a(this.c);
            this.c.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.d = true;
        }
    }

    public final void b() {
        if (this.d) {
            this.c.unregisterReceiver(this.e);
            this.d = false;
        }
    }
}
