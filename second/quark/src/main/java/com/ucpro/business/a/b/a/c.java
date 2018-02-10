package com.ucpro.business.a.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.uc.quark.s;
import com.ucpro.c.b;
import com.ucpro.services.d.a.u;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.j.a;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class c extends u<f> {
    public c() {
        super("cms_quark_anim_doodle");
    }

    private static f a(f fVar, JSONArray jSONArray) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        fVar.a = jSONObject.optString("file_url");
                        fVar.b = jSONObject.optString("url");
                        fVar.i = jSONObject.optString("data_info");
                    }
                    i++;
                } catch (Exception e) {
                }
            }
        }
        return fVar;
    }

    protected final void a(List<f> list) {
        this.b = list;
        if (list.size() > 0) {
            long j = ((f) list.get(0)).s;
            long j2 = ((f) list.get(0)).t;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String str = ((f) list.get(0)).a;
            a.a(d.a(), "CCB980D06D447B10", "B411CA4761F80005", j);
            a.a(d.a(), "CCB980D06D447B10", "3E5817A5ED67410E", j2);
            if (!com.ucweb.common.util.n.a.a(str) && !TextUtils.isEmpty(str)) {
                List d = d();
                if (currentTimeMillis >= j2) {
                    if (!(d == null || d.isEmpty() || d.get(0) == null)) {
                        m.a(0, new b(this));
                    }
                    a(this.a);
                    b(str, com.ucweb.common.util.l.d.a(str, ""));
                } else if (d == null || d.isEmpty() || d.get(0) == null || TextUtils.isEmpty(((f) d.get(0)).d) || TextUtils.isEmpty(((f) d.get(0)).a) || !((f) d.get(0)).a.equals(str)) {
                    b((List) list);
                    a(str, com.ucweb.common.util.l.d.a(str, ""));
                }
            }
        }
    }

    protected final String a() {
        return super.a() + "AnimDoodle/";
    }

    protected final void a(s sVar) {
        if (b.b()) {
            Log.e("vanda", "onDownloadComplete" + sVar.h());
        }
        m.a(0, new e(this, sVar));
    }

    public final /* synthetic */ com.ucpro.services.d.b.b b() {
        return new f();
    }
}
