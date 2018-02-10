package android.support.v4.b.a;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
class u extends p {
    u() {
    }

    public int c(Drawable drawable) {
        int a = j.a(drawable);
        return a >= 0 ? a : 0;
    }

    public void a(Drawable drawable, int i) {
        if (!j.b) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                j.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            j.b = true;
        }
        if (j.a != null) {
            try {
                j.a.invoke(drawable, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
                j.a = null;
            }
        }
    }
}
