package com.raizlabs.android.dbflow.structure.database.transaction;

import android.os.Looper;
import android.os.Process;
import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.config.c;
import com.raizlabs.android.dbflow.config.s;
import com.raizlabs.android.dbflow.config.t;
import com.raizlabs.android.dbflow.structure.database.b;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ProGuard */
public final class w extends Thread implements h {
    private final LinkedBlockingQueue<g> a = new LinkedBlockingQueue();
    private boolean b = false;

    public w(String str) {
        super(str);
    }

    public final void run() {
        b a;
        Looper.prepare();
        Process.setThreadPriority(10);
        while (true) {
            try {
                g gVar = (g) this.a.take();
                if (this.b) {
                    continue;
                } else {
                    try {
                        if (gVar.f) {
                            c cVar = gVar.d;
                            a aVar = gVar.c;
                            a = cVar.a();
                            a.a();
                            aVar.a(a);
                            a.b();
                            a.c();
                        } else {
                            gVar.c.a(gVar.d.a());
                        }
                        if (gVar.b != null) {
                            if (gVar.g) {
                                gVar.b.a(gVar);
                            } else {
                                g.a().post(new d(gVar));
                            }
                        }
                    } catch (Throwable th) {
                        t.a(th);
                        if (gVar.a == null) {
                            RuntimeException runtimeException = new RuntimeException("An exception occurred while executing a transaction", th);
                        } else if (gVar.g) {
                            gVar.a.a(gVar, th);
                        } else {
                            g.a().post(new e(gVar, th));
                        }
                    }
                }
            } catch (InterruptedException e) {
                synchronized (this) {
                    if (this.b) {
                        synchronized (this.a) {
                            this.a.clear();
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void a(@NonNull g gVar) {
        synchronized (this.a) {
            if (!this.a.contains(gVar)) {
                this.a.add(gVar);
            }
        }
    }

    public final void b(@NonNull g gVar) {
        synchronized (this.a) {
            if (this.a.contains(gVar)) {
                this.a.remove(gVar);
            }
        }
    }

    public final void a() {
        synchronized (this) {
            if (!isAlive()) {
                try {
                    start();
                } catch (Throwable e) {
                    t.a(s.e, e);
                }
            }
        }
    }
}
