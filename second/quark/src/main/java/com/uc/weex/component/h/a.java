package com.uc.weex.component.h;

import android.graphics.Canvas;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.b.o;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXViewUtils;
import com.uc.imagecodec.export.IPictureView;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class a extends ab<View> implements y {
    protected float a = IPictureView.DEFAULT_MIN_SCALE;
    i b = new i();
    public final View c = null;
    protected float d = IPictureView.DEFAULT_MIN_SCALE;
    protected float e = IPictureView.DEFAULT_MIN_SCALE;
    protected float f = 0.0f;
    protected float g = 0.0f;
    protected float h = 0.0f;
    protected float i = 0.0f;
    protected float j = 0.0f;
    protected boolean k = true;
    private int l;
    private String m;
    private r n;

    public a(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    public boolean isVirtualComponent() {
        return true;
    }

    @WXComponentProp(name = "scaleX")
    public void setScaleX(float f) {
        if (!o.a(this.d, f)) {
            this.d = f;
        }
    }

    @WXComponentProp(name = "scalex")
    public void setScaleX2(float f) {
        setScaleX(f);
    }

    @WXComponentProp(name = "scaleY")
    public void setScaleY(float f) {
        if (!o.a(this.e, f)) {
            this.e = f;
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
        if (!o.a(this.f, a)) {
            this.f = a;
        }
    }

    @WXComponentProp(name = "y")
    public void setTop(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.g, a)) {
            this.g = a;
        }
    }

    @WXComponentProp(name = "rotation")
    public void setRotation(float f) {
        if (!o.a(this.h, f)) {
            this.h = f;
        }
    }

    @WXComponentProp(name = "originX")
    public void setOriginX(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.i, a)) {
            this.i = a;
        }
    }

    @WXComponentProp(name = "originx")
    public void setOriginX2(float f) {
        setOriginX(f);
    }

    @WXComponentProp(name = "originY")
    public void setOriginY(float f) {
        float a = WXViewUtils.a(f);
        if (!o.a(this.j, a)) {
            this.j = a;
        }
    }

    @WXComponentProp(name = "originy")
    public void setOriginY2(float f) {
        setOriginY(f);
    }

    @WXComponentProp(name = "visible")
    public void setVisible(boolean z) {
        if (this.k != z) {
            this.k = z;
        }
    }

    @WXComponentProp(name = "opacity")
    public void setOpacity(float f) {
        if (!o.a(this.a, f)) {
            this.a = f;
        }
    }

    @WXComponentProp(name = "transform")
    public void setTransform(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (this.l != hashCode) {
                this.l = hashCode;
                this.m = str;
            }
        }
    }

    public void updateExtra(Object obj) {
        super.updateExtra(obj);
        this.b.a(v.a(this.f, this.g, this.d, this.e, this.h, this.i, this.j, this.m));
        if (!this.k) {
            setOpacity(0.0f);
        }
    }

    protected final void a(Canvas canvas) {
        canvas.save();
        if (this.b.a != null) {
            canvas.concat(this.b.a);
        }
    }

    private r a() {
        if (this.n == null) {
            this.n = v.a((ab) this);
        }
        return this.n;
    }

    public void updateProperties(Map<String, Object> map) {
        super.updateProperties(map);
        if (a() != null) {
            a().b();
        }
    }
}
