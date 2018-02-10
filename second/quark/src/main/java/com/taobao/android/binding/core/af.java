package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ui.component.ab;
import java.util.Map;

/* compiled from: ProGuard */
final class af implements bf {
    private af() {
    }

    public final void a(@NonNull ab abVar, @NonNull View view, @NonNull Object obj, @NonNull Map<String, Object> map) {
        as.a(view, new ae(this, map, view, obj));
    }
}
