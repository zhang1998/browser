package com.uc.weex.component.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.b.o;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.ui.view.l;
import com.taobao.weex.utils.WXViewUtils;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public class g extends e {
    private int a;
    private String b;
    public final l j = null;
    protected float k = IPictureView.DEFAULT_MIN_SCALE;
    protected float l = IPictureView.DEFAULT_MIN_SCALE;
    protected float m = 0.0f;
    protected float n = 0.0f;
    protected float o = 0.0f;
    protected float p = 0.0f;
    protected float q = 0.0f;

    public g(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    @WXComponentProp(name = "scaleX")
    public void setScaleX(float f) {
        if (!o.a(this.k, f)) {
            this.k = f;
        }
    }

    @WXComponentProp(name = "scalex")
    public void setScaleX2(float f) {
        setScaleX(f);
    }

    @WXComponentProp(name = "scaleY")
    public void setScaleY(float f) {
        if (!o.a(this.l, f)) {
            this.l = f;
        }
    }

    @WXComponentProp(name = "scaley")
    public void setScaleY2(float f) {
        setScaleY(f);
    }

    @WXComponentProp(name = "scale")
    public void setScale(float f) {
        setScaleX(f);
        setScaleY(f);
    }

    @WXComponentProp(name = "x")
    public void setLeft(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.m, a)) {
            this.m = a;
        }
    }

    @WXComponentProp(name = "y")
    public void setTop(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.n, a)) {
            this.n = a;
        }
    }

    @WXComponentProp(name = "rotation")
    public void setRotation(float f) {
        if (!o.a(this.o, f)) {
            this.o = f;
        }
    }

    @WXComponentProp(name = "originX")
    public void setOriginX(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.p, a)) {
            this.p = a;
        }
    }

    @WXComponentProp(name = "originx")
    public void setOriginX2(float f) {
        setOriginX(f);
    }

    @WXComponentProp(name = "originY")
    public void setOriginY(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.q, a)) {
            this.q = a;
        }
    }

    @WXComponentProp(name = "originy")
    public void setOriginY2(float f) {
        setOriginY(f);
    }

    @WXComponentProp(name = "transform")
    public void setTransform(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (this.a != hashCode) {
                this.b = str;
                this.a = hashCode;
            }
        }
    }

    protected final void a(Canvas canvas) {
        canvas.save();
        if (this.h.a != null) {
            canvas.concat(this.h.a);
        }
    }

    public void a(Canvas canvas, Paint paint, float f) {
        float f2 = f * this.f;
        if (f2 > 0.01f) {
            a(canvas);
            for (int i = 0; i < this.g.size(); i++) {
                ((y) h(i)).a(canvas, paint, f2);
            }
            canvas.restore();
        }
    }

    public void updateExtra(Object obj) {
        super.updateExtra(obj);
        this.h.a(v.a(this.m, this.n, this.k, this.l, this.o, this.p, this.q, this.b));
    }
}
