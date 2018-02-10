package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.a.s;
import com.tencent.wxop.stat.ai;
import org.json.JSONObject;

public final class h extends d {
    Long a = null;
    String n;
    String o;

    public h(Context context, String str, String str2, int i, Long l, ai aiVar) {
        super(context, i, aiVar);
        this.o = str;
        this.n = str2;
        this.a = l;
    }

    public final boolean a(JSONObject jSONObject) {
        s.a(jSONObject, "pi", this.n);
        s.a(jSONObject, "rf", this.o);
        if (this.a != null) {
            jSONObject.put("du", this.a);
        }
        return true;
    }

    public final e b() {
        return e.PAGE_VIEW;
    }
}
