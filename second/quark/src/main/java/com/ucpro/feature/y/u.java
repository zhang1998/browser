package com.ucpro.feature.y;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class u extends ViewGroup {
    public LottieAnimationView a;
    private ImageView b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public u(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = a.c((int) R.dimen.homepage_baseline_offset_y);
        this.f = a.c((int) R.dimen.homepage_searchbar_height);
        this.g = a.c((int) R.dimen.bottom_bar_height);
        this.d = a.c((int) R.dimen.homepage_logo_margin_bottom);
        this.e = a.c((int) R.dimen.homepage_searchbar_margin_baseline);
        this.h = a.c((int) R.dimen.ucwelcome_page_text_margin_bottom);
        this.a = new LottieAnimationView(getContext());
        this.a.setAnimation("lottie/uc_welcome/data.json");
        addView(this.a);
        this.b = new ImageView(getContext());
        addView(this.b);
        setBackgroundColor(-1);
        this.b.setImageDrawable(a.a("ucwelcome_page_text.png"));
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a != null) {
            this.a.measure(MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.ucwelcome_page_logo_width), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.ucwelcome_page_logo_height), UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.b != null) {
            this.b.measure(MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.ucwelcome_page_text_width), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.ucwelcome_page_text_height), UCCore.VERIFY_POLICY_QUICK));
        }
    }

    private int getBaseLineY() {
        return ((getHeight() - this.g) / 2) + this.c;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.a != null) {
            int width = (getWidth() - this.a.getMeasuredWidth()) / 2;
            int baseLineY = ((getBaseLineY() + this.e) - this.f) - this.d;
            int measuredHeight = baseLineY - this.a.getMeasuredHeight();
            this.a.layout(width, measuredHeight, this.a.getMeasuredWidth() + width, baseLineY);
        }
        if (this.b != null) {
            width = (getWidth() - this.b.getMeasuredWidth()) / 2;
            baseLineY = getHeight() - this.h;
            measuredHeight = baseLineY - this.b.getMeasuredHeight();
            this.b.layout(width, measuredHeight, this.b.getMeasuredWidth() + width, baseLineY);
        }
    }
}
