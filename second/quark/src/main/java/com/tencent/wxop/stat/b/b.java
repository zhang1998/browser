package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.ah;
import com.tencent.wxop.stat.ai;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends d {
    protected a a = new a();
    private long n = -1;

    public b(Context context, int i, String str, ai aiVar) {
        super(context, i, aiVar);
        this.a.a = str;
    }

    public final a a() {
        return this.a;
    }

    public final boolean a(JSONObject jSONObject) {
        jSONObject.put("ei", this.a.a);
        if (this.n > 0) {
            jSONObject.put("du", this.n);
        }
        if (this.a.b == null) {
            if (this.a.a != null) {
                Map a = ah.a(this.a.a);
                if (a != null && a.size() > 0) {
                    if (this.a.c == null || this.a.c.length() == 0) {
                        this.a.c = new JSONObject(a);
                    } else {
                        for (Entry entry : a.entrySet()) {
                            try {
                                this.a.c.put(entry.getKey().toString(), entry.getValue());
                            } catch (JSONException e) {
                            }
                        }
                    }
                }
            }
            jSONObject.put("kv", this.a.c);
        } else {
            jSONObject.put("ar", this.a.b);
        }
        return true;
    }

    public final e b() {
        return e.CUSTOM;
    }
}
