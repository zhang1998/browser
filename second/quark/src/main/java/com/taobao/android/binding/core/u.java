package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.taobao.weex.ui.component.ab;
import java.util.Map;

/* compiled from: ProGuard */
final class u implements bf {
    private u() {
    }

    public final void a(@NonNull ab abVar, @NonNull View view, @NonNull Object obj, @NonNull Map<String, Object> map) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = (int) as.a(doubleValue, abVar.getInstance());
            as.a(view, new t(this, view, layoutParams));
        }
    }
}
