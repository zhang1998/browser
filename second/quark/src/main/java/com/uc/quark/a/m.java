package com.uc.quark.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ProGuard */
public class m {
    static HandlerThread a;
    static Handler b;
    static HandlerThread c;
    static Handler d;
    static HandlerThread e;
    static Handler f;
    static ExecutorService g = Executors.newFixedThreadPool(3);
    static Handler h;
    static HandlerThread i;
    static Handler j;
    static Handler k;
    static HashMap<Object, r> l = new HashMap();

    private m() {
    }

    private static synchronized void a(int i, Runnable runnable, long j) {
        synchronized (m.class) {
            if (runnable != null) {
                Handler handler;
                if (h == null) {
                    e();
                }
                switch (i) {
                    case 0:
                        if (a == null) {
                            b();
                        }
                        handler = b;
                        break;
                    case 1:
                        if (c == null) {
                            c();
                        }
                        handler = d;
                        break;
                    case 2:
                        handler = h;
                        break;
                    case 3:
                        if (e == null) {
                            d();
                        }
                        handler = f;
                        break;
                    case 4:
                        if (i == null) {
                            f();
                        }
                        handler = j;
                        break;
                    default:
                        handler = h;
                        break;
                }
                if (handler != null) {
                    Looper myLooper = Looper.myLooper();
                    if (myLooper == null) {
                        myLooper = h.getLooper();
                    }
                    Runnable fVar = new f(myLooper, handler, new d(runnable, myLooper));
                    l.put(runnable, new r(fVar, Integer.valueOf(i)));
                    handler.postDelayed(fVar, j);
                }
            }
        }
    }

    public static void a(int i, Runnable runnable) {
        a(i, runnable, 0);
    }

    public static void b(Runnable runnable) {
        a(3, runnable, 100);
    }

    private static synchronized void b() {
        synchronized (m.class) {
            if (a == null) {
                HandlerThread handlerThread = new HandlerThread("BackgroundHandler", 10);
                a = handlerThread;
                handlerThread.start();
                b = new Handler(a.getLooper());
            }
        }
    }

    private static synchronized void c() {
        synchronized (m.class) {
            if (c == null) {
                HandlerThread handlerThread = new HandlerThread("WorkHandler", 5);
                c = handlerThread;
                handlerThread.start();
                d = new Handler(c.getLooper());
            }
        }
    }

    private static synchronized void d() {
        synchronized (m.class) {
            if (e == null) {
                HandlerThread handlerThread = new HandlerThread("sNormalHandler", 0);
                e = handlerThread;
                handlerThread.start();
                f = new Handler(e.getLooper());
            }
        }
    }

    private static synchronized void e() {
        synchronized (m.class) {
            if (h == null) {
                h = new Handler(Looper.getMainLooper());
            }
        }
    }

    private static synchronized void f() {
        synchronized (m.class) {
            if (i == null) {
                HandlerThread handlerThread = new HandlerThread("sSharedPreferencesHandler", 0);
                i = handlerThread;
                handlerThread.start();
                j = new Handler(i.getLooper());
            }
        }
    }

    public static void a(Runnable runnable) {
        if (!g.isShutdown()) {
            g.execute(new h(runnable));
        }
    }
}
