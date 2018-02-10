package com.bumptech.glide.b.c;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class ag {
    private static final String c = System.getProperty("http.agent");
    private static final Map<String, List<af>> d;
    boolean a = true;
    Map<String, List<af>> b = d;
    private boolean e = true;

    static {
        Map hashMap = new HashMap(2);
        if (!TextUtils.isEmpty(c)) {
            hashMap.put("User-Agent", Collections.singletonList(new ah(c)));
        }
        d = Collections.unmodifiableMap(hashMap);
    }
}
