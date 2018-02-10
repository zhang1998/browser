package com.bumptech.glide.b.c;

import com.bumptech.glide.b.m;
import com.bumptech.glide.g.b;
import java.io.File;

/* compiled from: ProGuard */
public final class ab<Data> implements aq<File, Data> {
    private final y<Data> a;

    public final /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        File file = (File) obj;
        return new ap(new b(file), new x(file, this.a));
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    public ab(y<Data> yVar) {
        this.a = yVar;
    }
}
