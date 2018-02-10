package com.ucpro.feature.l.b;

import com.ucpro.base.a.g;
import com.ucpro.feature.navigation.b.e;
import com.ucpro.model.a.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class l {
    public static List<m> a() {
        long currentTimeMillis = System.currentTimeMillis();
        List<m> arrayList = new ArrayList();
        int i = 0;
        while (i < e.a().c().length) {
            m mVar = new m();
            String str = e.a().b()[i];
            mVar.a = e.a().c()[i];
            mVar.b = str;
            long j = 1 + currentTimeMillis;
            mVar.d = currentTimeMillis;
            mVar.e = 0;
            arrayList.add(mVar);
            i++;
            currentTimeMillis = j;
        }
        return arrayList;
    }

    static m a(String str, String str2, String str3, long j) {
        m mVar = new m();
        mVar.a = str;
        mVar.b = str2;
        mVar.c = str3;
        mVar.d = j;
        mVar.e = 1;
        if (str2 == "ext:navifunc:qrcode") {
            mVar.f = a.a.a("setting_qrcode_enable", true);
        } else {
            c cVar = new c(mVar);
            g.a().b(com.ucpro.base.a.e.d, new Object[]{str2, cVar});
        }
        return mVar;
    }
}
