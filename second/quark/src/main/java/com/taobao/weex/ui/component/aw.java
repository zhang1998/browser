package com.taobao.weex.ui.component;

import android.graphics.Rect;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.ui.view.q;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class aw implements q {
    final /* synthetic */ be a;

    aw(be beVar) {
        this.a = beVar;
    }

    public final void a(WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
        if (be.a(this.a, i, i2)) {
            Rect contentFrame = wXScrollView.getContentFrame();
            Map hashMap = new HashMap(2);
            Map hashMap2 = new HashMap(2);
            Map hashMap3 = new HashMap(2);
            int i5 = this.a.getInstance().o;
            hashMap2.put(Style.WIDTH, Float.valueOf(WXViewUtils.c((float) contentFrame.width(), i5)));
            hashMap2.put(Style.HEIGHT, Float.valueOf(WXViewUtils.c((float) contentFrame.height(), i5)));
            hashMap3.put("x", Float.valueOf(-WXViewUtils.c((float) i, i5)));
            hashMap3.put("y", Float.valueOf(-WXViewUtils.c((float) i2, i5)));
            hashMap.put("contentSize", hashMap2);
            hashMap.put("contentOffset", hashMap3);
            this.a.fireEvent("scroll", hashMap);
        }
    }

    public final void b(WXScrollView wXScrollView, int i, int i2) {
    }

    public final void a(WXScrollView wXScrollView, int i, int i2) {
    }

    public final void a(boolean z) {
    }

    public final void a(int i, int i2, int i3, int i4) {
    }
}
