package com.uc.webview.export.internal.utility;

import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.SDKFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Interface
/* compiled from: ProGuard */
public class ReflectionUtil {

    @Interface
    /* compiled from: ProGuard */
    public final class BindingMethod<T> {
        private Class<?> a;
        private Method b;
        private T c;

        public BindingMethod(Class<?> cls, String str) {
            this(cls, str, null);
        }

        public BindingMethod(Class<?> cls, String str, Class<?>[] clsArr) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.a = cls;
            try {
                this.b = this.a.getDeclaredMethod(str, clsArr);
            } catch (Throwable th) {
                try {
                    this.b = this.a.getMethod(str, clsArr);
                } catch (NoSuchMethodException e) {
                    throw new NoSuchMethodError(e.getMessage());
                }
            }
        }

        public final T invoke() {
            return invoke(null, null);
        }

        public final T invoke(Object[] objArr) {
            return invoke(null, objArr);
        }

        public final T invoke(Object obj) {
            return invoke(obj, null);
        }

        public final T invoke(Object obj, Object[] objArr) {
            Throwable targetException;
            try {
                return this.b.invoke(obj, objArr);
            } catch (InvocationTargetException e) {
                targetException = e.getTargetException();
                if (targetException instanceof RuntimeException) {
                    throw ((RuntimeException) targetException);
                } else if (targetException instanceof Error) {
                    throw ((Error) targetException);
                } else {
                    throw new RuntimeException(targetException);
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Throwable targetException2) {
                throw new RuntimeException(targetException2);
            }
        }

        public final T getInstance() {
            if (this.c == null) {
                this.c = a();
            }
            return this.c;
        }

        private synchronized T a() {
            if (this.c == null) {
                this.c = invoke();
            }
            return this.c;
        }
    }

    public static Object invokeNoThrow(String str, String str2) {
        try {
            return invoke(str, str2);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object invokeNoThrow(Class<?> cls, String str) {
        try {
            return invoke((Object) cls, str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object invokeNoThrow(Object obj, String str) {
        try {
            return invoke(obj, str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object invokeNoThrow(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            return invoke(obj, str, clsArr, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object invokeNoThrow(String str, String str2, Class[] clsArr, Object[] objArr) throws Exception {
        try {
            return invoke(Class.forName(str, true, SDKFactory.c), str2, clsArr, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object invoke(String str, String str2) throws Exception {
        return invoke(str, str2, null, null);
    }

    public static Object invoke(String str, String str2, Class[] clsArr) throws Exception {
        return invoke(str, str2, clsArr, null);
    }

    public static Object invoke(String str, String str2, Object[] objArr) throws Exception {
        Class[] clsArr = null;
        if (objArr != null) {
            clsArr = new Class[objArr.length];
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
        }
        return invoke(str, str2, clsArr, objArr);
    }

    public static Object invoke(String str, String str2, Class[] clsArr, Object[] objArr) throws Exception {
        return invoke(Class.forName(str, true, SDKFactory.c), str2, clsArr, objArr);
    }

    public static Object invoke(Object obj, String str) throws Exception {
        return invoke(obj, str, null, new Object[0]);
    }

    public static Object invoke(Object obj, String str, Class[] clsArr, Object[] objArr) throws Exception {
        if (obj == null) {
            return null;
        }
        return invoke(obj, obj.getClass(), str, clsArr, objArr);
    }

    public static Object invoke(Class<?> cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        return invoke(null, cls, str, clsArr, objArr);
    }

    public static Object invoke(Object obj, Class<?> cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Method declaredMethod;
        try {
            declaredMethod = cls.getDeclaredMethod(str, clsArr);
        } catch (Throwable th) {
            declaredMethod = cls.getMethod(str, clsArr);
        }
        return invoke(obj, (Class) cls, declaredMethod, objArr);
    }

    public static Object invoke(Object obj, Class<?> cls, Method method, Object[] objArr) throws Exception {
        method.setAccessible(true);
        try {
            return method.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof Exception) {
                throw ((Exception) targetException);
            } else if (targetException instanceof Error) {
                throw ((Error) targetException);
            } else {
                throw new RuntimeException(targetException);
            }
        }
    }

    public static Object newInstanceNoThrow(String str) {
        try {
            return newInstance(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object newInstance(String str) throws Exception {
        return newInstance(str, null, null);
    }

    public static Object newInstance(String str, Class[] clsArr, Object[] objArr) throws Exception {
        try {
            Constructor constructor = Class.forName(str, true, SDKFactory.c).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof Exception) {
                throw ((Exception) targetException);
            } else if (targetException instanceof Error) {
                throw ((Error) targetException);
            } else {
                throw new RuntimeException(targetException);
            }
        }
    }

    public static ClassLoader getCoreClassLoader() {
        return SDKFactory.c;
    }

    public static Object getStaticField(String str, String str2) throws Exception {
        Object obj = null;
        try {
            obj = Class.forName(str, true, SDKFactory.c).getField(str2).get(null);
        } catch (Exception e) {
        }
        return obj;
    }
}
