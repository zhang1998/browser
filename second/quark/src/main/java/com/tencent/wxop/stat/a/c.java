package com.tencent.wxop.stat.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.wxop.stat.as;
import com.tencent.wxop.stat.d;
import com.tencent.wxop.stat.i;
import com.uc.webview.browser.interfaces.SettingKeys;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    static b a;
    private static p d = n.c();
    private static JSONObject e = new JSONObject();
    Integer b = null;
    String c = null;

    public c(Context context) {
        try {
            a(context);
            this.b = n.l(context.getApplicationContext());
            this.c = d.a(context).c;
        } catch (Throwable th) {
            d.b(th);
        }
    }

    private static synchronized b a(Context context) {
        b bVar;
        synchronized (c.class) {
            if (a == null) {
                a = new b(context.getApplicationContext());
            }
            bVar = a;
        }
        return bVar;
    }

    public final void a(JSONObject jSONObject, Thread thread) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (a != null) {
                b bVar = a;
                if (thread == null) {
                    if (bVar.c != null) {
                        jSONObject2.put("sr", bVar.c.widthPixels + "*" + bVar.c.heightPixels);
                        jSONObject2.put("dpi", bVar.c.xdpi + "*" + bVar.c.ydpi);
                    }
                    if (d.a(bVar.o).a()) {
                        JSONObject jSONObject3 = new JSONObject();
                        s.a(jSONObject3, "bs", s.c(bVar.o));
                        s.a(jSONObject3, "ss", s.d(bVar.o));
                        if (jSONObject3.length() > 0) {
                            s.a(jSONObject2, "wf", jSONObject3.toString());
                        }
                    }
                    JSONArray f = s.f(bVar.o);
                    if (f != null && f.length() > 0) {
                        s.a(jSONObject2, "wflist", f.toString());
                    }
                    s.a(jSONObject2, "sen", bVar.p);
                } else {
                    s.a(jSONObject2, "thn", thread.getName());
                    s.a(jSONObject2, "qq", i.c(bVar.o));
                    s.a(jSONObject2, "cui", i.d(bVar.o));
                    if (n.c(bVar.r) && bVar.r.split("/").length == 2) {
                        s.a(jSONObject2, "fram", bVar.r.split("/")[0]);
                    }
                    if (n.c(bVar.s) && bVar.s.split("/").length == 2) {
                        s.a(jSONObject2, "from", bVar.s.split("/")[0]);
                    }
                    if (as.a(bVar.o).b(bVar.o) != null) {
                        jSONObject2.put("ui", as.a(bVar.o).b(bVar.o).a);
                    }
                    s.a(jSONObject2, "mid", i.e(bVar.o));
                }
                s.a(jSONObject2, "pcn", n.o(bVar.o));
                s.a(jSONObject2, "osn", VERSION.RELEASE);
                s.a(jSONObject2, "av", bVar.a);
                s.a(jSONObject2, "ch", bVar.h);
                s.a(jSONObject2, "mf", bVar.f);
                s.a(jSONObject2, "sv", bVar.b);
                s.a(jSONObject2, "osd", Build.DISPLAY);
                s.a(jSONObject2, "prod", Build.PRODUCT);
                s.a(jSONObject2, "tags", Build.TAGS);
                s.a(jSONObject2, "id", Build.ID);
                s.a(jSONObject2, "fng", Build.FINGERPRINT);
                s.a(jSONObject2, "lch", bVar.n);
                s.a(jSONObject2, "ov", Integer.toString(bVar.d));
                jSONObject2.put("os", 1);
                s.a(jSONObject2, "op", bVar.i);
                s.a(jSONObject2, "lg", bVar.g);
                s.a(jSONObject2, "md", bVar.e);
                s.a(jSONObject2, "tz", bVar.j);
                if (bVar.l != 0) {
                    jSONObject2.put(SettingKeys.SYS_INFO_TYPE_UBI_MI_JAILBREAKT, bVar.l);
                }
                s.a(jSONObject2, "sd", bVar.k);
                s.a(jSONObject2, "apn", bVar.m);
                s.a(jSONObject2, "cpu", bVar.q);
                s.a(jSONObject2, "abi", Build.CPU_ABI);
                s.a(jSONObject2, "abi2", Build.CPU_ABI2);
                s.a(jSONObject2, "ram", bVar.r);
                s.a(jSONObject2, "rom", bVar.s);
            }
            s.a(jSONObject2, "cn", this.c);
            if (this.b != null) {
                jSONObject2.put("tn", this.b);
            }
            if (thread == null) {
                jSONObject.put("ev", jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            if (e != null && e.length() > 0) {
                jSONObject.put("eva", e);
            }
        } catch (Throwable th) {
            d.b(th);
        }
    }
}
