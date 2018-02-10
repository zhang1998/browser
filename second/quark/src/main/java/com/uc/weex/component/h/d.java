package com.uc.weex.component.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.b.o;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
public class d extends g {
    protected RectF a;
    protected float b = 0.0f;
    protected float c = 0.0f;
    protected boolean d;

    public d(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    @WXComponentProp(name = "x")
    public void setLeft(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.m, a)) {
            this.m = a;
            this.d = true;
        }
    }

    @WXComponentProp(name = "y")
    public void setTop(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.n, a)) {
            this.n = a;
            this.d = true;
        }
    }

    @WXComponentProp(name = "width")
    public void setWidth(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.b, a)) {
            this.b = a;
            this.d = true;
        }
    }

    @WXComponentProp(name = "height")
    public void setHeight(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.c, a)) {
            this.c = a;
            this.d = true;
        }
    }

    public final void a(Canvas canvas, Paint paint, float f) {
        float f2 = f * this.f;
        if (f2 > 0.01f) {
            a(canvas);
            if (this.a != null) {
                Canvas canvas2 = canvas;
                canvas2.clipRect(b() * this.a.left, b() * this.a.top, b() * this.a.right, b() * this.a.bottom, Op.REPLACE);
            }
            for (int i = 0; i < this.g.size(); i++) {
                ((y) h(i)).a(canvas, paint, f2);
            }
            canvas.restore();
        }
    }

    public void updateExtra(Object obj) {
        super.updateExtra(obj);
        if (this.d) {
            float[] fArr = new float[]{this.m, this.n, this.b, this.c};
            this.a = new RectF(fArr[0], fArr[1], fArr[0] + fArr[2], fArr[3] + fArr[1]);
            this.d = false;
        }
    }
}
