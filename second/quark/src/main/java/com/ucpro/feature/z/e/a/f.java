package com.ucpro.feature.z.e.a;

import com.uc.quark.s;
import com.ucpro.services.d.a.u;
import com.ucpro.services.d.b.b;
import com.ucweb.common.util.h.m;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class f extends u<b> {
    public f() {
        super("cms_qusou");
    }

    private static b a(b bVar, JSONArray jSONArray) throws Exception {
        if (jSONArray != null) {
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        bVar.a = jSONObject.optString("file_url");
                    }
                    i++;
                } catch (Exception e) {
                }
            }
        }
        return bVar;
    }

    protected final void a(List<b> list) {
        m.a(0, new a(this, list));
    }

    protected final void a(s sVar) {
        m.a(0, new e(this, sVar));
    }

    public final String a() {
        return super.a() + "Qusou/";
    }

    public final /* synthetic */ b b() {
        return new b();
    }
}
