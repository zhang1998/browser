package com.bumptech.glide.b.c;

import com.bumptech.glide.b.a.c;
import com.bumptech.glide.b.i;
import com.bumptech.glide.util.j;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public final class ap<Data> {
    public final i a;
    public final List<i> b;
    public final c<Data> c;

    public ap(i iVar, c<Data> cVar) {
        this(iVar, Collections.emptyList(), cVar);
    }

    private ap(i iVar, List<i> list, c<Data> cVar) {
        this.a = (i) j.a((Object) iVar, "Argument must not be null");
        this.b = (List) j.a((Object) list, "Argument must not be null");
        this.c = (c) j.a((Object) cVar, "Argument must not be null");
    }
}
