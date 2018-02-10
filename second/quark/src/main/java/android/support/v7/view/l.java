package android.support.v7.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
final class l implements OnMenuItemClickListener {
    private static final Class<?>[] a = new Class[]{MenuItem.class};
    private Object b;
    private Method c;

    public l(Object obj, String str) {
        this.b = obj;
        Class cls = obj.getClass();
        try {
            this.c = cls.getMethod(str, a);
        } catch (Throwable e) {
            InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
            inflateException.initCause(e);
            throw inflateException;
        }
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        try {
            if (this.c.getReturnType() == Boolean.TYPE) {
                return ((Boolean) this.c.invoke(this.b, new Object[]{menuItem})).booleanValue();
            }
            this.c.invoke(this.b, new Object[]{menuItem});
            return true;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
