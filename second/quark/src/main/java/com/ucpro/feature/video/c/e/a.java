package com.ucpro.feature.video.c.e;

import android.support.annotation.NonNull;
import com.uc.a.b.k;
import com.uc.base.b.c.c;
import com.ucpro.business.e.e.b;
import com.ucpro.business.stat.f;
import com.ucweb.common.util.d.e;
import com.ucweb.common.util.h;
import java.util.Locale;

/* compiled from: ProGuard */
public final class a {
    @NonNull
    public static com.ucpro.feature.video.c.e.b.a a(String str, String str2) {
        c cVar;
        c cVar2 = null;
        com.ucpro.feature.video.c.e.b.a aVar = new com.ucpro.feature.video.c.e.b.a();
        if (str == null) {
            cVar = null;
        } else {
            cVar = c.a(str);
        }
        aVar.a = cVar;
        if (str2 == null) {
            cVar = null;
        } else {
            cVar = c.a(str2);
        }
        aVar.b = cVar;
        k kVar = new k();
        kVar.a(b.b().d());
        kVar.b("android");
        kVar.c("2.4.1.985");
        kVar.d(com.ucpro.c.a.a());
        kVar.e("3300");
        kVar.f("180123054500");
        kVar.g("ucpro");
        kVar.h(Locale.getDefault().getLanguage());
        kVar.i("3.1");
        String b = com.ucpro.c.a.b();
        if (b != null) {
            cVar2 = c.a(b);
        }
        kVar.a = cVar2;
        aVar.c = kVar;
        com.uc.a.b.a aVar2 = new com.uc.a.b.a();
        aVar2.a(f.b());
        aVar2.b(com.ucpro.feature.h.b.a.c());
        aVar2.a = h.a.widthPixels;
        aVar2.b = h.a.heightPixels;
        aVar2.c(e.b());
        aVar.d = aVar2;
        aVar.e = 0;
        aVar.f = 1;
        return aVar;
    }
}
