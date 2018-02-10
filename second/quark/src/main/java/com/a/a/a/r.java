package com.a.a.a;

/* compiled from: ProGuard */
public final class r implements x {
    protected boolean a;
    protected boolean b;
    protected int c;

    public r() {
        this((byte) 0);
    }

    private r(byte b) {
        this('\u0000');
    }

    private r(char c) {
        this.a = false;
        this.b = true;
        this.a = false;
        this.b = true;
        this.c = 0;
    }

    public final t a(k kVar) {
        t uVar = new u(kVar, this.a, this.b);
        if (this.c != 0) {
            uVar.a(this.c);
        }
        return uVar;
    }
}
