package com.alibaba.analytics.core.b;

import android.content.Context;
import com.alibaba.analytics.a.u;

/* compiled from: ProGuard */
public final class g {
    private static String a = null;
    private static boolean b = true;

    public static String a(Context context) {
        if (context != null && b) {
            try {
                Class cls = Class.forName("com.taobao.dp.DeviceSecuritySDK");
                if (cls != null) {
                    Object a = u.a(cls, "getInstance", new Object[]{context}, Context.class);
                    if (a != null) {
                        Object a2 = u.a(a, "getSecurityToken");
                        if (a2 != null) {
                            a = (String) a2;
                        }
                        return (String) a2;
                    }
                }
                b = false;
            } catch (Exception e) {
            }
        }
        return null;
    }
}
