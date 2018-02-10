package com.ucpro.feature.setting.b.f;

import com.ucpro.feature.setting.b.b.a.i;
import com.ucpro.feature.u.a;
import com.ucpro.ui.b.e;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class br implements i {
    public final void a() {
        HashMap a = a.a();
        if (a != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Entry entry : a.entrySet()) {
                stringBuilder.append((String) entry.getKey()).append("   ------>   ").append(entry.getValue()).append("\n");
            }
            stringBuilder.append("类名对实例数目映射:\n");
            e.a().a(stringBuilder.toString(), 1);
        }
    }
}
