package com.ucpro.feature.lightapp.channelpage;

import org.json.JSONObject;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ c b;

    g(c cVar, JSONObject jSONObject) {
        this.b = cVar;
        this.a = jSONObject;
    }

    public final void run() {
        this.b.a.a(this.a.optString("articleId"), this.a.optString("url"));
    }
}
