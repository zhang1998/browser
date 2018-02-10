package com.taobao.weex.ui.component.b;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.ui.view.l;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class m extends bv<l> {
    int a;
    public ViewGroup b;
    public View c;
    public View d;
    boolean e;
    public int f;

    @Deprecated
    public m(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar, z);
    }

    public m(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, true);
        this.a = 0;
        this.e = true;
        this.f = -1;
    }

    public boolean isLazy() {
        return this.e;
    }

    public final ViewGroup g_() {
        return this.b;
    }

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        if (isSticky()) {
            View lVar = new l(context);
            this.b = new l(context);
            lVar.addView(this.b);
            return lVar;
        }
        lVar = new l(context);
        this.b = lVar;
        return lVar;
    }

    public /* bridge */ /* synthetic */ View getRealView() {
        return this.b;
    }
}
