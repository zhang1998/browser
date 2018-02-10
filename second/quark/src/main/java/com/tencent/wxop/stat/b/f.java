package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.a.s;
import com.tencent.wxop.stat.ai;
import com.tencent.wxop.stat.i;
import org.json.JSONObject;

public final class f extends d {
    public static final ai a;

    static {
        ai aiVar = new ai();
        a = aiVar;
        aiVar.a = "A9VH9B8L4GX4";
    }

    public f(Context context) {
        super(context, 0, a);
    }

    public final boolean a(JSONObject jSONObject) {
        s.a(jSONObject, "actky", i.a(this.l));
        return true;
    }

    public final e b() {
        return e.NETWORK_DETECTOR;
    }
}
