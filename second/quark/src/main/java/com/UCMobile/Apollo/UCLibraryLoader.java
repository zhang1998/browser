package com.UCMobile.Apollo;

import android.os.Build.VERSION;

/* compiled from: ProGuard */
public class UCLibraryLoader {
    public static native void nativeLoad(String str);

    public static void a(String str, boolean z) {
        if (VERSION.SDK_INT <= 23 || !z) {
            System.load(str);
        } else {
            nativeLoad(str);
        }
    }

    public static void b(String str, boolean z) {
        if (VERSION.SDK_INT <= 23 || !z) {
            System.loadLibrary(str);
        } else {
            nativeLoad(Global.gApolloSoPath + "/lib" + str + ".so");
        }
    }
}
