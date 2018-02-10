package com.uc.weex.component.g;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.be;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.ui.view.WXHorizontalScrollView;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.ui.view.refresh.wrapper.b;
import com.uc.weex.component.i.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class c extends be {
    private final a c = new a();
    private boolean d = false;
    private boolean e = false;

    public c(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar);
    }

    public final void a(WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
        super.a(wXScrollView, i, i2, i3, i4);
        a aVar = this.c;
        long uptimeMillis = SystemClock.uptimeMillis();
        int i5 = (uptimeMillis - aVar.c <= 10 && aVar.a == i && aVar.b == i2) ? 0 : 1;
        aVar.c = uptimeMillis;
        aVar.a = i;
        aVar.b = i2;
        if (i5 != 0 && g_().getChildAt(0) != null && getDomObject().c_().contains("scroll")) {
            Map hashMap = new HashMap();
            hashMap.put("x", Integer.valueOf(i));
            hashMap.put("y", Integer.valueOf(i2));
            getInstance().a(getRef(), "scroll", hashMap);
        }
    }

    public final void b(WXScrollView wXScrollView, int i, int i2) {
        super.b(wXScrollView, i, i2);
        Map hashMap = new HashMap();
        hashMap.put("x", Integer.valueOf(d().getScrollX()));
        hashMap.put("y", Integer.valueOf(d().getScrollY()));
        if (getDomObject().c_().contains("scrollStopped")) {
            getInstance().a(getRef(), "scrollStopped", hashMap);
        } else if (getDomObject().c_().contains("scrollstopped")) {
            getInstance().a(getRef(), "scrollstopped", hashMap);
        }
    }

    public final void a(boolean z) {
        super.a(z);
        Map hashMap = new HashMap();
        hashMap.put("x", Integer.valueOf(d().getScrollX()));
        hashMap.put("y", Integer.valueOf(d().getScrollY()));
        if (z) {
            if (getDomObject().c_().contains("beginDrag")) {
                getInstance().a(getRef(), "beginDrag", hashMap);
            } else if (getDomObject().c_().contains("begindrag")) {
                getInstance().a(getRef(), "begindrag", hashMap);
            }
        } else if (getDomObject().c_().contains("endDrag")) {
            getInstance().a(getRef(), "endDrag", hashMap);
        } else if (getDomObject().c_().contains("enddrag")) {
            getInstance().a(getRef(), "enddrag", hashMap);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (this.e && getDomObject().c_().contains("layout")) {
            Map hashMap = new HashMap();
            hashMap.put("x", Integer.valueOf(i));
            hashMap.put("y", Integer.valueOf(i2));
            if (this.a == 0) {
                hashMap.put(Style.WIDTH, Integer.valueOf(d().getChildAt(0).getHeight()));
                hashMap.put(Style.HEIGHT, Integer.valueOf(i4 - i2));
            } else {
                hashMap.put(Style.WIDTH, Integer.valueOf(i3 - i));
                hashMap.put(Style.HEIGHT, Integer.valueOf(d().getChildAt(0).getHeight()));
            }
            getInstance().a(getRef(), "layout", hashMap);
        }
    }

    @WXComponentProp(name = "sizeChanged")
    public void setShouldNotifyOnSizeChanged(boolean z) {
        this.e = z;
    }

    @WXComponentProp(name = "sizechanged")
    public void setShouldNotifyOnSizeChanged2(boolean z) {
        setShouldNotifyOnSizeChanged(z);
    }

    @WXComponentProp(name = "overScrollDistance")
    public void setOverScrollDistance(float f) {
        ViewGroup d = d();
        if (d instanceof b) {
            ((b) d).setOverScrollDistance(f);
        } else {
            ((d) d).setOverScrollDistance(f);
        }
    }

    @WXComponentProp(name = "overscrolldistance")
    public void setOverScrollDistance2(float f) {
        setOverScrollDistance(f);
    }

    protected final WXHorizontalScrollView a(@NonNull Context context) {
        return new b(context);
    }

    protected final /* synthetic */ b b(@NonNull Context context) {
        return new a(context, this.a, this);
    }
}
