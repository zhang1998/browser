package com.ucweb.c.c;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class b {
    public static WeakReference<Activity> a;

    public static Activity a() {
        if (a != null) {
            return (Activity) a.get();
        }
        throw new RuntimeException("context is null!");
    }
}
