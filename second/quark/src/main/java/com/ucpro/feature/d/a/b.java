package com.ucpro.feature.d.a;

import android.graphics.Bitmap;
import com.ucpro.c.c;
import com.ucweb.common.util.h.m;
import java.io.File;

/* compiled from: ProGuard */
public final class b {
    public static String a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        String a = a();
        if (a != null) {
            String name = new File(a).getName();
            String g = c.g();
            if (a.startsWith(g)) {
                m.a(1, new d(name, g));
            }
        }
        m.a(1, new a(a, bitmap));
        return a;
    }

    public static String a() {
        String g = c.g();
        return g + File.separator + ("TMPSNAPSHOT" + System.currentTimeMillis() + ".png");
    }
}
