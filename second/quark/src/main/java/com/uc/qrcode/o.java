package com.uc.qrcode;

import android.hardware.SensorManager;
import android.os.Message;
import com.uc.qrcode.a.c;

/* compiled from: ProGuard */
final class o implements Runnable {
    final /* synthetic */ t a;

    o(t tVar) {
        this.a = tVar;
    }

    public final void run() {
        if (this.a.g != null && this.a.g.h) {
            if (!this.a.g.n) {
                this.a.g.d.a.setPreviewCallback(null);
            }
            this.a.g.b();
            this.a.g.o.a(null, 0);
            this.a.g.p.a(null, 0);
            this.a.g.h = false;
        }
        if (this.a.h != null) {
            f b = this.a.h;
            b.b = e.c;
            b.c.b();
            Message.obtain(b.a.a(), 22).sendToTarget();
            try {
                b.a.join(500);
            } catch (InterruptedException e) {
            }
            b.removeMessages(18);
            b.removeMessages(19);
            this.a.h = null;
        }
        if (this.a.g != null) {
            c a = this.a.g;
            synchronized (a.b) {
                if (a.d != null) {
                    a.d.a.release();
                    a.d = null;
                    a.e = null;
                    a.f = null;
                }
            }
        }
        if (this.a.k != null) {
            a c = this.a.k;
            if (c.c != null) {
                ((SensorManager) c.a.getSystemService("sensor")).unregisterListener(c);
                c.b = null;
                c.c = null;
            }
        }
        if (this.a.j != null) {
            this.a.j.close();
        }
    }
}
