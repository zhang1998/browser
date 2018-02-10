package com.ucpro.business;

import android.text.TextUtils;
import com.ucpro.business.d.c;
import com.ucpro.business.d.d;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a {
    public static String a(d dVar, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = dVar.a.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!(cVar == null || TextUtils.isEmpty(cVar.c()))) {
                stringBuilder.append(cVar.c());
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }
}
