package com.a.a.a;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class dz implements ed {
    private static dz c = null;
    int a = 0;
    private final long b = 60000;

    public static synchronized dz a(Context context) {
        dz dzVar;
        synchronized (dz.class) {
            if (c == null) {
                c = new dz();
                c.a(bb.a(context).c.b());
            }
            dzVar = c;
        }
        return dzVar;
    }

    private dz() {
    }

    public final void a(JSONObject jSONObject, Context context) {
        bx a;
        cl clVar;
        if (this.a == 1) {
            jSONObject.remove("error");
            jSONObject.remove("ekv");
            jSONObject.remove("gkv");
            jSONObject.remove("cc");
            aj.a(context).a(false, true);
            bx.c = context;
            a = bv.a;
            clVar = new cl();
            a.c();
        } else if (this.a == 2) {
            jSONObject.remove("sessions");
            try {
                jSONObject.put("sessions", b());
            } catch (Exception e) {
            }
            jSONObject.remove("error");
            jSONObject.remove("ekv");
            jSONObject.remove("gkv");
            jSONObject.remove("cc");
            aj.a(context).a(false, true);
            bx.c = context;
            a = bv.a;
            clVar = new cl();
            a.c();
        } else if (this.a == 3) {
            jSONObject.remove("sessions");
            jSONObject.remove("error");
            jSONObject.remove("ekv");
            jSONObject.remove("gkv");
            jSONObject.remove("cc");
            aj.a(context).a(false, true);
            bx.c = context;
            a = bv.a;
            clVar = new cl();
            a.c();
        }
    }

    private static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("id", em.a());
            jSONObject.put("start_time", currentTimeMillis);
            jSONObject.put("end_time", currentTimeMillis + 60000);
            jSONObject.put("duration", 60000);
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    private void a(int i) {
        if (i >= 0 && i <= 3) {
            this.a = i;
        }
    }

    public final boolean a() {
        return this.a != 0;
    }

    public final void a(ar arVar) {
        a(arVar.b());
    }
}
