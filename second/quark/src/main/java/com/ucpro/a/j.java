package com.ucpro.a;

import android.webkit.ValueCallback;
import com.ucpro.a.c.g;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;
import java.util.HashMap;

/* compiled from: ProGuard */
final class j implements ValueCallback<HashMap<String, String>> {
    final /* synthetic */ s a;

    j(s sVar) {
        this.a = sVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        HashMap hashMap = (HashMap) obj;
        if (hashMap != null && !hashMap.isEmpty()) {
            com.ucpro.a.c.j a = k.a;
            if (g.a().c()) {
                p.a(1, 1, hashMap);
            } else {
                a.a(new g(1, hashMap));
            }
        }
    }
}
