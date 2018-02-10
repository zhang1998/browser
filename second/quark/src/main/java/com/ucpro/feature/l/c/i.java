package com.ucpro.feature.l.c;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.d.b;
import com.ucpro.ui.animation.g;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.h;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class i extends ViewGroup implements f {
    public h a;
    public h b;
    private h c;
    private d d;
    private View e;
    private h f;
    private b g;
    private ValueAnimator h;

    public i(Context context) {
        super(context);
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = null;
        this.b = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.e = new View(getContext());
        addView(this.e);
        this.c = new h(getContext());
        addView(this.c);
        this.d = new d(getContext());
        addView(this.d);
        a();
    }

    public final void setHomePage(View view) {
        if (this.f == null) {
            this.f = new h(getContext());
            addView(this.f, 0);
        }
        this.f.setSourceView(view);
    }

    public final void a() {
        this.c.a();
        this.d.setBackgroundColor(a.c("default_background_white"));
        this.e.setBackgroundColor(a.c("default_background_dark"));
    }

    public final void setPresenter(b bVar) {
        c.b(bVar instanceof b);
        this.g = (b) bVar;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.e.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        this.d.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.dicover_page_toolbar_height), UCCore.VERIFY_POLICY_QUICK));
        this.c.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight() - this.d.getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        if (this.a != null) {
            this.a.measure(MeasureSpec.makeMeasureSpec(this.a.getSourceView().getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.a.getSourceView().getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.b != null) {
            this.b.measure(MeasureSpec.makeMeasureSpec(this.b.getSourceView().getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.b.getSourceView().getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.f != null) {
            this.f.measure(MeasureSpec.makeMeasureSpec(this.f.getSourceView().getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.f.getSourceView().getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.e != null) {
            this.e.layout(0, 0, this.e.getMeasuredWidth() + 0, this.e.getMeasuredHeight() + 0);
        }
        if (this.c != null) {
            this.c.layout(0, 0, this.c.getMeasuredWidth() + 0, this.c.getMeasuredHeight() + 0);
        }
        if (this.d != null) {
            int measuredWidth = this.d.getMeasuredWidth() + 0;
            int bottom = this.c.getBottom();
            this.d.layout(0, bottom, measuredWidth, this.d.getMeasuredHeight() + bottom);
        }
        if (this.a != null && this.a.getVisibility() == 0) {
            View sourceView = this.a.getSourceView();
            bottom = getMeasuredHeight();
            this.a.layout(sourceView.getLeft(), bottom - this.a.getMeasuredHeight(), sourceView.getRight(), bottom);
        }
        if (this.b != null && this.b.getVisibility() == 0) {
            sourceView = this.b.getSourceView();
            bottom = getMeasuredHeight();
            this.b.layout(sourceView.getLeft(), bottom - this.b.getMeasuredHeight(), sourceView.getRight(), bottom);
        }
        if (this.f != null && this.f.getVisibility() == 0) {
            sourceView = this.f.getSourceView();
            this.f.layout(sourceView.getLeft(), sourceView.getTop(), sourceView.getRight(), sourceView.getBottom());
        }
    }

    public final h getContent() {
        return this.c;
    }

    public final void a(boolean z, float f, g gVar) {
        if (this.h != null) {
            this.h.cancel();
        }
        this.h = ValueAnimator.ofFloat(new float[]{f, IPictureView.DEFAULT_MIN_SCALE});
        this.h.addUpdateListener(new l(this, z));
        this.h.addListener(new k(this, gVar));
        if (z) {
            this.h.setInterpolator(new DecelerateInterpolator());
        } else {
            this.h.setInterpolator(new AccelerateInterpolator());
        }
        this.h.setDuration(300);
        this.h.start();
    }

    public final void a(float f) {
        a(f, true, -1);
    }

    private void a(float f, boolean z, int i) {
        int c;
        int i2;
        float f2;
        float f3;
        int i3;
        float f4;
        float f5;
        int i4;
        int i5;
        int height = this.f.getSourceView().getHeight() + this.a.getSourceView().getHeight();
        if (z) {
            this.f.setVisibility(0);
        }
        if (f == 0.0f) {
            if (z) {
                setVisibility(0);
                this.c.setTranslationY((float) height);
            } else {
                this.f.setVisibility(0);
            }
        } else if (f == IPictureView.DEFAULT_MIN_SCALE) {
            if (z) {
                this.f.setVisibility(8);
            } else {
                setVisibility(8);
            }
        }
        if (z) {
            c = a.c((int) R.dimen.dicover_page_toolbar_height);
            i2 = -100;
            f2 = 0.0f;
            f3 = 0.5f;
            i3 = height;
            height = 0;
            f4 = IPictureView.DEFAULT_MIN_SCALE;
            f5 = 0.88f;
            i4 = 0;
            i5 = c;
        } else {
            int translationY = i == -1 ? (int) this.c.getTranslationY() : 0;
            i3 = getMeasuredHeight();
            float scaleX = translationY == -1 ? this.f.getScaleX() : 0.8f;
            int translationY2 = (int) this.a.getTranslationY();
            i4 = (int) this.b.getTranslationY();
            f2 = translationY == -1 ? this.e.getAlpha() : 0.5f;
            i2 = i4;
            i4 = translationY2;
            f4 = scaleX;
            c = -100;
            i5 = 0;
            f5 = IPictureView.DEFAULT_MIN_SCALE;
            height = i3;
            i3 = translationY;
            f3 = 0.0f;
        }
        this.c.setTranslationY((float) ((int) ((((float) (height - i3)) * f) + ((float) i3))));
        f5 = ((f5 - f4) * f) + f4;
        this.f.setScaleX(f5);
        this.f.setScaleY(f5);
        this.a.setTranslationY((float) ((int) ((((float) (i5 - i4)) * f) + ((float) i4))));
        c = (int) ((((float) (c - i2)) * f) + ((float) i2));
        if (c < 0) {
            c = 0;
        }
        this.b.setTranslationY((float) c);
        if (z) {
            this.d.a(f);
        } else {
            this.d.a(IPictureView.DEFAULT_MIN_SCALE - f);
        }
        this.e.setAlpha(((f3 - f2) * f) + f2);
    }

    public final b getPresenter() {
        return this.g;
    }
}
