package com.ucpro.feature.webwindow.f.a.a;

import android.text.TextUtils;
import com.uc.apollo.android.GuideDialog;
import com.uc.base.jssdk.a.c;
import com.uc.base.jssdk.i;
import com.uc.base.jssdk.q;
import com.uc.base.jssdk.t;
import com.uc.encrypt.f;
import com.uc.quark.x;
import com.uc.quark.y;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.m;
import com.ucpro.feature.d.a.b;
import com.ucpro.feature.webwindow.b.a.d;
import com.ucweb.c.b.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class n implements c {
    private static void a(String str, String str2, String str3) {
        int i = com.ucweb.c.a.c.c;
        a aVar = new a();
        aVar.a = str3;
        aVar.c = str2;
        aVar.b = str;
        aVar.d = i;
        g.a().a(e.bC, aVar.a());
    }

    private static q a(String str, String str2, String str3, String str4) {
        com.uc.quark.n nVar = new com.uc.quark.n();
        nVar.a = str;
        nVar.d = null;
        nVar.b = str;
        nVar.e = b.a();
        nVar.f = true;
        nVar.g = false;
        y a = nVar.a();
        if (a == null) {
            return new q(i.d, "");
        }
        x.a().a(a).a(new i(str4, str3, str2)).k();
        return new q(i.a, "");
    }

    public final String a(String str, JSONObject jSONObject, t tVar) {
        q qVar = null;
        String optString;
        String optString2;
        Object optString3;
        Object optString4;
        if ("biz.share".equals(str)) {
            if (jSONObject == null || jSONObject.length() == 0) {
                qVar = new q(i.d, "");
            } else {
                String optString5 = jSONObject.optString(GuideDialog.TITLE);
                optString = jSONObject.optString("content");
                optString2 = jSONObject.optString("sourceUrl");
                String optString6 = jSONObject.optString("url");
                optString3 = jSONObject.optString("imageUrl");
                optString4 = jSONObject.optString("iconUrl");
                if (!TextUtils.isEmpty(optString3)) {
                    a(optString3, optString5, optString, optString2);
                }
                if (!TextUtils.isEmpty(optString4)) {
                    a(optString4, optString5, optString, optString2);
                }
                if (!TextUtils.isEmpty(optString2)) {
                    a(optString5, optString, optString2);
                }
                if (!TextUtils.isEmpty(optString6)) {
                    a(optString5, optString, optString6);
                }
                if (!TextUtils.isEmpty(optString)) {
                    int i = com.ucweb.c.a.c.e;
                    a aVar = new a();
                    aVar.a = optString2;
                    aVar.c = optString;
                    aVar.b = optString5;
                    aVar.d = i;
                    g.a().a(e.bC, aVar.a());
                }
                qVar = new q(i.a, "");
            }
        } else if ("biz.encryptOrDecrypt".equals(str)) {
            qVar = a(jSONObject);
        } else if ("biz.commonStat".equals(str)) {
            com.ucpro.feature.webwindow.f.i iVar = new com.ucpro.feature.webwindow.f.i(jSONObject);
            if (TextUtils.isEmpty(iVar.a) || TextUtils.isEmpty(iVar.b) || TextUtils.isEmpty(iVar.c)) {
                qVar = new q(i.d, "");
            } else {
                optString = iVar.b;
                optString2 = iVar.c;
                HashMap hashMap = iVar.d;
                if (!(optString2 == null || optString == null)) {
                    m.a(optString, optString2, hashMap);
                }
                qVar = new q(i.a, "");
            }
        } else if ("biz.openPicViewer".endsWith(str)) {
            List arrayList = new ArrayList();
            if (jSONObject.has("data")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    optString3 = optJSONObject.optString(GuideDialog.TITLE);
                    optString4 = optJSONObject.optString("picUrl");
                    if (TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4)) {
                        qVar = new q(i.d, "");
                        break;
                    }
                    arrayList.add(new com.ucpro.feature.webwindow.b.a.c(optString3, optString4, 2 == optJSONObject.optInt("itemType") ? com.ucpro.feature.webwindow.b.a.b.a : com.ucpro.feature.webwindow.b.a.b.b));
                }
            }
            int optInt = jSONObject.optInt("index");
            if (!arrayList.isEmpty()) {
                Object dVar = new d(arrayList);
                dVar.b = optInt;
                g.a().a(e.cq, dVar);
            }
            qVar = new q(i.a, "");
        }
        if (!(tVar == null || qVar == null)) {
            tVar.a(qVar);
        }
        return "";
    }

    private static q a(JSONObject jSONObject) {
        int i;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        int i2 = com.uc.encrypt.a.b;
        if (jSONObject.optInt("enc") == 1) {
            i = com.uc.encrypt.a.c;
        } else {
            i = i2;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (optJSONObject != null && optJSONObject.length() > 0) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String optString = optJSONObject.optString(str);
                try {
                    if (jSONObject.optInt("type") == 1) {
                        jSONObject2.put(str, f.a(optString, i));
                    } else {
                        jSONObject2.put(str, a(optString, i));
                    }
                } catch (JSONException e) {
                }
            }
        }
        return new q(i.a, jSONObject2);
    }

    private static String a(String str, int i) {
        try {
            byte[] b = f.b(com.ucpro.b.b.a.a(str), i);
            if (b != null) {
                return new String(b, "utf-8");
            }
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public final boolean a() {
        com.ucpro.feature.webwindow.f.a.a.a;
        return true;
    }
}
