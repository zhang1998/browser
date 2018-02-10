package com.uc.a.d;

import android.os.Handler;
import com.uc.a.e.a;
import com.uc.a.e.b;
import java.io.File;

/* compiled from: ProGuard */
public final class s extends h {
    private static Handler b = new Handler();
    private a c;
    private b d = new aj(this);

    public s(a aVar) {
        this.c = aVar;
    }

    public final a a() {
        return new o(this.c.d, this.c.e, this.c.f);
    }

    public final String a(String str) {
        return this.c.g + File.separator + str;
    }

    public final String b() {
        return this.c.g;
    }

    public final void a(Runnable runnable) {
        b.post(runnable);
    }
}
