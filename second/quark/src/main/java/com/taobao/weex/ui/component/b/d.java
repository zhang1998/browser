package com.taobao.weex.ui.component.b;

import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.av;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class d extends av {
    final /* synthetic */ e a;

    d(e eVar) {
        this.a = eVar;
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        super.a(recyclerView, i, i2);
        int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        if (e.a(this.a, computeHorizontalScrollOffset, computeVerticalScrollOffset)) {
            int measuredWidth = recyclerView.getMeasuredWidth() + recyclerView.computeHorizontalScrollRange();
            int computeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
            Map hashMap = new HashMap(2);
            Map hashMap2 = new HashMap(2);
            Map hashMap3 = new HashMap(2);
            hashMap2.put(Style.WIDTH, Float.valueOf(WXViewUtils.c((float) measuredWidth, this.a.getInstance().o)));
            hashMap2.put(Style.HEIGHT, Float.valueOf(WXViewUtils.c((float) computeVerticalScrollRange, this.a.getInstance().o)));
            hashMap3.put("x", Float.valueOf(-WXViewUtils.c((float) computeHorizontalScrollOffset, this.a.getInstance().o)));
            hashMap3.put("y", Float.valueOf(-WXViewUtils.c((float) computeVerticalScrollOffset, this.a.getInstance().o)));
            hashMap.put("contentSize", hashMap2);
            hashMap.put("contentOffset", hashMap3);
            this.a.fireEvent("scroll", hashMap);
        }
    }
}
