package com.taobao.weex.ui.component;

import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.s;
import java.util.Map;

/* compiled from: ProGuard */
final class u implements z {
    final /* synthetic */ ab a;

    u(ab abVar) {
        this.a = abVar;
    }

    public final void a() {
        Map a = s.a(1);
        Map a2 = s.a(4);
        int[] iArr = new int[2];
        this.a.mHost.getLocationOnScreen(iArr);
        a2.put("x", Float.valueOf(WXViewUtils.c((float) iArr[0], this.a.mInstance.o)));
        a2.put("y", Float.valueOf(WXViewUtils.c((float) iArr[1], this.a.mInstance.o)));
        a2.put(Style.WIDTH, Float.valueOf(WXViewUtils.c(this.a.mDomObj.o(), this.a.mInstance.o)));
        a2.put(Style.HEIGHT, Float.valueOf(WXViewUtils.c(this.a.mDomObj.p(), this.a.mInstance.o)));
        a.put("position", a2);
        this.a.fireEvent("click", a);
    }
}
