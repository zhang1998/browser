package com.ucpro.business.stat.b;

import com.uc.base.wa.w;
import java.util.Date;
import java.util.HashMap;

/* compiled from: ProGuard */
final class b extends w {
    final /* synthetic */ f a;

    b(f fVar) {
        this.a = fVar;
    }

    public final String a(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 3705:
                if (str.equals("tm")) {
                    obj = 2;
                    break;
                }
                break;
            case 116643:
                if (str.equals("ver")) {
                    obj = null;
                    break;
                }
                break;
            case 3542608:
                if (str.equals("sver")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return "2.4.1.985";
            case 1:
                return "release";
            case 2:
                return f.a(this.a).format(new Date(System.currentTimeMillis()));
            default:
                return null;
        }
    }

    public final void a(HashMap<String, Integer> hashMap) {
        hashMap.put("ver", Integer.valueOf(1));
        hashMap.put("sver", Integer.valueOf(1));
    }

    public final void b(HashMap<String, Integer> hashMap) {
        hashMap.put("tm", Integer.valueOf(1));
    }
}
