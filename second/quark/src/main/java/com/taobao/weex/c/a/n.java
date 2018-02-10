package com.taobao.weex.c.a;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.bridge.c;
import com.taobao.weex.bridge.h;
import com.taobao.weex.c.p;
import com.taobao.weex.c.q;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class n implements p {
    private final String a;
    private final String b;

    public n(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void a(q qVar) {
        ac a = qVar.a();
        c hVar = new h(qVar.a().e, this.b);
        if (a != null && !a.i) {
            Map hashMap;
            if (TextUtils.isEmpty(this.a)) {
                hashMap = new HashMap();
                hashMap.put("result", Boolean.valueOf(false));
                hashMap.put("errMsg", "Illegal parameter");
                hVar.a(hashMap);
                return;
            }
            Object hashMap2;
            Map hashMap3;
            int i;
            if ("viewport".equalsIgnoreCase(this.a)) {
                a = qVar.a();
                View view = a.f;
                if (view != null) {
                    hashMap2 = new HashMap();
                    hashMap3 = new HashMap();
                    a.f.getLocationOnScreen(new int[2]);
                    i = a.o;
                    hashMap3.put(Style.LEFT, Float.valueOf(0.0f));
                    hashMap3.put(Style.TOP, Float.valueOf(0.0f));
                    hashMap3.put(Style.RIGHT, Float.valueOf(WXViewUtils.c((float) view.getWidth(), i)));
                    hashMap3.put(Style.BOTTOM, Float.valueOf(WXViewUtils.c((float) view.getHeight(), i)));
                    hashMap3.put(Style.WIDTH, Float.valueOf(WXViewUtils.c((float) view.getWidth(), i)));
                    hashMap3.put(Style.HEIGHT, Float.valueOf(WXViewUtils.c((float) view.getHeight(), i)));
                    hashMap2.put("size", hashMap3);
                    hashMap2.put("result", Boolean.valueOf(true));
                } else {
                    hashMap = new HashMap();
                    hashMap.put("result", Boolean.valueOf(false));
                    hashMap.put("errMsg", "Component does not exist");
                    hVar.a(hashMap);
                    return;
                }
            }
            ab a2 = qVar.a(this.a);
            hashMap2 = new HashMap();
            if (a2 != null) {
                i = a.o;
                hashMap3 = new HashMap();
                Rect componentSize = a2.getComponentSize();
                hashMap3.put(Style.WIDTH, Float.valueOf(WXViewUtils.c((float) componentSize.width(), i)));
                hashMap3.put(Style.HEIGHT, Float.valueOf(WXViewUtils.c((float) componentSize.height(), i)));
                hashMap3.put(Style.BOTTOM, Float.valueOf(WXViewUtils.c((float) componentSize.bottom, i)));
                hashMap3.put(Style.LEFT, Float.valueOf(WXViewUtils.c((float) componentSize.left, i)));
                hashMap3.put(Style.RIGHT, Float.valueOf(WXViewUtils.c((float) componentSize.right, i)));
                hashMap3.put(Style.TOP, Float.valueOf(WXViewUtils.c((float) componentSize.top, i)));
                hashMap2.put("size", hashMap3);
                hashMap2.put("result", Boolean.valueOf(true));
            } else {
                hashMap2.put("errMsg", "Component does not exist");
            }
            hVar.a(hashMap2);
        }
    }
}
