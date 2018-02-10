package com.taobao.weex.ui.view.refresh.wrapper;

import android.content.Context;
import android.mini.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.taobao.weex.common.w;
import com.taobao.weex.ui.component.b.g;
import com.taobao.weex.ui.component.b.j;
import com.taobao.weex.ui.component.b.l;
import com.taobao.weex.ui.component.b.m;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.listview.a.d;
import com.taobao.weex.utils.WXLogUtils;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class a extends BaseBounceView<WXRecyclerView> implements g, c {
    private d b;
    private b c;
    private int d;
    private int e;
    private float f;
    private l g;

    public /* synthetic */ View a(Context context) {
        return b(context);
    }

    public /* bridge */ /* synthetic */ WXRecyclerView getInnerView() {
        return (WXRecyclerView) super.getInnerView();
    }

    public boolean postDelayed(Runnable runnable, long j) {
        return super.postDelayed(w.a(runnable), j);
    }

    public a(Context context, int i, int i2, float f, int i3) {
        this(context, i, i2, f, i3, true);
    }

    public a(Context context, int i, int i2, float f, int i3, boolean z) {
        super(context, i3);
        this.b = null;
        this.d = 1;
        this.e = 1;
        this.f = IPictureView.DEFAULT_MIN_SCALE;
        this.d = i;
        this.e = i2;
        this.f = f;
        a(context, z);
        this.g = new l(this);
    }

    public void setRecyclerViewBaseAdapter(d dVar) {
        this.b = dVar;
        if (getInnerView() != null) {
            ((WXRecyclerView) getInnerView()).setAdapter(dVar);
        }
    }

    public d getRecyclerViewBaseAdapter() {
        return this.b;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.c != null) {
            return onTouchEvent | this.c.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }

    public WXRecyclerView b(Context context) {
        WXRecyclerView wXRecyclerView = new WXRecyclerView(context);
        wXRecyclerView.a(this.d, this.e, getOrientation());
        return wXRecyclerView;
    }

    public final void c() {
        if (this.b != null) {
            this.b.a.b();
        }
    }

    public final void d() {
        if (this.b != null) {
            this.b.a.b();
        }
    }

    public final void a(m mVar) {
        l lVar = this.g;
        if (mVar != null) {
            m mVar2;
            lVar.c.put(mVar.getRef(), mVar);
            if (lVar.d != null) {
                mVar2 = (m) lVar.c.get(lVar.d);
                if (mVar2 == null || mVar.f > mVar2.f) {
                    lVar.d = mVar.getRef();
                }
            } else {
                lVar.d = mVar.getRef();
            }
            if (lVar.d == null) {
                WXLogUtils.e("Current Sticky ref is null.");
                return;
            }
            mVar2 = (m) lVar.c.get(lVar.d);
            View g_ = mVar2.g_();
            if (g_ == null) {
                WXLogUtils.e("Sticky header's real view is null.");
                return;
            }
            View view = (View) lVar.b.get(mVar2.getRef());
            if (view != null) {
                view.bringToFront();
                return;
            }
            lVar.b.put(mVar2.getRef(), g_);
            float translationX = g_.getTranslationX();
            float translationY = g_.getTranslationY();
            mVar2.d = ((com.taobao.weex.ui.view.l) mVar2.getHostView()).getChildAt(0);
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            ((com.taobao.weex.ui.view.l) mVar2.getHostView()).getLocationOnScreen(iArr);
            mVar2.getParentScroller().f().getLocationOnScreen(iArr2);
            int i = iArr[0] - iArr2[0];
            int top = mVar2.getParent().getHostView().getTop();
            ((com.taobao.weex.ui.view.l) mVar2.getHostView()).removeView(mVar2.d);
            mVar2.b = (ViewGroup) mVar2.d;
            mVar2.c = new FrameLayout(mVar2.getContext());
            ((com.taobao.weex.ui.view.l) mVar2.getHostView()).addView(mVar2.c, new LayoutParams((int) mVar2.getDomObject().o(), (int) mVar2.getDomObject().p()));
            mVar2.d.setTranslationX((float) i);
            mVar2.d.setTranslationY((float) top);
            lVar.a.post(w.a(new j(lVar, g_, translationX, translationY)));
        }
    }

    public final void a_(int i) {
        l lVar = this.g;
        List<m> arrayList = new ArrayList();
        for (Entry value : lVar.c.entrySet()) {
            m mVar = (m) value.getValue();
            int i2 = mVar.f;
            if (i2 > i) {
                arrayList.add(mVar);
            } else if (i2 == i) {
                lVar.d = mVar.getRef();
                View view = (View) lVar.b.get(mVar.getRef());
                if (view != null) {
                    view.bringToFront();
                }
            }
        }
        for (m mVar2 : arrayList) {
            lVar.a(mVar2);
        }
    }

    public final void b(m mVar) {
        this.g.a(mVar);
    }

    public final void a(@Nullable b bVar) {
        this.c = bVar;
        ((WXRecyclerView) getInnerView()).t = bVar;
    }
}
