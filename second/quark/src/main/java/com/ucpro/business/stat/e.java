package com.ucpro.business.stat;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.a.a.a.ej;
import com.a.a.a.fj;
import com.a.a.a.fw;
import com.a.a.b;
import com.a.a.i;
import com.ucpro.c.c;
import com.ucweb.common.util.d;
import java.io.File;

/* compiled from: ProGuard */
public final class e implements Runnable {
    public final void run() {
        k.b().edit().putString("state", n.FG.toString()).apply();
        File file = new File(c.a(), "crash_flag");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                Log.e("CrashHelper", "create file fail ", e);
            }
        }
        Context a = d.a();
        if (a == null) {
            fw.d("unexpected null context in onResume");
            return;
        }
        com.a.a.e a2 = com.a.a.c.a;
        if (a == null) {
            try {
                fw.d("unexpected null context in onResume");
                return;
            } catch (Throwable e2) {
                fw.a("Exception occurred in Mobclick.onResume(). ", e2);
                return;
            }
        }
        if (b.e && a2.b != null) {
            ej ejVar = a2.b;
            CharSequence name = a.getClass().getName();
            if (!TextUtils.isEmpty(name)) {
                synchronized (ejVar.a) {
                    ejVar.a.put(name, Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
        if (!(a2.e && a2.f)) {
            a2.a(a);
        }
        fj.a(new i(a2, a));
    }
}
