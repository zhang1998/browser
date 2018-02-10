package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ui.component.ab;
import java.util.Map;

/* compiled from: ProGuard */
final class an implements bf {
    private an() {
    }

    public final void a(@NonNull ab abVar, @NonNull View view, @NonNull Object obj, @NonNull Map<String, Object> map) {
        if (obj instanceof Double) {
            as.a(view, new am(this, view, ((Double) obj).doubleValue(), abVar.getInstance()));
        }
    }
}
