package com.uc.apollo.media.impl;

import android.net.Uri;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.apollo.Settings;
import com.uc.apollo.media.base.Statistic;
import com.uc.apollo.media.d;
import com.uc.crashsdk.export.LogType;
import java.util.Date;
import java.util.HashMap;

/* compiled from: ProGuard */
final class c {
    private int a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;
    private int g;
    private int h;
    private long i;
    private long j;
    private long k;
    private long l;
    private int m;

    public c() {
        a();
    }

    public final void a() {
        this.a = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = 0;
        this.h = 0;
    }

    private static String a(Uri uri) {
        if (uri == null || Uri.EMPTY.equals(uri)) {
            return null;
        }
        if ("file".equals(uri.getScheme())) {
            return "file";
        }
        return uri.getHost();
    }

    public final void a(DataSource dataSource) {
        if (dataSource instanceof DataSourceURI) {
            DataSourceURI dataSourceURI = (DataSourceURI) dataSource;
            this.d = a(dataSourceURI.uri);
            c(a(Uri.parse(dataSourceURI.pageUri)));
        } else if (dataSource instanceof DataSourceFD) {
            this.c = "FD";
            this.d = "FD";
        }
    }

    public final void a(String str) {
        if (str != null) {
            c(a(Uri.parse(str)));
        }
    }

    private void c(String str) {
        if (str != null && !str.isEmpty()) {
            this.c = str;
        }
    }

    public final void b() {
        if (this.h == 0) {
            this.h = 1;
        }
    }

    public final void c() {
        this.h = 2;
        if (this.l == 0) {
            this.k = new Date().getTime();
        }
    }

    public final void a(int i) {
        if (this.k != 0 && this.l == 0 && i > 0 && i < SecExceptionCode.SEC_ERROR_SIMULATORDETECT) {
            this.l = new Date().getTime() - ((long) i);
        }
    }

    public final void d() {
        if (this.g == 0) {
            this.g = 1;
        }
        this.i = new Date().getTime();
    }

    public final void b(int i) {
        this.g = 2;
        this.j = new Date().getTime();
        this.m = i;
    }

    public final void c(int i) {
        this.a = i;
    }

    public final void a(int i, String str) {
        this.e = i;
        this.f = str;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final String e() {
        return this.b;
    }

    public final void f() {
        d("ERROR");
    }

    public final void g() {
        d("COMPLETE");
    }

    public final void h() {
        d("EXIT");
    }

    private void d(String str) {
        if (this.i != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("as_ret", str);
            hashMap.put("as_ve", Settings.getVersion());
            hashMap.put("as_pt", d.b(this.a));
            hashMap.put("as_ptcrc", String.valueOf(this.e));
            if (!(this.f == null || this.f.isEmpty())) {
                Object obj = this.f;
                int length = this.f.length();
                if (length > LogType.UNEXP) {
                    obj = this.f.substring(0, 126) + ".." + this.f.substring(length - 128);
                }
                hashMap.put("as_ptcrd", obj);
            }
            if (this.b != null && this.b.length() > 0) {
                hashMap.put("as_ave", this.b);
            }
            if (this.j != 0) {
                hashMap.put("as_len", Integer.toString(this.m));
                hashMap.put("as_t1", Long.toString(this.j - this.i));
                if (this.k != 0) {
                    hashMap.put("as_ta", Long.toString(this.k - this.j));
                } else {
                    hashMap.put("as_ta", "-1");
                }
                if (this.k == 0 || this.l == 0) {
                    hashMap.put("as_tb", "-1");
                } else {
                    hashMap.put("as_tb", Long.toString(this.l - this.k));
                }
            } else {
                hashMap.put("as_len", "-1");
                hashMap.put("as_t1", "-1");
                hashMap.put("as_ta", "-1");
                hashMap.put("as_tb", "-1");
            }
            if (this.c != null) {
                hashMap.put("as_ph", this.c);
            }
            if (this.d != null) {
                hashMap.put("as_vh", this.d);
            }
            hashMap.put("as_p", String.valueOf(this.g));
            hashMap.put("as_s", String.valueOf(this.h));
            Statistic.onStatisticUpdate(1, hashMap);
            a();
        }
    }
}
