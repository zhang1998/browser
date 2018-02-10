package com.uc.a.d;

import com.uc.a.b.k;
import com.uc.a.e.a;
import com.uc.base.b.c.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class o implements a {
    private Map<String, String> a;
    private int b;
    private int c;
    private ae d;

    public o(Map<String, String> map, int i, int i2) {
        if (map == null) {
            throw new AssertionError("paramMap can't be null");
        }
        this.a = map;
        this.b = i;
        this.c = i2;
        this.d = null;
    }

    public final void a(k kVar) {
        c cVar;
        c cVar2 = null;
        kVar.a((String) this.a.get("sn"));
        String str = (String) this.a.get("utdid");
        if (str == null) {
            cVar = null;
        } else {
            cVar = c.a(str);
        }
        kVar.e = cVar;
        str = (String) this.a.get("aid");
        if (str == null) {
            cVar = null;
        } else {
            cVar = c.a(str);
        }
        kVar.f = cVar;
        kVar.h((String) this.a.get("lang"));
        kVar.b((String) this.a.get("fr"));
        kVar.c((String) this.a.get("version"));
        kVar.d((String) this.a.get("m_bid"));
        kVar.e((String) this.a.get("m_pfid"));
        kVar.f((String) this.a.get("m_bseq"));
        kVar.g((String) this.a.get("prd"));
        str = (String) this.a.get("btype");
        if (str == null) {
            cVar = null;
        } else {
            cVar = c.a(str);
        }
        kVar.b = cVar;
        str = (String) this.a.get("bmode");
        if (str == null) {
            cVar = null;
        } else {
            cVar = c.a(str);
        }
        kVar.c = cVar;
        kVar.i((String) this.a.get("pver"));
        str = (String) this.a.get("subver");
        if (str == null) {
            cVar = null;
        } else {
            cVar = c.a(str);
        }
        kVar.d = cVar;
        str = (String) this.a.get("bidf");
        if (str == null) {
            cVar = null;
        } else {
            cVar = c.a(str);
        }
        kVar.g = cVar;
        str = (String) this.a.get(ai.e);
        if (str != null) {
            cVar2 = c.a(str);
        }
        kVar.h = cVar2;
    }

    public final void a(com.uc.a.b.a aVar) {
        aVar.a((String) this.a.get(ai.a));
        aVar.b((String) this.a.get("useragent"));
        aVar.c((String) this.a.get(ai.c));
        aVar.a = this.b;
        aVar.b = this.c;
    }

    public final Map<String, String> a() {
        Map<String, String> hashMap = new HashMap();
        if (this.d != null) {
            String a = this.d.a();
            String b = this.d.b();
            String c = this.d.c();
            if (!(a == null && b == null && c == null)) {
                hashMap.put("gps_country", a);
                hashMap.put("gps_province", b);
                hashMap.put("gps_city", c);
            }
        }
        return hashMap;
    }

    public final String a(String str) {
        if (!("yz".equals(str) || "hz".equals(str))) {
            "tp".equals(str);
        }
        return "";
    }
}
