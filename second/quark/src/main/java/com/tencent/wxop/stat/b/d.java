package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.b.a.a.a.h;
import com.tencent.wxop.stat.a.a;
import com.tencent.wxop.stat.a.n;
import com.tencent.wxop.stat.a.s;
import com.tencent.wxop.stat.ai;
import com.tencent.wxop.stat.as;
import com.tencent.wxop.stat.i;
import com.uc.apollo.impl.SettingsConst;
import org.json.JSONObject;

public abstract class d {
    protected static String j = null;
    protected String b = null;
    protected long c;
    protected int d;
    protected a e = null;
    protected int f;
    protected String g = null;
    protected String h = null;
    protected String i = null;
    protected boolean k = false;
    protected Context l;
    public ai m = null;

    d(Context context, int i, ai aiVar) {
        this.l = context;
        this.c = System.currentTimeMillis() / 1000;
        this.d = i;
        this.h = i.b(context);
        this.i = n.j(context);
        this.b = i.a(context);
        if (aiVar != null) {
            this.m = aiVar;
            if (n.c(aiVar.a)) {
                this.b = aiVar.a;
            }
            if (n.c(aiVar.b)) {
                this.h = aiVar.b;
            }
            if (n.c(aiVar.c)) {
                this.i = aiVar.c;
            }
            this.k = aiVar.e;
        }
        this.g = i.d(context);
        this.e = as.a(context).b(context);
        if (b() != e.NETWORK_DETECTOR) {
            this.f = n.q(context).intValue();
        } else {
            this.f = -e.NETWORK_DETECTOR.j;
        }
        if (!h.b(j)) {
            String e = i.e(context);
            j = e;
            if (!n.c(e)) {
                j = SettingsConst.FALSE;
            }
        }
    }

    private boolean b(JSONObject jSONObject) {
        boolean z = false;
        try {
            s.a(jSONObject, "ky", this.b);
            jSONObject.put("et", b().j);
            if (this.e != null) {
                jSONObject.put("ui", this.e.a);
                s.a(jSONObject, "mc", this.e.b);
                int i = this.e.c;
                jSONObject.put("ut", i);
                if (i == 0 && n.t(this.l) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            s.a(jSONObject, "cui", this.g);
            if (b() != e.SESSION_ENV) {
                s.a(jSONObject, "av", this.i);
                s.a(jSONObject, "ch", this.h);
            }
            if (this.k) {
                jSONObject.put("impt", 1);
            }
            s.a(jSONObject, "mid", j);
            jSONObject.put("idx", this.f);
            jSONObject.put("si", this.d);
            jSONObject.put("ts", this.c);
            jSONObject.put("dts", n.a(this.l, false));
            z = a(jSONObject);
        } catch (Throwable th) {
        }
        return z;
    }

    public abstract boolean a(JSONObject jSONObject);

    public abstract e b();

    public final long c() {
        return this.c;
    }

    public final Context d() {
        return this.l;
    }

    public final boolean e() {
        return this.k;
    }

    public final String f() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
