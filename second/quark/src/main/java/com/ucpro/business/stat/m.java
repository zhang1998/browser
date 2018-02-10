package com.ucpro.business.stat;

import android.os.SystemClock;
import com.uc.base.wa.e;
import com.uc.base.wa.v;
import com.uc.base.wa.x;
import com.ucpro.business.stat.a.b;
import com.ucpro.business.stat.a.d;
import com.ucweb.common.util.c;
import hugo.weaving.DebugLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class m {
    public static void a(String str, String str2, long j, String... strArr) {
        c.a((CharSequence) str2);
        c.a(true, "keyValues should be paired");
        HashMap a = a(strArr);
        a.put("__vl", String.valueOf(j));
        a(str, str2, a);
    }

    public static void a(String str, String str2) {
        c.a((CharSequence) str2);
        com.ucpro.business.stat.b.c a = com.ucpro.business.stat.b.c.a();
        c.a((CharSequence) str);
        c.a((CharSequence) str2);
        a.a.put(str + str2, Long.valueOf(SystemClock.uptimeMillis()));
    }

    public static void b(String str, String str2) {
        c.a((CharSequence) str);
        c.a((CharSequence) str2);
        com.ucpro.business.stat.b.c a = com.ucpro.business.stat.b.c.a();
        c.a((CharSequence) str);
        c.a((CharSequence) str2);
        long uptimeMillis = SystemClock.uptimeMillis();
        Long l = (Long) a.a.remove(str + str2);
        if (l != null) {
            uptimeMillis -= l.longValue();
            c.b(uptimeMillis >= 0);
            if (uptimeMillis > 0) {
                a(str, str2, uptimeMillis, new String[0]);
            }
        }
    }

    public static void a(String str, String str2, String... strArr) {
        a(d.IMPORTANT, str, str2, a(strArr));
    }

    public static void a(String str, String str2, HashMap<String, String> hashMap) {
        a(d.IMPORTANT, str, str2, (HashMap) hashMap);
    }

    @DebugLog
    public static void a(d dVar, String str, String str2, HashMap<String, String> hashMap) {
        c.a((Object) dVar);
        c.a(dVar.d);
        c.a((CharSequence) str);
        c.a((CharSequence) str2);
        e eVar = new e();
        eVar.a("ev_ct", str);
        eVar.a("ev_ac", str2);
        if (hashMap != null) {
            eVar.a(hashMap);
        }
        eVar.a("ev_vl", 1, 1, false);
        x.a(dVar.d, eVar, new String[0]);
    }

    public static void b(String str, String str2, String... strArr) {
        b(str, str2, a(strArr));
    }

    @DebugLog
    public static void b(String str, String str2, HashMap<String, String> hashMap) {
        c.a((CharSequence) str2);
        c.a((CharSequence) str);
        e eVar = new e();
        eVar.a("ev_ct", str);
        eVar.a("ev_ac", str2);
        if (hashMap != null) {
            eVar.a(hashMap);
        }
        v vVar = new v();
        vVar.a = false;
        x.a(d.IMPORTANT.d, vVar, eVar, new String[0]);
    }

    private static HashMap<String, String> a(String... strArr) {
        boolean z;
        int i = 0;
        if (strArr.length % 2 == 0) {
            z = true;
        } else {
            z = false;
        }
        c.b(z);
        HashMap<String, String> hashMap = new HashMap();
        while (i < strArr.length / 2) {
            hashMap.put(strArr[i * 2], strArr[(i * 2) + 1]);
            i++;
        }
        return hashMap;
    }

    public static void a(d dVar) {
        if (dVar != null) {
            o.a(dVar);
        }
    }

    public static void a(b bVar) {
        a(bVar, new HashMap());
    }

    public static void a(b bVar, Map<String, String> map) {
        o.a(bVar.a, bVar.b, bVar.c, map);
    }
}
