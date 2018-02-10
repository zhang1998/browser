package com.uc.quark.filedownloader.message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: ProGuard */
public final class f {
    final List<Integer> a = new ArrayList();
    final /* synthetic */ j b;
    private final Executor c;

    public f(j jVar, int i) {
        this.b = jVar;
        this.c = com.uc.quark.filedownloader.e.f.a(1, "Flow-" + i);
    }

    public final void a(MessageSnapshot messageSnapshot) {
        this.c.execute(new a(this, messageSnapshot));
    }
}
