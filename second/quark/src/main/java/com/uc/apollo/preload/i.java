package com.uc.apollo.preload;

import android.os.RemoteException;
import com.uc.apollo.media.service.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public final class i {
    private static h a;
    private static ArrayList<Runnable> b = new ArrayList();

    public static void a(h hVar) {
        a = hVar;
        Iterator it = b.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        b.clear();
    }

    public static void a() {
        a = null;
    }

    public static void a(String str, String str2, Map<String, String> map, PreloadListener preloadListener) {
        if (a != null) {
            try {
                a.a(str, str2, (Map) map, new j(preloadListener));
                return;
            } catch (RemoteException e) {
                return;
            }
        }
        b.add(new k(str, str2, map, preloadListener));
    }

    public static void a(String str) {
        if (a != null) {
            try {
                a.b(str);
                return;
            } catch (RemoteException e) {
                return;
            }
        }
        b.add(new l(str));
    }

    public static void a(String str, String str2) {
        if (a != null) {
            try {
                a.b(str, str2);
                return;
            } catch (RemoteException e) {
                return;
            }
        }
        b.add(new m(str, str2));
    }

    public static void a(String str, int i) {
        if (a != null) {
            try {
                a.a(str, i);
                return;
            } catch (RemoteException e) {
                return;
            }
        }
        b.add(new n(str, i));
    }

    public static void a(StatisticUploadListener statisticUploadListener) {
        if (a != null) {
            try {
                a.a(new o(statisticUploadListener));
                return;
            } catch (RemoteException e) {
                return;
            }
        }
        b.add(new p(statisticUploadListener));
    }
}
