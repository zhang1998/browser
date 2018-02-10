package com.uc.a.d;

import android.text.TextUtils;
import com.uc.a.e;
import com.uc.a.k;
import com.uc.base.b.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class ac {
    protected ad a;

    public final void a(String str, int i, int i2, String str2) {
        this.a = new ad();
        this.a.e();
        this.a.a(e.a);
        this.a.b(i2);
        this.a.a("update_type", str2);
        this.a.a("server_type", String.valueOf(i));
        if (TextUtils.isEmpty(str) && i == 0) {
            this.a.a("req_url", "http://ucus.ucweb.com/usquery.php");
        } else {
            this.a.a("req_url", str);
        }
        k kVar = this.a;
        if (kVar != null) {
            t.a;
            kVar.b("User-Agent", "");
            kVar.b("Accept-Language", a.a.a());
            kVar.b("Accept", "application/xml,application/vnd.wap.xhtml+xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
            kVar.b("Connection", "close");
            kVar.b("Content-Type", "application/octet-stream");
        }
        h.a.a();
        Map a = h.a.a().a();
        if (!a.isEmpty()) {
            for (Entry entry : a.entrySet()) {
                this.a.c((String) entry.getKey(), (String) entry.getValue());
            }
        }
        h.a.a().a(this.a.d);
        h.a.a().a(this.a.e);
        h.a.a();
        h.a.a();
    }

    public final void a(ArrayList<ah> arrayList, boolean z) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ah ahVar = (ah) it.next();
                if (ahVar != null) {
                    this.a.d(ahVar.b, ahVar.c);
                }
            }
        }
        if (z) {
            this.a.d("null", "null");
        }
    }

    public final ac a(String str, String str2) {
        if (!(TextUtils.isEmpty(str) || str2 == null)) {
            this.a.c(str, str2);
        }
        return this;
    }

    public final void a(g gVar) {
        if (gVar != null) {
            Object obj = gVar.e;
            if (!TextUtils.isEmpty(obj)) {
                String[] split = obj.split(",");
                if (split != null) {
                    for (String trim : split) {
                        String trim2 = trim2.trim();
                        if (!TextUtils.isEmpty(trim2)) {
                            if ("as".equals(trim2)) {
                                this.a.c("as", "0001");
                            } else if ("yz".equals(trim2) || "hz".equals(trim2) || "tp".equals(trim2)) {
                                this.a.c(trim2, h.a.a().a(trim2));
                            } else if ("am".equals(trim2)) {
                                h.a.a();
                            }
                        }
                    }
                }
            }
        }
    }

    public final ad a() {
        return this.a;
    }
}
