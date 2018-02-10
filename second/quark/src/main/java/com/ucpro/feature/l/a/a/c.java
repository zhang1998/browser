package com.ucpro.feature.l.a.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import com.ucpro.c.b;
import com.ucpro.services.c.d;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class c implements d {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void a(String str, Bitmap bitmap, Object obj) {
        if (b.b()) {
            Log.e("vanda", "bitmap = " + bitmap + "   bindingObject instanceof ViewHolder = " + (obj instanceof b));
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bitmap == null) {
                bVar.n.setVisibility(0);
                bVar.o.setVisibility(4);
                bVar.n.setImageDrawable(this.a.d);
                return;
            }
            bVar.n.setVisibility(4);
            bVar.o.setVisibility(0);
            bVar.o.setImageDrawable(a.a(new BitmapDrawable(bitmap)));
        }
    }
}
