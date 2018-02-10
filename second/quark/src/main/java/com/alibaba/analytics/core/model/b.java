package com.alibaba.analytics.core.model;

import android.text.TextUtils;
import com.alibaba.analytics.a.s;
import com.alibaba.analytics.a.w;
import com.alibaba.analytics.core.b.e;
import com.alibaba.analytics.core.b.f;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.analytics.core.db.g;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@TableName("log")
/* compiled from: ProGuard */
public class b extends g {
    @Column("eventId")
    public String a;
    @Column("priority")
    public String b = "3";
    @Column("streamId")
    public String c;
    @Column("time")
    public String d = null;
    @Column("_index")
    public String e = "";
    @Column("content")
    private String f;
    @Ingore
    private String g;
    @Ingore
    private String h;
    @Ingore
    private String i;
    @Ingore
    private String k;
    @Ingore
    private Map<String, String> l;

    public b(String str, String str2, Map<String, String> map) {
        this.b = str;
        this.c = "";
        this.a = str2;
        this.d = String.valueOf(System.currentTimeMillis());
        this.e = b();
        map.put(LogField.RESERVE3.toString(), this.e);
        a(com.alibaba.analytics.core.b.b.a((Map) map));
    }

    public b(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        this.a = str2;
        this.g = str;
        this.h = str3;
        this.i = str4;
        this.k = str5;
        this.l = map;
        this.d = String.valueOf(System.currentTimeMillis());
        this.e = b();
        String a = f.a().a(str2);
        if (TextUtils.isEmpty(a)) {
            a = "3";
        }
        this.b = a;
        if (TextUtils.isEmpty(this.d)) {
            this.d = String.valueOf(System.currentTimeMillis());
        }
        a(com.alibaba.analytics.core.b.b.a(this.g, this.a, this.h, this.i, this.k, this.l, this.e, this.d));
    }

    public final String a() {
        try {
            byte[] a = s.a(this.f.getBytes("UTF-8"));
            if (a != null) {
                return new String(w.a(a, "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    private void a(String str) {
        if (str != null) {
            try {
                this.f = new String(s.c(w.a(str.getBytes(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")), "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
    }

    public String toString() {
        return "Log [eventId=" + this.a + ", index=" + this.e + "]";
    }

    private String b() {
        String str = "";
        String str2 = e.a().a;
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        } else if (str2.length() >= 2) {
            str2 = str2.substring(str2.length() - 2, str2.length());
        }
        if ("2202".equalsIgnoreCase(this.a)) {
            return String.format("%s%06d,2202_%06d", new Object[]{str2, Long.valueOf(e.a().b()), Long.valueOf((long) e.a().b.incrementAndGet())});
        }
        return String.format("%s%06d", new Object[]{str2, Long.valueOf(e.a().b())});
    }
}
