package com.ucpro.feature.webwindow.a;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class f extends ViewGroup implements OnClickListener {
    ImageView a;
    ImageView b;
    private FrameLayout c;
    private d d;

    public f(Context context) {
        super(context);
        this.a = null;
        this.c = null;
        this.b = null;
        this.d = null;
        this.c = new FrameLayout(getContext());
        this.c.setOnClickListener(this);
        addView(this.c);
        this.a = new ImageView(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.c.addView(this.a, layoutParams);
        this.b = new ImageView(getContext());
        this.b.setOnClickListener(this);
        addView(this.b);
        this.a.setImageDrawable(a.a("home_toolbar_discovery.svg"));
        this.b.setImageDrawable(a.a("discover_page_tip_toast.png"));
        setVisibility(8);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth() / 3, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.bottom_bar_height), UCCore.VERIFY_POLICY_QUICK));
        this.b.measure(MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.discover_page_enter_guide_tip_width), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.discover_page_enter_guide_tip_height), UCCore.VERIFY_POLICY_QUICK));
    }

    public final void onClick(View view) {
        if (this.d != null) {
            this.d.a();
        }
    }

    public final void setListener(d dVar) {
        this.d = dVar;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.c != null) {
            int measuredWidth = (getMeasuredWidth() - this.c.getMeasuredWidth()) / 2;
            int measuredWidth2 = this.c.getMeasuredWidth() + measuredWidth;
            int measuredHeight = getMeasuredHeight();
            this.c.layout(measuredWidth, measuredHeight - this.c.getMeasuredHeight(), measuredWidth2, measuredHeight);
        }
        if (this.b != null) {
            measuredWidth = (getMeasuredWidth() - this.b.getMeasuredWidth()) / 2;
            measuredHeight = getMeasuredHeight() - this.c.getMeasuredHeight();
            int measuredHeight2 = measuredHeight - this.b.getMeasuredHeight();
            this.b.layout(measuredWidth, measuredHeight2, this.b.getMeasuredWidth() + measuredWidth, measuredHeight);
        }
    }
}
