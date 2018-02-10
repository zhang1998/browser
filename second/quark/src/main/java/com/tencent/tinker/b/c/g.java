package com.tencent.tinker.b.c;

import java.util.Enumeration;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class g implements Enumeration<f> {
    final /* synthetic */ Iterator a;
    final /* synthetic */ i b;

    public g(i iVar, Iterator it) {
        this.b = iVar;
        this.a = it;
    }

    public final boolean hasMoreElements() {
        this.b.a();
        return this.a.hasNext();
    }

    public final /* synthetic */ Object nextElement() {
        this.b.a();
        return (f) this.a.next();
    }
}
