package com.ucpro.feature.webwindow.h;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.d.b;
import com.ucpro.ui.animation.i;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.b.e;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class h extends ViewGroup implements OnClickListener, OnLongClickListener, g {
    public d a = null;
    public View b = null;
    public int c = 0;
    public boolean d = false;
    private e e;
    private int f;
    private float g;
    private a h = null;
    private int i = 0;
    private float j = 0.7f;
    private int k = 0;

    public h(Context context, int i) {
        super(context);
        this.c = i;
        this.f = a.c((int) R.dimen.progressbar_height);
        this.e = new e(getContext());
        addView(this.e);
        e();
        setOnClickListener(this);
        d();
    }

    public final void d() {
        this.a.a();
        this.e.a();
        setBackgroundColor(a.c("background_color"));
    }

    public final void setUrlTextVisibility(int i) {
        this.a.setUrlTextVisibility(i);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getProgressBar() != null) {
            getProgressBar().measure(i, MeasureSpec.makeMeasureSpec(this.f, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.b != null) {
            this.b.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getProgressBar() != null) {
            getProgressBar().layout(0, 0, getWidth(), getProgressBar().getMeasuredHeight());
        }
        if (this.b != null && this.b.getVisibility() == 0) {
            int measuredHeight = (getMeasuredHeight() - this.b.getMeasuredHeight()) / 2;
            this.b.layout(0, measuredHeight, this.b.getMeasuredWidth() + 0, this.b.getMeasuredHeight() + measuredHeight);
        }
    }

    public final float getProgress() {
        if (getProgressBar() != null) {
            return getProgressBar().getProgress();
        }
        return 0.0f;
    }

    public final void setProgress(float f) {
        if (getProgressBar() != null) {
            e progressBar = getProgressBar();
            if (f >= IPictureView.DEFAULT_MIN_SCALE) {
                progressBar.b();
            }
        }
    }

    public final void setShrinkProgress(float f) {
        this.g = f;
        this.a.a(f, this.j, this.k, getBottom());
    }

    public final void setParentHeight(int i) {
        this.k = i;
    }

    public final void onClick(View view) {
        if (this.h != null) {
            if (view == this.a.getMultiWindowBtn()) {
                this.h.a();
            } else if (view == this.a.getMenuBtn()) {
                this.h.c();
            } else if (view == this.a.getStopBtn()) {
                this.h.e();
            } else if (view == this.a.getBackBtn()) {
                this.h.f();
            } else if (view == this.a.getHomeBtn()) {
                this.h.g();
            } else if (view == this.a.getUrlText()) {
                if (this.g == IPictureView.DEFAULT_MIN_SCALE) {
                    this.h.h();
                } else {
                    this.h.d();
                }
            } else if (view == this && this.g == IPictureView.DEFAULT_MIN_SCALE) {
                this.h.h();
            }
        }
    }

    public final boolean onLongClick(View view) {
        if (this.h == null || view != this.a.getMultiWindowBtn()) {
            return false;
        }
        this.h.b();
        return true;
    }

    public final String getUrl() {
        return this.a.getUrlText().getText().toString();
    }

    public final void a(int i) {
        this.a.a(i);
    }

    public final void a(String str) {
        this.a.getUrlText().setText(str);
    }

    public final void a(boolean z) {
        this.d = z;
        this.a.a(z);
    }

    public final boolean a() {
        return this.g == IPictureView.DEFAULT_MIN_SCALE;
    }

    public final void b() {
        this.a.c();
    }

    public final void c() {
        int c = a.c((int) R.dimen.multi_window_icon_jump_dist);
        int round = Math.round(getTranslationY());
        new i(round, round - c, new j(this)).a();
    }

    public final void setPresenter(b bVar) {
        c.a((Object) bVar);
        c.b(bVar instanceof a);
        this.h = (a) bVar;
    }

    public final e getProgressBar() {
        return this.e;
    }

    public final void setProgressListener(com.ucpro.ui.widget.b.b bVar) {
        this.e.setProgressListener(bVar);
    }

    public final void e() {
        if (this.c == 0) {
            this.a = new b(getContext());
        } else {
            this.a = new c(getContext());
        }
        this.b = this.a.getContentView();
        addView(this.b);
        this.a.a(this, this);
    }
}
