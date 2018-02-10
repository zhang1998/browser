package com.uc.weex.component.f;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class a extends bv<c> implements b {
    int a;
    int b = WXViewUtils.f(100.0f);
    int c;

    protected /* synthetic */ void setHostLayoutParams(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        c cVar = (c) view;
        super.setHostLayoutParams(cVar, i, i2, i3, i4, i5, i6);
        cVar.setHeaderHeight(i2);
    }

    public a(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar);
    }

    @WXComponentProp(name = "maxPullDown")
    public void setMaxPullDown(int i) {
        this.b = WXViewUtils.f((float) i);
    }

    @WXComponentProp(name = "minShrink")
    public void setMinShrink(int i) {
        this.a = WXViewUtils.f((float) i);
    }

    @WXComponentProp(name = "minForRefresh")
    public void setMinForRefresh(int i) {
        this.c = WXViewUtils.f((float) i);
    }

    public final void b() {
        if (getDomObject() != null && getDomObject().c_().contains("refresh")) {
            getInstance().b(getRef(), "refresh");
        }
    }

    public final void a(int i) {
        if (getDomObject() != null && getDomObject().c_().contains("sizeChanged")) {
            Map hashMap = new HashMap();
            hashMap.put(Style.HEIGHT, Float.valueOf(WXViewUtils.e((float) i)));
            getInstance().a(getRef(), "sizeChanged", hashMap);
        }
    }

    public final void d() {
        if (getDomObject() != null && getDomObject().c_().contains("scrollViewIsBottom")) {
            getInstance().b(getRef(), "scrollViewIsBottom");
        }
    }

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        View cVar = new c(context, this);
        cVar.setHeaderListener(this);
        return cVar;
    }
}
