package com.alibaba.analytics.core.h;

import com.alibaba.analytics.core.b;

/* compiled from: ProGuard */
public final class r implements q {
    public final void b(String str, String str2) {
        if ("sw_plugin".equalsIgnoreCase(str)) {
            boolean z = false;
            try {
                z = Boolean.parseBoolean(str2);
            } catch (Exception e) {
            }
            if (z) {
                b.a().p = true;
            }
        }
    }
}
