package com.tencent.connect.a;

import android.content.Context;
import com.tencent.a.b.b;
import com.tencent.connect.b.h;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public final class a {
    private static Class<?> a = null;
    private static Class<?> b = null;
    private static Method c = null;
    private static Method d = null;
    private static Method e = null;
    private static Method f = null;
    private static boolean g = false;

    public static void a(Context context, h hVar) {
        String str = "Aqc" + hVar.a;
        try {
            a = Class.forName("com.tencent.stat.StatConfig");
            Class cls = Class.forName("com.tencent.stat.StatService");
            b = cls;
            c = cls.getMethod("reportQQ", new Class[]{Context.class, String.class});
            d = b.getMethod("trackCustomEvent", new Class[]{Context.class, String.class, String[].class});
            e = b.getMethod("commitEvents", new Class[]{Context.class, Integer.TYPE});
            f = a.getMethod("setEnableStatService", new Class[]{Boolean.TYPE});
            try {
                boolean z;
                b a = b.a(context, hVar.a);
                String str2 = "Common_ta_enable";
                a.b("get " + str2);
                a.a();
                Object opt = a.a.opt(str2);
                if (opt != null) {
                    if (opt instanceof Integer) {
                        if (!opt.equals(Integer.valueOf(0))) {
                            z = true;
                            if (z) {
                                f.invoke(a, new Object[]{Boolean.valueOf(true)});
                            } else {
                                f.invoke(a, new Object[]{Boolean.valueOf(false)});
                            }
                            a.getMethod("setAutoExceptionCaught", new Class[]{Boolean.TYPE}).invoke(a, new Object[]{Boolean.valueOf(false)});
                            a.getMethod("setEnableSmartReporting", new Class[]{Boolean.TYPE}).invoke(a, new Object[]{Boolean.valueOf(true)});
                            a.getMethod("setSendPeriodMinutes", new Class[]{Integer.TYPE}).invoke(a, new Object[]{Integer.valueOf(1440)});
                            cls = Class.forName("com.tencent.stat.StatReportStrategy");
                            a.getMethod("setStatSendStrategy", new Class[]{cls}).invoke(a, new Object[]{cls.getField("PERIOD").get(null)});
                            b.getMethod("startStatService", new Class[]{Context.class, String.class, String.class}).invoke(b, new Object[]{context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null)});
                            g = true;
                        }
                    } else if (opt instanceof Boolean) {
                        z = ((Boolean) opt).booleanValue();
                        if (z) {
                            f.invoke(a, new Object[]{Boolean.valueOf(false)});
                        } else {
                            f.invoke(a, new Object[]{Boolean.valueOf(true)});
                        }
                        a.getMethod("setAutoExceptionCaught", new Class[]{Boolean.TYPE}).invoke(a, new Object[]{Boolean.valueOf(false)});
                        a.getMethod("setEnableSmartReporting", new Class[]{Boolean.TYPE}).invoke(a, new Object[]{Boolean.valueOf(true)});
                        a.getMethod("setSendPeriodMinutes", new Class[]{Integer.TYPE}).invoke(a, new Object[]{Integer.valueOf(1440)});
                        cls = Class.forName("com.tencent.stat.StatReportStrategy");
                        a.getMethod("setStatSendStrategy", new Class[]{cls}).invoke(a, new Object[]{cls.getField("PERIOD").get(null)});
                        b.getMethod("startStatService", new Class[]{Context.class, String.class, String.class}).invoke(b, new Object[]{context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null)});
                        g = true;
                    }
                }
                z = false;
                if (z) {
                    f.invoke(a, new Object[]{Boolean.valueOf(true)});
                } else {
                    f.invoke(a, new Object[]{Boolean.valueOf(false)});
                }
            } catch (Exception e) {
            }
            a.getMethod("setAutoExceptionCaught", new Class[]{Boolean.TYPE}).invoke(a, new Object[]{Boolean.valueOf(false)});
            a.getMethod("setEnableSmartReporting", new Class[]{Boolean.TYPE}).invoke(a, new Object[]{Boolean.valueOf(true)});
            a.getMethod("setSendPeriodMinutes", new Class[]{Integer.TYPE}).invoke(a, new Object[]{Integer.valueOf(1440)});
            cls = Class.forName("com.tencent.stat.StatReportStrategy");
            a.getMethod("setStatSendStrategy", new Class[]{cls}).invoke(a, new Object[]{cls.getField("PERIOD").get(null)});
            b.getMethod("startStatService", new Class[]{Context.class, String.class, String.class}).invoke(b, new Object[]{context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null)});
            g = true;
        } catch (Exception e2) {
        }
    }
}
