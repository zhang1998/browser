package com.ucpro.feature.webwindow.f.a.a;

import android.webkit.ValueCallback;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.jssdk.i;
import com.uc.base.jssdk.q;
import com.uc.base.jssdk.t;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class a implements ValueCallback<Boolean> {
    final /* synthetic */ t a;
    final /* synthetic */ g b;

    a(g gVar, t tVar) {
        this.b = gVar;
        this.a = tVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Boolean bool = (Boolean) obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", bool.booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE);
        } catch (JSONException e) {
            this.a.a(new q(i.e, e.getMessage()));
        }
        this.a.a(new q(i.a, jSONObject));
    }
}
