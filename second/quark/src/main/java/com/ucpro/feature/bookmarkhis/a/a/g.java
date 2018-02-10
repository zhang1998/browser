package com.ucpro.feature.bookmarkhis.a.a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ProGuard */
public final class g {
    private List<f> a = new LinkedList();

    public final List<f> a() {
        if (this.a == null) {
            this.a = new LinkedList();
        }
        return Collections.synchronizedList(this.a);
    }
}
