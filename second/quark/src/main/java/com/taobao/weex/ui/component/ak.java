package com.taobao.weex.ui.component;

import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.b.m;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class ak extends m {
    @Deprecated
    public ak(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar, z);
    }

    public ak(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
        if ("list".equals(bvVar.getDomObject().r())) {
            setSticky("sticky");
        }
    }

    public boolean isLazy() {
        return false;
    }

    public boolean isSticky() {
        return true;
    }

    public boolean canRecycled() {
        return false;
    }
}
