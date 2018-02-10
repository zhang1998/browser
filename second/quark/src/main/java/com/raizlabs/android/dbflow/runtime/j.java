package com.raizlabs.android.dbflow.runtime;

import android.annotation.TargetApi;
import android.database.ContentObserver;
import android.net.Uri;
import com.raizlabs.android.dbflow.a.b.b;
import com.raizlabs.android.dbflow.a.b.d;
import com.raizlabs.android.dbflow.a.b.h;
import com.raizlabs.android.dbflow.structure.e;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
public final class j extends ContentObserver {
    private static final AtomicInteger b = new AtomicInteger(0);
    private static boolean c = false;
    protected boolean a;
    private final Set<Object> d;
    private final Set<d> e;
    private final Map<String, Class<?>> f;
    private final Set<Uri> g;
    private final Set<Uri> h;
    private boolean i;

    public static boolean a() {
        return c || b.get() > 0;
    }

    public final void onChange(boolean z) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            it.next();
            e eVar = e.CHANGE;
        }
        it = this.e.iterator();
        while (it.hasNext()) {
            it.next();
            eVar = e.CHANGE;
        }
    }

    @TargetApi(16)
    public final void onChange(boolean z, Uri uri) {
        String fragment = uri.getFragment();
        String authority = uri.getAuthority();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        d[] dVarArr = new d[queryParameterNames.size()];
        if (!queryParameterNames.isEmpty()) {
            int i = 0;
            for (String str : queryParameterNames) {
                dVarArr[i] = b.a(new h(Uri.decode(str)).a()).a(Uri.decode(uri.getQueryParameter(str)));
                i++;
            }
        }
        Class cls = (Class) this.f.get(authority);
        e valueOf = e.valueOf(fragment);
        if (this.a) {
            if (!this.i) {
                valueOf = e.CHANGE;
                uri = com.raizlabs.android.dbflow.a.d.a(cls, valueOf);
            }
            synchronized (this.g) {
                this.g.add(uri);
            }
            synchronized (this.h) {
                this.h.add(com.raizlabs.android.dbflow.a.d.a(cls, valueOf));
            }
            return;
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            it.next();
        }
        it = this.e.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
