package com.alibaba.analytics.core.h.a;

import android.text.TextUtils;
import com.alibaba.analytics.core.b;
import com.uc.apollo.impl.SettingsConst;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/* compiled from: ProGuard */
public final class a {
    public static Map<String, String> a = Collections.synchronizedMap(new HashMap());
    private static a d = null;
    public ScheduledFuture b;
    public Runnable c = new b(this);

    private a() {
        if (b.a().b != null) {
            List a = b.a().n.a(c.class, null, null, -1);
            if (a != null) {
                for (int i = 0; i < a.size(); i++) {
                    a.put(((c) a.get(i)).a, ((c) a.get(i)).b);
                }
            }
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (d == null) {
                d = new a();
            }
            aVar = d;
        }
        return aVar;
    }

    public static String a(String str) {
        String str2 = (String) a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return SettingsConst.FALSE;
        }
        return str2;
    }
}
