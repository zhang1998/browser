package com.uc.apollo.util;

import com.uc.apollo.annotation.KeepForRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@KeepForRuntime
/* compiled from: ProGuard */
public class ReflectUtil {
    private static final Map<Class<?>, Class<?>> sPrimitiveTypes;

    static {
        Map hashMap = new HashMap();
        sPrimitiveTypes = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        sPrimitiveTypes.put(Character.class, Character.TYPE);
        sPrimitiveTypes.put(Byte.class, Byte.TYPE);
        sPrimitiveTypes.put(Short.class, Short.TYPE);
        sPrimitiveTypes.put(Integer.class, Integer.TYPE);
        sPrimitiveTypes.put(Long.class, Long.TYPE);
        sPrimitiveTypes.put(Float.class, Float.TYPE);
        sPrimitiveTypes.put(Double.class, Double.TYPE);
        sPrimitiveTypes.put(Void.class, Void.TYPE);
    }

    private static Class<?>[] getParamTypes(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i != objArr.length; i++) {
            Class cls;
            int i2;
            Class[] clsArr2;
            Object obj = objArr[i];
            if (obj == null) {
                cls = null;
                i2 = i;
                clsArr2 = clsArr;
            } else {
                Class cls2 = obj.getClass();
                cls = (Class) sPrimitiveTypes.get(cls2);
                Class<?>[] clsArr3;
                if (cls != null) {
                    i2 = i;
                    clsArr3 = clsArr;
                } else {
                    cls = cls2;
                    clsArr3 = clsArr;
                    i2 = i;
                }
            }
            clsArr2[i2] = cls;
        }
        return clsArr;
    }

    public static <T> T call(Class<T> cls, Object obj, Method method, Object... objArr) {
        if (method != null) {
            try {
                T invoke = method.invoke(obj, objArr);
                if (cls == Void.TYPE) {
                    return null;
                }
                return invoke;
            } catch (Exception e) {
            }
        }
        return getDefaultValue(cls);
    }

    public static <T> T call(Class<T> cls, Method method, Object... objArr) {
        return call((Class) cls, null, method, objArr);
    }

    public static <T> T call(Class<T> cls, Class<?> cls2, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        return call((Class) cls, obj, getMethod((Class) cls2, str, (Class[]) clsArr), objArr);
    }

    public static <T> T call(Class<T> cls, Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        return call(cls, obj.getClass(), obj, str, getParamTypes(objArr), objArr);
    }

    public static <T> T call(Class<T> cls, String str, String str2) {
        return call((Class) cls, str, str2, new Class[0], new Object[0]);
    }

    public static <T> T call(Class<T> cls, String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        return call(cls, getClass(str), null, str2, clsArr, objArr);
    }

    public static <T> T call(Class<T> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        if (obj == null) {
            return null;
        }
        return call(cls, obj.getClass(), obj, str, clsArr, objArr);
    }

    public static <T> T call(Class<T> cls, Class<?> cls2, String str, Object... objArr) {
        if (cls2 == null) {
            return null;
        }
        return call(cls, cls2, null, str, getParamTypes(objArr), objArr);
    }

    public static <T> T call(Class<T> cls, Class<?> cls2, String str, Class<?>[] clsArr, Object[] objArr) {
        if (cls2 == null) {
            return null;
        }
        return call(cls, cls2, null, str, clsArr, objArr);
    }

    public static Object newObject(ClassLoader classLoader, String str, Class<?>[] clsArr, Object[] objArr) {
        return newObject(getCtor(getClass(classLoader, str), (Class[]) clsArr), objArr);
    }

    public static Object newObject(String str, Object... objArr) {
        return newObject(getClass(str), objArr);
    }

    public static <T> T newObject(Class<T> cls, Object... objArr) {
        if (cls == null) {
            return null;
        }
        return newObject(getCtor((Class) cls, objArr), objArr);
    }

    public static <T> T newObject(Constructor<T> constructor, Object... objArr) {
        T t = null;
        if (constructor != null) {
            try {
                t = constructor.newInstance(objArr);
            } catch (Exception e) {
            }
        }
        return t;
    }

    public static Constructor<?> getCtor(Class<?> cls, Object... objArr) {
        return getCtor((Class) cls, getParamTypes(objArr));
    }

    public static Constructor<?> getCtor(String str, Class<?>... clsArr) {
        return getCtor(getClass(str), (Class[]) clsArr);
    }

    public static Constructor<?> getCtor(Class<?> cls, Class<?>... clsArr) {
        Constructor<?> constructor = null;
        if (cls != null) {
            try {
                constructor = getCtor2(cls, clsArr);
            } catch (Exception e) {
            }
        }
        return constructor;
    }

    public static Constructor<?> getCtor2(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        if (cls == null) {
            throw new IllegalArgumentException("null class");
        }
        Constructor<?> constructor;
        try {
            constructor = cls.getConstructor(clsArr);
        } catch (Exception e) {
            constructor = cls.getDeclaredConstructor(clsArr);
        }
        constructor.setAccessible(true);
        return constructor;
    }

    public static <T> T getValue(Class<T> cls, String str, String str2) {
        return getValue((Class) cls, getClass(str), str2, null);
    }

    public static <T> T getValue(Class<T> cls, Class<?> cls2, String str) {
        return getValue((Class) cls, null, getField((Class) cls2, str), null);
    }

    public static <T> T getValue(Class<T> cls, Object obj, String str) {
        return getValue((Class) cls, obj, getField(obj, str), null);
    }

    public static <T> T getValue(Class<T> cls, String str, String str2, T t) {
        return getValue((Class) cls, getClass(str), str2, (Object) t);
    }

    public static <T> T getValue(Class<T> cls, Class<?> cls2, String str, T t) {
        return getValue((Class) cls, null, getField((Class) cls2, str), (Object) t);
    }

    public static <T> T getValue(Class<T> cls, Object obj, String str, T t) {
        return getValue((Class) cls, obj, getField(obj, str), (Object) t);
    }

    public static <T> T getValue(Class<T> cls, Object obj, Field field, T t) {
        if (field != null) {
            Class type = field.getType();
            try {
                if (Boolean.TYPE == type) {
                    return Boolean.valueOf(field.getBoolean(obj));
                }
                if (Character.TYPE == type) {
                    return Character.valueOf(field.getChar(obj));
                }
                if (Byte.TYPE == type) {
                    return Byte.valueOf(field.getByte(obj));
                }
                if (Short.TYPE == type) {
                    return Short.valueOf(field.getShort(obj));
                }
                if (Integer.TYPE == type) {
                    return Integer.valueOf(field.getInt(obj));
                }
                if (Long.TYPE == type) {
                    return Long.valueOf(field.getLong(obj));
                }
                if (Float.TYPE == type) {
                    return Float.valueOf(field.getFloat(obj));
                }
                if (Double.TYPE == type) {
                    return Double.valueOf(field.getDouble(obj));
                }
                return field.get(obj);
            } catch (Exception e) {
            }
        }
        if (t == null) {
            return getDefaultValue(cls);
        }
        return t;
    }

    public static void setValue(Object obj, String str, Object obj2) {
        if (obj != null) {
            setValue(obj, getField(obj, str), obj2);
        }
    }

    public static void setValue(Object obj, Field field, Object obj2) {
        if (field != null) {
            Class type = field.getType();
            try {
                if (Boolean.TYPE == type) {
                    field.setBoolean(obj, ((Boolean) obj2).booleanValue());
                } else if (Character.TYPE == type) {
                    field.setChar(obj, ((Character) obj2).charValue());
                } else if (Byte.TYPE == type) {
                    field.setByte(obj, ((Byte) obj2).byteValue());
                } else if (Short.TYPE == type) {
                    field.setShort(obj, ((Short) obj2).shortValue());
                } else if (Integer.TYPE == type) {
                    field.setInt(obj, ((Integer) obj2).intValue());
                } else if (Long.TYPE == type) {
                    field.setLong(obj, ((Long) obj2).longValue());
                } else if (Float.TYPE == type) {
                    field.setFloat(obj, ((Float) obj2).floatValue());
                } else if (Double.TYPE == type) {
                    field.setDouble(obj, ((Double) obj2).doubleValue());
                } else {
                    field.set(obj, obj2);
                }
            } catch (Exception e) {
            }
        }
    }

    public static Method getMethod(Object obj, String str, Class<?>... clsArr) {
        if (obj == null) {
            return null;
        }
        return getMethod(obj.getClass(), str, (Class[]) clsArr);
    }

    public static Method getMethod(String str, String str2, Class<?>... clsArr) {
        return getMethod(getClass(str), str2, (Class[]) clsArr);
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (Throwable th) {
            return null;
        }
        method.setAccessible(true);
        return method;
    }

    public static Method getMethod2(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (Throwable th) {
            method = cls.getDeclaredMethod(str, clsArr);
        }
        method.setAccessible(true);
        return method;
    }

    public static Field getField(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return getField(obj.getClass(), str);
    }

    public static Field getField(String str, String str2) {
        Class cls = getClass(str);
        return cls != null ? getField(cls, str2) : null;
    }

    public static Field getField(Class<?> cls, String str) {
        if (cls == null) {
            return null;
        }
        Field field;
        try {
            field = cls.getField(str);
        } catch (Throwable th) {
            return null;
        }
        field.setAccessible(true);
        return field;
    }

    public static Field getField2(Class<?> cls, String str) throws NoSuchFieldException {
        Field field;
        try {
            field = cls.getField(str);
        } catch (Throwable th) {
            field = cls.getDeclaredField(str);
        }
        field.setAccessible(true);
        return field;
    }

    public static Class<?> getClass(ClassLoader classLoader, String str) {
        if (!(classLoader == null || str == null)) {
            try {
                if (str.length() > 0) {
                    return Class.forName(str, false, classLoader);
                }
            } catch (Throwable th) {
            }
        }
        return getClass(str);
    }

    public static Class<?> getClass(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return Class.forName(str);
                }
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public static Class<?> getClassSliently(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return Class.forName(str);
                }
            } catch (Throwable th) {
            }
        }
        return null;
    }

    private static <T> T getDefaultValue(Class<T> cls) {
        if (Void.TYPE == cls) {
            return null;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.FALSE;
        }
        if (Byte.TYPE == cls) {
            return Byte.valueOf((byte) 0);
        }
        if (Short.TYPE == cls) {
            return Short.valueOf((short) 0);
        }
        if (Integer.TYPE == cls) {
            return Integer.valueOf(0);
        }
        if (Long.TYPE == cls) {
            return Long.valueOf(0);
        }
        if (Float.TYPE == cls) {
            return Float.valueOf(0.0f);
        }
        if (Double.TYPE == cls) {
            return Double.valueOf(0.0d);
        }
        return null;
    }
}
