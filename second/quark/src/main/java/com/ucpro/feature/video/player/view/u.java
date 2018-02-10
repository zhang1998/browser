package com.ucpro.feature.video.player.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.video.player.a.d;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.a.j;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

@SuppressLint({"ViewConstructor"})
/* compiled from: ProGuard */
public final class u extends LinearLayout {
    public d a = null;
    public j b = null;
    private LinearLayout c;
    private ImageView d;
    private TextView e;
    private aj f;
    private ag g;
    private TextView h;
    private g i;
    private OnClickListener j = new g(this);

    public u(Context context, g gVar) {
        super(context);
        this.i = gVar;
        int a = (int) a.a((int) R.dimen.player_back_img_size);
        int a2 = (int) a.a((int) R.dimen.player_back_image_left_margin);
        int a3 = (int) a.a((int) R.dimen.player_back_image_right_margin);
        int a4 = (int) a.a((int) R.dimen.player_top_bar_title_right_margin);
        int a5 = (int) a.a((int) R.dimen.player_top_bar_net_right_margin);
        int a6 = (int) a.a((int) R.dimen.player_top_bar_battery_right_margin);
        int a7 = (int) a.a((int) R.dimen.player_top_bar_time_right_margin);
        int a8 = (int) a.a((int) R.dimen.player_top_bar_label_size);
        setId(20);
        setOrientation(0);
        setBackgroundDrawable(a.a("new_video_full_top_bar_bg.xml"));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) a.a((int) R.dimen.player_bottom_bar_inner_height));
        layoutParams.gravity = 48;
        this.c = new LinearLayout(getContext());
        this.c.setOrientation(0);
        this.c.setGravity(16);
        addView(this.c, layoutParams);
        Drawable a9 = a.a("new_video_top_bar_back.svg");
        this.d = new ImageView(context);
        this.d.setImageDrawable(a9);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a, a);
        layoutParams2.setMargins(a2, 0, a3, 0);
        this.d.setId(31);
        this.d.setOnClickListener(this.j);
        this.c.addView(this.d, layoutParams2);
        a = (int) a.a((int) R.dimen.player_top_title_menu_text_size);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, a4, 0);
        layoutParams3.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.e = new TextView(context);
        this.e.setTextSize(0, (float) a);
        this.e.setTextColor(a.c("player_label_text_color"));
        this.e.setSingleLine();
        this.e.setEllipsize(TruncateAt.MARQUEE);
        this.e.setMarqueeRepeatLimit(6);
        this.e.setFocusable(true);
        this.e.setFocusableInTouchMode(true);
        this.c.addView(this.e, layoutParams3);
        this.f = new aj(context);
        LayoutParams layoutParams4 = new LinearLayout.LayoutParams(a8, a8);
        layoutParams4.setMargins(0, 0, a5, 0);
        this.c.addView(this.f, layoutParams4);
        this.g = new ag(context);
        layoutParams4 = new LinearLayout.LayoutParams(a8, a8);
        layoutParams4.setMargins(0, 0, a6, 0);
        this.c.addView(this.g, layoutParams4);
        this.h = new TextView(context);
        this.h.setTextColor(a.c("player_label_text_color"));
        this.h.setGravity(17);
        this.h.setSingleLine();
        layoutParams4 = new LinearLayout.LayoutParams(-2, a8);
        layoutParams4.setMargins(0, 0, a7, 0);
        this.c.addView(this.h, layoutParams4);
    }

    public final void setTitle(CharSequence charSequence) {
        this.e.setText(charSequence);
    }

    public final void setTime(CharSequence charSequence) {
        this.h.setText(charSequence);
    }

    public final void setNetworkType$2ea18d7c(int i) {
        this.f.setNetworkType$2ea18d7c(i);
    }

    public final void setBatteryStatus$1bf19a6c(int i) {
        this.g.setLevel$1bf19a6c(i);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            a();
        }
    }

    private void a() {
        this.e.requestFocus();
    }

    public final void setSupportLittleWindow(boolean z) {
    }
}
