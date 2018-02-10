package com.UCMobile.Apollo.download;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class c {
    static final boolean a = a.LOGCAT;
    public static c b = null;
    com.UCMobile.Apollo.download.service.a c = null;
    Handler d = new Handler();
    Runnable e = new Runnable(this) {
        final /* synthetic */ c a;

        {
            this.a = r1;
        }

        public final void run() {
            c.a(this.a);
        }
    };
    ServiceConnection f;
    Context g;
    int h = b.b;
    HashMap<f, com.UCMobile.Apollo.download.service.b.a> i = new HashMap();

    /* compiled from: ProGuard */
    final class a implements ServiceConnection {
        final /* synthetic */ c a;

        private a(c cVar) {
            this.a = cVar;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (c.a) {
                new StringBuilder("DownloaderServiceClient.onServiceConnected() name/binder: ").append(componentName).append("/").append(iBinder);
            }
            this.a.c = com.UCMobile.Apollo.download.service.a.a.a(iBinder);
            this.a.h = b.d;
            for (Entry value : this.a.i.entrySet()) {
                try {
                    this.a.c.a((com.UCMobile.Apollo.download.service.b) value.getValue());
                } catch (Throwable th) {
                }
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            if (c.a) {
                new StringBuilder("DownloaderServiceClient.onServiceDisconnected() name ").append(componentName);
            }
            this.a.h = b.e;
            this.a.c = null;
        }
    }

    /* compiled from: ProGuard */
    final class b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        private static final /* synthetic */ int[] f = new int[]{a, b, c, d, e};
    }

    static /* synthetic */ void a(c cVar) {
        if (cVar.f != null && cVar.g != null) {
            try {
                cVar.g.unbindService(cVar.f);
            } catch (Throwable th) {
            }
            cVar.g = null;
            cVar.f = null;
            cVar.c = null;
            cVar.h = b.b;
        }
    }

    public static c a() {
        if (b == null) {
            b = new c();
        }
        return b;
    }

    private c() {
    }

    public final void finalize() throws Throwable {
        if (!(this.g == null || this.c == null)) {
            try {
                if (a) {
                    new StringBuilder().append(hashCode()).append(" DownloaderServiceClient.finalize()  will try to unbind MediaPlayerService");
                }
                this.g.unbindService(new a());
            } catch (Throwable th) {
            }
        }
        super.finalize();
    }
}
