package com.tencent.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.net.URL;

/* compiled from: ProGuard */
public final class m {
    private static m a = null;
    private volatile WeakReference<SharedPreferences> b = null;

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (a == null) {
                a = new m();
            }
            mVar = a;
        }
        return mVar;
    }

    public final String a(Context context, String str) {
        if (this.b == null || this.b.get() == null) {
            this.b = new WeakReference(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            Object host = new URL(str).getHost();
            if (host == null) {
                return str;
            }
            Object string = ((SharedPreferences) this.b.get()).getString(host, null);
            if (string != null && !host.equals(string)) {
                return str.replace(host, string);
            }
            new StringBuilder("host=").append(host).append(", envHost=").append(string);
            return str;
        } catch (Exception e) {
            new StringBuilder("getEnvUrl url=").append(str).append("error.: ").append(e.getMessage());
            return str;
        }
    }
}
