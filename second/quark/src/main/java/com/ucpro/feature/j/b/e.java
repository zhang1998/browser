package com.ucpro.feature.j.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.business.stat.m;
import com.ucpro.feature.j.a;
import com.ucpro.feature.j.a.b;
import com.ucpro.feature.j.c;
import com.ucpro.ui.widget.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class e extends FrameLayout {
    private View a = new View(getContext());
    private View b;
    private a c;

    public e(Context context) {
        super(context);
        addView(this.a, new LayoutParams(com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_min_view_width), com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_min_view_height)));
        this.b = new View(getContext());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_min_view_rect_width), com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_min_view_rect_height));
        layoutParams.gravity = 21;
        addView(this.b, layoutParams);
        a();
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_min_view_width), com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_min_view_height));
    }

    public final void a() {
        int c = com.ucpro.ui.c.a.c((int) R.dimen.multi_window_cardview2_corner_radius);
        this.b.setBackgroundDrawable(new i(new float[]{(float) c, (float) c, 0.0f, 0.0f, 0.0f, 0.0f, (float) c, (float) c}, com.ucpro.ui.c.a.c("default_background_white")));
        setBackgroundDrawable(com.ucpro.ui.c.a.a("shortcut_menu_shadow.9.png"));
        this.a.setBackgroundDrawable(com.ucpro.ui.c.a.a("shortcut_menu_shadow.9.png"));
        if (this.c != null) {
            a aVar = this.c;
            if (aVar.c != null) {
                aVar.c.a();
            }
        }
    }

    public final void setPresenter(a aVar) {
        this.c = aVar;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float f = IPictureView.DEFAULT_MIN_SCALE;
        if (this.c == null) {
            return false;
        }
        a aVar = this.c;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        motionEvent.getY();
        a aVar2;
        switch (action) {
            case 0:
                aVar.d = x;
                aVar.e.removeCallbacks(aVar.f);
                aVar.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                if (aVar.a != null) {
                    if (aVar.c == null) {
                        aVar.c = new a(aVar.a.h());
                        aVar.c.setPresenter(aVar);
                        aVar.c.setOnClickListener(new c(aVar));
                    }
                    aVar2 = aVar.c;
                    List<com.ucpro.feature.j.a.a> c = b.a().c();
                    List arrayList = new ArrayList();
                    for (com.ucpro.feature.j.a.a aVar3 : c) {
                        if (aVar3.e) {
                            arrayList.add(aVar3);
                        }
                    }
                    aVar2.a(arrayList);
                    if (aVar.c.getParent() != null) {
                        ((ViewGroup) aVar.c.getParent()).removeView(aVar.c);
                    }
                    aVar.a.a(aVar.c);
                    m.a("shrotcut_menu", "shortcut_menu_full_show", new String[0]);
                    break;
                }
                break;
            case 1:
            case 3:
                if (!(aVar.c == null || aVar.a == null)) {
                    aVar2 = aVar.c;
                    if (aVar2.b != null) {
                        aVar2.b.cancel();
                    }
                    aVar2.b = ValueAnimator.ofFloat(new float[]{aVar2.a, IPictureView.DEFAULT_MIN_SCALE});
                    aVar2.b.setDuration((long) ((IPictureView.DEFAULT_MIN_SCALE - aVar2.a) * ((float) aVar2.c)));
                    aVar2.b.addUpdateListener(new c(aVar2));
                    aVar2.b.start();
                }
                aVar.e.postDelayed(aVar.f, 3000);
                break;
            case 2:
                int i = aVar.d - x;
                if (aVar.c != null) {
                    float f2 = ((float) i) / 300.0f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    if (f2 <= IPictureView.DEFAULT_MIN_SCALE) {
                        f = f2;
                    }
                    aVar.c.setStretchProgress(f);
                    break;
                }
                break;
        }
        return true;
    }
}
