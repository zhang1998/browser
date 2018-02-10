package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ui.component.ab;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: ProGuard */
final class al implements bf {
    private al() {
    }

    public final void a(@NonNull ab abVar, @NonNull View view, @NonNull Object obj, @NonNull Map<String, Object> map) {
        if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList.size() >= 2 && (arrayList.get(0) instanceof Double) && (arrayList.get(1) instanceof Double)) {
                View view2 = view;
                as.a(view, new ak(this, view2, ((Double) arrayList.get(0)).doubleValue(), abVar.getInstance(), ((Double) arrayList.get(1)).doubleValue()));
            }
        }
    }
}
