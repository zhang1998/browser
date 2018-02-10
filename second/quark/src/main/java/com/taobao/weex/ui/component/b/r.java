package com.taobao.weex.ui.component.b;

import android.content.Context;
import android.view.ViewGroup;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.am;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.at;
import com.taobao.weex.ui.component.av;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.ui.component.t;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.refresh.wrapper.a;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Map;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class r extends e<a> {
    private String e;
    private am f;
    private float h;
    private float i;
    private av j;

    protected final /* synthetic */ ViewGroup a(Context context, int i) {
        return b(context, i);
    }

    @Deprecated
    public r(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar, z);
    }

    public r(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar);
        this.e = "WXListComponent";
        if (aeVar != null && (aeVar instanceof am)) {
            this.f = (am) aeVar;
            this.f.d();
            if ("waterfall".equals(aeVar.r)) {
                this.a = 3;
            } else {
                this.a = this.f.i().h();
            }
            g();
        }
    }

    public a b(Context context, int i) {
        return new a(context, this.a, this.b, this.c, i);
    }

    public void a(ab abVar, int i) {
        super.a(abVar, i);
        if (abVar != null && i >= -1) {
            if (getHostView() == null) {
                WXLogUtils.e(this.e, "setRefreshOrLoading: HostView == null !!!!!! check list attr has append =tree");
            } else if (abVar instanceof av) {
                this.j = (av) abVar;
                ((a) getHostView()).setOnRefreshListener(this.j);
                ((a) getHostView()).postDelayed(new n(this, abVar), 100);
            } else if (abVar instanceof at) {
                ((a) getHostView()).setOnLoadingListener((at) abVar);
                ((a) getHostView()).postDelayed(new o(this, abVar), 100);
            }
        }
    }

    private void g() {
        this.b = this.f.l;
        this.c = this.f.b();
        this.d = this.f.c();
        this.h = this.f.a_.k.a(0);
        this.i = this.f.a_.k.a(2);
    }

    @WXComponentProp(name = "columnWidth")
    public void setColumnWidth(int i) {
        if (this.f.c() != this.d) {
            d();
            g();
            WXRecyclerView wXRecyclerView = (WXRecyclerView) ((a) getHostView()).getInnerView();
            getContext();
            wXRecyclerView.a(this.a, this.b, a());
        }
    }

    @WXComponentProp(name = "columnCount")
    public void setColumnCount(int i) {
        if (this.f.l != this.b) {
            d();
            g();
            WXRecyclerView wXRecyclerView = (WXRecyclerView) ((a) getHostView()).getInnerView();
            getContext();
            wXRecyclerView.a(this.a, this.b, a());
        }
    }

    @WXComponentProp(name = "columnGap")
    public void setColumnGap(float f) throws InterruptedException {
        if (this.f.b() != this.c) {
            d();
            g();
            WXRecyclerView wXRecyclerView = (WXRecyclerView) ((a) getHostView()).getInnerView();
            getContext();
            wXRecyclerView.a(this.a, this.b, a());
        }
    }

    @WXComponentProp(name = "scrollable")
    public void setScrollable(boolean z) {
        ((WXRecyclerView) ((a) getHostView()).getInnerView()).setScrollable(z);
    }

    public void updateProperties(Map<String, Object> map) {
        super.updateProperties(map);
        if (!map.containsKey("padding") && !map.containsKey("paddingLeft") && !map.containsKey("paddingRight")) {
            return;
        }
        if (this.h != this.f.a_.k.a(0) || this.i != this.f.a_.k.a(2)) {
            d();
            g();
            WXRecyclerView wXRecyclerView = (WXRecyclerView) ((a) getHostView()).getInnerView();
            getContext();
            wXRecyclerView.a(this.a, this.b, a());
        }
    }

    public final void g(int i) {
        if (i < 0) {
            i = j() - 1;
            if (i < 0) {
                return;
            }
        }
        ab h = h(i);
        if (h instanceof t) {
            h.createView();
            if (h instanceof av) {
                ((a) getHostView()).setOnRefreshListener((av) h);
                ((a) getHostView()).postDelayed(new p(this, h), 100);
                return;
            } else if (h instanceof at) {
                ((a) getHostView()).setOnLoadingListener((at) h);
                ((a) getHostView()).postDelayed(new q(this, h), 100);
                return;
            } else {
                return;
            }
        }
        super.g(i);
    }

    public final void a(ab abVar, boolean z) {
        super.a(abVar, z);
        if (abVar instanceof at) {
            ((a) getHostView()).a(abVar);
        } else if (abVar instanceof av) {
            ((a) getHostView()).b(abVar);
        }
    }
}
