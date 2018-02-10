package com.taobao.weex.utils.a;

import java.util.ArrayList;

/* compiled from: ProGuard */
public final class c implements d {
    public a a;
    ArrayList<Runnable> b = new ArrayList();
    public boolean c = false;

    public c(a aVar) {
        this.a = aVar;
        aVar.a((d) this);
        this.c = true;
    }

    public final boolean a(Runnable runnable) {
        if (!this.c) {
            return false;
        }
        this.b.add(runnable);
        return true;
    }
}
