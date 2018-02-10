package com.uc.weex.component.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.b.o;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.ui.view.l;
import com.uc.imagecodec.export.IPictureView;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class e extends bv<l> implements y {
    private r a;
    public final l e = null;
    protected float f = IPictureView.DEFAULT_MIN_SCALE;
    protected i h = new i();
    protected boolean i = true;

    public e(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    public void a(Canvas canvas, Paint paint, float f) {
    }

    public boolean isVirtualComponent() {
        return true;
    }

    @WXComponentProp(name = "opacity")
    public void setOpacity(float f) {
        if (!o.a(this.f, f)) {
            this.f = f;
        }
    }

    @WXComponentProp(name = "visible")
    public void setVisible(boolean z) {
        if (this.i != z) {
            this.i = z;
        }
    }

    public final float b() {
        return this.h.b;
    }

    public void updateExtra(Object obj) {
        super.updateExtra(obj);
        if (!this.i) {
            setOpacity(0.0f);
        }
    }

    private r d() {
        if (this.a == null) {
            this.a = v.a((ab) this);
        }
        return this.a;
    }

    public void updateProperties(Map<String, Object> map) {
        super.updateProperties(map);
        if (d() != null) {
            d().b();
        }
    }
}
