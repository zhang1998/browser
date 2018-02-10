package com.uc.a.d;

import com.uc.a.b.a;
import com.uc.a.b.c;
import com.uc.a.b.g;
import com.uc.a.b.i;
import com.uc.a.b.j;
import com.uc.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class ad extends k {
    a d = new a();
    com.uc.a.b.k e = new com.uc.a.b.k();
    i f = new i();
    c g = new c();

    ad() {
        this.a.put("extend_kv", new HashMap());
        this.a.put("res_states", new HashMap());
    }

    public final void c(String str, String str2) {
        a("extend_kv", str, str2);
    }

    public final void d(String str, String str2) {
        a("res_states", str, str2);
    }

    private static void a(ArrayList<g> arrayList, HashMap<String, String> hashMap) {
        if (arrayList != null && hashMap != null && !hashMap.isEmpty()) {
            for (Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (!(str == null || str2 == null)) {
                    com.uc.base.b.c.c cVar;
                    com.uc.base.b.c.c cVar2;
                    g gVar = new g();
                    if (str == null) {
                        cVar = null;
                    } else {
                        cVar = com.uc.base.b.c.c.a(str);
                    }
                    gVar.a = cVar;
                    if (str2 == null) {
                        cVar2 = null;
                    } else {
                        cVar2 = com.uc.base.b.c.c.a(str2);
                    }
                    gVar.b = cVar2;
                    arrayList.add(gVar);
                }
            }
        }
    }

    public final byte[] f() {
        com.uc.base.b.c.c cVar;
        byte[] bArr = null;
        w.a("us req serialize body, req us server url:" + b("req_url"));
        j jVar = new j();
        com.uc.a.b.k kVar = this.e;
        if (kVar != null) {
            jVar.a = kVar;
            w.a("us req serialize body, req us pack Info:" + kVar.toString());
        }
        a aVar = this.d;
        if (aVar != null) {
            jVar.b = aVar;
            w.a("us req serialize body, req us mobile info:" + aVar.toString());
        }
        String b = b("ext_param");
        if (b == null) {
            cVar = null;
        } else {
            cVar = com.uc.base.b.c.c.a(b);
        }
        jVar.c = cVar;
        w.a("us req upload ext_param:" + b);
        b = b("cp_param");
        if (b == null) {
            cVar = null;
        } else {
            cVar = com.uc.base.b.c.c.a(b);
        }
        jVar.j = cVar;
        w.a("us req upload cp_param:" + b);
        jVar.e = com.uc.base.b.c.c.a.a(b("pop_flag"), 1);
        jVar.i = com.uc.base.b.c.c.a.a(b("zip_capable"), 1);
        ArrayList arrayList = jVar.d;
        HashMap a = a("res_states");
        a(arrayList, a);
        w.a("us req upload res_states>>>");
        w.a(a);
        arrayList = jVar.f;
        a = a("extend_kv");
        a(arrayList, a);
        w.a("us req upload extends key_value>>>");
        w.a(a);
        if (com.uc.base.b.c.c.a.a(b("li_close_flag"), 1) == 0) {
            i iVar = this.f;
            if (iVar != null) {
                jVar.g = iVar;
            }
        }
        c cVar2 = this.g;
        if (cVar2 != null) {
            jVar.h = cVar2;
        }
        byte[] l_ = jVar.l_();
        if (l_ != null) {
            String b2 = b("req_url");
            if (b2 == null || b2.length() == 0) {
                b2 = "";
            } else {
                int indexOf = b2.indexOf("://");
                if (indexOf > 0) {
                    b2 = b2.substring(0, indexOf);
                } else {
                    b2 = "";
                }
            }
            b2.equalsIgnoreCase("https");
            if (l_ != null) {
                byte[] bArr2 = new byte[16];
                bArr2[0] = (byte) 91;
                bArr2[2] = (byte) 0;
                bArr2[3] = (byte) -58;
                bArr = com.uc.a.c.a(bArr2, l_);
                w.a("us req pack body, data length=" + (bArr != null ? bArr.length : 0));
                w.a(bArr);
            }
        }
        return bArr;
    }
}
