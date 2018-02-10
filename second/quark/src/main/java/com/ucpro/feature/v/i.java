package com.ucpro.feature.v;

import android.webkit.ValueCallback;
import com.uc.translate.k;
import com.uc.translate.m;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class i {
    private static Pattern a = Pattern.compile("[\\u4E00-\\u9FBF]+");

    public static void a(String str, ValueCallback<String> valueCallback) {
        m mVar;
        m mVar2;
        boolean a = a(str);
        if (a) {
            mVar = m.ZH_CN;
        } else {
            mVar = m.EN;
        }
        if (a) {
            mVar2 = m.EN;
        } else {
            mVar2 = m.ZH_CN;
        }
        com.uc.translate.i.a(str, k.TEXT, mVar, mVar2, new d(valueCallback));
    }

    public static void b(String str, ValueCallback<String> valueCallback) {
        m mVar;
        m mVar2;
        boolean a = a(str);
        if (a) {
            mVar = m.ZH_CN;
        } else {
            mVar = m.EN;
        }
        if (a) {
            mVar2 = m.EN;
        } else {
            mVar2 = m.ZH_CN;
        }
        com.uc.translate.i.a(str, k.HTML, mVar, mVar2, new j(valueCallback));
    }

    private static boolean a(String str) {
        return str != null && a.matcher(str).find();
    }
}
