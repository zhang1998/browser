package com.alibaba.appmonitor.d;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.c.a.c;
import com.alibaba.analytics.core.c.i;
import com.alibaba.analytics.core.d.e;
import com.alibaba.appmonitor.a.d;
import com.alibaba.appmonitor.b.f;
import com.alibaba.appmonitor.f.h;

/* compiled from: ProGuard */
public final class a {
    public static void a(String str, String str2, String str3, double d) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                af.c("AppMonitorDelegate", "module & monitorPoint must not null");
                return;
            }
            if (com.alibaba.analytics.core.c.a.a().a(h.COUNTER, str, str2)) {
                f.c.a(i.a(i.a, h.COUNTER + ":" + str + ":" + str2, Double.valueOf(1.0d)));
            }
            if (f.b) {
                b.l();
                if (h.COUNTER.e && (f.a || d.a().a(h.COUNTER, str, str2))) {
                    af.a("commitCount", "module", str, "monitorPoint", str2, "args", str3, "value", Double.valueOf(d));
                    if (d.a().b(h.COUNTER, str, str2)) {
                        String str4;
                        Context context = b.a().b;
                        if (com.alibaba.analytics.core.c.a.a().b(h.COUNTER, str, str2)) {
                            String str5 = str + "_abtest";
                            com.alibaba.appmonitor.f.d.a().a(h.COUNTER.d, str, str2, str3, d);
                            str4 = str5;
                        } else {
                            str4 = str;
                        }
                        f.a().a(h.COUNTER, new com.alibaba.appmonitor.b.a(str4, str2, str3, d, e.c(), e.d()));
                        return;
                    }
                    com.alibaba.appmonitor.f.d.a().a(h.COUNTER.d, str, str2, str3, d);
                    return;
                }
            }
            af.c("log discard !", "module", str, "monitorPoint", str2, "args", str3, "value", Double.valueOf(d));
        } catch (Throwable th) {
            c.a(com.alibaba.analytics.core.c.a.b.b, th);
        }
    }
}
