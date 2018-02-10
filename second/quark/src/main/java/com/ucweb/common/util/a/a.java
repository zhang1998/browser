package com.ucweb.common.util.a;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
public final class a {
    public static final Paint a = new Paint();
    public static final Paint b = new Paint();
    public static boolean c = false;
    private static int d = 1610612736;

    static {
        a.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        b.setXfermode(new PorterDuffXfermode(Mode.SRC));
    }

    public static int a() {
        int i = d;
        d = i + 1;
        return i;
    }

    public static float a(Context context, float f) {
        return (context.getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public static boolean a(View view, Drawable drawable) {
        return a(view, drawable, "setVerticalThumbDrawable");
    }

    private static boolean a(View view, Drawable drawable, String str) {
        try {
            Object a = a(view);
            if (a == null) {
                return false;
            }
            a.getClass().getMethod(str, new Class[]{Drawable.class}).invoke(a, new Object[]{drawable});
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static Object a(View view) {
        Object obj = null;
        try {
            Field declaredField = View.class.getDeclaredField("mScrollCache");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(view);
            if (obj2 != null) {
                Field declaredField2 = obj2.getClass().getDeclaredField("scrollBar");
                declaredField2.setAccessible(true);
                obj = declaredField2.get(obj2);
            }
        } catch (Exception e) {
        }
        return obj;
    }

    private static Object a(TextView textView) {
        Object obj = null;
        if (VERSION.SDK_INT >= 11) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mEditor");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(textView);
                if (obj2 != null) {
                    Field declaredField2 = obj2.getClass().getDeclaredField("mCursorDrawable");
                    declaredField2.setAccessible(true);
                    obj = declaredField2.get(obj2);
                }
            } catch (Exception e) {
            }
        }
        return obj;
    }

    public static void a(TextView textView, Drawable drawable) {
        if (VERSION.SDK_INT >= 11) {
            try {
                if (VERSION.SDK_INT >= 11) {
                    try {
                        TextView.class.getDeclaredField("mCursorDrawableRes").setAccessible(true);
                    } catch (Exception e) {
                    }
                }
                Object a = a(textView);
                if (a != null) {
                    Array.set(a, 0, drawable);
                    Array.set(a, 1, drawable);
                }
            } catch (Exception e2) {
            }
        }
    }
}
