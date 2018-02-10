package com.uc.weex.component.d;

import android.content.Context;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.af;

/* compiled from: ProGuard */
public class a extends ab<c> {
    private int a;

    public a(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    @WXComponentProp(name = "circleColor")
    public void setCircleColor(String str) {
        this.a = af.a(str);
        ((c) getHostView()).setCircleColor(this.a);
        ((c) getHostView()).a();
    }

    protected /* synthetic */ View initComponentHostView(Context context) {
        return new c(context);
    }
}
