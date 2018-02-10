package com.ucpro.feature.webwindow;

import android.webkit.ValueCallback;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
public final class r implements l {
    final /* synthetic */ bo a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ ba c;

    public r(ba baVar, bo boVar, ValueCallback valueCallback) {
        this.c = baVar;
        this.a = boVar;
        this.b = valueCallback;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (u.c != i || this.a == null) {
            if (!(u.d != i || this.a == null || this.b == null)) {
                this.b.onReceiveValue(Boolean.valueOf(false));
            }
        } else if (this.b != null) {
            this.b.onReceiveValue(Boolean.valueOf(true));
        }
        return false;
    }
}
