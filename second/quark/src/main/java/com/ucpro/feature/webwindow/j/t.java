package com.ucpro.feature.webwindow.j;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.uc.webview.export.WebView;
import com.ucweb.common.util.h.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class t implements ValueCallback<String> {
    final /* synthetic */ WebView a;
    final /* synthetic */ j b;

    t(j jVar, WebView webView) {
        this.b = jVar;
        this.a = webView;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        p pVar = this.b.a.a.c;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        new StringBuilder("updateAllRule start to iterator JSONArray, \ntotal length: ").append(jSONArray.length());
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            n nVar = null;
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("host");
                                long optLong = optJSONObject.optLong("firstCreateTime");
                                int optInt = optJSONObject.optInt("blockCounter");
                                int optInt2 = optJSONObject.optInt("ruleCounter");
                                nVar = new n(optString, optLong, optInt, optInt2);
                                new StringBuilder("parserRule success\nhostname is: ").append(optString).append("\nfirstCreatTime is: ").append(optLong).append("\nblockCounter is: ").append(optInt).append("\nruleCounter is: ").append(optInt2).append("\n");
                            }
                            if (nVar != null) {
                                new StringBuilder("updateAllRule parserRule Success \n rule host is: ").append(nVar.a);
                                pVar.a.add(nVar);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
            }
        }
        m.a(2, new o(this));
        this.a.destroy();
    }
}
