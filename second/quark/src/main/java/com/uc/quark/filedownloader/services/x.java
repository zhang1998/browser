package com.uc.quark.filedownloader.services;

import com.uc.quark.ac;
import com.uc.quark.filedownloader.message.d;
import com.uc.quark.filedownloader.message.g;
import com.uc.quark.filedownloader.model.b;

/* compiled from: ProGuard */
final class x implements Runnable {
    public byte a;
    public b b;
    public g c;
    public final i d;
    public Object e;
    public com.uc.quark.g f;

    public x(i iVar) {
        this.d = iVar;
    }

    public final void run() {
        switch (this.a) {
            case (byte) -5:
                this.d.c(this.b);
                break;
            case (byte) -3:
                this.d.d(this.b.a);
                if (this.b.h == 0 && this.b.g > 0) {
                    this.b.a(this.b.g);
                }
                this.d.b(this.b, this.b.h);
                if (this.f instanceof ac) {
                    ((ac) this.f).j();
                    break;
                }
                break;
            case (byte) -2:
                this.d.c(this.b, this.b.g);
                break;
            case (byte) -1:
                if (this.e instanceof Throwable) {
                    this.d.a(this.b, (Throwable) this.e, this.b.g);
                    if (this.f instanceof ac) {
                        ((ac) this.f).a(this.b.b, (Throwable) this.e);
                        break;
                    }
                }
                break;
            case (byte) 1:
                this.d.b(this.b);
                break;
            case (byte) 3:
                if (this.e != null && (this.e instanceof Boolean) && ((Boolean) this.e).booleanValue()) {
                    this.d.a(this.b, this.b.g);
                    break;
                }
            case (byte) 7:
                this.d.c(this.b);
                break;
        }
        com.uc.quark.filedownloader.message.b.a.a(d.a(this.a, this.b, this.c), true);
    }
}
