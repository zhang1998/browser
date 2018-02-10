package com.ucpro.feature.navigation.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.List;

/* compiled from: ProGuard */
public final class t {
    private static int[] a = new int[2];
    private static int b = -1;

    public static void a(View view, View view2, Rect rect) {
        view2.getLocationInWindow(a);
        int i = a[0];
        int i2 = a[1];
        view.getLocationInWindow(a);
        i = a[0] - i;
        i2 = a[1] - i2;
        rect.set(i, i2, view.getMeasuredWidth() + i, view.getMeasuredHeight() + i2);
    }

    public static <T extends List> T a(T t, int i, int i2) {
        t.add(i2, t.remove(i));
        return t;
    }

    public static int a(Context context) {
        if (b == -1) {
            b = ViewConfiguration.get(context).getScaledTouchSlop();
        }
        return b;
    }

    public static Rect a(View view) {
        Rect rect = new Rect();
        if (view != null) {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        return rect;
    }

    public static Rect a(Rect rect, Rect rect2) {
        Rect rect3 = new Rect();
        if (Math.abs(rect.left - rect2.left) <= rect.width() && Math.abs(rect.top - rect2.top) <= rect.height()) {
            rect3.left = Math.max(rect.left, rect2.left);
            rect3.top = Math.max(rect.top, rect2.top);
            rect3.right = Math.min(rect.right, rect2.right);
            rect3.bottom = Math.min(rect.bottom, rect2.bottom);
        }
        return rect3;
    }
}
