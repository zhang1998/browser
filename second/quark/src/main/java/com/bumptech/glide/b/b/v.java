package com.bumptech.glide.b.b;

import com.bumptech.glide.b.a;
import com.bumptech.glide.b.d;

/* compiled from: ProGuard */
final class v extends w {
    v() {
    }

    public final boolean a(a aVar) {
        return aVar == a.REMOTE;
    }

    public final boolean a(boolean z, a aVar, d dVar) {
        return ((z && aVar == a.DATA_DISK_CACHE) || aVar == a.LOCAL) && dVar == d.TRANSFORMED;
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return true;
    }
}
