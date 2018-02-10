package com.ucpro.feature.z.g.a;

import com.ucpro.business.stat.m;
import com.ucweb.common.util.c;
import java.net.URLEncoder;
import java.util.ArrayList;
import okhttp3.Request;
import okhttp3.Request.Builder;
import org.json.JSONArray;

/* compiled from: ProGuard */
public final class g implements d {
    public final void a(String str, a aVar) {
        c.a((CharSequence) str);
        c.a((Object) aVar);
        Request build = new Builder().url("http://www.google.com/complete/search?hl=en&client=android&q=" + URLEncoder.encode(str)).get().build();
        com.ucpro.services.f.g.a().newCall(build).enqueue(new c(this, aVar, str));
    }

    static ArrayList<b> a(String str) {
        c.a((CharSequence) str);
        ArrayList<b> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = (JSONArray) new JSONArray(str).get(1);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.uc.base.b.c.c cVar;
                    b bVar = new b();
                    String string = jSONArray.getString(i);
                    bVar.a = 0;
                    if (string == null) {
                        cVar = null;
                    } else {
                        cVar = com.uc.base.b.c.c.a(string);
                    }
                    bVar.b = cVar;
                    arrayList.add(bVar);
                }
            }
        } catch (Exception e) {
            m.a(h.a, h.c, new String[0]);
        }
        return arrayList;
    }
}
