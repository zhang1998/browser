package com.uc.quark.filedownloader;

import com.uc.quark.filedownloader.b.a;
import com.uc.quark.filedownloader.b.b;
import com.uc.quark.filedownloader.b.e;
import com.uc.quark.filedownloader.b.f;

/* compiled from: ProGuard */
public abstract class ai extends f {
    private int a;

    public abstract void a();

    public abstract void b();

    public final boolean a(a aVar) {
        if (aVar instanceof b) {
            this.a = ((b) aVar).c;
            if (this.a == e.a) {
                a();
            } else {
                b();
            }
        }
        return false;
    }
}
