package com.taobao.weex.ui.component;

import android.mini.support.v4.view.bz;
import android.view.View;
import android.view.ViewGroup;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class bo implements bz {
    final /* synthetic */ bp a;

    bo(bp bpVar) {
        this.a = bpVar;
    }

    public final void a(View view, float f) {
        int i;
        int i2 = 1;
        int indexOf = this.a.d.a.indexOf(view);
        int currentItem = this.a.b.getCurrentItem();
        int c = this.a.d.c();
        if (currentItem == 0 || currentItem == c - 1 || Math.abs(indexOf - currentItem) <= 1) {
            i = 0;
        } else {
            i = 1;
        }
        if (currentItem == 0 && indexOf < c - 1 && indexOf > 1) {
            i = 1;
        }
        if (currentItem != c - 1 || indexOf >= c - 2 || indexOf <= 0) {
            i2 = i;
        }
        if (i2 == 0) {
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt != null) {
                float f2;
                if (f <= ((float) ((-c) + 1))) {
                    f2 = ((float) c) + f;
                } else {
                    f2 = f;
                }
                if (f2 >= ((float) (c - 1))) {
                    f2 -= (float) c;
                }
                if (f2 >= -1.0f && f2 <= IPictureView.DEFAULT_MIN_SCALE) {
                    float abs = Math.abs(Math.abs(f2) - IPictureView.DEFAULT_MIN_SCALE);
                    float a = this.a.h + ((this.a.k - this.a.h) * abs);
                    abs = (abs * (IPictureView.DEFAULT_MIN_SCALE - this.a.i)) + this.a.i;
                    float a2 = this.a.a(view);
                    if (f2 > 0.0f) {
                        f2 *= a2;
                        childAt.setTranslationX(-f2);
                        view.setTranslationX(-f2);
                    } else if (f2 == 0.0f) {
                        view.setTranslationX(0.0f);
                        childAt.setTranslationX(0.0f);
                        this.a.a(this.a.i, this.a.h);
                    } else if (c != 2 || Math.abs(f2) != IPictureView.DEFAULT_MIN_SCALE) {
                        f2 = (-f2) * a2;
                        childAt.setTranslationX(f2);
                        view.setTranslationX(f2);
                    } else {
                        return;
                    }
                    childAt.setScaleX(a);
                    childAt.setScaleY(a);
                    childAt.setAlpha(abs);
                }
            }
        }
    }
}
