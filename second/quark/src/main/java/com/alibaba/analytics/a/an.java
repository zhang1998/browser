package com.alibaba.analytics.a;

import android.content.Context;
import com.alibaba.analytics.core.b;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class an {
    public static String a() {
        long j = 0;
        try {
            if (af.a()) {
                j = System.currentTimeMillis();
            }
            Class cls = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
            Object invoke = cls.getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{b.a().b});
            Class cls2 = Class.forName("com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent");
            Object invoke2 = cls.getMethod("getInterface", new Class[]{Class.class}).invoke(invoke, new Object[]{cls2});
            Class cls3 = Class.forName("com.alibaba.wireless.security.open.securitybody.SecurityBodyDefine");
            int i = cls3.getField("OPEN_SECURITYBODY_FLAG_FORMAT_MINI").getInt(cls3);
            int i2 = cls3.getField("OPEN_SECURITYBODY_ENV_ONLINE").getInt(cls3);
            af.a("OPEN_SECURITYBODY_FLAG_FORMAT_MINI:" + i, new Object[0]);
            af.a("OPEN_SECURITYBODY_ENV_ONLINE:" + i2, new Object[0]);
            String str = (String) cls2.getMethod("getSecurityBodyDataEx", new Class[]{String.class, String.class, String.class, HashMap.class, Integer.TYPE, Integer.TYPE}).invoke(invoke2, new Object[]{null, null, null, null, Integer.valueOf(i), Integer.valueOf(i2)});
            if (!af.a()) {
                return str;
            }
            af.a("Mini Wua: " + str + ",waste time:" + (System.currentTimeMillis() - j), new Object[0]);
            return str;
        } catch (Throwable th) {
            af.a("", th.toString());
            return null;
        }
    }
}
