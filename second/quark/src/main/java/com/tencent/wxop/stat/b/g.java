package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.a.n;
import com.tencent.wxop.stat.a.s;
import com.tencent.wxop.stat.ai;
import com.tencent.wxop.stat.d;
import org.json.JSONObject;

public final class g extends d {
    private static String n = null;
    public String a = null;
    private String o = null;

    public g(Context context, int i, ai aiVar) {
        super(context, i, aiVar);
        this.o = d.a(context).c;
        if (n == null) {
            n = n.i(context);
        }
    }

    public final boolean a(JSONObject jSONObject) {
        s.a(jSONObject, "op", n);
        s.a(jSONObject, "cn", this.o);
        jSONObject.put("sp", this.a);
        return true;
    }

    public final e b() {
        return e.NETWORK_MONITOR;
    }
}
