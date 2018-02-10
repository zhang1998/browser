package com.ucpro.feature.downloadpage.e.c;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.uc.quark.s;
import com.ucpro.feature.downloadpage.e.c.a.b;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.l.d;

/* compiled from: ProGuard */
final class g implements b {
    final /* synthetic */ n a;

    g(n nVar) {
        this.a = nVar;
    }

    public final void a(String str, Drawable drawable, Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            try {
                s sVar = (s) this.a.c.get(tVar.getPosition());
                if (sVar == null) {
                    tVar.setImageIcon(com.ucpro.feature.downloadpage.e.b.b.a(""));
                } else if (str != null && str.equals(sVar.h())) {
                    if (drawable == null) {
                        if (com.ucpro.c.b.b()) {
                            Log.e("vanda", "position:" + tVar.getPosition() + "mimeType:" + sVar.i() + "      extension:" + d.b(sVar.i()));
                        }
                        tVar.setImageIcon(com.ucpro.feature.downloadpage.e.b.b.a(d.b(sVar.i())));
                        return;
                    }
                    tVar.setImageIcon(a.a(drawable));
                }
            } catch (IndexOutOfBoundsException e) {
                tVar.setImageIcon(com.ucpro.feature.downloadpage.e.b.b.a(""));
            }
        }
    }
}
