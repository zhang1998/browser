package com.bumptech.glide.b.c;

import android.net.Uri;
import com.bumptech.glide.b.m;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ProGuard */
public final class bq<Data> implements aq<Uri, Data> {
    private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    private final aq<ac, Data> b;

    public final /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        return this.b.a(new ac(((Uri) obj).toString()), i, i2, mVar);
    }

    public final /* synthetic */ boolean a(Object obj) {
        return a.contains(((Uri) obj).getScheme());
    }

    public bq(aq<ac, Data> aqVar) {
        this.b = aqVar;
    }
}
