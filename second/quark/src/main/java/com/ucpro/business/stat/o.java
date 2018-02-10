package com.ucpro.business.stat;

import android.util.Log;
import com.e.b.j;
import com.e.b.l;
import com.e.b.r;
import com.ucpro.business.stat.a.d;
import com.ucpro.c.b;
import com.ucweb.common.util.d.e;
import hugo.weaving.DebugLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class o {
    static boolean a = b.b();
    public static WeakReference<d> b = null;
    private static int c = -1;
    private static boolean d = false;

    static void a(d dVar) {
        a(dVar, false);
    }

    public static void a(d dVar, boolean z) {
        if (dVar != null) {
            Map hashMap = new HashMap();
            hashMap.put("spm-cnt", dVar.getSpm());
            hashMap.putAll(a());
            String pageName = dVar.getPageName();
            if (!dVar.getSpm().equals("dont_stat_spm") && !pageName.equals("dont_stat_pagename")) {
                if (!(z || b == null || b.get() == null)) {
                    a((d) b.get(), ((d) b.get()).getPageName());
                    b = null;
                }
                if (dVar != null) {
                    if (a) {
                        if (!d) {
                            c = dVar.hashCode();
                            d = true;
                        } else if (c == dVar.hashCode()) {
                            Log.w("UtStatAgentPage", "Page Show Error : " + pageName + "  连续Show了两次");
                            return;
                        } else {
                            Log.e("UtStatAgentPage", "Page Show Error : 连续Show了两个不同页面/实例, 这次是 " + pageName);
                            return;
                        }
                    }
                    com.e.b.b.a().d();
                    l.a((Object) dVar, pageName);
                    com.e.b.b.a().d();
                    l.a((Object) dVar, hashMap);
                    com.e.b.b.a().d();
                    l.a((Object) dVar);
                    com.e.b.b.a().d();
                    l.b((Object) dVar);
                    b = new WeakReference(dVar);
                }
            }
        }
    }

    @DebugLog
    public static void a(String str) {
        Map hashMap = new HashMap();
        hashMap.put("spm-url", str);
        com.e.b.b.a().d();
        l.b(hashMap);
    }

    @DebugLog
    public static void a(d dVar, String str) {
        if (!str.equals("dont_stat_pagename") && dVar != null) {
            if (a) {
                if (d) {
                    if (c != dVar.hashCode()) {
                        Log.e("UtStatAgentPage", "Page Hide Error : 这次Hide的页面/实例和上一个show的页面/实例不一样，这次是 " + str);
                        return;
                    } else {
                        c = dVar.hashCode();
                        d = false;
                    }
                } else if (c == dVar.hashCode()) {
                    Log.w("UtStatAgentPage", "Page Hide Error : " + str + "  连续Hide了两次");
                    return;
                } else {
                    Log.e("UtStatAgentPage", "Page Hide Error : 连续Hide了两个不同页面");
                    return;
                }
            }
            com.e.b.b.a().d().c(dVar);
        }
    }

    @DebugLog
    static void a(String str, String str2, String str3, Map<String, String> map) {
        r rVar = new r(str, str2);
        map.put("spm", str3);
        map.putAll(a());
        rVar.a(map);
        com.e.b.b.a().d().a(rVar.a());
    }

    @DebugLog
    public static void b(String str) {
        com.e.b.b.a().d().a(new j(str).a());
    }

    private static Map<String, String> a() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("dn", com.ucpro.business.e.e.b.b().c());
        hashMap.put("sn", com.ucpro.business.e.e.b.b().d());
        hashMap.put("prd", "ucpro");
        hashMap.put("pf", com.ucpro.base.system.b.a.A());
        hashMap.put("memory", String.valueOf(e.l()));
        return hashMap;
    }
}
