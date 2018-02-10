package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.a.c;
import com.tencent.wxop.stat.a.n;
import com.tencent.wxop.stat.ai;
import org.json.JSONObject;

public final class i extends d {
    private c a;
    private JSONObject n = null;

    public i(Context context, int i, JSONObject jSONObject, ai aiVar) {
        super(context, i, aiVar);
        this.a = new c(context);
        this.n = jSONObject;
    }

    public final boolean a(JSONObject jSONObject) {
        if (this.e != null) {
            jSONObject.put("ut", this.e.c);
        }
        if (this.n != null) {
            jSONObject.put("cfg", this.n);
        }
        if (n.v(this.l)) {
            jSONObject.put("ncts", 1);
        }
        this.a.a(jSONObject, null);
        return true;
    }

    public final e b() {
        return e.SESSION_ENV;
    }
}
