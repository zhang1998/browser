package com.ucweb.c;

import android.app.Activity;
import com.ucweb.c.b.b;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class a {
    public static final Boolean a = Boolean.valueOf(false);
    private static com.ucweb.c.a.a b;

    public static void a(Activity activity, b bVar, com.ucweb.c.a.b bVar2) {
        com.ucweb.c.a.a aVar = null;
        com.ucweb.c.c.b.a = null;
        com.ucweb.c.c.b.a = new WeakReference(activity);
        switch (com.ucweb.c.c.a.a[bVar2.ordinal()]) {
            case 1:
                aVar = new com.ucweb.c.c.b.a.b(com.ucweb.c.c.b.a.a.a);
                break;
            case 2:
                aVar = new com.ucweb.c.c.b.a.b(com.ucweb.c.c.b.a.a.b);
                break;
            case 3:
                aVar = new com.ucweb.c.c.c.a(true);
                break;
            case 4:
                aVar = new com.ucweb.c.c.c.a(false);
                break;
            case 5:
                aVar = new com.ucweb.c.c.d.a();
                break;
            case 6:
                aVar = new com.ucweb.c.c.a.a();
                break;
        }
        b = aVar;
        if (aVar != null) {
            b.a(bVar);
        }
    }
}
