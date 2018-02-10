package com.taobao.weex.utils;

/* compiled from: ProGuard */
public enum k {
    ERROR("error", 0, 6),
    WARN("warn", 1, 5),
    INFO("info", 2, 4),
    DEBUG("debug", 3, 3),
    VERBOSE("verbose", 4, 2),
    ALL("debug", 5, 3),
    OFF("off", 6, 3);
    
    public String h;
    int i;
    int j;

    private k(String str, int i, int i2) {
        this.h = str;
        this.i = i;
        this.j = i2;
    }

    public final int a(k kVar) {
        return this.i - kVar.i;
    }
}
