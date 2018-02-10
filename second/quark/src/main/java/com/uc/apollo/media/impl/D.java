package com.uc.apollo.media.impl;

import android.util.SparseArray;
import com.uc.apollo.media.base.g;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class D {
    private static SparseArray<B> a = new SparseArray();
    private static SparseArray<Map<String, String>> b = new SparseArray();

    public static SparseArray<B> a() {
        return a;
    }

    public static B a(int i) {
        return (B) a.get(i);
    }

    public static boolean a(int i, String str, String str2) {
        MediaPlayerClient mediaPlayerClient;
        boolean z = false;
        B b = (B) a.get(i);
        if (b == null) {
            mediaPlayerClient = null;
        } else {
            mediaPlayerClient = b.c();
        }
        if (mediaPlayerClient != null) {
            z = mediaPlayerClient.setOption(str, str2);
        }
        if (!z) {
            Map map = (Map) b.get(i);
            if (map == null) {
                map = new HashMap();
                b.put(i, map);
            }
            map.put(str, str2);
        }
        return z;
    }

    static B a(MediaPlayerClient mediaPlayerClient, boolean z, int i) {
        B b = (B) a.get(i);
        if (b == null) {
            B b2 = new B(z, i);
            a.put(i, b2);
            Map map = (Map) b.get(i);
            if (map != null) {
                if (map.size() > 0) {
                    for (Entry entry : map.entrySet()) {
                        b2.b((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                b.remove(i);
            }
            b = b2;
        }
        b.a(mediaPlayerClient);
        return b;
    }

    static void a(MediaPlayerClient mediaPlayerClient, B b) {
        if (b.b(mediaPlayerClient) == 0) {
            b.E();
            a.remove(b.h());
            b.remove(b.h());
        }
    }

    public static void b(int i) {
        B b = (B) a.get(i);
        if (b != null) {
            a.remove(i);
            int a = g.a();
            while (a.get(a) != null) {
                a = g.a();
            }
            b.a(a);
            a.put(a, b);
        }
    }
}
