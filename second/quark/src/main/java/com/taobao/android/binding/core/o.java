package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.ui.component.ab;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: ProGuard */
final class o implements bf {
    private o() {
    }

    public final void a(@NonNull ab abVar, @NonNull View view, @NonNull Object obj, @NonNull Map<String, Object> map) {
        View a = as.a(abVar);
        if (a != null) {
            ac instance = abVar.getInstance();
            if (obj instanceof Double) {
                as.a(a, new m(this, a, ((Double) obj).doubleValue(), instance));
            } else if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList.size() >= 2 && (arrayList.get(0) instanceof Double) && (arrayList.get(1) instanceof Double)) {
                    as.a(a, new n(this, a, ((Double) arrayList.get(0)).doubleValue(), instance, ((Double) arrayList.get(1)).doubleValue()));
                }
            }
        }
    }
}
