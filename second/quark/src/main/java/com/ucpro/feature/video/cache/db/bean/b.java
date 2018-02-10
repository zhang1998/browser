package com.ucpro.feature.video.cache.db.bean;

import java.util.Date;

/* compiled from: ProGuard */
public class b {
    public Long a;
    public String b;
    public String c;
    public String d;
    public int e;
    public String f;
    public String g;
    public String h;
    public String i;
    public Boolean j;
    public String k;
    public Long l;
    public Long m;
    public Integer n;
    public Integer o;
    public Integer p;
    public Integer q;
    public Date r;
    public Date s;

    public b(Long l, String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, Boolean bool, String str8, Long l2, Long l3, Integer num, Integer num2, Integer num3, Integer num4, Date date, Date date2) {
        this.a = l;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = i;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = bool;
        this.k = str8;
        this.l = l2;
        this.m = l3;
        this.n = num;
        this.o = num2;
        this.p = num3;
        this.q = num4;
        this.r = date;
        this.s = date2;
    }

    public final boolean a() {
        return this.j == null ? false : this.j.booleanValue();
    }

    public final long b() {
        return this.l == null ? 0 : this.l.longValue();
    }

    public final long c() {
        return this.m == null ? 0 : this.m.longValue();
    }

    public final int d() {
        return this.n == null ? 0 : this.n.intValue();
    }

    public final int e() {
        return this.o == null ? 0 : this.o.intValue();
    }

    public final int f() {
        return this.p == null ? 0 : this.p.intValue();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("VideoCacheTask{");
        stringBuffer.append("id=").append(this.a);
        stringBuffer.append(", mUrl='").append(this.b).append('\'');
        stringBuffer.append(", title='").append(this.c).append('\'');
        stringBuffer.append(", cacheType=").append(this.e);
        stringBuffer.append(", status='").append(this.f).append('\'');
        stringBuffer.append(", errorMsg='").append(this.g).append('\'');
        stringBuffer.append(", path='").append(this.h).append('\'');
        stringBuffer.append(", metaDataPath='").append(this.i).append('\'');
        stringBuffer.append(", metaDataReRequest=").append(this.j);
        stringBuffer.append(", reRequestMetaDataUrl='").append(this.k).append('\'');
        stringBuffer.append(", soFarBytes=").append(this.l);
        stringBuffer.append(", totalBytes=").append(this.m);
        stringBuffer.append(", speed=").append(this.n);
        stringBuffer.append(", totalTsCount=").append(this.o);
        stringBuffer.append(", sofarTsCount=").append(this.p);
        stringBuffer.append(", sofarErrorTsCount=").append(this.q);
        stringBuffer.append(", taskCreatedTime=").append(this.r);
        stringBuffer.append(", taskLastUpdateTime=").append(this.s);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
