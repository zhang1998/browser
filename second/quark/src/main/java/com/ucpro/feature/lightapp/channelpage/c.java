package com.ucpro.feature.lightapp.channelpage;

import android.text.TextUtils;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.base.weex.l;
import com.ucpro.feature.lightapp.b.d;
import com.ucpro.feature.lightapp.d.b;
import com.ucweb.common.util.h.m;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class c extends l {
    final l a;

    public c(l lVar, com.ucpro.base.weex.c cVar) {
        super(cVar);
        this.a = lVar;
    }

    public final boolean b(String str, String str2, com.taobao.weex.bridge.c cVar) {
        if ("lightapp.openArticlePage".equals(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (TextUtils.isEmpty(jSONObject.optString("articleId"))) {
                    l.a(cVar, (Object) d.a("error_msg", "articleId is empty"), false);
                    return true;
                }
                m.a(2, new g(this, jSONObject));
                l.a(cVar, (Object) d.a("success_msg", "openArticlePage Success"), true);
                return true;
            } catch (JSONException e) {
                l.a(cVar, (Object) d.a("error_msg", "parmas is invalid json string"), false);
                return true;
            }
        } else if (!"lightapp.addToNavigation".equals(str)) {
            return false;
        } else {
            try {
                if (TextUtils.isEmpty(new JSONObject(str2).optString("url"))) {
                    l.a(cVar, (Object) d.a("error_msg", "url is empty"), false);
                    return true;
                }
                g.a().a(e.b, new Object[]{b.c(new JSONObject(str2).optString("url")).b, new JSONObject(str2).optString("url"), null, new a(this, cVar)});
                return true;
            } catch (JSONException e2) {
                l.a(cVar, (Object) d.a("error_msg", "parmas is invalid json string"), false);
                return true;
            }
        }
    }
}
