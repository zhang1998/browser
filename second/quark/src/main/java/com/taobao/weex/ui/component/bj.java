package com.taobao.weex.ui.component;

import android.mini.support.v4.view.bx;
import android.widget.FrameLayout;
import com.taobao.weex.ad;
import com.taobao.weex.c.ai;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class bj implements bx {
    final /* synthetic */ bk a;
    private int b = -1;

    protected bj(bk bkVar) {
        this.a = bkVar;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void a(int i) {
        if (this.a.d.a(i) != this.b) {
            if (i.c()) {
                WXLogUtils.d("onPageSelected >>>>" + this.a.d.a(i) + " lastPos: " + this.b);
            }
            if (this.a.d != null && this.a.d.c() != 0) {
                int a = this.a.d.a(i);
                if (this.a.g != null && a < this.a.g.size() && this.a.getDomObject().c_().size() != 0) {
                    ai c_ = this.a.getDomObject().c_();
                    String b_ = this.a.getDomObject().b_();
                    if (c_.contains("change") && WXViewUtils.a(this.a.getHostView())) {
                        this.a.a.put("index", Integer.valueOf(a));
                        Map hashMap = new HashMap();
                        Map hashMap2 = new HashMap();
                        hashMap2.put("index", Integer.valueOf(a));
                        hashMap.put("attrs", hashMap2);
                        ad.a().a(this.a.getInstanceId(), b_, "change", this.a.a, hashMap);
                    }
                    this.a.b.requestLayout();
                    ((FrameLayout) this.a.getHostView()).invalidate();
                    this.b = this.a.d.a(i);
                }
            }
        }
    }

    public final void b(int i) {
        FrameLayout frameLayout = (FrameLayout) this.a.getHostView();
        if (frameLayout != null) {
            frameLayout.invalidate();
        }
    }
}
