package com.ucweb.common.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

/* compiled from: ProGuard */
public final class d {
    private static Context a = null;

    public static void a(Context context) {
        a = context;
    }

    public static Context a() {
        return a;
    }

    public static AssetManager b() {
        if (a != null) {
            return a.getAssets();
        }
        return null;
    }

    public static Resources c() {
        if (a != null) {
            return a.getResources();
        }
        return null;
    }

    public static Object a(String str) {
        return a.getSystemService(str);
    }
}
