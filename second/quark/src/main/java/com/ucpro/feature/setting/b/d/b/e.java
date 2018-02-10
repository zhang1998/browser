package com.ucpro.feature.setting.b.d.b;

import com.ucpro.feature.setting.b.b.a.f;
import com.ucpro.feature.setting.b.d.a.a;

/* compiled from: ProGuard */
final class e implements a {
    final /* synthetic */ f a;
    final /* synthetic */ j b;

    e(j jVar, f fVar) {
        this.b = jVar;
        this.a = fVar;
    }

    public final boolean a(String str) {
        try {
            float floatValue = Float.valueOf(str).floatValue();
            this.a.a(Float.valueOf(floatValue));
            this.b.a(String.valueOf(floatValue));
            return false;
        } catch (NumberFormatException e) {
            com.ucpro.ui.b.e.a().a("输入格式不合法，请重新输入", 1);
            return true;
        }
    }
}
