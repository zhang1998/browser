package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.d.b;
import android.support.v4.view.ViewCompat;
import android.support.v7.c.h;
import android.support.v7.view.a;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

/* compiled from: ProGuard */
final class t {
    private static final Class<?>[] a = new Class[]{Context.class, AttributeSet.class};
    private static final int[] b = new int[]{16843375};
    private static final String[] c = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> d = new b();
    private final Object[] e = new Object[2];

    t() {
    }

    final View a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.e[0] = context;
            this.e[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                for (String a2 : c) {
                    a = a(context, str, a2);
                    if (a != null) {
                        return a;
                    }
                }
                this.e[0] = null;
                this.e[1] = null;
                return null;
            }
            a = a(context, str, null);
            this.e[0] = null;
            this.e[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.e[0] = null;
            this.e[1] = null;
        }
    }

    static void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || ViewCompat.F(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new v(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View a(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        Constructor constructor = (Constructor) d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(a);
                d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.e);
    }

    static Context a(Context context, AttributeSet attributeSet, boolean z) {
        int resourceId;
        int resourceId2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.View, 0, 0);
        if (z) {
            resourceId = obtainStyledAttributes.getResourceId(h.View_android_theme, 0);
        } else {
            resourceId = 0;
        }
        if (resourceId == 0) {
            resourceId2 = obtainStyledAttributes.getResourceId(h.View_theme, 0);
        } else {
            resourceId2 = resourceId;
        }
        obtainStyledAttributes.recycle();
        if (resourceId2 == 0) {
            return context;
        }
        if ((context instanceof a) && ((a) context).a == resourceId2) {
            return context;
        }
        return new a(context, resourceId2);
    }
}
