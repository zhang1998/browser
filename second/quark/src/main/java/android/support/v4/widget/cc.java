package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
class cc extends ak {
    cc() {
    }

    public void a(PopupWindow popupWindow, int i) {
        if (!c.b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                c.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e) {
            }
            c.b = true;
        }
        if (c.a != null) {
            try {
                c.a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
