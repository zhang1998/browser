package com.uc.base.wa;

import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class y {
    private String a;
    private HashMap<String, String> b = new HashMap();

    private y(String str) {
        this.a = str;
    }

    public static y a(String str) {
        return new y(str);
    }

    final String a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : this.b.entrySet()) {
            stringBuilder.append("`").append((String) entry.getKey()).append("=").append((String) entry.getValue());
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("`");
        }
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }

    public final y a(HashMap<String, String> hashMap) {
        this.b.putAll(hashMap);
        return this;
    }
}
