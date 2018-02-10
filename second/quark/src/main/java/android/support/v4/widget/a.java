package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
final class a {
    private static Field a;
    private static boolean b;

    static Drawable a(CompoundButton compoundButton) {
        if (!b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            b = true;
        }
        if (a != null) {
            try {
                return (Drawable) a.get(compoundButton);
            } catch (IllegalAccessException e2) {
                a = null;
            }
        }
        return null;
    }
}
