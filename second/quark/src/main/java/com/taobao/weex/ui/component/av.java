package com.taobao.weex.ui.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.o;
import com.taobao.weex.ui.component.b.r;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.ui.view.l;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.p;
import com.taobao.weex.ui.view.refresh.core.WXSwipeLayout;
import com.taobao.weex.ui.view.refresh.core.c;
import com.taobao.weex.ui.view.refresh.core.k;
import com.taobao.weex.ui.view.refresh.core.m;
import com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView;
import com.taobao.weex.ui.view.refresh.wrapper.a;
import com.taobao.weex.ui.view.refresh.wrapper.b;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;
import java.util.HashMap;
import java.util.Map;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class av extends t implements m {
    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return a(context);
    }

    @Deprecated
    public av(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar, z);
    }

    public av(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    protected final l a(@NonNull Context context) {
        return new p(context);
    }

    public boolean canRecycled() {
        return false;
    }

    public final void b() {
        if (!isDestoryed()) {
            o domObject = getDomObject();
            if (domObject != null && domObject.c_().contains("refresh")) {
                fireEvent("refresh");
            }
        }
    }

    public final void d() {
        if (!isDestoryed()) {
            o domObject = getDomObject();
            if (domObject != null && domObject.c_().contains("release")) {
                fireEvent("release");
            }
        }
    }

    public int getLayoutTopOffsetForSibling() {
        return getParent() instanceof p ? -Math.round(getDomObject().p()) : 0;
    }

    public final void a(float f, int i, float f2) {
        if (getDomObject().c_() != null && getDomObject().c_().contains("pullingdown")) {
            Map hashMap = new HashMap();
            hashMap.put("dy", Float.valueOf(WXViewUtils.c(f, getInstance().o)));
            hashMap.put("pullingDistance", Float.valueOf(WXViewUtils.c((float) i, getInstance().o)));
            hashMap.put("viewHeight", Float.valueOf(WXViewUtils.c(f2, getInstance().o)));
            fireEvent("pullingdown", hashMap);
        }
    }

    protected boolean setProperty(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case 1671764162:
                if (str.equals("display")) {
                    obj2 = null;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                String a = ah.a(obj, null);
                if (a != null) {
                    setDisplay(a);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "display")
    public void setDisplay(String str) {
        if (!TextUtils.isEmpty(str) && str.equals("hide")) {
            if (((getParent() instanceof r) || (getParent() instanceof be)) && ((BaseBounceView) getParent().getHostView()).getSwipeLayout().c) {
                ((BaseBounceView) getParent().getHostView()).a();
                ((BaseBounceView) getParent().getHostView()).c();
            }
        }
    }

    @JSMethod
    public void refresh() {
        bv parent = getParent();
        if (((parent instanceof r) || (parent instanceof be)) && parent.getHostView() != null) {
            BaseBounceView baseBounceView = (BaseBounceView) parent.getHostView();
            if (baseBounceView.getSwipeLayout() != null) {
                if (baseBounceView instanceof a) {
                    ((WXRecyclerView) ((a) baseBounceView).getInnerView()).a(0);
                } else if (baseBounceView instanceof b) {
                    ((WXScrollView) ((b) baseBounceView).getInnerView()).scrollTo(0, 0);
                }
                WXSwipeLayout swipeLayout = baseBounceView.getSwipeLayout();
                int p = ((int) getDomObject().p()) + 1;
                if (!swipeLayout.c && swipeLayout.b != null) {
                    swipeLayout.d = 0;
                    swipeLayout.e = true;
                    swipeLayout.a = true;
                    ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{1, p});
                    ofInt.addUpdateListener(new k(swipeLayout));
                    ofInt.addListener(new c(swipeLayout));
                    ofInt.setDuration(300);
                    ofInt.start();
                }
            }
        }
    }
}
