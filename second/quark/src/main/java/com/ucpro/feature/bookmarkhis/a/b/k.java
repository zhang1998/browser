package com.ucpro.feature.bookmarkhis.a.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.ucpro.services.c.d;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class k implements d {
    final /* synthetic */ l a;

    k(l lVar) {
        this.a = lVar;
    }

    public final void a(String str, Bitmap bitmap, Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (str != null && str.equals(cVar.getUrl())) {
                if (bitmap == null) {
                    cVar.b();
                    cVar.setIcon(this.a.a());
                    return;
                }
                cVar.a();
                cVar.setIcon(a.a(new BitmapDrawable(bitmap)));
            }
        }
    }
}
