package com.uc.quark.filedownloader.services;

import android.util.SparseArray;
import com.uc.quark.filedownloader.e.f;
import com.uc.quark.filedownloader.e.h;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: ProGuard */
final class l {
    volatile Object a = new Object();
    SparseArray<ad> b = new SparseArray();
    ThreadPoolExecutor c;
    int d = 0;
    private final String e = "Network";
    private int f;

    l(int i, int i2) {
        int a = i == 0 ? (i2 == 0 || i2 == c.a) ? h.a().e : h.a().f : h.a(i);
        this.c = f.a(a, "Network");
        this.f = a;
    }

    final void a() {
        synchronized (this.a) {
            SparseArray sparseArray = new SparseArray();
            for (int i = 0; i < this.b.size(); i++) {
                int keyAt = this.b.keyAt(i);
                ad adVar = (ad) this.b.get(keyAt);
                if (adVar.a()) {
                    sparseArray.put(keyAt, adVar);
                }
            }
            this.b = sparseArray;
        }
    }

    public final boolean a(int i) {
        boolean z;
        synchronized (this.a) {
            ad adVar = (ad) this.b.get(i);
            z = adVar != null && adVar.a();
        }
        return z;
    }

    public final int b() {
        int size;
        synchronized (this.a) {
            a();
            size = this.b.size();
        }
        return size;
    }
}
