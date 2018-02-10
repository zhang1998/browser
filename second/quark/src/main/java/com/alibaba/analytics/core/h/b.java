package com.alibaba.analytics.core.h;

import java.util.Map;

/* compiled from: ProGuard */
public final class b extends m {
    public final void a(String str, Map<String, String> map) {
        if (map.containsKey("tpk")) {
            String str2 = (String) map.get("tpk");
            if (str2 != null) {
                com.alibaba.analytics.core.b.a().q = str2;
            }
        }
    }

    public final String[] c() {
        return new String[]{"ut_bussiness"};
    }
}
