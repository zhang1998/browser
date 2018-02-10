package com.ucpro.b.d;

import android.text.TextUtils;
import android.util.Log;
import com.ucpro.c.b;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class a {
    public static boolean a() {
        String a = com.ucweb.common.util.g.a.a();
        if (TextUtils.isEmpty(a)) {
            Log.e("hjw-version", "sign hash is empty");
            return false;
        } else if (com.ucweb.common.util.n.a.d("-1587262134", a)) {
            b.b();
            return true;
        } else if (com.ucweb.common.util.n.a.d("-1774043784", a)) {
            b.b();
            return false;
        } else {
            Log.e("hjw-version", "sign is wrong");
            return false;
        }
    }

    public static boolean b() {
        return com.ucpro.b.d.a.b.a().b();
    }

    public static boolean c() {
        return com.ucpro.b.d.a.b.a().k != 0;
    }

    public static boolean d() {
        return d.a().getPackageName().endsWith("love");
    }
}
