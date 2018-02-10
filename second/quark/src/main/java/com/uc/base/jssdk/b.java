package com.uc.base.jssdk;

import com.uc.base.jssdk.a.c;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ String b;
    final /* synthetic */ JSONObject c;
    final /* synthetic */ int d;
    final /* synthetic */ String e;
    final /* synthetic */ t f;
    final /* synthetic */ g g;

    b(g gVar, c cVar, String str, JSONObject jSONObject, int i, String str2, t tVar) {
        this.g = gVar;
        this.a = cVar;
        this.b = str;
        this.c = jSONObject;
        this.d = i;
        this.e = str2;
        this.f = tVar;
    }

    public final void run() {
        this.a.a(this.b, this.c, this.f);
    }
}
