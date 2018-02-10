package com.raizlabs.android.dbflow.runtime;

import android.os.Looper;
import android.os.Process;
import com.raizlabs.android.dbflow.config.s;
import com.raizlabs.android.dbflow.structure.database.transaction.b;
import com.raizlabs.android.dbflow.structure.database.transaction.c;
import com.raizlabs.android.dbflow.structure.database.transaction.f;
import com.raizlabs.android.dbflow.structure.database.transaction.q;
import com.raizlabs.android.dbflow.structure.database.transaction.t;
import com.raizlabs.android.dbflow.structure.database.transaction.u;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: ProGuard */
public final class i extends Thread {
    private int a = 50;
    private long b = 30000;
    private final ArrayList<Object> c;
    private boolean d = false;
    private b e;
    private c f;
    private Runnable g;
    private com.raizlabs.android.dbflow.config.c h;
    private final q i = new f(this);
    private final c j = new g(this);
    private final b k = new h(this);

    i(com.raizlabs.android.dbflow.config.c cVar) {
        super("DBBatchSaveQueue");
        this.h = cVar;
        this.c = new ArrayList();
    }

    public final void run() {
        super.run();
        Looper.prepare();
        Process.setThreadPriority(10);
        do {
            synchronized (this.c) {
                Collection arrayList = new ArrayList(this.c);
                this.c.clear();
            }
            if (arrayList.size() > 0) {
                com.raizlabs.android.dbflow.config.c cVar = this.h;
                t tVar = new t(this.i);
                tVar.c.addAll(arrayList);
                f a = cVar.a(new u(tVar));
                a.d = this.j;
                a.c = this.k;
                a.a().b();
            } else if (this.g != null) {
                this.g.run();
            }
            try {
                Thread.sleep(this.b);
            } catch (InterruptedException e) {
                com.raizlabs.android.dbflow.config.t.a(s.c, "DBRequestQueue Batch interrupted to start saving");
            }
        } while (!this.d);
    }
}
