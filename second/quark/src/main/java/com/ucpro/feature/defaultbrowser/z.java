package com.ucpro.feature.defaultbrowser;

import android.content.Intent;

/* compiled from: ProGuard */
public abstract class z extends e<Boolean> {
    public z(j jVar, x xVar) {
        super(jVar, xVar);
    }

    public final void b() {
        this.a.c();
    }

    final /* synthetic */ Object a(int i, Object obj) {
        boolean z = false;
        switch (i) {
            case 2:
                z = this.a.a((Intent) obj);
                break;
            case 3:
                this.a.r_();
                break;
        }
        return Boolean.valueOf(z);
    }
}
