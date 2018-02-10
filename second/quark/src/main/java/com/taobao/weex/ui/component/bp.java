package com.taobao.weex.ui.component;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.mini.support.v4.view.ViewPager;
import android.mini.support.v4.view.bz;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.common.w;
import com.taobao.weex.ui.view.WXCircleViewPager;
import com.taobao.weex.ui.view.g;
import com.taobao.weex.ui.view.h;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;
import com.uc.imagecodec.export.IPictureView;
import java.util.List;

/* compiled from: ProGuard */
public class bp extends bk {
    private float h = 0.8f;
    private float i = 0.6f;
    private float j = 25.0f;
    private float k = 0.9f;
    private bo l;

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return a(context);
    }

    public bp(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
    }

    public void bindData(ab abVar) {
        super.bindData(abVar);
    }

    protected final FrameLayout a(@NonNull Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.b = new WXCircleViewPager(getContext());
        this.b.setLayoutParams(layoutParams);
        this.d = new h();
        this.b.setAdapter(this.d);
        frameLayout.addView(this.b);
        this.b.a(this.f);
        this.b.setOverScrollMode(2);
        registerActivityStateListener();
        ViewPager viewPager = this.b;
        if (this.l == null) {
            this.l = new bo(this);
        }
        bz bzVar = this.l;
        if (VERSION.SDK_INT >= 11) {
            boolean z;
            boolean z2 = bzVar != null;
            if (viewPager.m != null) {
                z = true;
            } else {
                z = false;
            }
            int i = z2 != z ? 1 : 0;
            viewPager.m = bzVar;
            viewPager.setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                viewPager.n = 1;
            } else {
                viewPager.n = 0;
            }
            if (i != 0) {
                viewPager.b();
            }
        }
        return frameLayout;
    }

    protected final void a(View view, int i) {
        if (view != null && this.d != null && !(view instanceof g)) {
            View frameLayout = new FrameLayout(getContext());
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            frameLayout.addView(view);
            super.a(frameLayout, i);
            a(this.i, this.h);
            this.b.postDelayed(w.a(new bl(this, i)), 50);
        }
    }

    private static void a(View view, float f, float f2) {
        if (view != null) {
            if (f >= 0.0f && view.getAlpha() != f) {
                view.setAlpha(f);
            }
            if (f2 >= 0.0f && view.getScaleX() != f2) {
                view.setScaleX(f2);
                view.setScaleY(f2);
            }
        }
    }

    private void a(float f, float f2) {
        List list = this.d.a;
        int currentItem = this.b.getCurrentItem();
        if (list.size() > 0) {
            View view = (View) list.get(currentItem);
            a(((ViewGroup) view).getChildAt(0), (float) IPictureView.DEFAULT_MIN_SCALE, this.k);
            if (list.size() >= 2) {
                view.postDelayed(w.a(new bm(this, view, f, f2)), 17);
                int size = currentItem == 0 ? list.size() - 1 : currentItem - 1;
                int i = currentItem == list.size() + -1 ? 0 : currentItem + 1;
                int i2 = 0;
                while (i2 < this.d.c()) {
                    if (!(i2 == size || i2 == currentItem || i2 == i)) {
                        ((ViewGroup) list.get(i2)).getChildAt(0).setAlpha(0.0f);
                    }
                    i2++;
                }
            }
        }
    }

    private static void a(View view, float f, float f2, float f3) {
        a(((ViewGroup) view).getChildAt(0), f2, f3);
        view.setTranslationX(f);
        ((ViewGroup) view).getChildAt(0).setTranslationX(f);
    }

    private static void b(View view, float f, float f2, float f3) {
        a(view, -f, f2, f3);
    }

    @WXComponentProp(name = "neighborScale")
    public void setNeighborScale(String str) {
        float f = 0.8f;
        if (!TextUtils.isEmpty(str)) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException e) {
            }
        }
        if (this.h != f) {
            this.h = f;
            a(-1.0f, f);
        }
    }

    @WXComponentProp(name = "neighborAlpha")
    public void setNeighborAlpha(String str) {
        float f = 0.6f;
        if (!TextUtils.isEmpty(str)) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException e) {
            }
        }
        if (this.i != f) {
            this.i = f;
            a(f, -1.0f);
        }
    }

    @WXComponentProp(name = "neighborSpace")
    public void setNeighborSpace(String str) {
        float f = 25.0f;
        if (!TextUtils.isEmpty(str)) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException e) {
            }
        }
        if (this.j != f) {
            this.j = f;
        }
    }

    @WXComponentProp(name = "currentItemScale")
    public void setCurrentItemScale(String str) {
        float f = 0.9f;
        if (!TextUtils.isEmpty(str)) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException e) {
            }
        }
        if (this.k != f) {
            this.k = f;
            a(-1.0f, -1.0f);
        }
    }

    protected boolean setProperty(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1763701364:
                if (str.equals("neighborAlpha")) {
                    z = true;
                    break;
                }
                break;
            case -1747360392:
                if (str.equals("neighborScale")) {
                    z = false;
                    break;
                }
                break;
            case -1746973388:
                if (str.equals("neighborSpace")) {
                    z = true;
                    break;
                }
                break;
            case -1013904258:
                if (str.equals("currentItemScale")) {
                    z = true;
                    break;
                }
                break;
        }
        String a;
        switch (z) {
            case false:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setNeighborScale(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setNeighborAlpha(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setNeighborSpace(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setCurrentItemScale(a);
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    private float a(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return 0.0f;
        }
        View childAt = ((ViewGroup) view).getChildAt(0);
        return ((((((float) view.getMeasuredWidth()) - (((float) childAt.getMeasuredWidth()) * this.k)) / 2.0f) - WXViewUtils.a(this.j, getInstance().o)) / 2.0f) + ((((float) view.getMeasuredWidth()) - (((float) childAt.getMeasuredWidth()) * this.h)) / 4.0f);
    }

    static /* synthetic */ void a(bp bpVar, View view, float f, float f2) {
        List list = bpVar.d.a;
        int currentItem = bpVar.b.getCurrentItem();
        float a = bpVar.a(view);
        View view2 = (View) list.get(currentItem == 0 ? list.size() - 1 : currentItem - 1);
        View view3 = (View) list.get(currentItem == list.size() + -1 ? 0 : currentItem + 1);
        if (list.size() != 2) {
            a(view2, a, f, f2);
            b(view3, a, f, f2);
        } else if (currentItem == 0) {
            b(view3, a, f, f2);
        } else if (currentItem == 1) {
            a(view2, a, f, f2);
        }
    }
}
