package com.bumptech.glide.b.b;

import com.bumptech.glide.b.b.b.b;
import com.bumptech.glide.b.m;
import java.io.File;

/* compiled from: ProGuard */
final class c<DataType> implements b {
    private final com.bumptech.glide.b.c<DataType> a;
    private final DataType b;
    private final m c;

    c(com.bumptech.glide.b.c<DataType> cVar, DataType dataType, m mVar) {
        this.a = cVar;
        this.b = dataType;
        this.c = mVar;
    }

    public final boolean a(File file) {
        return this.a.a(this.b, file, this.c);
    }
}
