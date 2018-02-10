package com.uc.weex.component.e;

import android.content.Context;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;

/* compiled from: ProGuard */
public class n extends bv<q> {
    final String a = "isDefault";
    String b;
    boolean c;

    public n(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, false);
        if (aeVar.i() != null) {
            this.b = (String) aeVar.i().get("sceneName");
            Object obj = aeVar.i().get("isDefault");
            if (obj != null) {
                this.c = obj.toString().equalsIgnoreCase("true");
            }
        }
    }

    @WXComponentProp(name = "isDefault")
    public void setDefault(boolean z) {
        if (getHostView() != null) {
            this.c = z;
            if (z && getParent() != null && (getParent() instanceof l)) {
                boolean z2;
                l lVar = (l) getParent();
                if (this == null || lVar.g == null || !lVar.g.contains(this)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    ((q) getHostView()).a((byte) 2, false);
                    if (((q) getHostView()).getVisibility() != 0) {
                        ((q) getHostView()).setVisibility(0);
                    }
                    if (!lVar.a && this != null && getHostView() != null) {
                        ((c) lVar.getHostView()).a((q) getHostView());
                    }
                }
            }
        }
    }

    protected /* synthetic */ View initComponentHostView(Context context) {
        return new q(context, this, ((c) ((l) getParent()).getHostView()).getSwipeCallback());
    }
}
