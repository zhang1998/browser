package com.ucpro.feature.inputenhance.b;

import com.ucpro.feature.inputenhance.s;

/* compiled from: ProGuard */
public final class c extends e {
    public c(s sVar) {
        super(sVar);
    }

    public final void a(int i) {
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        this.o.setVisibility(8);
        this.n.setVisibility(0);
        if (i == 0) {
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        } else if (i == 1) {
            this.l.setVisibility(0);
            this.k.setVisibility(8);
        }
        this.m.setVisibility(0);
        if (i == 0) {
            this.f.setVisibility(0);
            this.g.setVisibility(8);
            this.h.setSlideViewEnabled(false);
        } else if (i == 1) {
            this.f.setVisibility(8);
            this.g.setVisibility(0);
            this.h.setSlideViewEnabled(true);
        }
    }
}
