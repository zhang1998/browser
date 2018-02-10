package com.ucpro.business.a.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.uc.quark.s;
import com.ucpro.base.system.b;
import com.ucpro.services.d.a.u;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.j.a;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class i extends u<d> {
    public i() {
        super("cms_quark_doodle");
    }

    private static d a(d dVar, JSONArray jSONArray) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        dVar.a = jSONObject.optString("img_url");
                        dVar.b = jSONObject.optString("file_url");
                        dVar.c = jSONObject.optString("url");
                        dVar.g = jSONObject.optInt("size_width");
                        dVar.h = jSONObject.optInt("size_height");
                        dVar.i = jSONObject.optInt("inset_bottom");
                    }
                    i++;
                } catch (Exception e) {
                }
            }
        }
        return dVar;
    }

    protected final void a(List<d> list) {
        this.b = list;
        if (list.size() > 0) {
            long j = ((d) list.get(0)).s;
            long j2 = ((d) list.get(0)).t;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String str = ((d) list.get(0)).a;
            String str2 = ((d) list.get(0)).b;
            a.a(d.a(), "EF56CBD4C21765A2", "741A34F18FDD73CF", j);
            a.a(d.a(), "EF56CBD4C21765A2", "A9BACB8AB50784F2", j2);
            if ((!com.ucweb.common.util.n.a.a(str) || !com.ucweb.common.util.n.a.a(str2)) && !TextUtils.isEmpty(str2)) {
                List d = d();
                if (currentTimeMillis >= j2) {
                    if (!(d == null || d.isEmpty() || d.get(0) == null)) {
                        d dVar = (d) d.get(0);
                        if (!(dVar == null || TextUtils.isEmpty(dVar.e))) {
                            b.a.d(dVar.e);
                        }
                        if (!(dVar == null || TextUtils.isEmpty(dVar.f))) {
                            b.a.d(dVar.f);
                        }
                    }
                    a(this.a);
                    b(str2, com.ucweb.common.util.l.d.a(str2, ""));
                } else if (d == null || d.isEmpty() || d.get(0) == null || TextUtils.isEmpty(((d) d.get(0)).e) || TextUtils.isEmpty(((d) d.get(0)).b) || !((d) d.get(0)).b.equals(str2)) {
                    b((List) list);
                    a(str2, com.ucweb.common.util.l.d.a(str2, ""));
                }
            }
        }
    }

    protected final void a(s sVar) {
        if (com.ucpro.c.b.b()) {
            Log.e("vanda", "onDownloadComplete" + sVar.h());
        }
        m.a(0, new g(this, sVar));
    }

    public final /* synthetic */ com.ucpro.services.d.b.b b() {
        return new d();
    }
}
