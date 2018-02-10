package kotlin.jvm.a;

import kotlin.SinceKotlin;
import kotlin.d.d;

/* compiled from: ProGuard */
public class c extends g implements d, d {
    private final int c = 0;

    @SinceKotlin(version = "1.1")
    public c(Object obj) {
        super(obj);
    }

    @SinceKotlin(version = "1.1")
    protected final kotlin.d.c b() {
        return h.a(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r5 != r4) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r5 instanceof kotlin.jvm.a.c;
        if (r2 == 0) goto L_0x004e;
    L_0x0009:
        r5 = (kotlin.jvm.a.c) r5;
        r2 = r4.d();
        if (r2 != 0) goto L_0x003f;
    L_0x0011:
        r2 = r5.d();
        if (r2 != 0) goto L_0x003d;
    L_0x0017:
        r2 = r4.e();
        r3 = r5.e();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x003d;
    L_0x0025:
        r2 = r4.f();
        r3 = r5.f();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x003d;
    L_0x0033:
        r2 = r4.a;
        r3 = r5.a;
        r2 = kotlin.jvm.a.f.a(r2, r3);
        if (r2 != 0) goto L_0x0004;
    L_0x003d:
        r0 = r1;
        goto L_0x0004;
    L_0x003f:
        r2 = r4.d();
        r3 = r5.d();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x003d;
    L_0x004d:
        goto L_0x0017;
    L_0x004e:
        r0 = r5 instanceof kotlin.d.d;
        if (r0 == 0) goto L_0x005b;
    L_0x0052:
        r0 = r4.c();
        r0 = r5.equals(r0);
        goto L_0x0004;
    L_0x005b:
        r0 = r1;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.a.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return (((d() == null ? 0 : d().hashCode() * 31) + e().hashCode()) * 31) + f().hashCode();
    }

    public String toString() {
        c c = c();
        if (c != this) {
            return c.toString();
        }
        return "<init>".equals(e()) ? "constructor (Kotlin reflection is not available)" : "function " + e() + " (Kotlin reflection is not available)";
    }
}
