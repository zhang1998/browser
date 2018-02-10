package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ui.component.ab;
import java.util.Map;

/* compiled from: ProGuard */
final class q implements bf {
    private q() {
    }

    public final void a(@NonNull ab abVar, @NonNull View view, @NonNull Object obj, @NonNull Map<String, Object> map) {
        View a = as.a(abVar);
        if (a != null && (obj instanceof Double)) {
            as.a(a, new p(this, a, ((Double) obj).doubleValue(), abVar.getInstance()));
        }
    }
}
