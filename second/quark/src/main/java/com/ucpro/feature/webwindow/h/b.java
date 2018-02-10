package com.ucpro.feature.webwindow.h;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.webwindow.ar;
import com.ucpro.ui.animation.i;
import com.ucpro.ui.widget.TextView;
import com.ucpro.ui.widget.a;

/* compiled from: ProGuard */
public final class b extends a implements d {
    private TextView a = null;
    private ar b = null;
    private ar c = null;

    public b(Context context) {
        super(context);
        setMaxItemCount(3);
        this.b = new ar(getContext(), "home_toolbar_multiwindow.svg", "home_toolbar_multiwindow.svg");
        a(this.b, 0);
        this.a = new TextView(getContext());
        this.a.setTextSize(0, (float) com.ucpro.ui.c.a.c((int) R.dimen.search_address_bar_text_size));
        this.a.setSingleLine();
        this.a.setEllipsize(TruncateAt.END);
        this.a.setTypeface(Typeface.defaultFromStyle(1));
        this.a.setClickable(true);
        this.a.setGravity(17);
        a(this.a, 1);
        this.c = new ar(getContext(), "home_toolbar_menu.svg", "home_toolbar_menu.svg");
        this.c.setTag(R.id.ui_auto, com.ucweb.common.util.p.b.b);
        a(this.c, 2);
        a();
    }

    public final void a(OnClickListener onClickListener, OnLongClickListener onLongClickListener) {
        this.b.setOnClickListener(onClickListener);
        this.a.setOnClickListener(onClickListener);
        this.c.setOnClickListener(onClickListener);
        this.b.setOnLongClickListener(onLongClickListener);
    }

    public final int getStackCount() {
        try {
            return Integer.valueOf(this.b.getText()).intValue();
        } catch (Exception e) {
            return 1;
        }
    }

    public final void a(boolean z) {
    }

    public final View getBackBtn() {
        return null;
    }

    public final View getStopBtn() {
        return null;
    }

    public final View getMultiWindowBtn() {
        return this.b;
    }

    public final TextView getUrlText() {
        return this.a;
    }

    public final View getMenuBtn() {
        return this.c;
    }

    public final View getHomeBtn() {
        return null;
    }

    public final View getContentView() {
        return this;
    }

    public final void a() {
        this.a.setTextColor(com.ucpro.ui.c.a.c("search_address_bar_url_edittext_textcolor"));
        this.a.setBackgroundDrawable(com.ucpro.ui.c.a.c());
        this.b.a();
        if (com.ucpro.feature.e.b.a.a) {
            this.c.setIconName("home_toolbar_menu_traceless.svg");
            this.c.setDarkIconName("home_toolbar_menu_traceless.svg");
        } else {
            this.c.setIconName("home_toolbar_menu.svg");
            this.c.setDarkIconName("home_toolbar_menu.svg");
        }
        this.c.a();
    }

    public final void setUrlTextVisibility(int i) {
        this.a.setVisibility(i);
    }

    public final void b() {
        a();
    }

    public final void a(float f, float f2, int i, int i2) {
        int measuredHeight = (int) (((float) (getMeasuredHeight() + 0)) * f);
        this.c.setY((float) measuredHeight);
        this.b.setY((float) measuredHeight);
        float f3 = ((IPictureView.DEFAULT_MIN_SCALE - f2) * (IPictureView.DEFAULT_MIN_SCALE - f)) + f2;
        this.a.setScaleX(f3);
        this.a.setScaleY(f3);
        this.a.setY((float) (((getMeasuredHeight() - (i2 - i)) - this.a.getMeasuredHeight()) / 2));
    }

    public final void a(int i) {
        this.b.a(String.valueOf(i), "home_toolbar_item_text_color", "home_toolbar_item_text_color", com.ucpro.ui.c.a.c((int) R.dimen.home_toolbar_item_text_size));
    }

    public final void c() {
        if (this.b != null) {
            int c = com.ucpro.ui.c.a.c((int) R.dimen.multi_window_icon_jump_dist);
            int round = Math.round(this.b.getTranslationY());
            new i(round, round - c, new k(this)).a();
        }
    }

    public final void a(String str, String str2, String str3) {
        this.c.a(str, str2, str3);
    }

    public final void d() {
        this.c.b();
    }
}
