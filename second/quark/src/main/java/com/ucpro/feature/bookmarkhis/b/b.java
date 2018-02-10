package com.ucpro.feature.bookmarkhis.b;

import com.ucpro.ui.widget.ad;

/* compiled from: ProGuard */
public enum b implements ad {
    DEFAULT(1),
    CHECK_NORMAL(2),
    CHECK_SELECT(3),
    STATUS_NORMAL(4);
    
    int e;

    private b(int i) {
        this.e = i;
    }

    public final int a() {
        return this.e;
    }
}
