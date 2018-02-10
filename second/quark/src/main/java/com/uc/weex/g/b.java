package com.uc.weex.g;

import android.content.res.Resources;
import com.taobao.weex.ad;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.h;
import com.taobao.weex.common.o;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class b extends o {
    @JSMethod
    public void measure(String str, String str2) {
        float f;
        float f2;
        float f3;
        float f4 = 0.0f;
        ab a = ad.a().c.a(this.b.e, str);
        if (a == null || a.getHostView() == null || this.b.g.getRealView() == null) {
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
        } else {
            int[] iArr = new int[]{0, 0};
            this.b.g.getRealView().getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            a.getHostView().getLocationInWindow(iArr);
            f3 = WXViewUtils.e((float) (iArr[0] - i));
            f2 = WXViewUtils.e((float) (iArr[1] - i2));
            f = WXViewUtils.e((float) a.getHostView().getWidth());
            f4 = WXViewUtils.e((float) a.getHostView().getHeight());
        }
        Map hashMap = new HashMap();
        hashMap.put("x", Float.valueOf(f3));
        hashMap.put("y", Float.valueOf(f2));
        hashMap.put(Style.WIDTH, Float.valueOf(f));
        hashMap.put(Style.HEIGHT, Float.valueOf(f4));
        new h(this.b.e, str2).a(hashMap);
    }

    @JSMethod
    public void measureInWindow(String str, String str2) {
        float f;
        float f2;
        float f3;
        float f4 = 0.0f;
        ab a = ad.a().c.a(this.b.e, str);
        if (a == null || a.getHostView() == null) {
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
        } else {
            int[] iArr = new int[]{0, 0};
            a.getHostView().getLocationOnScreen(iArr);
            f3 = WXViewUtils.e((float) iArr[0]);
            f2 = WXViewUtils.e((float) iArr[1]);
            Resources resources = a.getHostView().getContext().getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                iArr[1] = iArr[1] - ((int) resources.getDimension(identifier));
            }
            f = WXViewUtils.e((float) a.getHostView().getWidth());
            f4 = WXViewUtils.e((float) a.getHostView().getHeight());
        }
        Map hashMap = new HashMap();
        hashMap.put("x", Float.valueOf(f3));
        hashMap.put("y", Float.valueOf(f2));
        hashMap.put(Style.WIDTH, Float.valueOf(f));
        hashMap.put(Style.HEIGHT, Float.valueOf(f4));
        new h(this.b.e, str2).a(hashMap);
    }
}
