package com.alibaba.analytics.core.a;

import android.text.TextUtils;
import com.alibaba.analytics.a.r;
import com.alibaba.analytics.a.z;
import com.alibaba.analytics.core.h.e;
import com.alibaba.analytics.core.h.q;

/* compiled from: ProGuard */
public final class b implements q {
    public static b a;
    public g b;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    b() {
        try {
            this.b = new g();
            a(r.a(com.alibaba.analytics.core.b.a().b, "utanalytics_tnet_host_port"));
            a(z.a(com.alibaba.analytics.core.b.a().b, "utanalytics_tnet_host_port"));
            a(e.a().a("utanalytics_tnet_host_port"));
            e.a().a("utanalytics_tnet_host_port", (q) this);
        } catch (Throwable th) {
        }
    }

    public final void b(String str, String str2) {
        a(str2);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            int indexOf = trim.indexOf(":");
            if (indexOf != -1) {
                Object substring = trim.substring(0, indexOf);
                int parseInt = Integer.parseInt(trim.substring(indexOf + 1, trim.length()));
                if (!TextUtils.isEmpty(substring) && parseInt > 0) {
                    this.b.a = substring;
                    this.b.b = parseInt;
                }
            }
        }
    }
}
