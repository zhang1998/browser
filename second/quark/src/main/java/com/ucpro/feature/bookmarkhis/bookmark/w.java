package com.ucpro.feature.bookmarkhis.bookmark;

import com.ucpro.ui.widget.ad;

/* compiled from: ProGuard */
public enum w implements ad {
    DEFAULT(1),
    CHECK_NORMAL(2),
    CHECK_SELECT(3),
    STATUS_NORMAL(4);
    
    int e;

    private w(int i) {
        this.e = i;
    }

    public final int a() {
        return this.e;
    }
}
