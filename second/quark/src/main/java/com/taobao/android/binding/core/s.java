package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ui.component.ab;
import java.util.Map;

/* compiled from: ProGuard */
final class s implements bf {
    private s() {
    }

    public final void a(@NonNull ab abVar, @NonNull View view, @NonNull Object obj, @NonNull Map<String, Object> map) {
        if (obj instanceof Double) {
            View a = as.a(abVar);
            if (a != null) {
                as.a(view, new r(this, a, ((Double) obj).doubleValue(), abVar.getInstance()));
            }
        }
    }
}
