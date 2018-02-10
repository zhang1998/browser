package com.ucpro.feature.navigation.view;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.uc.imagecodec.export.IPictureView;
import com.ucweb.common.util.a.a;
import com.ucweb.common.util.d;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class l {
    static final float a = a.a(d.a(), (float) IPictureView.DEFAULT_MIN_SCALE);
    public i b;
    public View c;
    public View d;
    public Point e = new Point();
    public Rect f = new Rect();
    public Rect g = new Rect();
    public Rect h = new Rect();
    public ax i;
    public aj j;
    public int k = -1;
    ObjectAnimator l;
    ObjectAnimator m;
    int n = 0;
    aa o = new aa();
    public ArrayList<Object> p = new ArrayList();
    ObjectAnimator q;
    ObjectAnimator r;
    Interpolator s = new LinearInterpolator();
    private Rect t = new Rect();

    public final void a(int i, int i2) {
        if (this.b != null) {
            int i3 = i - this.e.x;
            int i4 = i2 - this.e.y;
            this.g.set(this.f.left, this.f.top, this.f.right, this.f.bottom);
            this.g.offset(i3, i4);
            b();
        }
    }

    protected final void a() {
        int i = this.o.b;
        if (this.b != null) {
            this.b.setAlpha(i);
            this.j.invalidate();
        }
    }

    protected final void b() {
        int width = this.g.width();
        int height = this.g.height();
        int round = Math.round(((float) width) * this.o.a);
        int round2 = Math.round(((float) height) * this.o.a);
        int i = this.g.left;
        int i2 = this.g.top;
        int i3 = this.g.right;
        int i4 = this.g.bottom;
        switch (this.n) {
            case 0:
                i = this.g.left - ((round - width) / 2);
                i2 = this.g.top - ((round2 - height) / 2);
                break;
            case 1:
                break;
            default:
                int i5 = i4;
                i4 = i2;
                i2 = i5;
                int i6 = i3;
                i3 = i;
                i = i6;
                break;
        }
        i4 = i2;
        i2 += round2;
        i3 = i;
        i += round;
        this.h.set(i3, i4, i, i2);
        if (this.b != null) {
            ab abVar = (ab) this.b.getLayoutParams();
            if (abVar != null) {
                abVar.a = this.h.left;
                abVar.b = this.h.top;
                abVar.width = this.h.width();
                abVar.height = this.h.height();
                if (this.t.width() > 0) {
                    this.j.invalidate(this.t);
                }
                this.j.invalidate(this.h);
                this.t.set(this.h);
            }
        }
    }
}
