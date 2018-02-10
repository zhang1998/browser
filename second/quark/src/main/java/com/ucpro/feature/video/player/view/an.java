package com.ucpro.feature.video.player.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

@SuppressLint({"ViewConstructor"})
/* compiled from: ProGuard */
public final class an extends LinearLayout {
    t a;
    boolean b = false;
    private TextView c;
    private LinearLayout d;
    private TextView e;
    private boolean f;

    public an(Context context, boolean z) {
        int a;
        float a2;
        super(context);
        this.f = z;
        setOrientation(1);
        float a3 = a.a((int) R.dimen.player_loading_text_size);
        int a4 = (int) a.a((int) R.dimen.player_loading_bottom_height);
        if (this.f) {
            a = (int) a.a((int) R.dimen.player_loading_size);
            a2 = a.a((int) R.dimen.player_loading_percent_size);
        } else {
            a = (int) a.a((int) R.dimen.player_loading_size_mini);
            a2 = a.a((int) R.dimen.player_loading_percent_size_mini);
        }
        LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
        layoutParams.gravity = 17;
        this.a = new t(context);
        this.a.setTextSize(a2);
        this.a.setTextColor(a.c("player_label_text_color"));
        addView(this.a, layoutParams);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, a4);
        layoutParams2.gravity = 17;
        this.c = new TextView(context);
        this.c.setTextSize(0, a3);
        this.c.setTextColor(a.c("player_label_text_color"));
        addView(this.c, layoutParams2);
        a = (int) a.a((int) R.dimen.player_view_play_slow_tips_margin);
        this.d = new LinearLayout(context);
        this.d.setBackgroundDrawable(a.a("play_slow_tips_background_selector.xml"));
        this.d.setPadding(a, 0, a, 0);
        this.d.setGravity(17);
        this.e = new TextView(context);
        this.e.setGravity(16);
        this.e.setTextColor(a.c("play_slow_tips_text_color"));
        this.e.setTextSize(0, a3);
        LinearLayout linearLayout = this.d;
        View view = this.e;
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.gravity = 16;
        linearLayout.addView(view, layoutParams3);
        addView(this.d, layoutParams2);
        this.d.setVisibility(8);
    }

    public final void setLoadingText(String str) {
        if (!this.b) {
            this.a.setText(str);
        }
    }

    public final void setBottomText(CharSequence charSequence) {
        if (!this.b) {
            this.c.setText(charSequence);
            this.c.setVisibility(0);
            this.d.setVisibility(8);
        }
    }
}
