package com.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import com.a.a.a.aj;
import com.a.a.a.ef;
import com.a.a.a.eh;
import com.a.a.a.ej;
import com.a.a.a.em;
import com.a.a.a.eo;
import com.a.a.a.es;
import com.a.a.a.ew;
import com.a.a.a.fg;
import com.a.a.a.fj;
import com.a.a.a.fw;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class e implements ew {
    public Context a;
    public ej b;
    em c;
    eo d;
    public boolean e;
    public boolean f;
    private es g;
    private eh h;
    private Object i;
    private ef j;
    private JSONObject k;

    private e() {
        this.a = null;
        this.g = new es();
        this.b = new ej();
        this.c = new em();
        this.h = null;
        this.i = new Object();
        this.j = null;
        this.d = null;
        this.e = false;
        this.k = null;
        this.f = false;
        this.g.a = this;
    }

    public final synchronized void a(Context context) {
        if (context != null) {
            try {
                if (VERSION.SDK_INT > 13 && !this.f) {
                    this.f = true;
                    fj.b(new h(this, context));
                }
                if (!this.e) {
                    this.a = context.getApplicationContext();
                    this.e = true;
                    if (this.h == null) {
                        synchronized (this.i) {
                            this.h = new eh(this.a);
                        }
                    }
                    this.j = ef.a(this.a);
                }
            } catch (Throwable th) {
            }
        }
    }

    final void b(Context context) {
        try {
            if (this.a == null && context != null) {
                this.a = context.getApplicationContext();
            }
            if (this.a != null) {
                if (this.c != null) {
                    em.a(this.a);
                }
                ej.a(this.a);
                eo.a(this.a);
                if (this.j != null) {
                    this.j.c().a(this.a);
                }
            }
        } catch (Throwable th) {
        }
    }

    public final void a(Throwable th) {
        try {
            if (this.b != null) {
                ej ejVar = this.b;
                String str = null;
                long j = 0;
                synchronized (ejVar.a) {
                    for (Entry entry : ejVar.a.entrySet()) {
                        String str2;
                        long j2;
                        if (((Long) entry.getValue()).longValue() > j) {
                            long longValue = ((Long) entry.getValue()).longValue();
                            str2 = (String) entry.getKey();
                            j2 = longValue;
                        } else {
                            j2 = j;
                            str2 = str;
                        }
                        str = str2;
                        j = j2;
                    }
                }
                if (str != null) {
                    ejVar.a(str);
                }
            }
            if (this.d != null) {
                eo eoVar = this.d;
                eoVar.a();
                if (eoVar.b != null) {
                    eoVar.b.unregisterActivityLifecycleCallbacks(eoVar.c);
                }
            }
            if (this.a != null) {
                if (!(th == null || this.j == null)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put("error_source", 1);
                    jSONObject.put("context", fg.a(th));
                    aj.a(this.a);
                    aj.a(em.a(), jSONObject.toString());
                }
                b(this.a);
                this.a.getSharedPreferences("umeng_general_config", 0).edit().commit();
            }
            fj.a();
        } catch (Throwable th2) {
            if (fw.a) {
                fw.a("Exception in onAppCrash", th2);
            }
        }
    }
}
