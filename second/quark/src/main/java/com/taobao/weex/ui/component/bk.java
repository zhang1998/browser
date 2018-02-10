package com.taobao.weex.ui.component;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.mini.support.v4.view.bx;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.i;
import com.taobao.weex.ui.view.WXCircleViewPager;
import com.taobao.weex.ui.view.a.f;
import com.taobao.weex.ui.view.g;
import com.taobao.weex.ui.view.h;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.ah;
import java.util.HashMap;
import java.util.Map;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class bk extends bv<FrameLayout> {
    Map<String, Object> a;
    WXCircleViewPager b;
    protected ar c;
    protected h d;
    protected boolean e;
    protected bx f;
    private boolean h;
    private float i;

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return a(context);
    }

    @Deprecated
    public bk(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar);
    }

    public bk(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
        this.h = true;
        this.a = new HashMap();
        this.i = 0.1f;
        this.f = new bj(this);
    }

    protected FrameLayout a(@NonNull Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        if (!(getDomObject() == null || getDomObject().i() == null)) {
            this.h = ah.a(getDomObject().i().get("infinite"), Boolean.valueOf(true)).booleanValue();
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.b = new WXCircleViewPager(context);
        this.b.setCircle(this.h);
        this.b.setLayoutParams(layoutParams);
        this.d = new h(this.h);
        this.b.setAdapter(this.d);
        frameLayout.addView(this.b);
        this.b.a(this.f);
        registerActivityStateListener();
        return frameLayout;
    }

    public final LayoutParams a(ab abVar, View view, int i, int i2, int i3, int i4, int i5, int i6) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        if (layoutParams instanceof MarginLayoutParams) {
            if (abVar instanceof ar) {
                ((MarginLayoutParams) layoutParams).setMargins(i3, i5, i4, i6);
            } else {
                ((MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            }
        }
        return layoutParams;
    }

    public void addEvent(String str) {
        super.addEvent(str);
        if ("scroll".equals(str) && this.b != null) {
            this.b.a(new bi(this));
        }
    }

    public boolean containsGesture(f fVar) {
        return false;
    }

    public final ViewGroup g_() {
        return this.b;
    }

    protected void a(View view, int i) {
        if (view != null && this.d != null && !(view instanceof g)) {
            h hVar = this.d;
            if (i.c()) {
                WXLogUtils.d("onPageSelected >>>> addPageView");
            }
            hVar.a.add(view);
            hVar.d();
            b();
            this.b.setCurrentItem(0);
            if (this.c != null) {
                ((g) this.c.getHostView()).forceLayout();
                ((g) this.c.getHostView()).requestLayout();
            }
        }
    }

    public final void a(ab abVar, boolean z) {
        if (abVar != null && abVar.getHostView() != null && this.d != null) {
            h hVar = this.d;
            View hostView = abVar.getHostView();
            if (i.c()) {
                WXLogUtils.d("onPageSelected >>>> removePageView");
            }
            hVar.a.remove(hostView);
            hVar.d();
            b();
            super.a(abVar, z);
        }
    }

    public void destroy() {
        super.destroy();
        if (this.b != null) {
            this.b.g();
            this.b.removeAllViews();
            WXCircleViewPager.h();
        }
    }

    public void onActivityResume() {
        if (this.b != null && this.b.o) {
            this.b.f();
        }
    }

    public void onActivityStop() {
        if (this.b != null) {
            WXCircleViewPager wXCircleViewPager = this.b;
            wXCircleViewPager.removeCallbacks(wXCircleViewPager.p);
        }
    }

    public final void a(ar arVar) {
        FrameLayout frameLayout = (FrameLayout) getHostView();
        if (frameLayout != null) {
            this.c = arVar;
            g gVar = (g) arVar.getHostView();
            if (gVar != null) {
                gVar.setCircleViewPager(this.b);
                frameLayout.addView(gVar);
            }
        }
    }

    protected boolean setProperty(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case 66669991:
                if (str.equals("scrollable")) {
                    z = true;
                    break;
                }
                break;
            case 100346066:
                if (str.equals("index")) {
                    z = true;
                    break;
                }
                break;
            case 111972721:
                if (str.equals("value")) {
                    z = false;
                    break;
                }
                break;
            case 570418373:
                if (str.equals("interval")) {
                    z = true;
                    break;
                }
                break;
            case 996926241:
                if (str.equals("showIndicators")) {
                    z = true;
                    break;
                }
                break;
            case 1438608771:
                if (str.equals("autoPlay")) {
                    z = true;
                    break;
                }
                break;
            case 1565939262:
                if (str.equals("offsetXAccuracy")) {
                    z = true;
                    break;
                }
                break;
        }
        String a;
        Integer a2;
        switch (z) {
            case false:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setValue(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setAutoPlay(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setShowIndicators(a);
                return true;
            case true:
                a2 = ah.a(obj, null);
                if (a2 == null) {
                    return true;
                }
                setInterval(a2.intValue());
                return true;
            case true:
                a2 = ah.a(obj, null);
                if (a2 == null) {
                    return true;
                }
                setIndex(a2.intValue());
                return true;
            case true:
                Float a3 = ah.a(obj, Float.valueOf(0.1f));
                if (a3.floatValue() == 0.0f) {
                    return true;
                }
                setOffsetXAccuracy(a3.floatValue());
                return true;
            case true:
                setScrollable(ah.a(obj, Boolean.valueOf(true)).booleanValue());
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "value")
    @Deprecated
    public void setValue(String str) {
        if (str != null && getHostView() != null) {
            try {
                setIndex(Integer.parseInt(str));
            } catch (Throwable e) {
                WXLogUtils.e("", e);
            }
        }
    }

    @WXComponentProp(name = "autoPlay")
    public void setAutoPlay(String str) {
        if (TextUtils.isEmpty(str) || str.equals("false")) {
            this.b.g();
            return;
        }
        this.b.g();
        this.b.f();
    }

    @WXComponentProp(name = "showIndicators")
    public void setShowIndicators(String str) {
        if (TextUtils.isEmpty(str) || str.equals("false")) {
            this.e = false;
        } else {
            this.e = true;
        }
        if (this.c != null) {
            ar arVar = this.c;
            boolean z = this.e;
            if (arVar.getHostView() == null) {
                return;
            }
            if (z) {
                ((g) arVar.getHostView()).setVisibility(0);
            } else {
                ((g) arVar.getHostView()).setVisibility(8);
            }
        }
    }

    @WXComponentProp(name = "interval")
    public void setInterval(int i) {
        if (this.b != null && i > 0) {
            this.b.setIntervalTime((long) i);
        }
    }

    @WXComponentProp(name = "index")
    public void setIndex(int i) {
        if (this.b != null && this.d != null && i < this.d.c() && i >= 0) {
            this.b.setCurrentItem(i);
            if (this.c != null && this.c.getHostView() != null && ((g) this.c.getHostView()).getRealCurrentItem() != i) {
                WXLogUtils.d("setIndex >>>> correction indicator to " + i);
                ((g) this.c.getHostView()).setRealCurrentItem(i);
                ((g) this.c.getHostView()).invalidate();
                if (this.f != null && this.d != null) {
                    this.f.a(this.d.e() + i);
                }
            }
        }
    }

    @WXComponentProp(name = "scrollable")
    public void setScrollable(boolean z) {
        if (this.b != null && this.d != null && this.d.c() > 0) {
            this.b.setScrollable(z);
        }
    }

    @WXComponentProp(name = "offsetXAccuracy")
    public void setOffsetXAccuracy(float f) {
        this.i = f;
    }

    private void b() {
        if (this.b != null && this.d != null && this.h) {
            if (this.d.c() == 2) {
                this.b.setOnTouchListener(new bf(this, new GestureDetector(getContext(), new bh(this.b))));
                return;
            }
            this.b.setOnTouchListener(null);
        }
    }

    public /* bridge */ /* synthetic */ View getRealView() {
        return this.b;
    }
}
