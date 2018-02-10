package com.ucpro.feature.webwindow.a;

import com.ucpro.feature.webwindow.bb;

/* compiled from: ProGuard */
public final class k implements b {
    final /* synthetic */ bb a;
    final /* synthetic */ g b;

    public k(g gVar, bb bbVar) {
        this.b = gVar;
        this.a = bbVar;
    }

    public final void a() {
        if (this.a.getAddressBar() != null) {
            this.a.getAddressBar().setUrlTextVisibility(0);
        }
    }
}
