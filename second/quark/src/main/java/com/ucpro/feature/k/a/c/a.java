package com.ucpro.feature.k.a.c;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.system.b;
import com.ucpro.feature.x.e;
import com.ucpro.ui.widget.RoundRectView;

/* compiled from: ProGuard */
public final class a extends ViewGroup {
    RoundRectView a;
    int b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private float k;

    public a(Context context) {
        super(context);
        this.k = IPictureView.DEFAULT_MIN_SCALE;
        this.k = ((float) (b.a.d() - com.ucpro.ui.c.a.c((int) R.dimen.quark_lab_wallpaper_preview_empty_height))) / ((float) b.a.d());
        this.f = (int) (((float) com.ucpro.ui.c.a.c((int) R.dimen.homepage_baseline_offset_y)) * this.k);
        this.g = (int) (((float) com.ucpro.ui.c.a.c((int) R.dimen.homepage_searchbar_height)) * this.k);
        this.h = (int) (((float) com.ucpro.ui.c.a.c((int) R.dimen.homepage_logo_margin_bottom)) * this.k);
        this.i = (int) (((float) com.ucpro.ui.c.a.c((int) R.dimen.homepage_searchbar_margin_baseline)) * this.k);
        this.j = (int) (((float) com.ucpro.ui.c.a.c((int) R.dimen.homepage_searchbar_marginx)) * this.k);
        this.a = new RoundRectView(getContext());
        this.a.setBorderRadius(com.ucpro.ui.c.a.c((int) R.dimen.multi_window_cardview2_corner_radius));
        addView(this.a);
        this.c = new ImageView(getContext());
        addView(this.c);
        this.d = new ImageView(getContext());
        addView(this.d);
        this.e = new ImageView(getContext());
        addView(this.e);
        a();
    }

    public final void a() {
        this.c.setImageDrawable(com.ucpro.ui.c.a.b("home_logo.svg"));
        this.e.setImageDrawable(com.ucpro.ui.c.a.a("wallpaper_fake_toolbar.svg"));
        if (e.a(this.b)) {
            this.d.setBackgroundDrawable(com.ucpro.ui.c.a.a("wallpaper_preview_searchbar_dark.xml"));
            this.c.setColorFilter(-11184811);
            this.e.setColorFilter(-11184811);
            return;
        }
        this.d.setBackgroundDrawable(com.ucpro.ui.c.a.a("wallpaper_preview_searchbar.xml"));
        this.c.setColorFilter(-1);
        this.e.setColorFilter(-1);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float c = ((float) b.a.c()) / ((float) b.a.d());
        int measuredHeight = getMeasuredHeight();
        setMeasuredDimension((int) (c * ((float) measuredHeight)), measuredHeight);
        if (this.a != null) {
            this.a.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.c != null) {
            this.c.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (this.d != null) {
            this.d.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth() - (this.j * 2), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.g, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.e != null) {
            this.e.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.a != null) {
            this.a.layout(0, 0, this.a.getMeasuredWidth() + 0, this.a.getMeasuredHeight() + 0);
        }
        if (this.d != null) {
            int width = (getWidth() - this.d.getMeasuredWidth()) / 2;
            int baseLineY = getBaseLineY() + this.i;
            int measuredHeight = baseLineY - this.d.getMeasuredHeight();
            this.d.layout(width, measuredHeight, this.d.getMeasuredWidth() + width, baseLineY);
        }
        if (!(this.c == null || this.d == null)) {
            width = (getWidth() - this.c.getMeasuredWidth()) / 2;
            baseLineY = this.d.getTop() - this.h;
            measuredHeight = baseLineY - this.c.getMeasuredHeight();
            this.c.layout(width, measuredHeight, this.c.getMeasuredWidth() + width, baseLineY);
        }
        if (this.e != null) {
            width = this.e.getMeasuredWidth() + 0;
            int measuredHeight2 = getMeasuredHeight();
            this.e.layout(0, measuredHeight2 - this.e.getMeasuredHeight(), width, measuredHeight2);
        }
    }

    private int getBaseLineY() {
        return (getHeight() / 2) + this.f;
    }

    public final void setLogoVisibility(int i) {
        this.c.setVisibility(i);
    }
}
