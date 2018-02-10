package com.ucpro.a;

import android.webkit.ValueCallback;
import com.ucpro.a.c.g;
import com.ucpro.a.c.j;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class o implements ValueCallback<HashMap<String, String>> {
    final /* synthetic */ m a;

    o(m mVar) {
        this.a = mVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        HashMap hashMap = (HashMap) obj;
        if (hashMap != null && !hashMap.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("updateWebCoreCDParam");
            for (Entry entry : hashMap.entrySet()) {
                stringBuilder.append(entry.getKey() + " : " + entry.getValue() + "\n");
            }
            j a = k.a;
            if (g.a().c()) {
                p.a(2, 1, hashMap);
            } else {
                a.a(new g(2, hashMap));
            }
        }
    }
}
