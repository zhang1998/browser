package com.ucpro.feature.webwindow.h;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.e.b;
import com.ucpro.feature.webwindow.ar;
import com.ucpro.ui.animation.i;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public final class c extends LinearLayout implements d {
    private ar a = null;
    private ar b = null;
    private ar c = null;
    private TextView d = null;
    private ar e = null;
    private ar f = null;
    private ValueAnimator g = null;

    public c(Context context) {
        super(context);
        setOrientation(0);
        View view = new View(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 4.0f;
        addView(view, layoutParams);
        view = new FrameLayout(getContext());
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 14.0f;
        addView(view, layoutParams2);
        LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.a = new ar(getContext(), "discover_close.svg");
        this.a.setVisibility(8);
        view.addView(this.a, layoutParams3);
        this.b = new ar(getContext(), "home_toolbar_back.svg");
        view.addView(this.b, layoutParams3);
        this.e = new ar(getContext(), "home_toolbar_multiwindow.svg", "home_toolbar_multiwindow.svg");
        addView(this.e, layoutParams2);
        this.d = new TextView(getContext());
        this.d.setTextSize(0, (float) a.c((int) R.dimen.search_address_bar_text_size));
        this.d.setSingleLine();
        this.d.setEllipsize(TruncateAt.END);
        this.d.setTypeface(Typeface.defaultFromStyle(1));
        this.d.setClickable(true);
        this.d.setGravity(17);
        int c = a.c((int) R.dimen.five_btn_address_bar_url_padding_left);
        this.d.setPadding(c, 0, c, 0);
        LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1);
        layoutParams4.weight = 36.0f;
        addView(this.d, layoutParams4);
        this.f = new ar(getContext(), "home_toolbar_menu.svg", "home_toolbar_menu.svg");
        addView(this.f, layoutParams2);
        this.c = new ar(getContext(), "home_toolbar_home.svg");
        addView(this.c, layoutParams2);
        addView(new View(getContext()), layoutParams);
        a();
    }

    public final View getBackBtn() {
        return this.b;
    }

    public final View getStopBtn() {
        return this.a;
    }

    public final View getMultiWindowBtn() {
        return this.e;
    }

    public final TextView getUrlText() {
        return this.d;
    }

    public final View getMenuBtn() {
        return this.f;
    }

    public final View getHomeBtn() {
        return this.c;
    }

    public final View getContentView() {
        return this;
    }

    public final void a() {
        this.d.setTextColor(a.c("search_address_bar_url_edittext_textcolor"));
        this.d.setBackgroundDrawable(a.c());
        this.e.a();
        if (b.a.a) {
            this.f.setIconName("home_toolbar_menu_traceless.svg");
            this.f.setDarkIconName("home_toolbar_menu_traceless.svg");
        } else {
            this.f.setIconName("home_toolbar_menu.svg");
            this.f.setDarkIconName("home_toolbar_menu.svg");
        }
        this.f.a();
        this.a.a();
        this.b.a();
        this.c.a();
    }

    public final void setUrlTextVisibility(int i) {
        this.d.setVisibility(i);
    }

    public final void b() {
        a();
    }

    public final void a(float f, float f2, int i, int i2) {
        int measuredHeight = (int) (((float) (getMeasuredHeight() + 0)) * f);
        this.f.setY((float) measuredHeight);
        this.e.setY((float) measuredHeight);
        this.a.setY((float) measuredHeight);
        this.b.setY((float) measuredHeight);
        this.c.setY((float) measuredHeight);
        float f3 = ((IPictureView.DEFAULT_MIN_SCALE - f2) * (IPictureView.DEFAULT_MIN_SCALE - f)) + f2;
        this.d.setScaleX(f3);
        this.d.setScaleY(f3);
        this.d.setY((float) (((getMeasuredHeight() - (i2 - i)) - this.d.getMeasuredHeight()) / 2));
    }

    public final void a(int i) {
        this.e.a(String.valueOf(i), "home_toolbar_item_text_color", "home_toolbar_item_text_color", a.c((int) R.dimen.home_toolbar_item_text_size));
    }

    public final void c() {
        if (this.e != null) {
            int c = a.c((int) R.dimen.multi_window_icon_jump_dist);
            int round = Math.round(this.e.getTranslationY());
            new i(round, round - c, new i(this)).a();
        }
    }

    public final void a(String str, String str2, String str3) {
        this.f.a(str, str2, str3);
    }

    public final void d() {
        this.f.b();
    }

    public final void a(OnClickListener onClickListener, OnLongClickListener onLongClickListener) {
        this.e.setOnClickListener(onClickListener);
        this.d.setOnClickListener(onClickListener);
        this.f.setOnClickListener(onClickListener);
        this.a.setOnClickListener(onClickListener);
        this.b.setOnClickListener(onClickListener);
        this.c.setOnClickListener(onClickListener);
        this.e.setOnLongClickListener(onLongClickListener);
    }

    public final int getStackCount() {
        try {
            return Integer.valueOf(this.e.getText()).intValue();
        } catch (Exception e) {
            return 1;
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.a.setVisibility(0);
            this.b.setVisibility(8);
            return;
        }
        this.a.setVisibility(8);
        this.b.setVisibility(0);
    }
}
