package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.widget.a.a;
import com.ucpro.ui.widget.a.j;

/* compiled from: ProGuard */
public final class f extends a {
    private j b;

    public f(Context context) {
        super(context);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setCacheColorHint(0);
        setDivider(null);
        setSelector(new ColorDrawable(0));
        a();
    }

    public final void b() {
        if (getAdapter() instanceof q) {
            q qVar = (q) getAdapter();
            qVar.d = true;
            qVar.notifyDataSetChanged();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof s) {
                    s sVar = (s) childAt;
                    sVar.a();
                    sVar.b();
                    sVar.i();
                    float f = (float) (-(s.a + s.c));
                    float f2 = (float) ((s.b * 2) + (s.d * 2));
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
                    ofFloat.setDuration(300);
                    ofFloat.addUpdateListener(new r(sVar, f, f2));
                    sVar.f = ofFloat;
                    ofFloat.start();
                }
            }
            qVar.f = true;
        }
    }

    public final void c() {
        if (getAdapter() instanceof q) {
            this.a = null;
            q qVar = (q) getAdapter();
            qVar.d = false;
            qVar.notifyDataSetChanged();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof s) {
                    s sVar = (s) childAt;
                    sVar.a();
                    float f = (float) (s.a + s.c);
                    float f2 = (float) (-((s.b * 2) + (s.d * 2)));
                    int width = sVar.getWidth();
                    int width2 = sVar.getWidth();
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
                    ofFloat.setDuration(300);
                    ofFloat.addUpdateListener(new t(sVar, f, f2, width, width2));
                    ofFloat.addListener(new a(sVar, width2));
                    sVar.g = ofFloat;
                    ofFloat.start();
                }
            }
            qVar.f = false;
        }
    }

    public final void a() {
        if (this.b != null) {
            setDragViewBg(new ColorDrawable(com.ucpro.ui.c.a.c("bookmark_drag_bg")));
            setDragViewTopShadow(com.ucpro.ui.c.a.a("bookmark_toolbar_shape.9.png"));
            setDragViewBottomShadow(com.ucpro.ui.c.a.a("bookmark_toolbar_shape_bottom.9.png"));
        }
    }
}
