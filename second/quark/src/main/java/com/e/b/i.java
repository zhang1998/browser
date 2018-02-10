package com.e.b;

import android.app.Application;
import android.os.HandlerThread;
import android.os.Message;
import com.alibaba.analytics.a.af;
import com.e.b.d.a;
import com.e.b.d.b;
import com.e.b.d.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class i {
    private static i c;
    public Application a;
    private Map<String, l> b = new HashMap();

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (c == null) {
                c = new i();
            }
            iVar = c;
        }
        return iVar;
    }

    private i() {
    }

    public static void a(Map<String, String> map) {
        af.b();
        e a = e.a();
        af.b();
        if (!a.a) {
            synchronized (a.c) {
                if (!a.a) {
                    a.b = new b();
                    a.b.c = a;
                    b bVar = a.b;
                    bVar.a = new HandlerThread("UT-INVOKE-ASYNC");
                    bVar.a.start();
                    bVar.b = new a(bVar, bVar.a.getLooper());
                    a.a = true;
                }
            }
        }
        if (map.containsKey("_sls")) {
            a.b(map);
        } else if (a.b != null) {
            b bVar2 = a.b;
            if (bVar2.b != null) {
                if (map != null && map.containsKey("_sls")) {
                    map.remove("_sls");
                    if (bVar2.c != null) {
                        bVar2.c.a(map);
                        return;
                    }
                }
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = map;
                bVar2.b.sendMessage(obtain);
            }
        }
    }
}
