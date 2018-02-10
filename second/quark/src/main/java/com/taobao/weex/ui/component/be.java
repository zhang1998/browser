package com.taobao.weex.ui.component;

import android.content.Context;
import android.graphics.Point;
import android.mini.support.annotation.NonNull;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.c.ae;
import com.taobao.weex.common.w;
import com.taobao.weex.i;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.a.f;
import com.taobao.weex.ui.view.WXHorizontalScrollView;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.ui.view.e;
import com.taobao.weex.ui.view.q;
import com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView;
import com.taobao.weex.ui.view.refresh.wrapper.b;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;
import com.uc.apollo.impl.SettingsConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class be extends bv<ViewGroup> implements p, q {
    public int a;
    public Map<String, Map<String, ab>> b;
    private List<ab> c;
    private int d;
    private boolean e;
    private int f;
    private Point h;
    private Map<String, m> i;
    private FrameLayout j;
    private int k;
    private f l;
    private Handler m;
    private boolean n;

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        Object obj;
        View a;
        if (getDomObject() == null || getDomObject().i().isEmpty()) {
            obj = "vertical";
        } else {
            obj = getDomObject().i().get("scrollDirection");
            if (obj == null) {
                obj = "vertical";
            } else {
                obj = obj.toString();
            }
        }
        if ("horizontal".equals(obj)) {
            this.a = 0;
            a = a(context);
            this.j = new FrameLayout(context);
            a.setScrollViewListener(new az(this));
            a.addView(this.j, new LayoutParams(-1, -1));
            a.setHorizontalScrollBarEnabled(false);
        } else {
            this.a = 1;
            View b = b(context);
            this.j = new FrameLayout(context);
            WXScrollView wXScrollView = (WXScrollView) b.getInnerView();
            wXScrollView.a((q) this);
            wXScrollView.addView(this.j, new LayoutParams(-1, -1));
            wXScrollView.setVerticalScrollBarEnabled(true);
            wXScrollView.a(new ba(this));
            a = b;
        }
        a.getViewTreeObserver().addOnGlobalLayoutListener(new bb(this));
        return a;
    }

    static /* synthetic */ boolean a(be beVar, int i, int i2) {
        if (beVar.h.x == -1 && beVar.h.y == -1) {
            beVar.h.x = i;
            beVar.h.y = i2;
            return true;
        } else if (beVar.a == 0 && Math.abs(i - beVar.h.x) >= beVar.f) {
            beVar.h.x = i;
            beVar.h.y = i2;
            return true;
        } else if (beVar.a != 1 || Math.abs(i2 - beVar.h.y) < beVar.f) {
            return false;
        } else {
            beVar.h.x = i;
            beVar.h.y = i2;
            return true;
        }
    }

    @Deprecated
    public be(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar);
    }

    public be(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
        this.a = 1;
        this.c = new ArrayList();
        this.d = 0;
        this.e = false;
        this.f = 10;
        this.h = new Point(-1, -1);
        this.i = new HashMap();
        this.b = new HashMap();
        this.k = 0;
        this.m = new Handler();
        this.n = true;
        this.l = new f(this);
    }

    public final ViewGroup g_() {
        return this.j;
    }

    public void createViewImpl() {
        super.createViewImpl();
        for (int i = 0; i < this.c.size(); i++) {
            ab abVar = (ab) this.c.get(i);
            abVar.createViewImpl();
            h(abVar);
        }
    }

    public final ViewGroup d() {
        if (getHostView() == null) {
            return null;
        }
        if (getHostView() instanceof b) {
            return (ViewGroup) ((b) getHostView()).getInnerView();
        }
        return (ViewGroup) getHostView();
    }

    public void addEvent(String str) {
        super.addEvent(str);
        if ("scroll".equals(str) && d() != null && (d() instanceof WXScrollView)) {
            ((WXScrollView) d()).a(new aw(this));
        }
    }

    protected final void a(View view, int i) {
        if (view != null && this.j != null && !(view instanceof com.taobao.weex.ui.view.f)) {
            if (i >= this.j.getChildCount()) {
                i = -1;
            }
            if (i == -1) {
                this.j.addView(view);
            } else {
                this.j.addView(view, i);
            }
        }
    }

    protected final int c() {
        return this.d;
    }

    public final void a(ab abVar, int i) {
        this.d += abVar.getLayoutTopOffsetForSibling();
        if ((abVar instanceof t) && !h(abVar)) {
            this.c.add(abVar);
        }
        super.a(abVar, i);
    }

    private boolean h(ab abVar) {
        if ((abVar instanceof av) && getHostView() != null) {
            ((BaseBounceView) getHostView()).setOnRefreshListener((av) abVar);
            this.m.postDelayed(w.a(new ax(this, abVar)), 100);
        }
        if (!(abVar instanceof at) || getHostView() == null) {
            return false;
        }
        ((BaseBounceView) getHostView()).setOnLoadingListener((at) abVar);
        this.m.postDelayed(w.a(new ay(this, abVar)), 100);
        return true;
    }

    public final void a(ab abVar, boolean z) {
        super.a(abVar, z);
        if (abVar instanceof at) {
            ((BaseBounceView) getHostView()).a(abVar);
        } else if (abVar instanceof av) {
            ((BaseBounceView) getHostView()).b(abVar);
        }
    }

    public void destroy() {
        super.destroy();
        if (this.i != null) {
            this.i.clear();
        }
        if (this.b != null) {
            this.b.clear();
        }
        if (d() != null && (d() instanceof e)) {
            ((e) d()).a();
        }
    }

    protected y measure(int i, int i2) {
        int i3 = -1;
        y yVar = new y();
        int b;
        int b2;
        if (this.a == 0) {
            b = WXViewUtils.b(i.e);
            b2 = WXViewUtils.b(getInstanceId());
            if (b2 < b) {
                b = b2;
            }
            if (i > b) {
                i = -1;
            }
            yVar.a = i;
            yVar.b = i2;
        } else {
            b = WXViewUtils.c(i.e);
            b2 = WXViewUtils.a(getInstanceId());
            if (b2 < b) {
                b = b2;
            }
            if (i2 <= b) {
                i3 = i2;
            }
            yVar.b = i3;
            yVar.a = i;
        }
        return yVar;
    }

    public WXHorizontalScrollView a(@NonNull Context context) {
        return new WXHorizontalScrollView(context);
    }

    public b b(@NonNull Context context) {
        return new b(context, this.a, this);
    }

    public final int a() {
        return this.a;
    }

    protected boolean setProperty(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case -223520855:
                if (str.equals("showScrollbar")) {
                    z = false;
                    break;
                }
                break;
            case -5620052:
                if (str.equals("offsetAccuracy")) {
                    z = true;
                    break;
                }
                break;
            case 66669991:
                if (str.equals("scrollable")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                Boolean a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setShowScrollbar(a.booleanValue());
                return true;
            case true:
                setScrollable(ah.a(obj, Boolean.valueOf(true)).booleanValue());
                return true;
            case true:
                setOffsetAccuracy(ah.a(obj, Integer.valueOf(10)).intValue());
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "showScrollbar")
    public void setShowScrollbar(boolean z) {
        if (d() != null) {
            if (this.a == 1) {
                d().setVerticalScrollBarEnabled(z);
            } else {
                d().setHorizontalScrollBarEnabled(z);
            }
        }
    }

    @WXComponentProp(name = "scrollable")
    public void setScrollable(boolean z) {
        this.n = z;
        ViewGroup d = d();
        if (d instanceof WXHorizontalScrollView) {
            ((WXHorizontalScrollView) d).setScrollable(z);
        } else if (d instanceof WXScrollView) {
            ((WXScrollView) d).setScrollable(z);
        }
    }

    @WXComponentProp(name = "offsetAccuracy")
    public void setOffsetAccuracy(int i) {
        this.f = (int) WXViewUtils.a((float) i, getInstance().o);
    }

    public final boolean b() {
        return this.n;
    }

    public final void a(ab abVar) {
        f.a(abVar, this.b);
    }

    public final void b(ab abVar) {
        f.b(abVar, this.b);
    }

    public final void c(ab abVar) {
        a(0, abVar, true);
    }

    private void a(int i, ab abVar, boolean z) {
        m mVar = (m) this.i.get(abVar.getRef());
        if (mVar == null) {
            mVar = new m(abVar);
            this.i.put(abVar.getRef(), mVar);
        }
        mVar.b[i] = z;
        b(0, 0, 0, 0);
    }

    public final void d(ab abVar) {
        a(1, abVar, true);
    }

    public final void e(ab abVar) {
        a(0, abVar, false);
    }

    public final void f(ab abVar) {
        a(1, abVar, false);
    }

    public final void a(ab abVar, Map<String, Object> map) {
        float a;
        boolean z;
        int i;
        int i2 = 0;
        if (map != null) {
            String obj = map.get("offset") == null ? SettingsConst.FALSE : map.get("offset").toString();
            boolean booleanValue = ah.a(map.get("animated"), Boolean.valueOf(true)).booleanValue();
            if (obj != null) {
                try {
                    boolean z2 = booleanValue;
                    a = WXViewUtils.a(Float.parseFloat(obj), getInstance().o);
                    z = z2;
                } catch (Exception e) {
                    WXLogUtils.e("Float parseFloat error :" + e.getMessage());
                }
            }
            z = booleanValue;
            a = 0.0f;
        } else {
            z = true;
            a = 0.0f;
        }
        int absoluteY = abVar.getAbsoluteY() - getAbsoluteY();
        int absoluteX = abVar.getAbsoluteX() - getAbsoluteX();
        if (d() == null) {
            i = 0;
        } else {
            i = d().getScrollX();
        }
        i = (absoluteX - i) + ((int) a);
        if (d() != null) {
            i2 = d().getScrollY();
        }
        int i3 = ((int) a) + (absoluteY - i2);
        if (d() != null) {
            d().postDelayed(new bc(this, z, i3, i), 16);
        }
    }

    public void a(WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4);
    }

    private void b(int i, int i2, int i3, int i4) {
        String str;
        int i5 = i2 - i4;
        int i6 = i - i3;
        String str2 = i5 > 0 ? "up" : i5 < 0 ? "down" : null;
        if (this.a != 0 || i6 == 0) {
            str = str2;
        } else {
            str = i6 > 0 ? Style.RIGHT : Style.LEFT;
        }
        for (Entry value : this.i.entrySet()) {
            m mVar = (m) value.getValue();
            if (mVar.a()) {
                int a = mVar.a(mVar.b());
                if (a != 0) {
                    mVar.a.notifyAppearStateChange(a == 1 ? "appear" : "disappear", str);
                }
                a = mVar.b(mVar.c());
                if (a != 0) {
                    ab abVar = mVar.a;
                    if (a == 1) {
                        str2 = "customAppear";
                    } else {
                        str2 = "customDisappear";
                    }
                    abVar.notifyCustomAppearStateChange(str2, str);
                }
            }
        }
    }

    public void b(WXScrollView wXScrollView, int i, int i2) {
    }

    @JSMethod
    public void resetLoadmore() {
        this.e = true;
    }

    public void a(boolean z) {
    }

    public void a(int i, int i2, int i3, int i4) {
    }

    public final void a(WXScrollView wXScrollView, int i, int i2) {
        try {
            Object d = getDomObject().i().d();
            if (!TextUtils.isEmpty(d)) {
                int a = (int) WXViewUtils.a(Float.parseFloat(d), getInstance().o);
                int height = wXScrollView.getChildAt(0).getHeight();
                int height2 = (height - i2) - wXScrollView.getHeight();
                if (height2 < a) {
                    if (i.c()) {
                        WXLogUtils.d("[WXScroller-onScroll] offScreenY :" + height2);
                    }
                    if (this.k != height || this.e) {
                        fireEvent("loadmore");
                        this.k = height;
                        this.e = false;
                    }
                }
            }
        } catch (Throwable e) {
            WXLogUtils.d("[WXScroller-onScroll] ", e);
        }
    }

    public /* bridge */ /* synthetic */ View getRealView() {
        return this.j;
    }
}
