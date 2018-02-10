package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.ucpro.services.c.d;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class l implements d {
    final /* synthetic */ q a;

    l(q qVar) {
        this.a = qVar;
    }

    public final void a(String str, Bitmap bitmap, Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (str != null && str.equals(sVar.getData().f)) {
                if (bitmap == null) {
                    sVar.h();
                    sVar.setFavIcon(this.a.j());
                    return;
                }
                sVar.g();
                sVar.setFavIcon(a.a(new BitmapDrawable(bitmap)));
            }
        }
    }
}
