package com.ucpro.services.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class a {
    private static boolean g;
    private static Method h = null;
    private static Method i = null;
    private static Method j = null;
    String[] a;
    int b;
    private Context c;
    private int d;
    private List<Integer> e;
    private boolean f = true;

    public a(Context context, int i, String[] strArr) {
        this.c = context;
        this.d = i;
        this.a = strArr;
        this.e = new ArrayList();
        this.b = a(this.a);
    }

    private static int a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return -1;
        }
        int i = 1;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            i = (strArr[i2] == null ? 0 : strArr[i2].hashCode()) + (i * 97);
        }
        return i;
    }

    public final boolean a() {
        this.e.clear();
        if (!g) {
            return true;
        }
        boolean z;
        if (this.a != null) {
            for (int i = 0; i < this.a.length; i++) {
                if (a(this.c, this.a[i]) != 0) {
                    this.e.add(Integer.valueOf(i));
                }
            }
        }
        if (this.e.size() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return z;
        }
        e.b().a(this.d);
        return z;
    }

    public final String[] b() {
        String[] strArr = new String[this.e.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = this.a[((Integer) this.e.get(i)).intValue()];
        }
        return strArr;
    }

    public final boolean c() {
        if (!this.f) {
            return false;
        }
        boolean z;
        e b = e.b();
        int i = this.b;
        Long l = (Long) b.b.get(i);
        if (l != null) {
            long uptimeMillis = SystemClock.uptimeMillis() - l.longValue();
            if (uptimeMillis <= 3000 && uptimeMillis > 0) {
                new StringBuilder("isFrequently permissionsHashCode:").append(i).append(" true");
                z = true;
                if (z) {
                    return z;
                }
                e.b().a(this.d);
                return z;
            }
        }
        z = false;
        if (z) {
            return z;
        }
        e.b().a(this.d);
        return z;
    }

    public final void d() {
        if (this.e.size() > 0) {
            Object obj;
            e b = e.b();
            int i = this.b;
            int size = b.a.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                int i4;
                d dVar = (d) b.a.valueAt(i2);
                if (dVar != null) {
                    a a = dVar.a();
                    if (a != null) {
                        i4 = a.b;
                        if (i4 != -1 && i4 == i) {
                            i4 = i3 + 1;
                            if (i4 > 1) {
                                new StringBuilder("hasRunningHandler permissionsHashCode:").append(i).append(" true");
                                obj = 1;
                                break;
                            }
                            i2++;
                            i3 = i4;
                        }
                    }
                }
                i4 = i3;
                i2++;
                i3 = i4;
            }
            obj = null;
            if (obj == null) {
                a(this.c, b(), this.d);
            }
        }
    }

    private static synchronized void a(Context context, String[] strArr, int i) {
        synchronized (a.class) {
            if (context != null) {
                try {
                    if (i == null) {
                        Method method = context.getClass().getMethod("requestPermissions", new Class[]{String[].class, Integer.TYPE});
                        i = method;
                        method.setAccessible(true);
                    }
                    i.invoke(context, new Object[]{strArr, Integer.valueOf(i)});
                } catch (Exception e) {
                }
            }
        }
    }

    static {
        boolean z = false;
        g = false;
        if ("MNC".equals(VERSION.CODENAME) || VERSION.SDK_INT >= 23) {
            z = true;
        }
        g = z;
    }

    static int a(Context context, String str) {
        if (!g) {
            return 0;
        }
        if (context == null) {
            return -1;
        }
        int intValue;
        synchronized (a.class) {
            try {
                if (h == null) {
                    Method method = context.getClass().getMethod("checkSelfPermission", new Class[]{String.class});
                    h = method;
                    method.setAccessible(true);
                }
                intValue = ((Integer) h.invoke(context, new Object[]{str})).intValue();
            } catch (Exception e) {
                return -1;
            }
        }
        return intValue;
    }
}
