package com.uc.weex.component.h;

import android.graphics.Path;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.b.o;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
public class h extends b {
    private float n;
    private float o;
    private float p;
    private float q;

    public h(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    @WXComponentProp(name = "x1")
    public void setX1(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.n, a)) {
            this.n = a;
        }
    }

    @WXComponentProp(name = "y1")
    public void setY1(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.o, a)) {
            this.o = a;
        }
    }

    @WXComponentProp(name = "x2")
    public void setX2(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.p, a)) {
            this.p = a;
        }
    }

    @WXComponentProp(name = "y2")
    public void setY2(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.q, a)) {
            this.q = a;
        }
    }

    protected final Path a() {
        try {
            Path path = new Path();
            path.moveTo(this.n, this.o);
            path.lineTo(this.p, this.q);
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}
