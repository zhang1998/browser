package com.a.a.a;

/* compiled from: ProGuard */
public final class b {
    private final t a;
    private final i b;

    public b() {
        this(new v());
    }

    public b(x xVar) {
        this.b = new i();
        this.a = xVar.a(this.b);
    }

    public final void a(c cVar, byte[] bArr) throws g {
        try {
            i iVar = this.b;
            int length = bArr.length;
            iVar.a = bArr;
            iVar.b = 0;
            iVar.c = length + 0;
            cVar.a(this.a);
        } finally {
            this.b.a = null;
            this.a.s();
        }
    }
}
