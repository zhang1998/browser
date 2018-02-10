package com.uc.apollo.android;

import android.os.Build;
import java.util.Locale;

/* compiled from: ProGuard */
public final class c {
    public static final int a;

    static {
        String toLowerCase = Build.BRAND.toLowerCase(Locale.getDefault());
        if (toLowerCase.equals("xiaomi")) {
            a = 1;
        } else if (toLowerCase.equals("huawei")) {
            a = 2;
        } else if (toLowerCase.equals("honor")) {
            a = 3;
        } else if (toLowerCase.equals("vivo")) {
            a = 4;
        } else if (toLowerCase.equals("oppo")) {
            a = 5;
        } else if (toLowerCase.equals("smartisan")) {
            a = 6;
        } else if (toLowerCase.equals("meizu")) {
            a = 7;
        } else {
            a = 0;
        }
    }
}
