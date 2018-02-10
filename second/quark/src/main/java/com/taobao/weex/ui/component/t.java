package com.taobao.weex.ui.component;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.view.l;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class t extends bv<l> {
    private au a;

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return a(context);
    }

    public t(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    public final void g(ab abVar) {
        super.g(abVar);
        a(abVar);
    }

    protected l a(@NonNull Context context) {
        return new l(context);
    }

    public final void a(ab abVar, int i) {
        super.a(abVar, i);
        a(abVar);
    }

    private void a(ab abVar) {
        if (abVar instanceof au) {
            this.a = (au) abVar;
        }
    }
}
