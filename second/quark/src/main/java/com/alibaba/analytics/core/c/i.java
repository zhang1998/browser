package com.alibaba.analytics.core.c;

import com.alibaba.appmonitor.f.h;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class i {
    public static int a = 1;
    public static int b = 2;
    public static int c = 3;
    public static int d = 4;
    public static int e = 5;
    public static int f = 6;
    public static int g = 7;
    public static int h = 8;
    public static int i = 9;
    public static int j = 10;
    public static int k = 11;
    private static HashMap<Integer, String> r = new HashMap();
    public String l = "";
    public h m = null;
    public String n;
    public Double o;
    public DimensionValueSet p;
    public MeasureValueSet q;

    static {
        r.put(Integer.valueOf(a), "sampling_monitor");
        r.put(Integer.valueOf(b), "db_clean");
        r.put(Integer.valueOf(e), "db_monitor");
        r.put(Integer.valueOf(c), "upload_failed");
        r.put(Integer.valueOf(d), "upload_traffic");
        r.put(Integer.valueOf(f), "config_arrive");
        r.put(Integer.valueOf(g), "tnet_request_send");
        r.put(Integer.valueOf(h), "tnet_create_session");
        r.put(Integer.valueOf(i), "tnet_request_timeout");
        r.put(Integer.valueOf(j), "tent_request_error");
        r.put(Integer.valueOf(k), "datalen_overflow");
    }

    public static i a(int i, String str, Double d) {
        return new i((String) r.get(Integer.valueOf(i)), str, d);
    }

    private i(String str, String str2, Double d) {
        this.l = str;
        this.n = str2;
        this.o = d;
        this.m = h.COUNTER;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SelfMonitorEvent{");
        stringBuilder.append("arg='").append(this.n).append('\'');
        stringBuilder.append(", monitorPoint='").append(this.l).append('\'');
        stringBuilder.append(", type=").append(this.m);
        stringBuilder.append(", value=").append(this.o);
        stringBuilder.append(", dvs=").append(this.p);
        stringBuilder.append(", mvs=").append(this.q);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
