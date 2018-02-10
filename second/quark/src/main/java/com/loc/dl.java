package com.loc;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public final class dl {
    private static Method a;

    public static long a(Context context, String str, String str2) {
        long j = 0;
        try {
            j = context.getSharedPreferences(str, 0).getLong(str2, 0);
        } catch (Throwable th) {
            cq.a(th, "SPUtil", "getPrefsLong");
        }
        return j;
    }

    public static void a(Context context, String str, String str2, int i) {
        try {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putInt(str2, i);
            a(edit);
        } catch (Throwable th) {
            cq.a(th, "SPUtil", "setPrefsInt");
        }
    }

    public static void a(Context context, String str, String str2, long j) {
        try {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j);
            a(edit);
        } catch (Throwable th) {
            cq.a(th, "SPUtil", "setPrefsLong");
        }
    }

    public static void a(Context context, String str, String str2, boolean z) {
        try {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putBoolean(str2, z);
            a(edit);
        } catch (Throwable th) {
            cq.a(th, "SPUtil", "updatePrefsBoolean");
        }
    }

    public static void a(Editor editor) {
        if (editor != null) {
            if (VERSION.SDK_INT >= 9) {
                try {
                    if (a == null) {
                        a = Editor.class.getDeclaredMethod("apply", new Class[0]);
                    }
                    a.invoke(editor, new Object[0]);
                    return;
                } catch (Throwable th) {
                    cq.a(th, "SPUtil", "applySharedPreference");
                }
            }
            try {
                new dk(editor).execute(new Void[]{null, null, null});
            } catch (Throwable th2) {
                cq.a(th2, "SPUtil", "commit1");
            }
        }
    }

    public static int b(Context context, String str, String str2) {
        int i = 0;
        try {
            i = context.getSharedPreferences(str, 0).getInt(str2, 0);
        } catch (Throwable th) {
            cq.a(th, "SPUtil", "getPrefsInt");
        }
        return i;
    }

    public static boolean b(Context context, String str, String str2, boolean z) {
        try {
            z = context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            cq.a(th, "SPUtil", "getPrefsBoolean");
        }
        return z;
    }
}
