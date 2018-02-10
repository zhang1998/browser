package com.ucpro.feature.lightapp.e;

import android.content.Context;
import android.text.TextUtils;
import com.quark.browser.R;
import com.uc.apollo.android.GuideDialog;
import com.uc.weex.h.o;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.base.c.b.m;
import com.ucpro.base.weex.c;
import com.ucpro.feature.webwindow.aj;
import com.ucpro.ui.c.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class b extends g {
    public final Context a;
    public final com.ucpro.feature.lightapp.d.b b;
    public final String c;
    public String d;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public o m;
    private final h n;

    public b(Context context, m mVar, com.ucpro.feature.lightapp.d.b bVar, String str, h hVar, c cVar) {
        super(mVar, cVar);
        this.a = context;
        this.b = bVar;
        this.c = str;
        this.n = hVar;
    }

    public final void i() {
        if (!TextUtils.isEmpty(this.d)) {
            Object ajVar = new aj();
            ajVar.o = this.d;
            ajVar.t = true;
            ajVar.s = aj.n;
            g.a().a(e.k, ajVar);
        }
    }

    protected final void a() {
        if (!(this.f == null || this.n == null)) {
            this.n.a();
        }
        if (this.m != null) {
            this.m.d();
            this.m = null;
        }
        a(null);
    }

    public final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.l = jSONObject.optString("articleId");
            this.d = jSONObject.optString("webUrl");
            this.h = jSONObject.optString(GuideDialog.TITLE);
            this.i = jSONObject.optString("snippet");
            this.j = jSONObject.optString("providerName");
        } catch (JSONException e) {
        }
    }

    public final void b(String str) {
        if (str != null) {
            String d = a.d((int) R.string.lightapp_copyright_report);
            String str2 = "";
            try {
                str2 = a.d((int) R.string.lightapp_report_tip) + new JSONObject(str).getString(GuideDialog.TITLE);
            } catch (Exception e) {
            }
            String str3 = "[轻应用版权]:" + str + " ";
            g.a().a(e.S, new String[]{str3, d, str2});
        }
    }

    public final String b() {
        if (this.b != null) {
            return this.b.b;
        }
        return "";
    }

    public final String c() {
        return this.k;
    }
}
