package com.ucpro.feature.lightapp.d;

import android.text.TextUtils;
import com.uc.apollo.android.GuideDialog;

/* compiled from: ProGuard */
public final class a extends b {
    public String a;

    public static a a(String str) {
        b aVar = new a();
        aVar.b = b.a(GuideDialog.TITLE, str);
        aVar.c = b.a("categoryId", str);
        aVar.a = b.a("articleId", str);
        aVar.e = str.substring(0, str.indexOf("articleId") - 1);
        return aVar;
    }

    public static boolean b(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("ext:navifunc:lightapp") && str.contains("articleId")) {
            return true;
        }
        return false;
    }
}
