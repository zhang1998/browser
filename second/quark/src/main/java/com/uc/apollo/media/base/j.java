package com.uc.apollo.media.base;

import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.uc.apollo.android.SystemProperties;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public final class j {
    public static final boolean a = a();

    /* compiled from: ProGuard */
    final class a {
        private static Class a;
        private static Field b;
        private static Field c;
        private static Field d;
        private static Field e;
        private static Field f;
        private static Field g;
        private static Field h;
        private static Field i;
        private static Constructor j;
        private static Method k;

        private static Field a(String str) {
            try {
                Field declaredField = a.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Throwable th) {
                return null;
            }
        }

        public static boolean a(View view, LayoutParams layoutParams) {
            if (!a()) {
                return false;
            }
            try {
                Object newInstance = j.newInstance(new Object[0]);
                LayoutParams layoutParams2 = (LayoutParams) c.get(newInstance);
                layoutParams2.copyFrom(layoutParams);
                if (f != null) {
                    f.set(newInstance, Integer.valueOf(layoutParams.x));
                }
                if (g != null) {
                    g.set(newInstance, Integer.valueOf(layoutParams.y));
                }
                if (e != null) {
                    e.set(newInstance, Integer.valueOf(layoutParams.gravity));
                }
                if (h != null) {
                    h.set(newInstance, Float.valueOf(layoutParams.horizontalMargin));
                }
                if (i != null) {
                    i.set(newInstance, Float.valueOf(layoutParams.verticalMargin));
                }
                b.set(newInstance, null);
                d.set(newInstance, view);
                k.invoke(newInstance, new Object[0]);
                layoutParams.copyFrom(layoutParams2);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }

        private static boolean a() {
            if (a == null) {
                try {
                    Class cls = Class.forName("android.widget.Toast$TN");
                    a = cls;
                    Constructor constructor = cls.getDeclaredConstructors()[0];
                    j = constructor;
                    constructor.setAccessible(true);
                    Method declaredMethod = a.getDeclaredMethod("handleShow", new Class[0]);
                    k = declaredMethod;
                    declaredMethod.setAccessible(true);
                    b = a("mView");
                    c = a("mParams");
                    d = a("mNextView");
                    e = a("mGravity");
                    f = a("mX");
                    g = a("mY");
                    h = a("mHorizontalMargin");
                    i = a("mVerticalMargin");
                } catch (Throwable th) {
                }
            }
            if (a == null || j == null || c == null || d == null || k == null || b == null) {
                return false;
            }
            return true;
        }
    }

    private static boolean a() {
        try {
            String str = SystemProperties.get("ro.miui.ui.version.name", "");
            if (str == null || str.length() <= 0 || Integer.valueOf(str.substring(str.length() - 1)).intValue() < 8) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(View view, LayoutParams layoutParams) {
        return a.a(view, layoutParams);
    }
}
