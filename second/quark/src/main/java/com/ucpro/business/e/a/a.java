package com.ucpro.business.e.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.uc.a.d.ai;
import com.uc.a.d.j;
import com.uc.a.d.p;
import com.uc.a.d.u;
import com.ucpro.business.e.e.b;
import com.ucpro.business.stat.f;
import com.ucpro.services.f.g;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import com.ucweb.common.util.d.e;
import com.ucweb.common.util.h;
import com.ucweb.common.util.h.m;
import hugo.weaving.DebugLog;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class a implements u, com.ucpro.services.networkstate.a {
    private static a a = new a(d.a());
    private p b = null;

    private a(Context context) {
        byte b;
        p pVar;
        c.a((Object) context);
        String a = com.ucpro.c.c.a("us");
        HashMap hashMap = new HashMap();
        hashMap.put("fr", "android");
        hashMap.put(ai.e, "u4");
        hashMap.put("prd", "ucpro");
        hashMap.put("m_pfid", "3300");
        hashMap.put("lang", Locale.getDefault().getLanguage());
        hashMap.put("btype", com.ucpro.c.a.d());
        hashMap.put("bmode", com.ucpro.c.a.e());
        hashMap.put("version", "2.4.1.985");
        hashMap.put("subver", "release");
        hashMap.put("pver", "3.1");
        hashMap.put("m_bseq", "180123054500");
        hashMap.put("m_bid", com.ucpro.c.a.a());
        hashMap.put("bidf", "");
        hashMap.put("useragent", Build.MODEL);
        hashMap.put(ai.a, e.d());
        hashMap.put(ai.b, e.e());
        hashMap.put(ai.c, e.b());
        hashMap.put(ai.d, e.f());
        hashMap.put("utdid", f.b());
        hashMap.put("sn", b.b().a("sn", ""));
        hashMap.put("m_dn", b.b().a("dn", ""));
        hashMap.put("cp", b.b().a("cp_param", ""));
        if (com.ucpro.c.b.b()) {
            a(hashMap);
        }
        com.uc.a.d.a aVar = new com.uc.a.d.a(context);
        aVar.c = "https://ucus.ucweb.com/usquery.php";
        aVar.g = a;
        aVar.e = h.a.widthPixels;
        aVar.f = h.a.heightPixels;
        aVar.b = com.ucpro.business.e.b.a.b.a;
        aVar.h = com.ucpro.business.e.b.b.a.a;
        aVar.i = g.a();
        aVar.d = hashMap;
        aVar.j = com.ucpro.c.b.b();
        aVar.k = com.ucweb.common.util.k.a.a(com.ucpro.c.c.b("us").getAbsolutePath(), "uslog.txt");
        if (TextUtils.isEmpty(aVar.c)) {
            Log.e("us", "[us] default server url is empty");
            b = (byte) 0;
        } else {
            if (TextUtils.isEmpty((CharSequence) aVar.d.get("fr"))) {
                aVar.d.put("fr", "android");
            }
            b = (byte) 1;
        }
        if (b == (byte) 0) {
            pVar = null;
        } else {
            pVar = new p(aVar);
        }
        this.b = pVar;
        pVar = this.b;
        pVar.a.a(new com.ucpro.business.e.e.a());
        this.b.a((u) this);
        com.ucpro.services.networkstate.b.a.a(this);
    }

    private static void a(HashMap<String, String> hashMap) {
        if (com.ucpro.c.b.b()) {
            for (Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                new StringBuilder("[us] ").append(str).append("=").append((String) entry.getValue());
            }
        }
    }

    public static a a() {
        return a;
    }

    public final p b() {
        return this.b;
    }

    public final void a(String str, j jVar) {
        this.b.a.a(str, jVar);
    }

    public final void a(String str) {
        this.b.a.a(str);
    }

    public final synchronized void a(boolean z) {
        if (com.ucpro.business.e.c.a.a()) {
            a("http://119.147.224.127:8161/ldus_st", 10800);
        }
        c.a();
        m.a(0, new b(this, z));
    }

    public final void p_() {
        if (com.ucweb.common.util.i.c.a()) {
            a(false);
        }
    }

    @DebugLog
    public final void a(int i) {
        if (i != 0) {
            if (com.ucpro.c.b.b()) {
                com.ucpro.ui.b.e.a().a("[DEBUG] US request fail: " + i, 0);
            }
            if (com.ucweb.common.util.i.c.a()) {
                com.ucpro.business.stat.m.a("us", "rqst_ex", "result", String.valueOf(i));
            }
        } else if (com.ucpro.c.b.b()) {
            com.ucpro.ui.b.e.a().a("[DEBUG] US request OK", 0);
        }
    }

    public static void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            Log.w("us", "[us] empty serverUrl");
            return;
        }
        if (i < 0) {
            i = 0;
        }
        com.uc.a.d.c.a();
        com.uc.a.d.c.a(str, i);
    }
}
