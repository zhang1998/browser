package com.ucpro.feature.g.h;

import com.uc.encrypt.f;
import com.ucpro.business.e.e.b;
import com.ucpro.business.stat.m;
import com.ucpro.feature.f.e;
import com.ucpro.feature.f.n;

/* compiled from: ProGuard */
public final class a implements com.uc.sync.c.c.a {
    public final String a() {
        return b.b().d();
    }

    public final String b() {
        return b.b().a("CLOUD_SYNC_SERVER_ADDR_KEY", "http://browser.cloud.uc.cn/sync");
    }

    public final boolean e() {
        return com.ucpro.feature.g.a.c;
    }

    public final boolean f() {
        return com.ucpro.feature.g.a.d;
    }

    public final byte g() {
        if (com.ucpro.feature.g.a.c || com.ucpro.feature.g.a.b) {
            return (byte) 1;
        }
        return (byte) 2;
    }

    public final byte[] a(byte[] bArr) {
        if (com.ucpro.feature.g.a.c || com.ucpro.feature.g.a.b) {
            return f.a(bArr, com.uc.encrypt.a.b);
        }
        return f.a(bArr);
    }

    public final byte[] b(byte[] bArr) {
        if (com.ucpro.feature.g.a.c || com.ucpro.feature.g.a.b) {
            return f.b(bArr, com.uc.encrypt.a.b);
        }
        return f.b(bArr);
    }

    public final void a(String str, String str2, String... strArr) {
        m.a(str, str2, strArr);
    }

    public final String c() {
        n.a;
        return e.d();
    }

    public final boolean d() {
        return com.ucpro.feature.setting.b.c.b.a.c();
    }
}
