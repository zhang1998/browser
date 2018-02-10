package com.ucpro.feature.defaultbrowser;

/* compiled from: ProGuard */
public abstract class w implements x {
    protected j a;
    protected e b;
    protected e c;
    protected e d;

    public w(j jVar) {
        this.a = jVar;
    }

    public e b() {
        if (this.c == null) {
            this.c = new s(this.a, this);
        }
        return this.c;
    }

    public final e c() {
        if (this.b == null) {
            this.b = new l(this.a, this);
        }
        return this.b;
    }
}
