package com.uc.framework.resources;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class b {
    static String a = "resources/strings/";
    public static String b = "en-us";

    public static boolean a(String str) {
        return str != null && str.equals("theme/default/");
    }

    static boolean b(String str) {
        return str != null && str.equals("theme/night/");
    }

    public static boolean c(String str) {
        return str != null && (str.equals("theme/default/") || str.equals("theme/night/") || str.equals("theme/transparent/") || str.equals("theme/pink/") || str.equals("theme/green/") || str.equals("theme/black/") || str.equals("theme/orange/"));
    }

    static int d(String str) {
        if (str.equals("state_focused")) {
            return 16842908;
        }
        if (str.equals("state_enabled")) {
            return 16842910;
        }
        if (str.equals("state_selected")) {
            return 16842913;
        }
        if (str.equals("state_active") || str.equals("state_active")) {
            return 16842914;
        }
        if (str.equals("state_pressed")) {
            return 16842919;
        }
        if (str.endsWith("state_checked")) {
            return 16842912;
        }
        return str.endsWith("state_checkable") ? 16842911 : 0;
    }

    public static float a(Context context, float f) {
        return context.getResources().getDisplayMetrics().scaledDensity * f;
    }

    public static float b(Context context, float f) {
        return (context.getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public static String a(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static byte[] a(InputStream inputStream) {
        byte[] bArr = null;
        if (inputStream != null) {
            int i = 0;
            try {
                i = inputStream.available();
            } catch (IOException e) {
            }
            if (i > 0) {
                bArr = new byte[i];
                try {
                    inputStream.read(bArr);
                } catch (IOException e2) {
                }
                try {
                    inputStream.close();
                } catch (Exception e3) {
                }
            }
        }
        return bArr;
    }
}
