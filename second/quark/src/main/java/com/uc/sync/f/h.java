package com.uc.sync.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseArray;
import com.ucweb.common.util.d;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class h implements m {
    private static h e;
    e a;
    SparseArray<o> b = new SparseArray();
    public SparseArray<a> c = new SparseArray();
    n d;
    private HandlerThread f = new HandlerThread("CloudSyncThread", 10);
    private ArrayList<b> g;

    private h() {
        this.f.start();
        this.a = new e(this.f.getLooper(), this);
        this.d = new n(this, this.f.getLooper());
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (e == null) {
                e = new h();
            }
            hVar = e;
        }
        return hVar;
    }

    public final boolean a(o oVar) {
        boolean z;
        synchronized (this.b) {
            int i = oVar.a;
            if (((o) this.b.get(i)) == null) {
                this.b.put(i, oVar);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean a(int i) {
        boolean z;
        synchronized (this.b) {
            o oVar = (o) this.b.get(i);
            if (oVar != null) {
                if (oVar.c == 1) {
                    oVar.a(3);
                }
                this.b.remove(i);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean b(int i) {
        boolean z;
        synchronized (this.b) {
            z = ((o) this.b.get(i)) != null;
        }
        return z;
    }

    public final void b() {
        new Handler(d.a().getMainLooper()).post(new d(this));
    }

    final void a(SparseArray<o> sparseArray) {
        for (int i = 0; i < sparseArray.size(); i++) {
            o oVar = (o) sparseArray.get(sparseArray.keyAt(i));
            if (oVar.c == 3) {
                j jVar = new j(oVar.a);
                jVar.b = 2;
                a(jVar);
            }
        }
    }

    public final void a(ArrayList<b> arrayList) {
        this.g = arrayList;
    }

    public final void a(j jVar) {
        int i = jVar.a;
        synchronized (this.b) {
            o oVar = (o) this.b.get(i);
            if (oVar != null) {
                jVar.g = oVar.d;
                jVar.h = oVar.o;
                jVar.k = oVar.b;
                if (oVar.c == 2) {
                    this.b.remove(oVar.a);
                }
            }
        }
        synchronized (this.c) {
            a aVar = (a) this.c.get(i);
            if (aVar != null) {
                Message obtain = Message.obtain();
                obtain.what = 262145;
                obtain.obj = jVar;
                aVar.a.sendMessage(obtain);
            }
        }
    }
}
