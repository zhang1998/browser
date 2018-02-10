package com.ucpro.feature.webwindow.o;

/* compiled from: ProGuard */
final class c {
    String a;
    long b;
    long c;
    long d;
    long e;
    long f;

    private c() {
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("StatBean{");
        stringBuffer.append("id='").append(this.a).append('\'');
        stringBuffer.append(", tStart=").append(this.b);
        stringBuffer.append(", t0=").append(this.c);
        stringBuffer.append(", t1=").append(this.d);
        stringBuffer.append(", t2=").append(this.e);
        stringBuffer.append(", t3=").append(this.f);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
