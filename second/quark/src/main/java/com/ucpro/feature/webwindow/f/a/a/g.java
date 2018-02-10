package com.ucpro.feature.webwindow.f.a.a;

import android.text.TextUtils;
import com.uc.apollo.android.GuideDialog;
import com.uc.base.jssdk.a.c;
import com.uc.base.jssdk.i;
import com.uc.base.jssdk.q;
import com.uc.base.jssdk.t;
import com.ucpro.base.a.e;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucweb.common.util.n.a;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class g implements c {
    private static final String a = g.class.getSimpleName();

    private static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", 100);
            jSONObject.put("error_msg", str);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public final String a(String str, JSONObject jSONObject, t tVar) {
        if (a.c(str, "bookmark.addNaviBookmark")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("site");
            if (optJSONObject == null) {
                tVar.a(new q(i.d, a("site Json Obj is null")));
            }
            String optString = optJSONObject.optString(GuideDialog.TITLE);
            if (a.a(optString)) {
                tVar.a(new q(i.d, a("title is null")));
            }
            String optString2 = optJSONObject.optString("url");
            if (a.a(optString2)) {
                tVar.a(new q(i.d, a("url is null")));
            }
            if (a.a(optJSONObject.optString("image"))) {
                tVar.a(new q(i.d, a("image is null")));
            }
            a aVar = new a(this, tVar);
            if (!(TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2))) {
                s.a().a(m.a(optString, optString2), new o(this));
            }
            com.ucpro.base.a.g.a().a(e.b, new Object[]{optString, optString2, r0, aVar});
        } else if (a.c(str, "base.addBookmark") && jSONObject != null) {
            Object optString3 = jSONObject.optString(GuideDialog.TITLE);
            Object optString4 = jSONObject.optString("url");
            if (!(TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4))) {
                s.a().a(m.a(optString3, optString4), new d(this, tVar));
            }
        }
        return "";
    }

    public final boolean a() {
        com.ucpro.feature.webwindow.f.a.a.a;
        return true;
    }
}
