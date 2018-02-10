package com.ucpro.feature.lightapp.d;

import com.uc.apollo.android.GuideDialog;

/* compiled from: ProGuard */
public class b {
    public String b;
    public String c;
    public String d;
    public String e;

    public static b c(String str) {
        b bVar = new b();
        bVar.b = a(GuideDialog.TITLE, str);
        bVar.c = a("categoryId", str);
        bVar.e = str;
        return bVar;
    }

    protected static String a(String str, String str2) {
        String str3 = str + "=";
        int indexOf = str2.indexOf(str3);
        String str4 = "";
        if (indexOf >= 0) {
            str3 = str2.substring(str3.length() + indexOf);
            if (str3 != null && str3.length() > 0) {
                int indexOf2 = str3.indexOf("^");
                if (indexOf2 == -1) {
                    return str3;
                }
                return str3.substring(0, indexOf2);
            }
        }
        return str4;
    }
}
