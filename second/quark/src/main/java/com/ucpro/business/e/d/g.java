package com.ucpro.business.e.d;

import android.text.TextUtils;
import com.uc.a.d.j;
import com.uc.base.b.d.c;
import com.ucpro.business.c.a.b;
import com.ucpro.business.c.a.e;
import com.ucpro.business.stat.m;
import com.ucweb.common.util.n.a;
import java.io.File;
import java.util.HashMap;

/* compiled from: ProGuard */
public class g implements j {
    public b a;
    public c b;
    public boolean c;
    private boolean d;
    private HashMap<String, e> e;

    private g() {
        this.a = new e().d;
        this.d = true;
        this.b = c.a(true, (byte) 1, (byte) 3);
        this.e = null;
        this.c = false;
        this.e = new HashMap();
    }

    public static final g a() {
        return i.a;
    }

    public final e a(String str) {
        if (a.a(str)) {
            return null;
        }
        e eVar;
        synchronized (this.e) {
            eVar = (e) this.e.get(str);
            if (eVar != null) {
                this.e.remove(str);
            }
        }
        return eVar;
    }

    public final void a(String str, com.uc.a.b.e eVar) {
        if ("sl_uc_param".equals(str)) {
            m.a("us", "test_us_cd_update", new String[0]);
            com.ucpro.business.d.a aVar = new com.ucpro.business.d.a();
            boolean[] zArr = new boolean[]{true};
            Runnable cVar = new c(this, aVar, eVar, zArr);
            Runnable hVar = new h(this, zArr, aVar);
            String a = a.a(a.a(this.b.a.a, "/us/"), "/ucparam.ucmd");
            this.d = false;
            File file = new File(r0);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File absolutePath : listFiles) {
                        if (absolutePath.getAbsolutePath().startsWith(a)) {
                            this.d = true;
                            break;
                        }
                    }
                }
            }
            if (this.d) {
                com.ucweb.common.util.h.m.a(0, cVar, hVar);
                return;
            }
            cVar.run();
            hVar.run();
        }
    }

    public final String b(String str) {
        return (String) this.a.get(str);
    }

    public final String a(String str, String str2) {
        String str3 = (String) this.a.get(str);
        return str3 == null ? str2 : str3;
    }

    public final long a(String str, long j) {
        try {
            j = Long.valueOf(b(str)).longValue();
        } catch (Exception e) {
        }
        return j;
    }

    public final int a(String str, int i) {
        try {
            i = Integer.valueOf(b(str)).intValue();
        } catch (Exception e) {
        }
        return i;
    }

    public final boolean c(String str) {
        String b = b(str);
        try {
            if (!a.a(b)) {
                return Boolean.valueOf(b).booleanValue();
            }
        } catch (Exception e) {
            com.ucweb.common.util.c.a("getUcParamBooleanValue catch exception");
        }
        return true;
    }

    public final void a(String str, e eVar) {
        if (!TextUtils.isEmpty(str) && eVar != null) {
            this.e.put(str, eVar);
        }
    }

    public final void d(String str) {
        if (!TextUtils.isEmpty(str) && this.e.containsKey(str)) {
            this.e.remove(str);
        }
    }

    static /* synthetic */ void b(g gVar) {
        HashMap hashMap = new e().d;
        hashMap.put("test", "default_test");
        hashMap.put("ad_block_rule_url", "default_ad_block_rule_url");
        gVar.a = hashMap;
    }

    static /* synthetic */ void c(g gVar) {
        Runnable dVar = new d(gVar, gVar.a.a.c());
        if (gVar.d) {
            com.ucweb.common.util.h.m.a(0, dVar);
        } else {
            dVar.run();
        }
    }
}
