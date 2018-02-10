package com.ucpro.feature.s.a;

import com.uc.quark.s;
import com.ucpro.model.keepproguard.discnavi.DiscoveryNavigationData;
import com.ucpro.services.d.a.u;
import com.ucpro.services.d.b.b;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.k.a;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class g extends u<a> {
    private d d;
    private String e;

    private g() {
        super("cms_navi_reco");
    }

    public static g e() {
        return b.a;
    }

    private static a a(a aVar, JSONArray jSONArray) throws Exception {
        if (jSONArray != null) {
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        aVar.a = jSONObject.optString("file_url");
                    }
                    i++;
                } catch (Exception e) {
                }
            }
        }
        return aVar;
    }

    protected final void a(List<a> list) {
        m.a(0, new e(this, list));
    }

    protected final String a() {
        return super.a() + "discovernavi/";
    }

    protected final void a(s sVar) {
        m.a(0, new h(this, sVar));
    }

    public final DiscoveryNavigationData f() {
        if (this.d == null) {
            this.d = new d(g());
        }
        return this.d;
    }

    private String g() {
        try {
            return a.g(new File(a() + "navi.json"));
        } catch (IOException e) {
            return "";
        }
    }

    public final String b(String str) {
        if (com.ucweb.common.util.n.a.a(this.e)) {
            this.e = a();
        }
        return this.e + "image/" + str;
    }

    public final /* synthetic */ b b() {
        return new a();
    }
}
