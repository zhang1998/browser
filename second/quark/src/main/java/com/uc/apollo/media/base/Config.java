package com.uc.apollo.media.base;

import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForRuntime;

@KeepForRuntime
@Deprecated
/* compiled from: ProGuard */
public final class Config extends Settings {
    public static void set(int i, Object obj) {
        Settings.setGlobalOption(i, obj);
    }

    public static Object get(int i, Object obj) {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(Settings.getGlobalOption(i, ((Boolean) obj).booleanValue()));
        }
        return Settings.getGlobalOption(String.valueOf(i), String.valueOf(obj));
    }

    public static void set(int i, boolean z) {
        set(i, Boolean.valueOf(z));
    }

    public static void set(int i, int i2) {
        set(i, Integer.valueOf(i2));
    }

    public static void set(int i, String str) {
        set(i, (Object) str);
    }

    public static boolean get(int i, boolean z) {
        return Settings.getGlobalOption(i, z);
    }

    public static int get(int i, int i2) {
        return Settings.getGlobalOption(i, i2);
    }

    public static String get(int i, String str) {
        return Settings.getGlobalOption(i, str);
    }
}
