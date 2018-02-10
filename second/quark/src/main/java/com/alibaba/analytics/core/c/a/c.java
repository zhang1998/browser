package com.alibaba.analytics.core.c.a;

import com.alibaba.analytics.a.r;
import com.alibaba.analytics.core.f.f;
import com.alibaba.appmonitor.d.g;
import com.alibaba.appmonitor.e.a;
import com.alibaba.appmonitor.f.b;
import com.alibaba.appmonitor.f.h;
import com.alibaba.fastjson.e;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public final class c {
    public static void a(int i, Throwable th) {
        try {
            a aVar = (b) com.alibaba.appmonitor.e.b.a().a(b.class, new Object[0]);
            aVar.b = h.ALARM.d;
            Object hashMap = new HashMap();
            hashMap.put("meta", g.a());
            a aVar2 = (com.alibaba.appmonitor.e.c) com.alibaba.appmonitor.e.b.a().a(com.alibaba.appmonitor.e.c.class, new Object[0]);
            e eVar = (e) com.alibaba.appmonitor.e.b.a().a(com.alibaba.appmonitor.e.e.class, new Object[0]);
            if (com.alibaba.analytics.core.b.a().b != null) {
                eVar.a("pname", r.b(com.alibaba.analytics.core.b.a().b));
            }
            eVar.a("page", "APPMONITOR");
            eVar.a("monitorPoint", a(i));
            eVar.a("arg", th.getClass().getSimpleName());
            eVar.a("successCount", Integer.valueOf(0));
            eVar.a("failCount", Integer.valueOf(1));
            List arrayList = new ArrayList();
            String a = a(th);
            if (a != null) {
                e eVar2 = (e) com.alibaba.appmonitor.e.b.a().a(com.alibaba.appmonitor.e.e.class, new Object[0]);
                eVar2.a(INoCaptchaComponent.errorCode, a);
                eVar2.a("errorCount", Integer.valueOf(1));
                arrayList.add(eVar2);
            }
            eVar.a("errors", arrayList);
            aVar2.add(eVar);
            hashMap.put("data", aVar2);
            aVar.f.put(h.ALARM.g, com.alibaba.fastjson.a.a(hashMap));
            aVar.c = "APPMONITOR";
            aVar.d = a(i);
            if (aVar != null) {
                f.a().a(new com.alibaba.analytics.core.model.b(aVar.a, String.valueOf(aVar.b), aVar.c, aVar.d, aVar.e, aVar.f));
                com.alibaba.appmonitor.e.b.a().a(aVar);
            }
            com.alibaba.appmonitor.e.b.a().a(aVar2);
        } catch (Throwable th2) {
        }
    }

    private static String a(int i) {
        if (b.a == i) {
            return "ut-exception";
        }
        if (b.c == i) {
            return "ut-common-exception";
        }
        return "sdk-exception";
    }

    private static String a(Throwable th) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(th.getClass().getName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuilder.append(stackTraceElement.toString());
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        if (com.alibaba.analytics.a.b.c(stringBuilder2)) {
            return th.toString();
        }
        return stringBuilder2;
    }
}
