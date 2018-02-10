package com.uc.weex.component.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.util.Log;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.b.o;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.af;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public abstract class b extends a {
    protected Path l;
    public FillType m = FillType.WINDING;
    private int n;
    private boolean o = false;
    private int p;
    private boolean q = false;
    private float r = IPictureView.DEFAULT_MIN_SCALE;
    private int s = 1;
    private int t = 1;
    private int u;
    private int v;

    public b(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    @WXComponentProp(name = "fill")
    public void setFill(String str) {
        if (str == null) {
            this.q = true;
            return;
        }
        int hashCode = str.hashCode();
        if (this.v != hashCode) {
            this.p = af.a(str);
            this.v = hashCode;
        }
    }

    @WXComponentProp(name = "fillrule")
    public void setFillRule2(String str) {
        setFillRule(str);
    }

    @WXComponentProp(name = "stroke")
    public void setStroke(String str) {
        if (str == null) {
            this.o = true;
            return;
        }
        int hashCode = str.hashCode();
        if (this.u != hashCode) {
            this.n = af.a(str);
            this.u = hashCode;
        }
    }

    private static int a(String str) {
        if ("butt".equals(str)) {
            return 0;
        }
        if ("square".equals(str)) {
            return 2;
        }
        return 1;
    }

    @WXComponentProp(name = "strokeCap")
    public void setStrokeCap(String str) {
        int a = a(str);
        if (this.s != a) {
            this.s = a;
        }
    }

    @WXComponentProp(name = "strokecap")
    public void setStrokeCap2(String str) {
        setStrokeCap(str);
    }

    @WXComponentProp(name = "strokeLinecap")
    public void setStrokeLinecap(String str) {
        int a = a(str);
        if (this.s != a) {
            this.s = a;
        }
    }

    @WXComponentProp(name = "strokelinecap")
    public void setStrokeLinecap2(String str) {
        setStrokeLinecap(str);
    }

    private static int b(String str) {
        if ("miter".equals(str)) {
            return 0;
        }
        if ("bevel".equals(str)) {
            return 2;
        }
        return 1;
    }

    @WXComponentProp(name = "strokeJoin")
    public void setStrokeJoin(String str) {
        int b = b(str);
        if (this.t != b) {
            this.t = b;
        }
    }

    @WXComponentProp(name = "strokejoin")
    public void setStrokeJoin2(String str) {
        setStrokeJoin(str);
    }

    @WXComponentProp(name = "strokeLinejoin")
    public void setStrokeLinejoin(String str) {
        int b = b(str);
        if (this.t != b) {
            this.t = b;
        }
    }

    @WXComponentProp(name = "strokelinejoin")
    public void setStrokeLinejoin2(String str) {
        setStrokeLinejoin(str);
    }

    @WXComponentProp(name = "strokeWidth")
    public void setStrokeWidth(float f) {
        if (!o.a(this.r, f)) {
            this.r = f;
        }
    }

    @WXComponentProp(name = "strokewidth")
    public void setStrokeWidth2(float f) {
        setStrokeWidth(f);
    }

    public void a(Canvas canvas, Paint paint, float f) {
        Path a = a();
        if (a != null) {
            this.l = a;
        }
        if (this.l == null) {
            Log.w("ART-SVG", "path is null");
            return;
        }
        this.l.setFillType(this.m);
        float f2 = this.a * f;
        if (f2 > 0.01f) {
            a(canvas);
            if (b(paint, f2)) {
                canvas.drawPath(this.l, paint);
            }
            if (a(paint, f2)) {
                canvas.drawPath(this.l, paint);
            }
            canvas.restore();
        }
    }

    protected final boolean a(Paint paint, float f) {
        if (this.r == 0.0f || this.o) {
            return false;
        }
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Style.STROKE);
        switch (this.s) {
            case 0:
                paint.setStrokeCap(Cap.BUTT);
                break;
            case 1:
                paint.setStrokeCap(Cap.ROUND);
                break;
            case 2:
                paint.setStrokeCap(Cap.SQUARE);
                break;
        }
        switch (this.t) {
            case 0:
                paint.setStrokeJoin(Join.MITER);
                break;
            case 1:
                paint.setStrokeJoin(Join.ROUND);
                break;
            case 2:
                paint.setStrokeJoin(Join.BEVEL);
                break;
        }
        paint.setStrokeWidth(this.r * this.b.b);
        paint.setColor(this.n);
        paint.setAlpha((int) (((float) paint.getAlpha()) * f));
        return true;
    }

    protected final boolean b(Paint paint, float f) {
        if (this.q) {
            return false;
        }
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Style.FILL);
        paint.setColor(this.p);
        paint.setAlpha((int) (((float) paint.getAlpha()) * f));
        return true;
    }

    protected Path a() {
        return null;
    }

    @WXComponentProp(name = "fillRule")
    public void setFillRule(String str) {
        FillType fillType;
        if ("evenodd".equalsIgnoreCase(str)) {
            fillType = FillType.EVEN_ODD;
        } else {
            fillType = FillType.WINDING;
        }
        if (fillType != this.m) {
            this.m = fillType;
        }
    }
}
