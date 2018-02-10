package com.loc;

import android.content.Context;

/* compiled from: ProGuard */
public final class dj {
    static boolean a = false;
    static boolean b = false;
    static boolean c = false;
    static boolean d = false;
    static int e = 0;
    static int f = 0;
    static boolean g = true;
    static boolean h = false;

    public static void a(Context context) {
        try {
            if (c && !a) {
                dl.a(context, "loc", "startMark", dl.b(context, "loc", "startMark") + 1);
                a = true;
            }
        } catch (Throwable th) {
            cq.a(th, "RollBackDynamic", "AddStartMark");
        }
    }

    private static void a(Context context, int i) {
        try {
            if (c) {
                dl.a(context, "loc", "endMark", i);
                dl.a(context, "loc", "startMark", i);
            }
        } catch (Throwable th) {
            cq.a(th, "RollBackDynamic", "resetMark");
        }
    }

    public static void a(Context context, ep epVar) {
        if (!d) {
            c = ac.a(context, epVar);
            d = true;
            if (!c && cq.b()) {
                ac.a(context, "loc");
                di.a("dexrollbackstatistics", "RollBack because of version error");
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            ac.a(context, str);
            di.a("dexrollbackstatistics", "RollBack because of " + str2);
        } catch (Throwable th) {
            cq.a(th, "RollBackDynamic", "rollBackDynamicFile");
        }
    }

    public static void b(Context context) {
        try {
            if (!d) {
                a(context, cq.a("loc", "2.8.0"));
                d = true;
            }
            if (c && !b) {
                dl.a(context, "loc", "endMark", dl.b(context, "loc", "endMark") + 1);
                b = true;
            }
        } catch (Throwable th) {
            cq.a(th, "RollBackDynamic", "AddEndMark");
        }
    }

    public static synchronized boolean c(Context context) {
        boolean z = false;
        synchronized (dj.class) {
            try {
                if (c) {
                    if (h) {
                        z = g;
                    } else {
                        if (e == 0) {
                            e = dl.b(context, "loc", "startMark");
                        }
                        if (f == 0) {
                            f = dl.b(context, "loc", "endMark");
                        }
                        if (!(a || b)) {
                            if (e < f) {
                                a(context, 0);
                                g = true;
                            }
                            if (e - f > 0 && e > 99) {
                                a(context, 0);
                                g = true;
                            }
                            if (e - f > 0 && e < 99) {
                                a(context, -2);
                                g = false;
                            }
                            if (e - f > 0 && f < 0) {
                                a(context, "loc", "checkMark");
                                g = false;
                            }
                        }
                        dl.a(context, "loc", "isload", g);
                        h = true;
                        z = g;
                    }
                }
            } catch (Throwable th) {
                cq.a(th, "RollBackDynamic", "checkMark");
            }
        }
        return z;
    }

    public static boolean d(Context context) {
        try {
            return !c ? false : dl.b(context, "loc", "isload", true);
        } catch (Throwable th) {
            cq.a(th, "RollBackDynamic", "isLoad");
            return true;
        }
    }
}
