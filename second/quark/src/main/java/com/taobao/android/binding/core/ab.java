package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.view.View;
import java.util.Map;

/* compiled from: ProGuard */
final class ab implements bf {
    private ab() {
    }

    public final void a(@NonNull com.taobao.weex.ui.component.ab abVar, @NonNull View view, @NonNull Object obj, @NonNull Map<String, Object> map) {
        if (obj instanceof Double) {
            as.a(view, new aa(this, map, view, obj));
        }
    }
}
