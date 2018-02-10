package com.ucpro.business.e.g;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.UCMobile.Apollo.ApolloMetaData;
import com.uc.a.f.c;
import com.uc.a.f.e;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.a.ac;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;
import com.ucpro.business.stat.f;
import com.ucpro.business.stat.m;
import com.ucpro.services.f.g;
import com.ucpro.services.networkstate.a;
import com.ucpro.services.networkstate.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class d implements e, a {
    private static d d = new d(com.ucweb.common.util.d.a());
    public com.uc.a.f.a a;
    private Context b;
    private HashMap<String, ArrayList<Object>> c = new HashMap(10);
    private b e;

    private d(Context context) {
        byte b;
        com.uc.a.f.a aVar;
        this.b = context;
        b.a.a(this);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "ucmobile");
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
        hashMap.put("utdid", f.b());
        hashMap.put("sn", com.ucpro.business.e.e.b.b().d());
        hashMap.put("m_dn", com.ucpro.business.e.e.b.b().c());
        hashMap.put("cp", com.ucpro.business.e.e.b.b().a());
        a(hashMap);
        a aVar2 = new a(this);
        c cVar = new c(this.b);
        cVar.g = g.a();
        cVar.c = "http://183.61.109.210:10033/";
        cVar.d = "http://u.uc123.com:80";
        cVar.e = "http://u.ucfly.com:80";
        cVar.h = com.ucpro.business.e.b.a.b.a;
        cVar.i = com.ucpro.business.e.b.c.a.a;
        cVar.b = hashMap;
        cVar.f = this;
        if (TextUtils.isEmpty(cVar.c)) {
            Log.e("dispatcher", "[dispatcher]  primary server address is empty, check if it's set  correctly");
            b = (byte) 0;
        } else if (TextUtils.isEmpty(cVar.d)) {
            Log.e("dispatcher", "[dispatcher]  secondary server address is empty, check if it's set  correctly");
            b = (byte) 0;
        } else if (cVar.g == null) {
            b = (byte) 0;
        } else {
            b = (byte) 1;
        }
        if (b == (byte) 0) {
            if (cVar.i != null) {
                cVar.i.a("Validatoin check failed!");
            }
            aVar = null;
        } else {
            cVar.b.put("newserver", "");
            cVar.b.put("localserver", SettingsConst.FALSE);
            cVar.b.put("last_server", "");
            cVar.b.put("reassign", "false");
            aVar = new com.uc.a.f.a(cVar);
            aVar.a(cVar.f);
        }
        this.a = aVar;
    }

    public static d a() {
        return d;
    }

    public final com.uc.a.f.a b() {
        return this.a;
    }

    private static void a(HashMap<String, String> hashMap) {
        if (com.ucpro.c.b.b()) {
            for (Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                new StringBuilder("[dispatcher] request param: ").append(str).append("=").append((String) entry.getValue());
            }
        }
    }

    public final void a(com.uc.a.f.a aVar) {
        boolean z;
        int i;
        if (this.e == null) {
            this.e = new b();
        }
        String a = aVar.a("assign");
        String str = null;
        if (TextUtils.isEmpty(a)) {
            str = "empty";
            z = false;
            i = 1;
        } else if (a.contains("u2.uc")) {
            str = "u2";
            z = false;
            i = 1;
        } else if (Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(a).matches()) {
            str = ApolloMetaData.KEY_IP;
            z = true;
            i = 1;
        } else {
            z = true;
            boolean z2 = false;
        }
        if (i != 0) {
            String a2 = com.ucpro.business.e.e.b.b().a();
            String d = com.ucpro.business.e.e.b.b().d();
            String c = com.ucpro.business.e.e.b.b().c();
            String a3 = a().a.a("client_ip");
            m.a("dispatcher", "mwa_exp", "type", str, "value", a, "sn", d, "dn", c, "loc", a2, ApolloMetaData.KEY_IP, a3);
            Log.e("dispatcher", "[dispatcher] abnormal middleware address :" + a);
        }
        if (z) {
            ac b = ac.b();
            com.ucweb.common.util.c.a((CharSequence) a);
            if (!TextUtils.isEmpty(a)) {
                k.a;
                p.a(SettingKeys.NetworkWifiFoxyServerAddr, a);
                b.a = a;
            }
        }
        str = aVar.a();
        int b2 = aVar.b();
        com.ucpro.business.e.a.a.a();
        com.ucpro.business.e.a.a.a(str, b2);
        com.ucpro.business.e.a.a.a().a(false);
    }

    public final String d() {
        return this.a.a("assign", "vs22.gzct.u3.ucweb.com:8080");
    }

    public final void a(boolean z) {
        com.ucweb.common.util.h.m.a(0, new c(this, z));
    }

    public final void p_() {
        if (com.ucweb.common.util.i.c.a()) {
            a(false);
        }
    }
}
