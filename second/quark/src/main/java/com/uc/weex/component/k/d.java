package com.uc.weex.component.k;

import android.content.Context;
import android.mini.support.v4.view.bx;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.ai;
import com.taobao.weex.i;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class d extends bv<f> implements bx {
    private int a;
    private boolean b;
    private f c;
    private boolean d = false;

    public d(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    public void addEvent(String str) {
        super.addEvent(str);
        if (this.c != null) {
            this.c.setOnTouchListener(null);
        }
        cleanGestureType();
    }

    public final ViewGroup g_() {
        return this.c;
    }

    protected final void a(View view, int i) {
        if (view != null && this.c.e() != null) {
            this.d = true;
            e e = this.c.e();
            e.a.add(view);
            e.b();
            e.b.setOffscreenPageLimit(e.a.size());
            this.d = false;
            if (!this.b && this.a > 0 && this.a < this.c.e().a()) {
                a(this.a, false);
                this.b = true;
            }
        }
    }

    public final void a(ab abVar, boolean z) {
        if (abVar != null && abVar.getHostView() != null && this.c.e() != null) {
            this.g.remove(abVar);
            if (z) {
                this.d = true;
                f fVar = this.c;
                View hostView = abVar.getHostView();
                e e = fVar.e();
                e.a.remove(hostView);
                e.b();
                e.b.setOffscreenPageLimit(e.a.size());
                this.d = false;
                int currentItem = this.c.getCurrentItem();
                if (currentItem > 0) {
                    a(currentItem - 1, false);
                }
            }
            if (z) {
                abVar.destroy();
            }
        }
    }

    public void destroy() {
        super.destroy();
        if (this.c != null) {
            this.c.removeAllViews();
        }
    }

    @WXComponentProp(name = "scrollEnabled")
    public void setScrollEnabled(boolean z) {
        this.c.o = z;
    }

    @WXComponentProp(name = "scrollenabled")
    public void setScrollEnabled2(boolean z) {
        setScrollEnabled(z);
    }

    @WXComponentProp(name = "pageMargin")
    public void setPageMargin(float f) {
        this.c.setPageMargin((int) WXViewUtils.b(f));
    }

    @WXComponentProp(name = "pagemargin")
    public void setPageMargin2(float f) {
        setPageMargin(f);
    }

    @WXComponentProp(name = "initialPage")
    public void setInitialPage(int i) {
        this.a = i;
    }

    @WXComponentProp(name = "initialpage")
    public void setInitialPage2(int i) {
        setInitialPage(i);
    }

    @WXComponentProp(name = "currentItem")
    public void setCurrentItemWithAnimation(int i) {
        a(i, true);
    }

    @WXComponentProp(name = "currentitem")
    public void setCurrentItemWithAnimation2(int i) {
        setCurrentItemWithAnimation(i);
    }

    private void a(int i, boolean z) {
        if (i >= 0) {
            this.d = true;
            this.c.a(i, z);
            this.d = false;
        }
    }

    public final void a(int i, float f, int i2) {
        if (getDomObject().c_() != null && getDomObject().c_().size() != 0) {
            ai c_ = getDomObject().c_();
            String b_ = getDomObject().b_();
            if (WXViewUtils.a(getHostView())) {
                Map hashMap = new HashMap();
                hashMap.put("position", Integer.valueOf(i));
                hashMap.put("offset", Float.valueOf(f));
                if (c_.contains("pageScroll")) {
                    getInstance().a(b_, "pageScroll", hashMap);
                } else if (c_.contains("pagescroll")) {
                    getInstance().a(b_, "pagescroll", hashMap);
                }
            }
        }
    }

    public final void a(int i) {
        if (!this.d) {
            if (i.c()) {
                WXLogUtils.d("onPageSelected >>>>" + i);
            }
            if (this.c.e() != null && this.c.e().a() != 0) {
                int a = i % this.c.e().a();
                if (this.g != null && a < this.g.size() && getDomObject().c_() != null && getDomObject().c_().size() != 0) {
                    ai c_ = getDomObject().c_();
                    String b_ = getDomObject().b_();
                    if (WXViewUtils.a(getHostView())) {
                        Map hashMap = new HashMap();
                        hashMap.put("position", Integer.valueOf(a));
                        if (c_.contains("pageSelected")) {
                            getInstance().a(b_, "pageSelected", hashMap);
                        } else if (c_.contains("pageselected")) {
                            getInstance().a(b_, "pageselected", hashMap);
                        }
                    }
                }
            }
        }
    }

    public final void b(int i) {
        if (getDomObject().c_() != null && getDomObject().c_().size() != 0) {
            Object obj;
            switch (i) {
                case 0:
                    obj = "idle";
                    break;
                case 1:
                    obj = "dragging";
                    break;
                case 2:
                    obj = "settling";
                    break;
                default:
                    throw new IllegalStateException("Unsupported pageScrollState");
            }
            ai c_ = getDomObject().c_();
            String b_ = getDomObject().b_();
            if (WXViewUtils.a(getHostView())) {
                Map hashMap = new HashMap();
                hashMap.put("pageScrollState", obj);
                if (c_.contains("pageScrollStateChanged")) {
                    getInstance().a(b_, "pageScrollStateChanged", hashMap);
                } else if (c_.contains("pagescrollstatechanged")) {
                    getInstance().a(b_, "pagescrollstatechanged", hashMap);
                }
            }
        }
    }

    protected /* synthetic */ View initComponentHostView(Context context) {
        this.c = new f(getContext());
        this.c.a((bx) this);
        registerActivityStateListener();
        return this.c;
    }

    public /* bridge */ /* synthetic */ View getRealView() {
        return this.c;
    }
}
