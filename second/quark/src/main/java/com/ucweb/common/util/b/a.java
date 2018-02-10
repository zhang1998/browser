package com.ucweb.common.util.b;

import java.lang.reflect.Field;

/* compiled from: ProGuard */
public final class a {
    public static final String[] a = new String[]{"android.os.StrictMode$ThreadPolicy", "android.os.StrictMode$VmPolicy"};
    public static final String[] b = new String[]{"setThreadPolicy", "setVmPolicy"};

    public static Object a(Object obj, String str) {
        Object obj2 = null;
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            obj2 = declaredField.get(obj);
        } catch (NoSuchFieldException e) {
        } catch (Exception e2) {
        }
        return obj2;
    }

    public static Object b(Object obj, String str) {
        try {
            Class superclass = obj.getClass().getSuperclass();
            Field field = null;
            while (superclass != null) {
                try {
                    field = superclass.getDeclaredField(str);
                    if (field != null) {
                        break;
                    }
                } catch (Exception e) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (field == null) {
                return null;
            }
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e2) {
            return null;
        }
    }

    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        Object obj2 = null;
        try {
            obj2 = obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception e) {
        }
        return obj2;
    }
}
