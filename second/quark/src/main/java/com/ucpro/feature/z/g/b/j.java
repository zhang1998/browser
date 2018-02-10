package com.ucpro.feature.z.g.b;

import com.ucpro.services.d.a.u;
import com.ucpro.services.d.b.b;
import com.ucweb.common.util.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class j extends u<l> {
    private static final String d = j.class.getSimpleName();

    public j() {
        super("cms_search_engine");
    }

    private static l a(l lVar, JSONArray jSONArray) throws Exception {
        c.a((Object) lVar);
        c.a((Object) jSONArray);
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                m mVar = new m();
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("id");
                    String string2 = jSONObject.getString("url");
                    mVar.a = string;
                    mVar.b = string2;
                    lVar.a.add(mVar);
                } catch (JSONException e) {
                }
            }
        }
        return lVar;
    }

    protected final void a(List<l> list) {
        boolean z = true;
        if (list != null) {
            if (list.size() != 1) {
                z = false;
            }
            c.b(z);
            l lVar = (l) list.get(0);
            if (lVar != null) {
                Object obj = lVar.a;
                c.a(obj);
                if (obj != null) {
                    Iterator it = obj.iterator();
                    while (it.hasNext()) {
                        m mVar = (m) it.next();
                        new StringBuilder("update engine: ").append(mVar.a).append(" : ").append(mVar.b);
                        n nVar = n.b;
                        n.a(mVar.a, mVar.b);
                    }
                }
            }
        }
    }

    public final /* synthetic */ b b() {
        return new l();
    }
}
