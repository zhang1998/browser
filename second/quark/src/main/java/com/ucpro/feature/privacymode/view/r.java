package com.ucpro.feature.privacymode.view;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class r extends FrameLayout {
    public n a;
    private FrameLayout b = new FrameLayout(getContext());
    private ImageView c = new ImageView(getContext());
    private int d = a.c((int) R.dimen.privacymode_close_icon_size);
    private int e = a.c((int) R.dimen.privacymode_close_icon_margintop);
    private d f;

    public final void setOnPrivacyGuideClick(d dVar) {
        this.f = dVar;
    }

    public r(Context context) {
        super(context);
        this.c.setImageDrawable(a.a("privacy_mode_camera_close.svg"));
        int c = a.c((int) R.dimen.privacymode_close_icon_real_size);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(c, c);
        layoutParams.gravity = 17;
        this.b.addView(this.c, layoutParams);
        this.b.setOnClickListener(new k(this));
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.d, this.d);
        layoutParams2.topMargin = this.e;
        addView(this.b, layoutParams2);
        this.a = new g(this, getContext());
        layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        addView(this.a, layoutParams2);
    }

    public final void a() {
        n nVar = this.a;
        nVar.c.setVisibility(8);
        nVar.b.setVisibility(0);
        nVar.b.setBackgroundDrawable(nVar.d);
        nVar.b.setText(a.d((int) R.string.privacymode_guide_btn_text));
    }

    public final void setProgress(int i) {
        this.a.setProgress(i);
    }

    public final void setProgressWithAnimation(int i) {
        this.a.setProgressWithAnimation(i);
    }

    public final void setProgressDesc(String str) {
        this.a.setProgressDesc(str);
    }
}
