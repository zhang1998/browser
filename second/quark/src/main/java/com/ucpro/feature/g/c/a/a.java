package com.ucpro.feature.g.c.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.ucpro.feature.g.a.c;
import com.ucpro.feature.g.c.b.g;

/* compiled from: ProGuard */
public final class a<T> {
    public T a;
    public String b;
    public StateListDrawable c;

    public a(T t, String str) {
        this.a = t;
        this.b = str;
        if (com.ucweb.common.util.n.a.b(null)) {
            Drawable gVar = new g();
            gVar.setColor(com.ucpro.ui.c.a.c(str));
            Drawable gVar2 = new g();
            gVar2.setColor(com.ucpro.ui.c.a.c(null));
            this.c = c.a(gVar, gVar2);
        }
    }
}
