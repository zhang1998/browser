package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.text.TextUtils;
import com.uc.crashsdk.export.LogType;
import com.uc.sync.f.l;
import com.uc.sync.g.a;
import com.ucpro.feature.z.f.b.g;
import com.ucpro.feature.z.f.b.n;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public class m extends n {
    public long b;
    public String c;
    public long d;
    public String e;
    public String f;
    public String g;
    public int h;
    public int i;
    public int j;
    public long k;
    public long l;
    public long m;
    public String n;
    public String o;
    public int p = -1;
    public int q = 0;
    public int r;
    public String s;
    public int t;
    public int u;
    public String v;
    public boolean w;

    public final boolean g() {
        return this.j == 1;
    }

    public final boolean h() {
        return this.j == 0;
    }

    public final boolean i() {
        return this.m > 0;
    }

    public final void a(m mVar) {
        int i;
        int i2;
        int i3;
        int i4;
        this.q = 0;
        if (this.p != 0) {
            this.p = 3;
        }
        int i5 = !this.e.equals(mVar.e) ? 1 : 0;
        if (this.f.equals(mVar.f)) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.d != mVar.d) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.g.equals(mVar.g)) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (this.m != mVar.m) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (i5 != 0) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (i != 0) {
            i5 |= 2;
        }
        if (i2 != 0) {
            i5 |= 128;
        }
        if (i3 != 0) {
            i5 |= 4;
        }
        if (i4 != 0) {
            i5 |= LogType.UNEXP;
        }
        this.r = i5 | this.r;
    }

    public String toString() {
        return "luid:" + this.b + ",guid:" + this.c + ",parentId:" + this.d + ",folder:" + this.j + ",property:" + this.i + ",optState:,pined:" + i() + this.p + ",syncState:" + this.q + ",title:" + this.e + ",url:" + this.f;
    }

    public final m j() {
        m mVar = new m();
        mVar.b = this.b;
        mVar.c = this.c;
        mVar.d = this.d;
        mVar.e = this.e;
        mVar.f = this.f;
        mVar.i = this.i;
        mVar.j = this.j;
        mVar.l = this.l;
        mVar.k = this.l;
        mVar.t = this.t;
        mVar.u = this.u;
        mVar.v = this.v;
        mVar.s = this.s;
        mVar.p = this.p;
        mVar.q = this.q;
        mVar.r = this.r;
        mVar.g = this.g;
        mVar.n = this.n;
        mVar.o = this.o;
        mVar.h = this.h;
        mVar.w = this.w;
        mVar.m = this.m;
        return mVar;
    }

    public final x k() {
        l xVar = new x();
        xVar.j = this.b;
        xVar.e = this.c;
        xVar.n = this.e;
        xVar.o = this.f;
        xVar.r = this.h;
        xVar.s = this.d;
        xVar.c(this.q);
        xVar.b = this.p;
        xVar.q = this.l;
        xVar.p = this.j;
        xVar.m = this.g;
        xVar.l = this.n;
        xVar.k = this.o;
        xVar.t = this.i;
        xVar.d(this.r);
        xVar.a(this.s);
        xVar.u = this.m;
        return xVar;
    }

    public final int b() {
        return (int) this.b;
    }

    public final String a() {
        return this.f;
    }

    public final String c() {
        return this.e;
    }

    public final g d() {
        return g.SOURCE_TYPE_BOOKMARK;
    }

    public final int e() {
        return 0;
    }

    public final long f() {
        return this.l;
    }

    public static m a(String str, String str2) {
        c.a((CharSequence) str);
        c.a((CharSequence) str2);
        m mVar = new m();
        mVar.e = str;
        mVar.f = str2;
        mVar.l = System.currentTimeMillis() * 1000;
        mVar.n = "phone";
        mVar.o = "android";
        mVar.j = 0;
        mVar.i = 1;
        mVar.q = 0;
        mVar.p = 0;
        return mVar;
    }

    public static m a(String str) {
        c.a((CharSequence) str);
        m mVar = new m();
        mVar.e = str;
        mVar.f = str;
        mVar.j = 1;
        mVar.l = System.currentTimeMillis() * 1000;
        mVar.n = "phone";
        mVar.o = "android";
        mVar.i = 1;
        mVar.q = 0;
        mVar.p = 0;
        return mVar;
    }

    public static m a(x xVar) {
        m mVar = new m();
        mVar.b = (long) ((int) xVar.j);
        mVar.c = xVar.e;
        mVar.e = xVar.n;
        mVar.f = xVar.o;
        mVar.o = xVar.k;
        mVar.n = xVar.l;
        mVar.q = xVar.d;
        mVar.p = xVar.b;
        mVar.i = xVar.t;
        mVar.g = xVar.m;
        mVar.j = xVar.p;
        mVar.l = xVar.q;
        mVar.r = xVar.i();
        mVar.h = xVar.r;
        if (mVar.h < 0) {
            mVar.h = Integer.MAX_VALUE;
        }
        mVar.d = xVar.s;
        String b = xVar.b();
        if (TextUtils.isEmpty(b)) {
            b = a(xVar.o, xVar.m, xVar.p, xVar.l);
        }
        mVar.s = b;
        mVar.m = xVar.u;
        return mVar;
    }

    public static String a(String str, String str2, int i, String str3) {
        try {
            String substring = str3.equals("pad") ? str2.substring((a.a + "`pad`").length()) : str3.equals("pc") ? str2.substring((a.a + "`pc`").length()) : str2;
            if (TextUtils.isEmpty(str2)) {
                substring = "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append("^");
            stringBuffer.append(str3);
            stringBuffer.append("^");
            stringBuffer.append(substring);
            stringBuffer.append("^");
            stringBuffer.append(i);
            return com.ucweb.common.util.e.a.e(stringBuffer.toString().getBytes("UTF-8")).toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }
}
