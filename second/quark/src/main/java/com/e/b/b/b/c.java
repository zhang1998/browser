package com.e.b.b.b;

import android.text.TextUtils;
import com.alibaba.analytics.core.d.a;

/* compiled from: ProGuard */
public final class c implements a {
    private e a = new e();
    private String b = "";
    private int c = 0;

    public final synchronized void a(int i) {
        this.c = i;
    }

    public final synchronized d a() {
        d dVar;
        a(this.b, a.a(this.c));
        dVar = new d(this.a);
        e eVar = this.a;
        synchronized (eVar) {
            if (eVar.a != null) {
                eVar.a.b = 0;
                eVar.a.a = 0;
            }
            if (eVar.b != null) {
                eVar.b.b = 0;
                eVar.b.a = 0;
            }
            eVar.c = null;
        }
        a(this.b, a.a(this.c));
        return dVar;
    }

    public final synchronized void a(String str) {
        b a = a.a(this.c);
        if (TextUtils.isEmpty(this.b)) {
            a(str, a);
        } else {
            a(this.b, a);
        }
        this.b = str;
    }

    private void a(String str, b bVar) {
        if (bVar != null && !TextUtils.isEmpty(str)) {
            e eVar;
            long j;
            long j2;
            if (str.equals("Wi-Fi")) {
                eVar = this.a;
                synchronized (eVar) {
                    if (bVar != null) {
                        if (eVar.c != null) {
                            j = bVar.b - eVar.c.b;
                            j2 = bVar.a - eVar.c.a;
                            if (j2 > 0 && j > 0) {
                                eVar.b.a(j);
                                eVar.b.b(j2);
                            }
                        }
                        eVar.c = bVar;
                    }
                }
                return;
            }
            eVar = this.a;
            synchronized (eVar) {
                if (bVar != null) {
                    if (eVar.c != null) {
                        j = bVar.b - eVar.c.b;
                        j2 = bVar.a - eVar.c.a;
                        if (j2 > 0 && j > 0) {
                            eVar.a.a(j);
                            eVar.a.b(j2);
                        }
                    }
                    eVar.c = bVar;
                }
            }
        }
    }
}
