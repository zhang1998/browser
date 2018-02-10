package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ui.component.ab;
import java.util.Map;

/* compiled from: ProGuard */
final class l implements bf {
    private l() {
    }

    public final void a(@NonNull ab abVar, @NonNull View view, @NonNull Object obj, @NonNull Map<String, Object> map) {
        if (obj instanceof Integer) {
            as.a(view, new k(this, view, ((Integer) obj).intValue()));
        }
    }
}
