package android.mini.support.v4.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
final class ab {
    private static Field a;
    private static boolean b;

    static void a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!b) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            b = true;
        }
        if (a != null) {
            try {
                a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
