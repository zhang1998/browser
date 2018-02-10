package android.support.v4.b.a;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
final class j {
    static Method a;
    static boolean b;
    private static Method c;
    private static boolean d;

    public static int a(Drawable drawable) {
        if (!d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            d = true;
        }
        if (c != null) {
            try {
                return ((Integer) c.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                c = null;
            }
        }
        return -1;
    }
}
