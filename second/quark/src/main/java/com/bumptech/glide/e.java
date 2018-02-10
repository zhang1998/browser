package com.bumptech.glide;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.b.b.af;
import com.bumptech.glide.f.g;

@TargetApi(14)
/* compiled from: ProGuard */
public final class e extends ContextWrapper implements ComponentCallbacks2 {
    public final Handler a = new Handler(Looper.getMainLooper());
    public final m b;
    final g c;
    final af d;
    public final int e;
    private final com.bumptech.glide.f.a.e f;
    private final ComponentCallbacks2 g;

    public e(Context context, m mVar, com.bumptech.glide.f.a.e eVar, g gVar, af afVar, ComponentCallbacks2 componentCallbacks2, int i) {
        super(context.getApplicationContext());
        this.b = mVar;
        this.f = eVar;
        this.c = gVar;
        this.d = afVar;
        this.g = componentCallbacks2;
        this.e = i;
    }

    public final void onTrimMemory(int i) {
        this.g.onTrimMemory(i);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        this.g.onConfigurationChanged(configuration);
    }

    public final void onLowMemory() {
        this.g.onLowMemory();
    }
}
