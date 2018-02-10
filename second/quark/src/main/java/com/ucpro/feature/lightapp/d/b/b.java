package com.ucpro.feature.lightapp.d.b;

import android.content.Context;
import android.text.TextUtils;
import com.ucpro.business.e.d.e;
import com.ucpro.business.e.d.j;
import com.ucpro.c.c;
import java.io.File;

/* compiled from: ProGuard */
public final class b implements e {
    private static Object b = new Object();
    public h a;
    private Context c;

    public b(Context context) {
        this.c = context;
    }

    private static String d() {
        return c.a("light_app") + File.separator + "dXNlcnRva2V1";
    }

    public final void a(j jVar, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Object obj = -1;
            switch (str.hashCode()) {
                case 358774030:
                    if (str.equals("usertoken")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    if (!TextUtils.isEmpty(str2)) {
                        this.a.b = str2;
                        a.a(this.a, d());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
