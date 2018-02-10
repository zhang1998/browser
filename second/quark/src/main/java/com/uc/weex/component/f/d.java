package com.uc.weex.component.f;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.bv;

/* compiled from: ProGuard */
public class d extends bv<k> {
    public d(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar);
    }

    protected final void a(View view, int i) {
        super.a(view, i);
        if (view instanceof c) {
            ((k) getHostView()).setHeaderView((c) view);
        }
    }

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return new k(context);
    }
}
