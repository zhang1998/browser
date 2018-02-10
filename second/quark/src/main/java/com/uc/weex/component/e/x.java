package com.uc.weex.component.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

/* compiled from: ProGuard */
public final class x {
    private static boolean a = false;
    private static boolean b = false;
    private static final String[] c = new String[]{"M040", "M045"};

    public static void a(View view, int i) {
        try {
            Integer valueOf;
            Integer.valueOf(-1);
            switch (i) {
                case 0:
                    valueOf = Integer.valueOf(a(View.class, "LAYER_TYPE_NONE"));
                    break;
                case 1:
                    valueOf = Integer.valueOf(a(View.class, "LAYER_TYPE_SOFTWARE"));
                    break;
                case 2:
                    valueOf = Integer.valueOf(a(View.class, "LAYER_TYPE_HARDWARE"));
                    break;
                default:
                    throw new RuntimeException("unsupported layer type");
            }
            if (valueOf.intValue() != -1) {
                View.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(view, new Object[]{valueOf, null});
            }
        } catch (Exception e) {
        }
    }

    public static void a(View view) {
        try {
            View.class.getMethod("buildLayer", new Class[0]).invoke(view, new Object[0]);
        } catch (Exception e) {
        }
    }

    private static int a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str).getInt(cls);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void a(Context context, View view, LayoutParams layoutParams) {
        if ((context instanceof Activity) && view != null && view.getParent() != null) {
            if (layoutParams instanceof WindowManager.LayoutParams) {
                WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
                if (layoutParams2.type > 0 && layoutParams2.type <= 99) {
                    layoutParams2.token = null;
                }
                if (layoutParams2.type == 2) {
                    Object obj = context instanceof Activity ? (((Activity) context).getWindow().getAttributes().flags & 1024) != 1024 ? 1 : null : null;
                    if (obj == null) {
                        layoutParams2.flags &= -2049;
                        layoutParams2.flags |= 1024;
                    } else {
                        layoutParams2.flags &= -1025;
                        layoutParams2.flags |= 2048;
                    }
                }
            }
            ((Activity) context).getWindowManager().updateViewLayout(view, layoutParams);
        }
    }

    public static void a(Context context, View view) {
        if ((context instanceof Activity) && view != null && view.getParent() != null) {
            ((Activity) context).getWindowManager().removeView(view);
        }
    }
}
