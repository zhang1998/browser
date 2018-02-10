package com.ucpro.feature.l.c;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class d extends FrameLayout implements OnClickListener {
    private FrameLayout a;
    private View b;
    private View c;

    public d(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = new FrameLayout(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(a.c((int) R.dimen.dicover_page_close_container_width), -1);
        layoutParams.gravity = 17;
        addView(this.a, layoutParams);
        this.a.setOnClickListener(this);
        layoutParams = new FrameLayout.LayoutParams(a.c((int) R.dimen.dicover_page_close_btn_width), a.c((int) R.dimen.dicover_page_close_btn_width));
        layoutParams.gravity = 17;
        this.b = new View(getContext());
        this.a.addView(this.b, layoutParams);
        this.b.setBackgroundDrawable(a.a("home_toolbar_discovery.svg"));
        this.c = new View(getContext());
        this.a.addView(this.c, layoutParams);
        this.c.setBackgroundDrawable(a.a("discover_close.svg"));
        this.c.setAlpha(0.0f);
    }

    public final void a(float f) {
        int i = (int) (180.0f * f);
        this.b.setRotation((float) i);
        this.c.setRotation((float) (i + 180));
        this.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE - f);
        this.c.setAlpha(f);
        this.b.setScaleX(((IPictureView.DEFAULT_MIN_SCALE - f) * 0.5f) + 0.5f);
        this.b.setScaleY(((IPictureView.DEFAULT_MIN_SCALE - f) * 0.5f) + 0.5f);
    }

    public final void onClick(View view) {
        g.a().b(e.cT);
    }
}
