package com.uc.weex.component.richtext;

import android.graphics.drawable.Drawable;
import com.taobao.weex.a.f;
import com.taobao.weex.a.g;
import com.taobao.weex.ad;

/* compiled from: ProGuard */
final class z implements c {
    final /* synthetic */ aa a;

    private z(aa aaVar) {
        this.a = aaVar;
    }

    public final Drawable a(int i, int i2) {
        Drawable abVar = new ab(i, i2);
        this.a.M.add(abVar);
        if (ad.a().g != null) {
            f fVar = new f();
            fVar.b = i2;
            fVar.a = i;
            g gVar = ad.a().g;
        }
        return abVar;
    }
}
