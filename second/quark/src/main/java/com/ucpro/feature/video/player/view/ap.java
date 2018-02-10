package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.video.player.a.d;
import com.ucpro.feature.video.player.a.j;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public final class ap extends LinearLayout {
    public d a = null;
    public j b = null;
    private LinearLayout c;
    private aj d;
    private ag e;
    private TextView f;

    public ap(Context context) {
        super(context);
        a.a((int) R.dimen.player_back_img_size);
        a.a((int) R.dimen.player_back_image_left_margin);
        a.a((int) R.dimen.player_back_image_right_margin);
        a.a((int) R.dimen.player_top_bar_title_right_margin);
        int a = (int) a.a((int) R.dimen.player_top_bar_net_right_margin);
        int a2 = (int) a.a((int) R.dimen.player_top_bar_battery_right_margin);
        int a3 = (int) a.a((int) R.dimen.player_top_bar_time_right_margin);
        int a4 = (int) a.a((int) R.dimen.player_top_bar_label_size);
        setId(20);
        setOrientation(0);
        setBackgroundDrawable(a.a("new_video_full_top_bar_bg.xml"));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) a.a((int) R.dimen.player_bottom_bar_inner_height));
        layoutParams.gravity = 48;
        this.c = new LinearLayout(getContext());
        this.c.setOrientation(0);
        this.c.setGravity(16);
        addView(this.c, layoutParams);
        View view = new View(context);
        layoutParams = new LinearLayout.LayoutParams(0, 1);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.c.addView(view, layoutParams);
        this.d = new aj(context);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a4, a4);
        layoutParams2.setMargins(0, 0, a, 0);
        this.c.addView(this.d, layoutParams2);
        this.e = new ag(context);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(a4, a4);
        layoutParams3.setMargins(0, 0, a2, 0);
        this.c.addView(this.e, layoutParams3);
        this.f = new TextView(context);
        this.f.setTextColor(a.c("player_label_text_color"));
        this.f.setGravity(17);
        this.f.setSingleLine();
        layoutParams3 = new LinearLayout.LayoutParams(-2, a4);
        layoutParams3.setMargins(0, 0, a3, 0);
        this.c.addView(this.f, layoutParams3);
    }

    public final void setTime(CharSequence charSequence) {
        this.f.setText(charSequence);
    }

    public final void setNetworkType$2ea18d7c(int i) {
        this.d.setNetworkType$2ea18d7c(i);
    }

    public final void setBatteryStatus$1bf19a6c(int i) {
        this.e.setLevel$1bf19a6c(i);
    }
}
