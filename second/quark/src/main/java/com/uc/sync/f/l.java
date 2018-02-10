package com.uc.sync.f;

import com.uc.crashsdk.export.LogType;

/* compiled from: ProGuard */
public abstract class l {
    protected int a;
    public int b = -1;
    protected int c = -1;
    public int d = 0;
    public String e;
    protected int f;
    protected String g;
    protected boolean h = false;
    protected byte[] i = null;
    public long j = -1;
    public String k = "android";
    public String l = "phone";

    public final void a(l lVar) {
        this.a = lVar.a;
        this.b = lVar.b;
        this.d = lVar.d;
        this.e = lVar.e;
        this.f = lVar.f;
        this.g = lVar.g;
        this.h = lVar.h;
        this.i = lVar.i;
        this.k = lVar.k;
        this.l = lVar.l;
    }

    public final int a() {
        return this.a;
    }

    final void a(int i) {
        this.a = i;
    }

    public final String b() {
        return this.g;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final byte[] c() {
        return this.i;
    }

    public final void a(byte[] bArr) {
        this.i = bArr;
    }

    public final int d() {
        return this.c;
    }

    final void b(int i) {
        this.c = i;
    }

    public final void c(int i) {
        this.d = i;
        if (this.d == 2) {
            this.f = 0;
            this.b = -1;
            this.c = -1;
        }
    }

    public final boolean e() {
        return (this.f & 1) > 0;
    }

    public final boolean f() {
        return (this.f & 16) > 0;
    }

    public final boolean g() {
        return (this.f & 32) > 0;
    }

    public final int i() {
        return this.f;
    }

    public final void d(int i) {
        if (this.b != 0) {
            Object obj;
            if ((this.f & 8) > 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                this.f |= i;
            }
        }
    }

    public final boolean h() {
        return (this.f & LogType.UNEXP) > 0;
    }
}
