package com.ucpro.a;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.uc.a.d.e;
import com.uc.a.d.l;
import com.uc.base.b.c.b.c;
import com.ucpro.business.a;
import com.ucpro.business.d.d;
import java.util.HashMap;
import java.util.Set;

/* compiled from: ProGuard */
final class w implements Runnable {
    final /* synthetic */ Set a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ ax c;

    w(ax axVar, Set set, ValueCallback valueCallback) {
        this.c = axVar;
        this.a = set;
        this.b = valueCallback;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        if (!(this.a == null || this.a.isEmpty())) {
            for (String str : this.a) {
                if (!TextUtils.isEmpty(str)) {
                    Object obj = -1;
                    switch (str.hashCode()) {
                        case 1344568959:
                            if (str.equals("hide_domainlist")) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            hashMap.put(str, at.a());
                            break;
                        default:
                            c dVar = new d();
                            if (!e.a(l.a(str), dVar)) {
                                break;
                            }
                            obj = a.a(dVar, "^^");
                            if (!TextUtils.isEmpty(obj)) {
                                new StringBuilder("getAccessibleMap: \nkey is: ").append(str).append("\nvalue is: ").append(obj);
                                hashMap.put(str, obj);
                                break;
                            }
                            break;
                    }
                }
            }
        }
        this.b.onReceiveValue(hashMap);
    }
}
