package com.uc.weex.component.h;

import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.b.o;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
public class f extends b {
    private float n;
    private float o;
    private float p;
    private float q;

    public f(ac acVar, ae aeVar, bv bvVar, boolean z) {
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

    @WXComponentProp(name = "rx")
    public void setRx(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.p, a)) {
            this.p = a;
        }
    }

    @WXComponentProp(name = "ry")
    public void setRy(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.q, a)) {
            this.q = a;
        }
    }

    protected final Path a() {
        try {
            Path path = new Path();
            path.addOval(new RectF(this.n - this.p, this.o - this.q, this.n + this.p, this.o + this.q), Direction.CW);
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}
