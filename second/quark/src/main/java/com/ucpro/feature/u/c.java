package com.ucpro.feature.u;

import android.content.Context;
import com.ucpro.c.b;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class c {
    private static boolean a = false;
    private static Class b;
    private static Object c;

    private static void e() {
        if (b.b() && !a) {
            try {
                Class cls = Class.forName("com.uc.monitorpanel.panel.MemoryWatcherManager");
                b = cls;
                cls.getMethod("initModule", new Class[]{Context.class}).invoke(null, new Object[]{d.a()});
                c = b.getMethod("getInstance", new Class[0]).invoke(new Class[0], new Object[0]);
                a = true;
            } catch (Exception e) {
            }
        }
    }

    public static boolean a() {
        if (b.b()) {
            e();
            try {
                return ((Boolean) b.getMethod("isMonitorPanelShowing", new Class[0]).invoke(c, new Object[0])).booleanValue();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static void b() {
        if (b.b()) {
            e();
            try {
                b.getMethod("showMonitorPanel", new Class[0]).invoke(c, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    public static void c() {
        if (b.b()) {
            e();
            try {
                b.getMethod("closeMonitorPanel", new Class[0]).invoke(c, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    public static void d() {
        if (b.b()) {
            e();
            if (b.a.a.getBoolean("926B4774B1E4C37C", false)) {
                b();
            }
        }
    }
}
