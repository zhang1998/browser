package com.a.a.a;

import android.text.TextUtils;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class bz extends cl {
    final /* synthetic */ bx a;

    bz(bx bxVar) {
        this.a = bxVar;
    }

    public final void a(Object obj) {
        if (obj.equals("success")) {
            bx bxVar = this.a;
            for (Entry key : bxVar.a.a.entrySet()) {
                List list = (List) key.getKey();
                if (!bxVar.d.contains(list)) {
                    bxVar.d.add(TextUtils.join("!", list));
                }
            }
            if (bxVar.d.size() > 0) {
                ca.a(new cl(), bxVar.d);
            }
        }
    }
}
