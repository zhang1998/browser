package com.loc;

import android.text.TextUtils;
import com.autonavi.aps.amapapi.model.AmapLoc;

/* compiled from: ProGuard */
public final class ci {
    private static ci c = null;
    boolean a = true;
    int b = 0;
    private AmapLoc d = null;
    private long e = 0;
    private long f = 0;

    private ci() {
    }

    public static synchronized ci a() {
        ci ciVar;
        synchronized (ci.class) {
            if (c == null) {
                c = new ci();
            }
            ciVar = c;
        }
        return ciVar;
    }

    private AmapLoc b(AmapLoc amapLoc) {
        if (dm.a(amapLoc)) {
            if (!this.a || !de.c(amapLoc.e)) {
                amapLoc.i = this.b;
            } else if (amapLoc.i == 5 || amapLoc.i == 6) {
                amapLoc.i = 2;
            }
        }
        return amapLoc;
    }

    public final synchronized AmapLoc a(AmapLoc amapLoc) {
        if (!dm.a(this.d) || !dm.a(amapLoc)) {
            this.e = dm.b();
        } else if (amapLoc.e != this.d.e || amapLoc.d >= 300.0f) {
            if (amapLoc.a.equals("gps")) {
                this.e = dm.b();
                this.d = amapLoc;
                amapLoc = this.d;
            } else if (amapLoc.x != this.d.x) {
                this.e = dm.b();
                this.d = amapLoc;
                amapLoc = this.d;
            } else if (amapLoc.w.equals(this.d.w) || TextUtils.isEmpty(amapLoc.w)) {
                this.b = amapLoc.i;
                float a = dm.a(amapLoc, this.d);
                float f = this.d.d;
                float f2 = amapLoc.d;
                float f3 = f2 - f;
                long b = dm.b();
                long j = b - this.e;
                if ((f < 101.0f && f2 > 299.0f) || (f > 299.0f && f2 > 299.0f)) {
                    if (this.f == 0) {
                        this.f = b;
                    } else if (b - this.f > 30000) {
                        this.e = b;
                        this.d = amapLoc;
                        this.f = 0;
                        amapLoc = this.d;
                    }
                    this.d = b(this.d);
                    amapLoc = this.d;
                } else if (f2 >= 100.0f || f <= 299.0f) {
                    if (f2 <= 299.0f) {
                        this.f = 0;
                    }
                    if (a >= 10.0f || ((double) a) <= 0.1d) {
                        if (f3 < 300.0f) {
                            this.e = dm.b();
                            this.d = amapLoc;
                            amapLoc = this.d;
                        } else if (j >= 30000) {
                            this.e = dm.b();
                            this.d = amapLoc;
                            amapLoc = this.d;
                        } else {
                            this.d = b(this.d);
                            amapLoc = this.d;
                        }
                    } else if (f3 >= -300.0f) {
                        this.d = b(this.d);
                        amapLoc = this.d;
                    } else if (f / f2 >= 2.0f) {
                        this.e = b;
                        this.d = amapLoc;
                        amapLoc = this.d;
                    } else {
                        this.d = b(this.d);
                        amapLoc = this.d;
                    }
                } else {
                    this.e = b;
                    this.d = amapLoc;
                    this.f = 0;
                    amapLoc = this.d;
                }
            } else {
                this.e = dm.b();
                this.d = amapLoc;
                amapLoc = this.d;
            }
        }
        return amapLoc;
    }

    public final synchronized void b() {
        this.d = null;
        this.e = 0;
        this.f = 0;
    }
}
