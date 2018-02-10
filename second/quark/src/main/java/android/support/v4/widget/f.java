package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
final class f {
    private static Field a;

    static {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
        }
    }

    static void a(PopupWindow popupWindow, boolean z) {
        if (a != null) {
            try {
                a.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
            }
        }
    }
}
