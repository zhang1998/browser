package com.ucpro.business.stat;

import com.uc.apollo.impl.SettingsConst;
import com.ucpro.b.d.a;
import java.io.File;

/* compiled from: ProGuard */
public final class c implements Runnable {
    public final void run() {
        n a = k.a();
        if (a != n.NIL) {
            String str = a.a;
            String str2 = "crash";
            String[] strArr = new String[4];
            strArr[0] = "type";
            strArr[1] = a.d;
            strArr[2] = "first_run";
            strArr[3] = a.c() ? SettingsConst.TRUE : SettingsConst.FALSE;
            m.a(str, str2, strArr);
            k.b().edit().putString("state", n.NIL.toString()).apply();
        }
        if (new File(com.ucpro.c.c.a(), "crash_flag").exists()) {
            str = "crash";
            str2 = "crash_f";
            strArr = new String[4];
            strArr[0] = "type";
            strArr[1] = "fg";
            strArr[2] = "first_run";
            strArr[3] = a.c() ? SettingsConst.TRUE : SettingsConst.FALSE;
            m.a(str, str2, strArr);
        }
    }
}
