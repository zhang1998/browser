package com.taobao.weex.ui.component;

import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.view.k;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class as extends l {
    @Deprecated
    public as(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar, z);
    }

    public as(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    protected final void a(k kVar) {
        super.a(kVar);
        kVar.setSingleLine();
    }

    protected y measure(int i, int i2) {
        return super.measure(i, i2);
    }
}
