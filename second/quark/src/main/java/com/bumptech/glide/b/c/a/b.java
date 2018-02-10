package com.bumptech.glide.b.c.a;

import android.support.annotation.Nullable;
import com.bumptech.glide.b.a.n;
import com.bumptech.glide.b.c.ac;
import com.bumptech.glide.b.c.an;
import com.bumptech.glide.b.c.ao;
import com.bumptech.glide.b.c.ap;
import com.bumptech.glide.b.c.aq;
import com.bumptech.glide.b.l;
import com.bumptech.glide.b.m;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class b implements aq<ac, InputStream> {
    public static final l<Integer> a = l.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
    @Nullable
    private final ao<ac, ac> b;

    public final /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        obj = (ac) obj;
        if (this.b != null) {
            ac acVar = (ac) this.b.a(obj);
            if (acVar == null) {
                ao aoVar = this.b;
                aoVar.a.b(an.a(obj), obj);
            } else {
                ac acVar2 = acVar;
            }
        }
        return new ap(obj, new n(obj, ((Integer) mVar.a(a)).intValue()));
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    public b() {
        this(null);
    }

    public b(ao<ac, ac> aoVar) {
        this.b = aoVar;
    }
}
