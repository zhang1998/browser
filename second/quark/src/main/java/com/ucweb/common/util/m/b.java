package com.ucweb.common.util.m;

import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
public final class b {
    public static boolean a(View view, Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(view, new a(view.getContext()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
