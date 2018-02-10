package com.taobao.weex.ui.view.refresh.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.taobao.weex.c.o;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.view.p;
import com.taobao.weex.ui.view.refresh.core.WXRefreshView;
import com.taobao.weex.ui.view.refresh.core.WXSwipeLayout;
import com.taobao.weex.ui.view.refresh.core.l;
import com.taobao.weex.ui.view.refresh.core.m;
import com.taobao.weex.utils.af;
import com.taobao.weex.utils.ah;

/* compiled from: ProGuard */
public abstract class BaseBounceView<T extends View> extends FrameLayout {
    protected WXSwipeLayout a;
    private int b;
    private T c;

    public abstract T a(Context context);

    public abstract void c();

    public abstract void d();

    public BaseBounceView(Context context, int i) {
        this(context, null, i);
    }

    public BaseBounceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.b = 1;
        this.b = i;
    }

    public int getOrientation() {
        return this.b;
    }

    public final void a(Context context, boolean z) {
        this.c = a(context);
        if (this.c == null) {
            return;
        }
        if (z) {
            this.a = new WXSwipeLayout(context);
            this.a.setLayoutParams(new LayoutParams(-1, -1));
            this.a.addView(this.c, new LayoutParams(-1, -1));
            addView(this.a, -1, -1);
            return;
        }
        addView(this.c, -1, -1);
    }

    public void setOnRefreshListener(m mVar) {
        if (this.a != null) {
            this.a.setOnRefreshListener(mVar);
        }
    }

    public void setOnLoadingListener(l lVar) {
        if (this.a != null) {
            this.a.setOnLoadingListener(lVar);
        }
    }

    public final void a() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public T getInnerView() {
        return this.c;
    }

    public void setHeaderView(ab abVar) {
        if (!abVar.isDestoryed()) {
            setRefreshEnable(true);
            if (this.a != null) {
                WXRefreshView headerView = this.a.getHeaderView();
                if (headerView != null) {
                    o domObject = abVar.getDomObject();
                    if (domObject != null) {
                        this.a.setRefreshHeight((int) domObject.p());
                        Object a = ah.a((String) domObject.g().get(Style.BACKGROUND_COLOR), null);
                        if (!(a == null || TextUtils.isEmpty(a))) {
                            int a2 = af.a(a);
                            if (a2 != 0) {
                                this.a.setRefreshBgColor(a2);
                            }
                        }
                        headerView.setRefreshView(abVar.getHostView());
                    }
                }
            }
        }
    }

    public void setFooterView(ab abVar) {
        if (!abVar.isDestoryed()) {
            setLoadmoreEnable(true);
            if (this.a != null) {
                WXRefreshView footerView = this.a.getFooterView();
                if (footerView != null) {
                    o domObject = abVar.getDomObject();
                    if (domObject != null) {
                        this.a.setLoadingHeight((int) domObject.p());
                        Object a = ah.a((String) domObject.g().get(Style.BACKGROUND_COLOR), null);
                        if (!(a == null || TextUtils.isEmpty(a))) {
                            int a2 = af.a(a);
                            if (a2 != 0) {
                                this.a.setLoadingBgColor(a2);
                            }
                        }
                        footerView.setRefreshView(abVar.getHostView());
                    }
                }
            }
        }
    }

    public final void a(ab abVar) {
        setLoadmoreEnable(false);
        if (this.a != null && this.a.getFooterView() != null) {
            this.a.setLoadingHeight(0);
            this.a.getFooterView().removeView(abVar.getHostView());
            this.a.b();
        }
    }

    public final void b(ab abVar) {
        setRefreshEnable(false);
        if (this.a != null && this.a.getHeaderView() != null) {
            this.a.setRefreshHeight(0);
            this.a.getHeaderView().removeView(abVar.getHostView());
            this.a.a();
        }
    }

    public void setRefreshEnable(boolean z) {
        if (this.a != null) {
            this.a.setPullRefreshEnable(z);
        }
    }

    public void setLoadmoreEnable(boolean z) {
        if (this.a != null) {
            this.a.setPullLoadEnable(z);
        }
    }

    public void removeView(View view) {
        if (view instanceof com.taobao.weex.ui.view.o) {
            b();
            setLoadmoreEnable(false);
            if (this.a != null) {
                this.a.removeView(this.a.getFooterView());
            }
        } else if (view instanceof p) {
            a();
            setRefreshEnable(false);
            if (this.a != null) {
                this.a.removeView(this.a.getHeaderView());
            }
        } else {
            super.removeView(view);
        }
    }

    public WXSwipeLayout getSwipeLayout() {
        return this.a;
    }
}
