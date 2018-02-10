package com.ucweb.login;

import android.app.Activity;
import com.ucweb.c.c.b;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class a {
    private static com.ucweb.login.a.a a;

    public static void a(Activity activity, b bVar) {
        com.ucweb.login.a.a aVar = null;
        b.a = null;
        b.a = new WeakReference(activity);
        switch (com.ucweb.c.c.a.b[bVar.ordinal()]) {
            case 1:
                aVar = new com.ucweb.login.qq.a();
                break;
            case 2:
                aVar = new com.ucweb.login.b.b();
                break;
            case 3:
                aVar = new com.ucweb.login.weibo.a(activity);
                break;
        }
        a = aVar;
        if (aVar != null) {
            a.a();
        }
    }
}
