package com.ucpro.feature.c.d;

import android.text.TextUtils;
import android.util.Log;
import com.quark.browser.R;
import com.ucpro.feature.c.a.b;
import com.ucpro.feature.c.a.c;
import com.ucpro.services.f.g;
import com.ucpro.ui.c.a;
import java.io.File;
import okhttp3.Request.Builder;

/* compiled from: ProGuard */
public final class e {
    public static void a(String str, i iVar) {
        com.ucpro.ui.b.e.a().a(a.d((int) R.string.search_image_ing), 1);
        if (TextUtils.isEmpty(str)) {
            iVar.a("pic path empty.");
            return;
        }
        File file = new File(str);
        if (str.length() == 0) {
            iVar.a("pic length is zero.");
            return;
        }
        b a = c.a(str, com.ucpro.c.c.b("tmp").getAbsolutePath() + File.separator + com.ucpro.b.b.b.c(file.getName()));
        if (a == null) {
            iVar.a("pic compressing error.");
        } else if (TextUtils.isEmpty(a.a)) {
            iVar.a("compressed pic path empty.");
        } else {
            if (com.ucpro.c.b.b()) {
                Log.e("hjw-pic", "localPictureFile size=" + file.length());
            }
            Object c = com.ucpro.b.b.b.c(a.a);
            if (TextUtils.isEmpty(c)) {
                iVar.a("uploadable pic name empty.");
                return;
            }
            com.ucpro.feature.c.b.a dVar = new d(a, new f(c, iVar, a));
            if (new File(a.a).exists()) {
                String a2 = com.ucpro.feature.c.c.a.a(com.ucpro.b.b.b.c(a.a));
                com.ucpro.c.b.b();
                g.a().newCall(new Builder().url(a2).get().build()).enqueue(new c(dVar));
                return;
            }
            dVar.a("file not exists");
        }
    }
}
