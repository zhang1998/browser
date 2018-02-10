package com.uc.a.f;

import android.util.Log;
import com.uc.a.b;
import com.uc.a.e.d;
import com.uc.a.g;
import com.uc.a.l;
import com.uc.a.m;
import com.uc.a.n;
import java.util.ArrayList;
import okhttp3.OkHttpClient;

/* compiled from: ProGuard */
public final class h implements l {
    private static int a = 2;
    private f b;
    private ArrayList<String> c = new ArrayList();
    private int d = -1;
    private d e;
    private boolean f = false;
    private int g = 0;
    private boolean h = false;
    private OkHttpClient i;

    public h(d dVar, OkHttpClient okHttpClient) {
        this.e = dVar;
        this.i = okHttpClient;
        m a = g.a;
        this.c.add(a.a("MainDispAddr"));
        this.c.add(a.a("SubDispAddr1"));
        this.c.add(a.a("SubDispAddr2"));
    }

    final boolean a(int i, f fVar) {
        if (this.h) {
            return true;
        }
        if (this.e == null) {
            return false;
        }
        this.b = fVar;
        this.d = 0;
        boolean a = a(i);
        if (a) {
            this.h = true;
        }
        return a;
    }

    private boolean a(int i) {
        if (this.d < 0 || this.d >= this.c.size()) {
            this.d = -1;
            return false;
        }
        n a = this.e.a(i, (String) this.c.get(this.d));
        if (a == null) {
            Log.e("DispatcherReqExecutor", "can not create dispatcher request for type: " + i);
            return false;
        }
        b bVar = new b(this.i);
        bVar.a((l) this);
        if (bVar.a(a)) {
            return true;
        }
        return false;
    }

    public final void a(n nVar, byte[] bArr) {
        if (!this.f) {
            this.h = false;
            if (this.e != null) {
                int i = -1;
                if (nVar != null) {
                    i = nVar.c();
                }
                b bVar = new b();
                if (bVar.a(bArr)) {
                    this.f = true;
                    if (this.b != null) {
                        this.b.a(i, bVar.a);
                        return;
                    }
                    return;
                }
                b(i);
            }
        }
    }

    public final void a(String str, n nVar) {
        if (!this.f) {
            int b;
            if (nVar != null) {
                b = nVar.b();
            } else {
                b = 0;
            }
            do {
                boolean z;
                this.d++;
                if (this.d < 0 || this.d >= this.c.size()) {
                    Log.e("DispatcherReqExecutor", "mDispatcherAddrList len error !", new Throwable());
                    this.d = 0;
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    this.h = false;
                    b(b);
                    return;
                }
            } while (!a(b));
        }
    }

    private void b(int i) {
        while (this.g < a) {
            this.g++;
            if (a(i, this.b)) {
                return;
            }
        }
        this.f = true;
        if (this.b != null) {
            this.b.b(i);
        }
    }
}
