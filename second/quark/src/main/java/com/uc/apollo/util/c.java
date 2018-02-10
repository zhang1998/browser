package com.uc.apollo.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.uc.apollo.base.Config;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class c extends BroadcastReceiver {
    private static c f;
    private Context a;
    private final ConnectivityManager b;
    private ArrayList<WeakReference<a>> c = new ArrayList();
    private boolean d = false;
    private int e = -1;

    /* compiled from: ProGuard */
    public interface a {
        void a();
    }

    /* compiled from: ProGuard */
    public final class b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = new int[]{a, b, c};
    }

    private c(Context context) {
        this.a = context.getApplicationContext();
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static c a() {
        if (f == null) {
            Context context = Config.getContext();
            if (f == null) {
                f = new c(context);
            }
        }
        return f;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            if (this.c.size() == 0 && !this.d) {
                this.d = true;
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    this.a.registerReceiver(this, intentFilter);
                } catch (Throwable th) {
                }
            }
            boolean z = false;
            for (int i = 0; i < this.c.size(); i++) {
                if (((WeakReference) this.c.get(i)).get() == aVar) {
                    z = true;
                }
            }
            if (!z) {
                this.c.add(new WeakReference(aVar));
            }
        }
    }

    public final void b(a aVar) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < this.c.size()) {
            if (((WeakReference) this.c.get(i)).get() == aVar || ((WeakReference) this.c.get(i)).get() == null) {
                arrayList.add(this.c.get(i));
            }
            i++;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.c.remove(arrayList.get(i2));
        }
        if (this.c.size() == 0 && this.d) {
            this.d = false;
            try {
                this.a.unregisterReceiver(this);
            } catch (Throwable th) {
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo = this.b.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 0 && this.e == 1) {
                try {
                    if (f.a()) {
                        b();
                    } else {
                        new Handler(Looper.getMainLooper()).post(new d(this));
                    }
                } catch (Throwable th) {
                }
            }
            this.e = activeNetworkInfo.getType();
        }
    }

    private void b() {
        int i = 0;
        while (i < this.c.size()) {
            try {
                a aVar = (a) ((WeakReference) this.c.get(i)).get();
                if (aVar != null) {
                    aVar.a();
                }
                i++;
            } catch (Throwable th) {
                return;
            }
        }
    }

    public static boolean a(Context context) {
        int i;
        int i2 = b.b;
        int i3 = b.c;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() != 1) {
                if (activeNetworkInfo.getType() == 0) {
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            i = b.b;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            i = b.b;
                            break;
                        case 13:
                            i = b.b;
                            break;
                        default:
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                                i = b.b;
                                break;
                            }
                            i = b.b;
                            break;
                            break;
                    }
                }
            }
            i = b.a;
            if (i2 != i) {
                return true;
            }
            return false;
        }
        i = i3;
        if (i2 != i) {
            return false;
        }
        return true;
    }
}
