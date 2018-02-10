package com.ucpro.c;

import android.os.Build.VERSION;
import java.util.Locale;

/* compiled from: ProGuard */
public final class d {
    public static boolean a() {
        return Locale.getDefault().getLanguage().equalsIgnoreCase("ru");
    }

    public static boolean b() {
        return !Locale.getDefault().getLanguage().startsWith("zh");
    }

    public static final String c() {
        if (VERSION.SDK_INT >= 21) {
            return Locale.getDefault().toLanguageTag();
        }
        return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
    }
}
