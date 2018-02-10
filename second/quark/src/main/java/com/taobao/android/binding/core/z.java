package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ui.component.ab;
import java.util.Map;

/* compiled from: ProGuard */
final class z implements bf {
    private z() {
    }

    public final void a(@NonNull ab abVar, @NonNull View view, @NonNull Object obj, @NonNull Map<String, Object> map) {
        if (obj instanceof Double) {
            as.a(view, new y(this, map, view, obj));
        }
    }
}
