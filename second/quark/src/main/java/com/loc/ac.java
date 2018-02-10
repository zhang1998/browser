package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Constructor;

/* compiled from: ProGuard */
public final class ac {
    public static <T> T a(Context context, ep epVar, String str, Class cls, Class[] clsArr, Object[] objArr) throws dw {
        af a;
        T t = null;
        try {
            a = ag.a().a(context, epVar);
        } catch (Throwable th) {
            es.a(th, "InstanceFactory", "getInstance1");
            a = null;
        }
        if (a != null) {
            try {
                if (a.a() && a.d) {
                    Class loadClass = a.loadClass(str);
                    if (loadClass != null) {
                        Constructor declaredConstructor = loadClass.getDeclaredConstructor(clsArr);
                        declaredConstructor.setAccessible(true);
                        t = declaredConstructor.newInstance(objArr);
                        return t;
                    }
                }
            } catch (Throwable th2) {
                es.a(th2, "InstanceFactory", "getInstance1()");
            }
        }
        if (cls != null) {
            try {
                Constructor declaredConstructor2 = cls.getDeclaredConstructor(clsArr);
                declaredConstructor2.setAccessible(true);
                t = declaredConstructor2.newInstance(objArr);
            } catch (Throwable th3) {
                es.a(th3, "InstanceFactory", "getInstance2()");
                dw dwVar = new dw("获取对象错误");
            }
        }
        return t;
    }

    public static void a(Context context, aa aaVar, ep epVar) {
        if (aaVar != null) {
            try {
                if (!TextUtils.isEmpty(aaVar.a) && !TextUtils.isEmpty(aaVar.b) && !TextUtils.isEmpty(aaVar.e)) {
                    new z(context, aaVar, epVar).start();
                }
            } catch (Throwable th) {
                es.a(th, "InstanceFactory", "dDownload()");
            }
        }
    }

    public static void a(Context context, String str) {
        try {
            fa.b().submit(new ab(context, str));
        } catch (Throwable th) {
            es.a(th, "InstanceFactory", "rollBack");
        }
    }

    public static boolean a(Context context, ep epVar) {
        try {
            return new File(ak.b(context, epVar.a(), epVar.b())).exists();
        } catch (Throwable th) {
            es.a(th, "IFactory", "isdowned");
            return false;
        }
    }
}
