package com.uc.weex.component.e;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.uc.weex.component.b;

/* compiled from: ProGuard */
public class l extends bv<c> {
    boolean a = false;
    int b = 0;
    private boolean c = true;

    public l(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
        b.a().a(getInstanceId(), this);
    }

    public final void a(ab abVar, int i) {
        if (abVar.getDomObject().r().equals("uc-scene")) {
            super.a(abVar, i);
        }
    }

    protected final void a(View view, int i) {
        q qVar = (q) view;
        if (qVar.d.c) {
            ((c) getHostView()).a(qVar);
            this.a = true;
        }
    }

    public final void a(ab abVar, boolean z) {
        super.a(abVar, z);
        if (abVar.getHostView() != null) {
            ((c) getHostView()).c((q) abVar.getHostView());
        }
    }

    public void destroy() {
        super.destroy();
        getHostView();
        c.b();
    }

    final void a(n nVar) {
        nVar.createView();
        nVar.applyLayoutAndEvent(nVar);
        ((q) nVar.getHostView()).setEnableSwipeGesture(this.c);
        a(true);
    }

    final void a(boolean z) {
        b a = b.a();
        getInstanceId();
        a.a(z);
    }

    final void b() {
        if (getHostView() == null || ((c) getHostView()).a() <= 1) {
            a(true);
        } else {
            a(false);
        }
    }

    static Animation d() {
        return null;
    }

    static Animation e() {
        return null;
    }

    @WXComponentProp(name = "animationType")
    public void setAnimationType(String str) {
        if ("LR".equals(str)) {
            this.b = 0;
        } else if ("TB".equals(str)) {
            this.b = 1;
        }
    }

    protected /* synthetic */ View initComponentHostView(Context context) {
        b.a();
        return new j(context, this);
    }
}
