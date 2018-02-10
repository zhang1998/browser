package com.ucpro.services.d.a;

import android.util.Log;
import com.uc.quark.n;
import com.uc.quark.s;
import com.uc.quark.x;
import com.ucpro.services.d.b.b;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.n.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public abstract class u<T extends b> implements k, m<T> {
    public String a;
    public List<T> b;
    protected i<T> c;
    private String d;

    public abstract T a(T t, JSONArray jSONArray) throws Exception;

    public abstract void a(List<T> list);

    public u(String str) {
        this.a = str;
        this.c = new i(str, this);
        m.a(0, new g(this));
    }

    private List<T> b(String str) {
        if (a.a(str)) {
            return null;
        }
        List<T> arrayList = new ArrayList();
        try {
            com.ucpro.c.b.b();
            JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                b b = b();
                b.q = jSONObject.optString("data_id");
                b.r = jSONObject.optString("data_type");
                b.p = jSONObject.optString("test_id");
                b.u = jSONObject.optString("img_pack");
                b.v = jSONObject.optString("chk_sum");
                b.s = jSONObject.optLong("start_time");
                b.t = jSONObject.optLong("end_time");
                a(b, jSONObject.getJSONArray("items"));
                arrayList.add(b);
            }
            com.ucpro.c.b.b();
            return arrayList;
        } catch (Throwable e) {
            if (!com.ucpro.c.b.b()) {
                return null;
            }
            Log.e("CMS_LOG", "CMS json data parse error " + Log.getStackTraceString(e));
            return null;
        }
    }

    public final void c() {
        List arrayList = new ArrayList();
        arrayList.add(this.a);
        m.a(0, new n(this, arrayList));
    }

    public final void a(int i, String str, String str2) {
        if (a.c(str, this.a)) {
            com.ucpro.c.b.b();
            a(b(str2));
        }
    }

    public final List<T> d() {
        return this.c.a();
    }

    public final void b(List<T> list) {
        if (list != null) {
            m.a(0, new q(this, list));
        }
    }

    public final void a(String str) {
        m.a(0, new l(this, str));
    }

    public final void a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        s.a();
        this.d = stringBuilder.append(s.b()).append(str2).toString();
        n nVar = new n();
        nVar.e = this.d;
        nVar.a = str;
        nVar.d = str2;
        nVar.b = str;
        nVar.f = true;
        nVar.g = false;
        x.a().a(nVar.a()).a(new t(this)).k();
    }

    public void a(s sVar) {
    }

    public final void b(String str, String str2) {
        x.a().a(x.a(str, str2), this.d, str2, true);
    }

    public String a() {
        s.a();
        return s.b();
    }
}
