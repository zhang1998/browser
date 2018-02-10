package com.ucpro.business.stat.b;

import com.e.b.d.a.b;
import com.e.b.d.a.c;
import com.e.b.k;
import com.ucpro.c.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public final class e implements k {
    private static boolean a;
    private static boolean b;

    public final String a() {
        return "2.4.1.985^release^180123054500";
    }

    public final String b() {
        return a.d() + "^" + a.a() + "^" + a.b();
    }

    public final c c() {
        return new b("24493918", "0002");
    }

    public final boolean d() {
        return com.ucpro.c.b.a();
    }

    public final boolean e() {
        return f();
    }

    private static boolean f() {
        String str;
        String str2 = null;
        if (!a) {
            a = true;
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
                str = (String) method.invoke(null, new Object[]{"ro.yunos.version"});
                try {
                    str2 = (String) method.invoke(null, new Object[]{"java.vm.name"});
                } catch (NoSuchMethodException e) {
                } catch (ClassNotFoundException e2) {
                } catch (IllegalAccessException e3) {
                } catch (InvocationTargetException e4) {
                }
            } catch (NoSuchMethodException e5) {
                str = null;
            } catch (ClassNotFoundException e6) {
                str = null;
            } catch (IllegalAccessException e7) {
                str = null;
            } catch (InvocationTargetException e8) {
                str = null;
            }
            if ((str2 == null || !str2.toLowerCase().contains("lemur")) && (r0 == null || r0.trim().length() <= 0)) {
                b = false;
            } else {
                b = true;
            }
        }
        return b;
    }
}
