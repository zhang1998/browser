package com.ucpro.a;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.ucpro.business.e.d.g;
import java.util.HashMap;
import java.util.Set;

/* compiled from: ProGuard */
final class au implements Runnable {
    final /* synthetic */ Set a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ x c;

    au(x xVar, Set set, ValueCallback valueCallback) {
        this.c = xVar;
        this.a = set;
        this.b = valueCallback;
    }

    public final void run() {
        HashMap hashMap = null;
        if (!(this.a == null || this.a.isEmpty())) {
            HashMap hashMap2 = new HashMap();
            for (String str : this.a) {
                if (!TextUtils.isEmpty(str)) {
                    CharSequence b = g.a().b(str);
                    new StringBuilder("getCDParamMap(Set<String> keySet):\nkey is: ").append(str).append("\nvalue is: ").append(b);
                    if (!TextUtils.isEmpty(b)) {
                        hashMap2.put(str, b);
                    }
                }
            }
            hashMap = hashMap2;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            this.b.onReceiveValue(hashMap);
        }
    }
}
