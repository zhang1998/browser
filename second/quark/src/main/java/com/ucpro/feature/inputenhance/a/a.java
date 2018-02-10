package com.ucpro.feature.inputenhance.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.ucpro.base.system.b;

/* compiled from: ProGuard */
public final class a {
    public static Rect a(Context context) {
        Rect rect = new Rect();
        if (context != null && (context instanceof Activity)) {
            Window window = ((Activity) context).getWindow();
            if (window != null) {
                View decorView = window.getDecorView();
                if (decorView != null) {
                    decorView.getWindowVisibleDisplayFrame(rect);
                }
            }
        }
        return rect;
    }

    public static boolean a() {
        return b.a.f() < b.a.g();
    }
}
