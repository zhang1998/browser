package com.uc.weex.component.h;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.b.o;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;
import com.uc.imagecodec.export.IPictureView;
import java.util.Map;

/* compiled from: ProGuard */
public class r extends bv<t> implements u {
    protected float a = 0.0f;
    protected float b = 0.0f;

    public r(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    public boolean isVirtualComponent() {
        return false;
    }

    protected boolean setProperty(String str, Object obj) {
        float a;
        if (Style.WIDTH.equals(str)) {
            a = WXViewUtils.a(ah.a(obj));
            if (o.a(this.a, a)) {
                return true;
            }
            this.a = a;
            return true;
        } else if (!Style.HEIGHT.equals(str)) {
            return super.setProperty(str, obj);
        } else {
            a = WXViewUtils.a(ah.a(obj));
            if (o.a(this.b, a)) {
                return true;
            }
            this.b = a;
            return true;
        }
    }

    public final void a(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, (float) (((int) this.a) + 0), (float) (((int) this.b) + 0));
        RectF rectF2 = new RectF(0.0f, 0.0f, this.a, this.b);
        float f = rectF.left;
        float f2 = rectF.top;
        float width = rectF.width();
        float height = rectF.height();
        float f3 = rectF2.left;
        float f4 = rectF2.top;
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        f -= f3;
        f2 -= f4;
        f3 = Math.min(width2 / width, height2 / height);
        if (f3 > IPictureView.DEFAULT_MIN_SCALE) {
            f -= ((width2 / f3) - width) / 2.0f;
            height2 = f2 - (((height2 / f3) - height) / 2.0f);
        } else {
            f -= (width2 - (width * f3)) / 2.0f;
            height2 = f2 - ((height2 - (height * f3)) / 2.0f);
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-f) * IPictureView.DEFAULT_MIN_SCALE, (-height2) * IPictureView.DEFAULT_MIN_SCALE);
        matrix.postScale(f3, f3);
        canvas.concat(matrix);
        b(canvas);
    }

    private void b(Canvas canvas) {
        try {
            Paint paint = new Paint();
            for (int i = 0; i < this.g.size(); i++) {
                ((y) h(i)).a(canvas, paint, IPictureView.DEFAULT_MIN_SCALE);
            }
        } catch (Throwable th) {
        }
    }

    public final void b() {
        if (getHostView() != null) {
            ((t) getHostView()).setWillNotDraw(false);
            ((t) getHostView()).postInvalidate();
        }
    }

    public void updateProperties(Map<String, Object> map) {
        super.updateProperties(map);
        b();
    }

    protected /* synthetic */ View initComponentHostView(Context context) {
        View tVar = new t(context);
        tVar.setSVGDrawable(this);
        return tVar;
    }
}
