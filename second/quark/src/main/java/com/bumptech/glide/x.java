package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.c.p;
import com.ucpro.base.b.a;
import com.ucpro.base.b.d;
import java.util.Collections;
import java.util.Set;

/* compiled from: ProGuard */
final class x extends a {
    private final d a = new d();

    x() {
        Log.isLoggable("Glide", 3);
    }

    public final void a(Context context, d dVar) {
        this.a.a(context, dVar);
    }

    public final void a(Context context, c cVar, m mVar) {
        new a().a(context, cVar, mVar);
        this.a.a(context, cVar, mVar);
    }

    public final Set<Class<?>> a() {
        return Collections.emptySet();
    }

    public final boolean c() {
        return false;
    }

    final /* synthetic */ p b() {
        return new w();
    }
}
