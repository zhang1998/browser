package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;

/* compiled from: ProGuard */
public final class al extends e {
    public static final f a = new ba();
    private static final aw g;
    private final String b;
    private final CharSequence c;
    private final CharSequence[] d;
    private final boolean e;
    private final Bundle f;

    public final String a() {
        return this.b;
    }

    public final CharSequence b() {
        return this.c;
    }

    public final CharSequence[] c() {
        return this.d;
    }

    public final boolean d() {
        return this.e;
    }

    public final Bundle e() {
        return this.f;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            g = new by();
        } else if (VERSION.SDK_INT >= 16) {
            g = new au();
        } else {
            g = new as();
        }
    }
}
