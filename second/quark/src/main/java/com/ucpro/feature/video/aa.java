package com.ucpro.feature.video;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class aa<E> {
    List<WeakReference<E>> a;
    ReferenceQueue<Object> b;

    public aa() {
        this.a = null;
        this.b = new ReferenceQueue();
        this.a = new ArrayList();
    }
}
