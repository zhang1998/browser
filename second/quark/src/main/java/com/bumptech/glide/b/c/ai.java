package com.bumptech.glide.b.c;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class ai implements ae {
    private final Map<String, List<af>> c;
    private volatile Map<String, String> d;

    ai(Map<String, List<af>> map) {
        this.c = Collections.unmodifiableMap(map);
    }

    public final Map<String, String> a() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    Map hashMap = new HashMap();
                    for (Entry entry : this.c.entrySet()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        List list = (List) entry.getValue();
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            Object a = ((af) list.get(i)).a();
                            if (!TextUtils.isEmpty(a)) {
                                stringBuilder.append(a);
                                if (i != list.size() - 1) {
                                    stringBuilder.append(',');
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(stringBuilder.toString())) {
                            hashMap.put(entry.getKey(), stringBuilder.toString());
                        }
                    }
                    this.d = Collections.unmodifiableMap(hashMap);
                }
            }
        }
        return this.d;
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.c + '}';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ai)) {
            return false;
        }
        return this.c.equals(((ai) obj).c);
    }

    public final int hashCode() {
        return this.c.hashCode();
    }
}
