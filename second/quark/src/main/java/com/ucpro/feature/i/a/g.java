package com.ucpro.feature.i.a;

import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
final class g implements b {
    private g() {
    }

    public final void a(Window window, boolean z) {
        LayoutParams attributes = window.getAttributes();
        try {
            Field declaredField = LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            if (z) {
                i |= i2;
            } else {
                i = (i ^ -1) & i2;
            }
            declaredField2.setInt(attributes, i);
            window.setAttributes(attributes);
            declaredField.setAccessible(false);
            declaredField2.setAccessible(false);
        } catch (Exception e) {
        }
    }
}
