package com.uc.weex.component.h;

import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.b.o;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;

/* compiled from: ProGuard */
public class m extends b {
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;

    public m(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    @WXComponentProp(name = "x")
    public void setX(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.n, a)) {
            this.n = a;
        }
    }

    @WXComponentProp(name = "y")
    public void setY(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.o, a)) {
            this.o = a;
        }
    }

    @WXComponentProp(name = "width")
    public void setWidth(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.p, a)) {
            this.p = a;
        }
    }

    @WXComponentProp(name = "height")
    public void setHeight(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.q, a)) {
            this.q = a;
        }
    }

    @WXComponentProp(name = "rx")
    public void setRx(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.r, a)) {
            this.r = a;
        }
    }

    @WXComponentProp(name = "ry")
    public void setRy(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.s, a)) {
            this.s = a;
        }
    }

    protected final Path a() {
        try {
            Path path = new Path();
            if (this.r == 0.0f && this.s == 0.0f) {
                path.addRect(this.n, this.o, this.n + this.p, this.o + this.q, Direction.CW);
                return path;
            }
            if (this.r == 0.0f) {
                this.r = this.s;
            } else if (this.s == 0.0f) {
                this.s = this.r;
            }
            if (this.r > this.p / 2.0f) {
                this.r = this.p / 2.0f;
            }
            if (this.s > this.q / 2.0f) {
                this.s = this.q / 2.0f;
            }
            path.addRoundRect(new RectF(this.n, this.o, this.n + this.p, this.o + this.q), this.r, this.s, Direction.CW);
            return path;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean setProperty(String str, Object obj) {
        if (Style.WIDTH.equals(str)) {
            setWidth(ah.a(obj));
            return true;
        } else if (!Style.HEIGHT.equals(str)) {
            return super.setProperty(str, obj);
        } else {
            setHeight(ah.a(obj));
            return true;
        }
    }
}
