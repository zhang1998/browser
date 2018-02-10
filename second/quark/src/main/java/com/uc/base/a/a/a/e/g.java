package com.uc.base.a.a.a.e;

import android.text.TextUtils;
import com.uc.base.a.a.a.d.a;
import com.uc.base.a.a.a.d.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ j c;

    g(j jVar, String str, c cVar) {
        this.c = jVar;
        this.a = str;
        this.b = cVar;
    }

    public final void run() {
        String str = null;
        b a = a.a(this.a);
        if (a.a != 200) {
            a.e = "获取微信TOKEN失败";
            this.b.b(a);
            return;
        }
        String optString;
        try {
            JSONObject jSONObject = new JSONObject(a.c);
            optString = jSONObject.optString("access_token");
            try {
                str = jSONObject.optString("openid");
            } catch (JSONException e) {
            }
        } catch (JSONException e2) {
            optString = str;
        }
        if (!TextUtils.isEmpty(optString)) {
            this.c.a(l.WECHAT, optString, str, this.b);
        }
    }
}
