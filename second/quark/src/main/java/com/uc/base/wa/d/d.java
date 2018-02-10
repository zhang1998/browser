package com.uc.base.wa.d;

import com.uc.base.wa.component.e;

/* compiled from: ProGuard */
final class d implements g {
    final /* synthetic */ byte[] a;
    final /* synthetic */ k b;

    d(k kVar, byte[] bArr) {
        this.b = kVar;
        this.a = bArr;
    }

    public final void a(int i) {
        if (this.b.a == null) {
            return;
        }
        if (this.b.b == null) {
            if (i == 0) {
                e.a.a("1114AA5B512B55CECADDF881C655BFA4", this.b.g);
            }
            this.b.a.a(i, this.b.j, this.b.f, null);
            return;
        }
        throw new Error("param invalid");
    }

    public final String a() {
        this.b.a(k.a());
        this.b.a(this.a);
        return String.valueOf(System.currentTimeMillis());
    }
}
