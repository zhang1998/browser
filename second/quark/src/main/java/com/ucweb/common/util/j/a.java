package com.ucweb.common.util.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.ucweb.common.util.d;

@SuppressLint({"CommitPrefEdits"})
/* compiled from: ProGuard */
public final class a {
    private static Context a = d.a();

    public static void a(Context context, String str, String str2, String str3) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    edit.putString(str2, str3);
                    edit.apply();
                }
            }
        }
    }

    public static String b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return str3;
        }
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void a(String str, boolean z) {
        a(a, "9664302A405DA1820E68DD54BE1E9868", str, z);
    }

    public static boolean b(String str, boolean z) {
        return b(a, "9664302A405DA1820E68DD54BE1E9868", str, z);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (context != null) {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            if (edit != null) {
                edit.putBoolean(str2, z);
                edit.apply();
            }
        }
    }

    public static boolean b(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return z;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str2, z);
        }
        return z;
    }

    public static long b(Context context, String str, String str2, long j) {
        if (context == null) {
            return j;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str2, j);
        }
        return j;
    }

    public static void a(String str, int i) {
        a(a, "9664302A405DA1820E68DD54BE1E9868", str, i);
    }

    public static int a(String str) {
        return b(a, "9664302A405DA1820E68DD54BE1E9868", str, -1);
    }

    public static void a(Context context, String str, String str2, int i) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    edit.putInt(str2, i);
                    edit.apply();
                }
            }
        }
    }

    public static int b(Context context, String str, String str2, int i) {
        if (context == null) {
            return i;
        }
        return context.getSharedPreferences(str, 0).getInt(str2, i);
    }

    public static void a(Editor editor) {
        if (editor != null) {
            try {
                editor.apply();
            } catch (Throwable th) {
                editor.commit();
            }
        }
    }

    public static void a(Context context, String str, String str2, long j) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    edit.putLong(str2, j);
                    edit.apply();
                }
            }
        }
    }
}
