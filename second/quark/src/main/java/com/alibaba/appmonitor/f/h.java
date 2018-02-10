package com.alibaba.appmonitor.f;

import com.alibaba.appmonitor.a.b;
import com.alibaba.appmonitor.a.c;
import com.alibaba.appmonitor.a.e;
import com.alibaba.wireless.security.SecExceptionCode;

/* compiled from: ProGuard */
public enum h {
    ALARM(65501, "alarmData", "ap_alarm", e.class),
    COUNTER(65502, "counterData", "ap_counter", b.class),
    STAT(65503, "statData", "ap_stat", c.class);
    
    static String l;
    public int d;
    public boolean e;
    int f;
    public String g;
    public int h;
    public int i;
    public Class j;
    public int k;
    private String m;

    static {
        l = "EventType";
    }

    private h(int i, int i2, String str, String str2) {
        this.h = 25;
        this.i = SecExceptionCode.SEC_ERROR_STA_ENC;
        this.d = i;
        this.f = 30;
        this.e = true;
        this.g = i2;
        this.k = 1000;
        this.m = str;
        this.j = str2;
    }

    public static h a(int i) {
        h[] values = values();
        for (h hVar : values) {
            if (hVar != null && hVar.d == i) {
                return hVar;
            }
        }
        return null;
    }

    public static h a(String str) {
        if (str == null) {
            return null;
        }
        h[] values = values();
        for (h hVar : values) {
            if (hVar != null && str.equalsIgnoreCase(hVar.m)) {
                return hVar;
            }
        }
        return null;
    }
}
