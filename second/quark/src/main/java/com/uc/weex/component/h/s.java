package com.uc.weex.component.h;

import com.taobao.weex.c.ae;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;

/* compiled from: ProGuard */
public class s extends ae {
    public final void a() {
        float f;
        super.a();
        Object obj = i().get(Style.WIDTH);
        if (obj == null) {
            f = -1.0f;
        } else {
            f = ah.a(obj);
        }
        if (f != -1.0f) {
            a(WXViewUtils.a(f));
        }
        obj = i().get(Style.HEIGHT);
        if (obj == null) {
            f = -1.0f;
        } else {
            f = ah.a(obj);
        }
        if (f != -1.0f) {
            b(WXViewUtils.a(f));
        }
    }
}
