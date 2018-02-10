package com.uc.quark;

import android.content.ContentValues;
import android.text.TextUtils;
import com.uc.apollo.android.GuideDialog;
import com.uc.quark.a.b;
import com.uc.quark.a.m;
import java.io.File;
import java.util.Map;

/* compiled from: ProGuard */
public final class z extends s {
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private long k;
    private boolean l;
    private boolean m;
    private boolean n;
    private String o;
    private String p;
    private long q;
    private int r;
    private boolean s = false;
    private boolean t = false;
    private Map<String, String> u;
    private int v;
    private long w = -1;
    private boolean x;
    private Throwable y;
    private String z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z(int r6, com.uc.quark.y r7, long r8) {
        /*
        r5 = this;
        r0 = 0;
        r5.<init>();
        r5.s = r0;
        r5.t = r0;
        r2 = -1;
        r5.w = r2;
        r5.e = r6;
        r1 = r7.a;
        r1 = r1.a;
        r5.f = r1;
        r1 = r5.f;
        r1 = com.uc.quark.a.j.a(r1);
        r5.x = r1;
        r2 = r5.f;
        r2 = com.uc.quark.a.j.b(r2);
        if (r1 == 0) goto L_0x002f;
    L_0x0024:
        r1 = r7.a;
        r1 = r1.c;
        r1 = android.text.TextUtils.equals(r2, r1);
        if (r1 != 0) goto L_0x002f;
    L_0x002e:
        r0 = 1;
    L_0x002f:
        if (r0 == 0) goto L_0x00b8;
    L_0x0031:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r7.a;
        r1 = r1.d;
        r0 = r0.append(r1);
        r1 = ".";
        r1 = r0.append(r1);
        r0 = r5.f;
        r2 = com.uc.quark.a.j.a(r0);
        if (r2 == 0) goto L_0x00b5;
    L_0x004c:
        r0 = com.uc.quark.a.j.b(r0);
        r0 = com.uc.quark.a.e.b(r0);
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x00b5;
    L_0x005a:
        r0 = r1.append(r0);
        r0 = r0.toString();
    L_0x0062:
        r5.h = r0;
        r0 = r7.a;
        r0 = r0.e;
        r5.g = r0;
        r0 = r7.a;
        r0 = r0.c;
        r5.i = r0;
        r0 = r7.a;
        r0 = r0.b;
        r5.j = r0;
        r5.k = r8;
        r0 = r7.a;
        r0 = r0.f;
        r5.l = r0;
        r0 = r7.a;
        r0 = r0.h;
        r5.m = r0;
        r0 = r7.a;
        r0 = r0.i;
        r5.n = r0;
        r0 = r7.a;
        r0 = r0.j;
        r5.o = r0;
        r0 = r7.a;
        r0 = r0.k;
        r5.p = r0;
        r0 = r7.a;
        r0 = r0.l;
        r5.s = r0;
        r0 = r7.a;
        r0 = r0.m;
        r5.t = r0;
        r0 = r7.a;
        r0 = r0.n;
        r5.u = r0;
        r0 = r7.a;
        r0 = r0.o;
        r5.v = r0;
        r0 = r7.a;
        r0 = r0.p;
        r5.w = r0;
        return;
    L_0x00b5:
        r0 = "bin";
        goto L_0x005a;
    L_0x00b8:
        r0 = r7.a;
        r0 = r0.d;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.z.<init>(int, com.uc.quark.y, long):void");
    }

    public final String toString() {
        return "id:" + this.e + " title:" + this.h + " mUrl:" + this.f + " path:" + this.g + " mimetype:" + this.i + " refurl:" + this.j;
    }

    public final int a() {
        return this.e;
    }

    public final String b() {
        return this.h;
    }

    public final String h() {
        return this.g;
    }

    public final String g() {
        return this.f;
    }

    public final String j() {
        return this.j;
    }

    public final String i() {
        return this.i;
    }

    public final long c() {
        if (this.x) {
            return new File(this.g).length();
        }
        x.a();
        return x.a(this.e);
    }

    public final int e() {
        if (this.x) {
            return -3;
        }
        x.a();
        return x.a(this.e, this.g);
    }

    public final long f() {
        return this.q;
    }

    public final void a(long j) {
        this.q = j;
    }

    public final long d() {
        if (this.x) {
            return new File(this.g).length();
        }
        x.a();
        return x.b(this.e);
    }

    public final void k() {
        if (this.x) {
            Object obj = this.f;
            Object obj2 = this.g;
            if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj2)) {
                m.a(0, new b(obj, obj2, this));
                return;
            }
            return;
        }
        x.a().a(this.e, this.s, this.b, this.z, this.a);
    }

    public final boolean l() {
        return this.l;
    }

    public final void a(boolean z) {
        this.l = z;
    }

    public final void m() {
        x.a().d(this.e);
    }

    public final boolean n() {
        return this.m;
    }

    public final boolean o() {
        return this.n;
    }

    public final String p() {
        return this.o;
    }

    public final String q() {
        return this.p;
    }

    public final void a(int i) {
        this.r = i;
    }

    public final int r() {
        return this.r;
    }

    public final boolean s() {
        return this.t;
    }

    public final void b(boolean z) {
        this.t = z;
    }

    public final boolean t() {
        return this.s;
    }

    public final void c(boolean z) {
        this.s = z;
    }

    public final Map<String, String> u() {
        return this.u;
    }

    public final int v() {
        return this.v;
    }

    public final long w() {
        return this.w;
    }

    public final Throwable x() {
        return this.y;
    }

    public final void a(Throwable th) {
        this.y = th;
    }

    public final String y() {
        return this.z;
    }

    public final void a(String str) {
        this.z = str;
    }

    public final ContentValues z() {
        int i;
        int i2 = 1;
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.e));
        contentValues.put(GuideDialog.TITLE, this.h);
        contentValues.put("url", this.f);
        contentValues.put("path", this.g);
        contentValues.put("mimetype", this.i);
        contentValues.put("refurl", this.j);
        contentValues.put("create_time", Long.valueOf(this.k));
        contentValues.put("flag_silent", Integer.valueOf(this.l ? 1 : 0));
        String str = "flag_is_video_cache";
        if (this.m) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str, Integer.valueOf(i));
        String str2 = "flag_is_verif_file";
        if (!this.n) {
            i2 = 0;
        }
        contentValues.put(str2, Integer.valueOf(i2));
        contentValues.put("verif_file_info", this.o);
        contentValues.put("post_body", this.p);
        return contentValues;
    }
}
