package com.uc.apollo.util;

import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class g {

    /* compiled from: ProGuard */
    public interface c {
        void a(WindowManager windowManager, View view, LayoutParams layoutParams, int i);
    }

    /* compiled from: ProGuard */
    public final class a implements c {
        public final void a(WindowManager windowManager, View view, LayoutParams layoutParams, int i) {
            try {
                layoutParams.type = i;
                windowManager.updateViewLayout(view, layoutParams);
            } catch (Throwable th) {
            }
        }
    }

    /* compiled from: ProGuard */
    public final class b implements c {
        public final void a(WindowManager windowManager, View view, LayoutParams layoutParams, int i) {
            try {
                layoutParams.type = i;
                windowManager.updateViewLayout(view, layoutParams);
                d.a(view, i);
            } catch (Throwable th) {
            }
        }
    }

    /* compiled from: ProGuard */
    final class d {
        static Method a;
        static Object b;
        static Object c = ReflectUtil.getValue(Object.class, b, "mLock");
        static ArrayList<Object> d = ((ArrayList) ReflectUtil.getValue(ArrayList.class, b, "mRoots"));

        static {
            Class cls = ReflectUtil.getClass("android.view.WindowManagerGlobal");
            a = ReflectUtil.getMethod(cls, "findViewLocked", View.class, Boolean.TYPE);
            Object call = ReflectUtil.call(Object.class, cls, "getInstance", new Object[0]);
            b = call;
            if (call != null) {
            }
        }

        static void a(View view, int i) {
            synchronized (c) {
                try {
                    LayoutParams layoutParams = (LayoutParams) ReflectUtil.getValue(LayoutParams.class, d.get(((Integer) ReflectUtil.call(Integer.TYPE, b, a, view, Boolean.valueOf(true))).intValue()), "mWindowAttributes");
                    if (layoutParams != null) {
                        layoutParams.type = i;
                    }
                } catch (Throwable th) {
                }
            }
        }
    }
}
