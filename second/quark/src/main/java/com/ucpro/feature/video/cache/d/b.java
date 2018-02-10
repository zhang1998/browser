package com.ucpro.feature.video.cache.d;

/* compiled from: ProGuard */
public enum b {
    a,
    PUT,
    c,
    DELETE,
    HEAD,
    OPTIONS;

    static b a(String str) {
        for (b bVar : values()) {
            if (bVar.toString().equalsIgnoreCase(str)) {
                return bVar;
            }
        }
        return null;
    }
}
