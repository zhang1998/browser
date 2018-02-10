package com.uc.weex.component.h;

import android.graphics.Path;
import android.graphics.Path.Direction;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.b.o;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
public class c extends b {
    private float n;
    private float o;
    private float p;

    public c(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    @WXComponentProp(name = "cx")
    public void setCx(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.n, a)) {
            this.n = a;
        }
    }

    @WXComponentProp(name = "cy")
    public void setCy(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.o, a)) {
            this.o = a;
        }
    }

    @WXComponentProp(name = "r")
    public void setR(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.p, a)) {
            this.p = a;
        }
    }

    protected final Path a() {
        try {
            Path path = new Path();
            path.addCircle(this.n, this.o, this.p, Direction.CW);
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}
