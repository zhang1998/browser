package com.ucpro.ui.animation.explosionfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
public class ExplosionField extends View {
    private List<a> a;
    private int[] b;
    private ValueAnimator c;

    public ExplosionField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList();
        this.b = new int[2];
        this.c = null;
        a();
    }

    public ExplosionField(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList();
        this.b = new int[2];
        this.c = null;
        a();
    }

    private void a() {
        Arrays.fill(this.b, b.a(32));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (a aVar : this.a) {
            if (aVar.isStarted()) {
                for (c cVar : aVar.c) {
                    float f = 0.0f;
                    float floatValue = ((Float) aVar.getAnimatedValue()).floatValue() / 1.4f;
                    if (floatValue < cVar.l || floatValue > IPictureView.DEFAULT_MIN_SCALE - cVar.m) {
                        cVar.a = 0.0f;
                    } else {
                        floatValue = (floatValue - cVar.l) / ((IPictureView.DEFAULT_MIN_SCALE - cVar.l) - cVar.m);
                        float f2 = 1.4f * floatValue;
                        if (floatValue >= 0.7f) {
                            f = (floatValue - 0.7f) / 0.3f;
                        }
                        cVar.a = IPictureView.DEFAULT_MIN_SCALE - f;
                        f = cVar.i * f2;
                        cVar.c = cVar.f + f;
                        cVar.d = ((float) (((double) cVar.g) - (((double) cVar.k) * Math.pow((double) f, 2.0d)))) - (f * cVar.j);
                        cVar.e = a.h + ((cVar.h - a.h) * f2);
                    }
                    if (cVar.a > 0.0f) {
                        aVar.b.setColor(cVar.b);
                        aVar.b.setAlpha((int) (((float) Color.alpha(cVar.b)) * cVar.a));
                        canvas.drawCircle(cVar.c, cVar.d, cVar.e, aVar.b);
                    }
                }
                aVar.d.invalidate();
            }
        }
    }

    public ValueAnimator getAnimator() {
        return this.c;
    }
}
