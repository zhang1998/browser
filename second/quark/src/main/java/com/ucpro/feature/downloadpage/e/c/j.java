package com.ucpro.feature.downloadpage.e.c;

import android.graphics.drawable.Drawable;
import com.uc.quark.s;
import com.ucpro.feature.downloadpage.e.b.b;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.l.d;
import java.io.File;

/* compiled from: ProGuard */
final class j implements Runnable {
    public s a;
    public s b;
    int c;
    long d;
    long e;
    long f;
    int g;
    Drawable h;
    private String i;
    private String j;

    public final void run() {
        if (this.b != null) {
            this.i = this.b.i();
            this.j = this.b.h();
            this.c = this.b.e();
            this.d = this.b.d();
            this.e = this.b.c();
            this.f = this.b.f();
            this.g = this.b.r();
            if (this.c == -3 && this.e <= 0) {
                long length = new File(this.j).length();
                this.e = length;
                this.d = length;
            }
            this.h = b.a(d.b(this.i));
            m.a(2, new k(this));
        }
    }
}
