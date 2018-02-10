package com.ucpro.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucweb.common.util.p.b;

/* compiled from: ProGuard */
public final class f implements OnClickListener {
    public View a = LayoutInflater.from(this.h).inflate(R.layout.toolbar, null, false);
    public ATTextView b = ((ATTextView) this.a.findViewById(R.id.tv_title));
    public ImageView c;
    public AnimateImageView d;
    public FrameLayout e = ((FrameLayout) this.a.findViewById(R.id.fl_title_contain));
    public af f = this;
    public w g;
    private Context h;
    private ATTextView i;
    private ATTextView j;
    private FrameLayout k;
    private FrameLayout l;
    private View m;
    private ad n;

    public f(Context context) {
        this.h = context;
        this.b.getPaint().setFakeBoldText(true);
        this.b.setTypeface(null, 1);
        this.c = (ImageView) this.a.findViewById(R.id.iv_left);
        this.c.setTag(R.id.ui_auto, b.e);
        this.d = (AnimateImageView) this.a.findViewById(R.id.iv_right);
        this.i = (ATTextView) this.a.findViewById(R.id.tv_left);
        this.j = (ATTextView) this.a.findViewById(R.id.tv_right);
        this.k = (FrameLayout) this.a.findViewById(R.id.rl_title_left);
        this.l = (FrameLayout) this.a.findViewById(R.id.rl_title_right);
        this.m = this.a.findViewById(R.id.title_line);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        b();
    }

    public final void a(Drawable drawable) {
        this.c.setImageDrawable(drawable);
    }

    public final void a(Drawable drawable, ad adVar) {
        if (adVar != null) {
            this.n = adVar;
        }
        this.c.setImageDrawable(drawable);
    }

    public final void b(Drawable drawable) {
        this.d.setImageDrawable(drawable);
    }

    public final void a(Drawable drawable, w wVar) {
        if (wVar != null) {
            this.g = wVar;
        }
        this.d.setImageDrawable(drawable);
    }

    public final void a(Drawable drawable, boolean z) {
        this.d.a(drawable, z);
    }

    public final void a(String str) {
        this.b.setText(str);
    }

    public final void a(boolean z) {
        this.l.setClickable(z);
    }

    public final void a() {
        this.m.setVisibility(8);
    }

    public final void onClick(View view) {
        if (this.f != null) {
            int id = view.getId();
            if (id == R.id.rl_title_left) {
                this.f.a(this, view, this.n);
            } else if (id == R.id.rl_title_right) {
                this.f.a(this, view, this.g);
            }
        }
    }

    public final void b() {
        this.k.setBackgroundDrawable(a.c());
        this.l.setBackgroundDrawable(a.c());
        this.a.setBackgroundColor(a.c("default_background_white"));
        this.m.setBackgroundColor(a.c("title_bar_line_color"));
        this.b.setTextColor(a.c("default_maintext_gray"));
    }
}
