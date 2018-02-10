package android.support.v4.widget;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
final class bj {
    static Field a;
    static boolean b;
    static Field c;
    static boolean d;

    static Field a(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            Log.e("TextViewCompatDonut", "Could not retrieve " + str + " field.");
            return field;
        }
    }

    static int a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e) {
            new StringBuilder("Could not retrieve value of ").append(field.getName()).append(" field.");
            return -1;
        }
    }
}
