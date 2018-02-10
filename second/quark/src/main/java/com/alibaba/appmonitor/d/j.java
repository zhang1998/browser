package com.alibaba.appmonitor.d;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.c.a;
import com.alibaba.analytics.core.c.i;
import com.alibaba.analytics.core.d.e;
import com.alibaba.appmonitor.a.d;
import com.alibaba.appmonitor.b.c;
import com.alibaba.appmonitor.b.f;
import com.alibaba.appmonitor.f.h;
import com.uc.apollo.impl.SettingsConst;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class j {
    public static void a(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                af.c("AppMonitorDelegate", "module & monitorPoint must not null");
                return;
            }
            if (a.a().a(h.ALARM, str, str2)) {
                f.c.a(i.a(i.a, h.ALARM + ":" + str + ":" + str2, Double.valueOf(1.0d)));
            }
            if (f.b) {
                b.l();
                if (h.ALARM.e && (f.a || d.a().a(str, str2, Boolean.valueOf(true)))) {
                    af.a("commitSuccess", "module", str, "monitorPoint", str2, "arg", str3);
                    if (d.a().b(h.ALARM, str, str2)) {
                        String str4;
                        Context context = b.a().b;
                        if (a.a().b(h.ALARM, str, str2)) {
                            str4 = str + "_abtest";
                            com.alibaba.appmonitor.f.d.a().a(h.ALARM.d, str, str2, str3);
                        } else {
                            str4 = str;
                        }
                        f.a().a(h.ALARM, new c(str4, str2, str3, null, null, true, e.c(), e.d()));
                        return;
                    }
                    com.alibaba.appmonitor.f.d.a().a(h.ALARM.d, str, str2, str3);
                    return;
                }
            }
            af.c("log discard !", "module", str, "monitorPoint", str2, "arg", str3);
        } catch (Throwable th) {
            com.alibaba.analytics.core.c.a.c.a(com.alibaba.analytics.core.c.a.b.b, th);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                af.c("AppMonitorDelegate", "module & monitorPoint must not null");
                return;
            }
            if (a.a().a(h.ALARM, str, str2)) {
                f.c.a(i.a(i.a, h.ALARM + ":" + str + ":" + str2, Double.valueOf(1.0d)));
            }
            new HashMap().put("_status", SettingsConst.FALSE);
            if (f.b) {
                b.l();
                if (h.ALARM.e && (f.a || d.a().a(str, str2, Boolean.valueOf(false)))) {
                    af.a("commitFail ", "module", str, "monitorPoint", str2, "errorCode:", str4, "errorMsg:", str5);
                    if (d.a().b(h.ALARM, str, str2)) {
                        String str6;
                        if (a.a().b(h.ALARM, str, str2)) {
                            String str7 = str + "_abtest";
                            com.alibaba.appmonitor.f.d.a().a(h.ALARM.d, str, str2, str3, str4, str5);
                            str6 = str7;
                        } else {
                            str6 = str;
                        }
                        Context context = b.a().b;
                        f.a().a(h.ALARM, new c(str6, str2, str3, str4, str5, false, e.c(), e.d()));
                        return;
                    }
                    com.alibaba.appmonitor.f.d.a().a(h.ALARM.d, str, str2, str3, str4, str5);
                    return;
                }
            }
            af.c("log discard !", "module", str, "monitorPoint", str2, "errorCode:", str4, "errorMsg:", str5);
        } catch (Throwable th) {
            com.alibaba.analytics.core.c.a.c.a(com.alibaba.analytics.core.c.a.b.b, th);
        }
    }
}
