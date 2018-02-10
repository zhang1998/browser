package com.alibaba.analytics.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public final class u {
    public static Object a(Class cls, String str) {
        Object obj = null;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            obj = declaredMethod.invoke(null, new Object[0]);
        } catch (SecurityException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalArgumentException e3) {
        } catch (IllegalAccessException e4) {
        } catch (InvocationTargetException e5) {
        }
        return obj;
    }

    public static Object a(Class cls, String str, Object[] objArr, Class... clsArr) {
        Object obj = null;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            obj = declaredMethod.invoke(null, objArr);
        } catch (SecurityException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalArgumentException e3) {
        } catch (IllegalAccessException e4) {
        } catch (InvocationTargetException e5) {
        }
        return obj;
    }

    public static Object a(Object obj, String str, Object[] objArr, Class... clsArr) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (SecurityException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            return null;
        } catch (IllegalArgumentException e3) {
            return null;
        } catch (IllegalAccessException e4) {
            return null;
        } catch (InvocationTargetException e5) {
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, new Object[0]);
        } catch (SecurityException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            return null;
        } catch (IllegalArgumentException e3) {
            return null;
        } catch (IllegalAccessException e4) {
            return null;
        } catch (InvocationTargetException e5) {
            return null;
        }
    }

    public static Object a(String str, String str2) {
        try {
            Class cls = Class.forName(str);
            if (cls != null) {
                return a(cls, str2);
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }
}
