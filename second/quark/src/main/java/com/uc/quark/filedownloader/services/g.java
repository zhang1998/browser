package com.uc.quark.filedownloader.services;

import android.util.Log;
import android.util.SparseArray;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.services.b.b;

/* compiled from: ProGuard */
public final class g implements b {
    final SparseArray<ae> a = new SparseArray();
    final SparseArray<ae> b = new SparseArray();
    int c;

    public g(int i) {
        if (i <= 0) {
            this.c = 3;
        } else {
            this.c = i;
        }
    }

    public final void a(int i) {
        synchronized (this.a) {
            this.a.remove(i);
            if (j.a) {
                Log.e("vanda", "execComplete size:" + this.a.size());
            }
            if (this.b.size() > 0 && this.a.size() < this.c) {
                ae aeVar = (ae) this.b.valueAt(0);
                this.b.removeAt(0);
                this.a.put(aeVar.l, aeVar);
                aeVar.j();
            }
        }
    }

    public final boolean b(int i) {
        boolean z;
        synchronized (this.a) {
            z = ((ae) this.a.get(i)) != null;
        }
        return z;
    }

    public final boolean a() {
        boolean z;
        synchronized (this.a) {
            if (j.a) {
                Log.e("vanda", "isIdle size:" + this.a.size());
            }
            z = this.a.size() <= 0;
        }
        return z;
    }

    public final boolean c(int i) {
        synchronized (this.a) {
            ae aeVar = (ae) this.a.get(i);
            if (aeVar != null) {
                aeVar.g();
            }
            aeVar = (ae) this.b.get(i);
            if (aeVar != null) {
                this.b.remove(i);
                aeVar.g();
            }
            if (j.a) {
                j.d(this, "paused %d", Integer.valueOf(i));
            }
            a(i);
        }
        return true;
    }

    public final int[] b() {
        int[] iArr;
        synchronized (this.a) {
            iArr = new int[this.a.size()];
            for (int i = 0; i < this.a.size(); i++) {
                iArr[i] = this.a.keyAt(i);
            }
        }
        return iArr;
    }
}
