package com.ucpro.feature.privacymode.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public class t extends FrameLayout {
    private ImageView a = new ImageView(getContext());
    public FrameLayout b = new FrameLayout(getContext());
    private int c = a.c((int) R.dimen.privacymode_close_icon_size);
    private int d = a.c((int) R.dimen.privacymode_close_icon_margintop);
    private b e;
    private h f;

    public t(@NonNull Context context) {
        super(context);
        this.a.setImageDrawable(a.a("privacy_mode_password_close.svg"));
        int c = a.c((int) R.dimen.privacymode_close_icon_real_size);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(c, c);
        layoutParams.gravity = 17;
        this.b.addView(this.a, layoutParams);
        this.b.setOnClickListener(new o(this));
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.c, this.c);
        layoutParams2.topMargin = this.d;
        addView(this.b, layoutParams2);
        this.b.setVisibility(4);
        this.e = new i(this, getContext());
        layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 49;
        layoutParams2.topMargin = this.c * 2;
        addView(this.e, layoutParams2);
    }

    public void setTitle(String str) {
        this.e.setTitle(str);
    }

    public void setPassWordType$1e30636a(int i) {
        if (i == p.b || i == p.c) {
            this.b.setVisibility(0);
        }
        this.e.setPassWordType$1e30636a(i);
    }

    public boolean a(String str) {
        return false;
    }

    public final void a() {
        this.e.a();
    }

    public void setOnPassWord(h hVar) {
        this.f = hVar;
    }
}
