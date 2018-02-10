package com.ucpro.base.system;

import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ProGuard */
public class UCLibLoader {
    private static final List<String> LOADEDLIBS_LIST = new LinkedList();
    private static final String TAG = "UCLibLoader";

    public static synchronized void loadLibrary(String str) {
        synchronized (UCLibLoader.class) {
            String findLibrary = findLibrary(str);
            if (findLibrary != null) {
                load(findLibrary);
            }
        }
    }

    private static final String findLibrary(String str) {
        ClassLoader classLoader = UCLibLoader.class.getClassLoader();
        if (classLoader instanceof BaseDexClassLoader) {
            return ((BaseDexClassLoader) classLoader).findLibrary(str);
        }
        Log.e(TAG, "Cannot find Lib:" + str);
        return null;
    }

    public static synchronized void load(String str) {
        synchronized (UCLibLoader.class) {
            System.load(str);
            if (!LOADEDLIBS_LIST.contains(str)) {
                LOADEDLIBS_LIST.add(str);
                Log.e(TAG, "start Load lib:" + str);
            }
        }
    }
}
