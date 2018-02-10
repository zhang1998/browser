package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

/* compiled from: ProGuard */
public final class bf extends b {
    public static final g d = new co();
    public int a;
    public CharSequence b;
    public PendingIntent c;
    private final Bundle e;
    private final al[] f;

    public bf(CharSequence charSequence, PendingIntent pendingIntent) {
        this(charSequence, pendingIntent, new Bundle());
    }

    private bf(CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        this.a = 0;
        this.b = cq.d(charSequence);
        this.c = pendingIntent;
        this.e = bundle;
        this.f = null;
    }

    public final int a() {
        return this.a;
    }

    public final CharSequence b() {
        return this.b;
    }

    public final PendingIntent c() {
        return this.c;
    }

    public final Bundle d() {
        return this.e;
    }

    public final /* bridge */ /* synthetic */ e[] e() {
        return this.f;
    }
}
