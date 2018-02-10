package com.e.b.b.b;

/* compiled from: ProGuard */
public final class d {
    public b a = null;
    public b b = null;

    public d(e eVar) {
        if (eVar.b() != null) {
            this.a = new b();
            this.a.b = eVar.b().b;
            this.a.a = eVar.b().a;
        } else {
            this.a = new b();
        }
        if (eVar.a() != null) {
            this.b = new b();
            this.b.b = eVar.a().b;
            this.b.a = eVar.a().a;
            return;
        }
        this.b = new b();
    }
}
