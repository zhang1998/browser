package com.ucpro.feature.webwindow.n;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.ui.a;

/* compiled from: ProGuard */
public final class b extends RelativeLayout implements OnClickListener {
    public Interpolator a = new LinearInterpolator();
    public Runnable b = new c(this);
    private final d c;
    private final a d;
    private final String e;
    private final int f;
    private TextView g;
    private ImageView h;

    public b(Context context, String str, a aVar, d dVar) {
        super(context);
        this.e = str;
        this.c = dVar;
        this.d = aVar;
        this.f = com.ucpro.ui.c.a.c((int) R.dimen.webwindow_banner_height);
        setOnClickListener(this);
        this.h = new ImageView(getContext());
        this.h.setOnClickListener(this);
        int c = com.ucpro.ui.c.a.c((int) R.dimen.webwindow_banner_padding_x);
        this.h.setPadding(c, 0, c, 0);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        this.h.setId(R.id.webwindow_banner_close_button);
        addView(this.h, layoutParams);
        this.g = new TextView(getContext());
        this.g.setText(this.e);
        this.g.setTextSize(0, com.ucpro.ui.c.a.a((int) R.dimen.webwindow_banner_textsize));
        this.g.setPadding(c, 0, c, 0);
        this.g.setGravity(16);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f);
        layoutParams2.addRule(0, R.id.webwindow_banner_close_button);
        addView(this.g, layoutParams2);
        setBackgroundColor(com.ucpro.ui.c.a.c("webwindow_banner_bg_color"));
        this.g.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.h.setImageDrawable(com.ucpro.ui.c.a.a("home_nav_list_added.svg"));
    }

    public final void onClick(View view) {
        if (view == this) {
            removeCallbacks(this.b);
            a(false);
        } else if (view == this.h) {
            a();
        }
    }

    public final void a() {
        removeCallbacks(this.b);
        a(true);
    }

    private void a(boolean z) {
        animate().cancel();
        animate().alpha(0.0f).setDuration(200).setInterpolator(this.a).setListener(new a(this, z)).start();
    }
}
