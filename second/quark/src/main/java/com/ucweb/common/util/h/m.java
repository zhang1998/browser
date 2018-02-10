package com.ucweb.common.util.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.ucweb.common.util.e;
import com.ucweb.common.util.f;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ProGuard */
public class m {
    static HandlerThread a;
    static e b;
    static HandlerThread c;
    static e d;
    static HandlerThread e;
    static e f;
    static final int g;
    static ExecutorService h;
    static e i;
    static HandlerThread j;
    static e k;
    static e l;
    static HashMap<Object, e> m = new HashMap();

    static {
        int b = (f.b() * 3) + 2;
        g = b;
        h = Executors.newFixedThreadPool(b);
    }

    private m() {
    }

    public static void a(Runnable runnable) {
        b(runnable, null);
    }

    public static void a(Runnable runnable, Runnable runnable2) {
        b(runnable, runnable2);
    }

    private static void b(Runnable runnable, Runnable runnable2) {
        if (!h.isShutdown()) {
            e eVar = null;
            if (runnable2 != null) {
                eVar = new e("threadpool", Looper.myLooper());
            }
            h.execute(new b(runnable, eVar, runnable2));
        }
    }

    private static synchronized void a(int i, Runnable runnable, Runnable runnable2, long j) {
        synchronized (m.class) {
            if (runnable != null) {
                Handler handler;
                if (i == null) {
                    h();
                }
                switch (i) {
                    case 0:
                        if (a == null) {
                            e();
                        }
                        handler = b;
                        break;
                    case 1:
                        if (c == null) {
                            f();
                        }
                        handler = d;
                        break;
                    case 2:
                        handler = i;
                        break;
                    case 3:
                        if (e == null) {
                            g();
                        }
                        handler = f;
                        break;
                    case 4:
                        if (j == null) {
                            i();
                        }
                        handler = k;
                        break;
                    default:
                        handler = i;
                        break;
                }
                if (handler != null) {
                    Looper myLooper = Looper.myLooper();
                    if (myLooper == null) {
                        myLooper = i.getLooper();
                    }
                    Runnable hVar = new h(null, myLooper, handler, new d(runnable, runnable2, myLooper));
                    m.put(runnable, new e(hVar, Integer.valueOf(i)));
                    handler.postDelayed(hVar, j);
                }
            }
        }
    }

    public static void a(int i, Runnable runnable, Runnable runnable2) {
        a(i, runnable, runnable2, 0);
    }

    public static void b(int i, Runnable runnable, Runnable runnable2) {
        a(i, runnable, runnable2, 0);
    }

    public static void a(int i, Runnable runnable) {
        a(i, runnable, null, 0);
    }

    public static void a(int i, Runnable runnable, long j) {
        a(i, runnable, null, j);
    }

    public static void b(Runnable runnable) {
        a(2, runnable, null, 1000);
    }

    public static synchronized void c(Runnable runnable) {
        synchronized (m.class) {
            if (runnable != null) {
                e eVar = (e) m.get(runnable);
                if (eVar != null) {
                    Runnable runnable2 = eVar.a;
                    if (runnable2 != null) {
                        switch (eVar.b.intValue()) {
                            case 0:
                                if (b != null) {
                                    b.removeCallbacks(runnable2);
                                    break;
                                }
                                break;
                            case 1:
                                if (d != null) {
                                    d.removeCallbacks(runnable2);
                                    break;
                                }
                                break;
                            case 2:
                                if (i != null) {
                                    i.removeCallbacks(runnable2);
                                    break;
                                }
                                break;
                            case 3:
                                if (f != null) {
                                    f.removeCallbacks(runnable2);
                                    break;
                                }
                                break;
                            case 4:
                                if (k != null) {
                                    k.removeCallbacks(runnable2);
                                    break;
                                }
                                break;
                        }
                        m.remove(runnable);
                    }
                }
            }
        }
    }

    private static synchronized void e() {
        synchronized (m.class) {
            if (a == null) {
                HandlerThread handlerThread = new HandlerThread("BackgroundHandler", 10);
                a = handlerThread;
                handlerThread.start();
                b = new e("BackgroundHandler", a.getLooper());
            }
        }
    }

    private static synchronized void f() {
        synchronized (m.class) {
            if (c == null) {
                HandlerThread handlerThread = new HandlerThread("WorkHandler", 5);
                c = handlerThread;
                handlerThread.start();
                d = new e("WorkHandler", c.getLooper());
            }
        }
    }

    private static synchronized void g() {
        synchronized (m.class) {
            if (e == null) {
                HandlerThread handlerThread = new HandlerThread("sNormalHandler", 0);
                e = handlerThread;
                handlerThread.start();
                f = new e("sNormalHandler", e.getLooper());
            }
        }
    }

    private static synchronized void h() {
        synchronized (m.class) {
            if (i == null) {
                i = new e("BackgroundHandler.MainThreadHandler + 38", Looper.getMainLooper());
            }
        }
    }

    private static synchronized void i() {
        synchronized (m.class) {
            if (j == null) {
                HandlerThread handlerThread = new HandlerThread("sSharedPreferencesHandler", 0);
                j = handlerThread;
                handlerThread.start();
                k = new e("sSharedPreferencesHandler", j.getLooper());
            }
        }
    }

    public static synchronized Looper a() {
        Looper looper;
        synchronized (m.class) {
            e();
            looper = a.getLooper();
        }
        return looper;
    }

    public static synchronized Looper b() {
        Looper looper;
        synchronized (m.class) {
            f();
            looper = c.getLooper();
        }
        return looper;
    }

    public static void d(Runnable runnable) {
        IdleHandler kVar = new k(runnable);
        if (k.a != null) {
            k.b.postDelayed(kVar.c, 10000);
            k.a.addIdleHandler(kVar);
            return;
        }
        throw new Error("CustomIdelHandler main thread queue is null!");
    }

    public static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
