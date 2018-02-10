package com.uc.base.wa.d;

import android.util.Log;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ k a;
    private g b;
    private boolean c;

    public j(k kVar, g gVar, boolean z) {
        this.a = kVar;
        this.b = gVar;
        this.c = z;
    }

    public final void run() {
        Throwable e;
        int i = 1;
        try {
            if (!(this.a.k || this.a.l)) {
                Log.e("gzm_wa_WaNet", "", new Throwable());
            }
            if (this.a.d == null) {
                this.a.d = new h(this);
            }
            if (this.a.e == null) {
                this.a.e = new i(this, this.a.d);
            }
            String a = this.b.a();
            if ("".equals(a)) {
                i = 0;
            } else {
                i = this.a.a(a, this.c);
            }
            if (i != 0) {
                Log.e("gzm_wa_WaNet", "ret: " + i);
            }
            if (this.a.e != null) {
                this.a.e.close();
                this.a.e = null;
            }
            if (this.a.d != null) {
                this.a.d.close();
                this.a.d = null;
            }
            this.b.a(i);
        } catch (Throwable e2) {
            Log.e("gzm_wa_WaNet", "", e2);
            this.b.a(9);
        } catch (Throwable th) {
            e2 = th;
            i = 9;
            this.b.a(i);
            throw e2;
        }
    }
}
