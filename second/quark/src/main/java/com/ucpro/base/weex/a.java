package com.ucpro.base.weex;

import android.os.Message;
import com.uc.weex.o;
import com.ucpro.base.a.j;
import com.ucpro.base.e.e;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a extends e {
    public final void a(int i, Message message) {
        int i2 = com.ucpro.base.a.e.bP;
    }

    public final void b(int i, Message message) {
        if (j.f == i) {
            o.a.a("themeChange", com.ucpro.base.weex.a.a.a());
        }
    }

    public final void q_() {
        super.q_();
        a(true);
    }

    public final void v_() {
        super.v_();
        a(false);
    }

    private static void a(boolean z) {
        if (f.a().a) {
            int i = z ? 1 : 0;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", i);
            } catch (JSONException e) {
            }
            o.a.a("appStateChange", jSONObject.toString());
        }
    }
}
