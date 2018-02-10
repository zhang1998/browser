package com.bumptech.glide.b.c;

import android.net.Uri;
import com.bumptech.glide.b.m;
import com.bumptech.glide.g.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ProGuard */
public final class bo<Data> implements aq<Uri, Data> {
    private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));
    private final bm<Data> b;

    public final /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        Uri uri = (Uri) obj;
        return new ap(new b(uri), this.b.a(uri));
    }

    public final /* synthetic */ boolean a(Object obj) {
        return a.contains(((Uri) obj).getScheme());
    }

    public bo(bm<Data> bmVar) {
        this.b = bmVar;
    }
}
