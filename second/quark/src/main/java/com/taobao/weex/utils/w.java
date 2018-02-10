package com.taobao.weex.utils;

import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.a.e;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* compiled from: ProGuard */
public final class w {
    public static Object a(Type type, Object obj) {
        if (type == String.class) {
            if (obj instanceof String) {
                return obj;
            }
            return a.a(obj);
        } else if (type == Integer.TYPE) {
            if (obj.getClass().isAssignableFrom(Integer.TYPE)) {
                return obj;
            }
            return Integer.valueOf(ah.b(obj));
        } else if (type == Long.TYPE) {
            if (obj.getClass().isAssignableFrom(Long.TYPE)) {
                return obj;
            }
            return Long.valueOf(ah.c(obj));
        } else if (type == Double.TYPE) {
            if (obj.getClass().isAssignableFrom(Double.TYPE)) {
                return obj;
            }
            return Double.valueOf(ah.d(obj));
        } else if (type != Float.TYPE) {
            return a.a(obj instanceof String ? (String) obj : a.a(obj), type, new e[0]);
        } else if (obj.getClass().isAssignableFrom(Float.TYPE)) {
            return obj;
        } else {
            return Float.valueOf(ah.a(obj));
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                Object valueOf;
                Field a = a(obj, str);
                if ((obj2 instanceof BigDecimal) || (obj2 instanceof Number) || (obj2 instanceof String)) {
                    if (a.getType() == Float.class || a.getType() == Float.TYPE) {
                        valueOf = Float.valueOf(Float.parseFloat(obj2.toString()));
                        if ((a.getType() == Boolean.TYPE || a.getType() == Boolean.class) && obj2 != null) {
                            valueOf = Boolean.valueOf(obj2.toString());
                        }
                        if (obj != null && a != null) {
                            try {
                                a.setAccessible(true);
                                a.set(obj, valueOf);
                                return;
                            } catch (Exception e) {
                                return;
                            }
                        }
                    } else if (a.getType() == Double.class || a.getType() == Double.TYPE) {
                        valueOf = Double.valueOf(Double.parseDouble(obj2.toString()));
                        valueOf = Boolean.valueOf(obj2.toString());
                        if (obj != null) {
                        }
                    } else if (a.getType() == Integer.class || a.getType() == Integer.TYPE) {
                        valueOf = Integer.valueOf((int) Double.parseDouble(obj2.toString()));
                        valueOf = Boolean.valueOf(obj2.toString());
                        if (obj != null) {
                        }
                    } else if (a.getType() == Boolean.class || a.getType() == Boolean.TYPE) {
                        valueOf = Boolean.valueOf(obj2.toString());
                        valueOf = Boolean.valueOf(obj2.toString());
                        if (obj != null) {
                        }
                    }
                }
                valueOf = obj2;
                valueOf = Boolean.valueOf(obj2.toString());
                if (obj != null) {
                }
            } catch (Exception e2) {
            }
        }
    }

    private static Field a(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }
}
