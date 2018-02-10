package com.ucpro.feature.setting.c.a;

import com.ucpro.services.d.a.u;
import com.ucpro.services.d.b.b;
import com.ucweb.common.util.h.m;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class e extends u<a> {
    private e() {
        super("cms_quest_survey");
    }

    public static e e() {
        return c.a;
    }

    private static a a(a aVar, JSONArray jSONArray) throws Exception {
        if (jSONArray != null) {
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        aVar.b = jSONObject.optString("web_url");
                        aVar.a = jSONObject.optString("quest_title");
                    }
                    i++;
                } catch (Exception e) {
                }
            }
        }
        return aVar;
    }

    protected final void a(List<a> list) {
        m.a(0, new b(this, list));
    }

    public final /* synthetic */ b b() {
        return new a();
    }
}
