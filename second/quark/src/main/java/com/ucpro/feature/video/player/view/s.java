package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.utility.Utils;
import com.ucpro.feature.video.player.a;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.a.d;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.a.j;
import com.ucpro.feature.video.player.b.h;
import com.ucpro.feature.video.player.p;
import com.ucpro.feature.video.player.q;
import java.util.List;

/* compiled from: ProGuard */
public final class s extends q<Boolean> implements a, p {
    public FrameLayout a;
    b b;
    public d c = null;
    public j d = null;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private OnClickListener i;
    private n j;
    private int k = 0;

    public s(Context context, g gVar, com.ucpro.feature.video.player.e.a aVar, int i) {
        super(context, gVar, aVar);
        this.k = i;
        com.ucpro.ui.c.a.a((int) R.dimen.player_bottom_img_margin_mini);
        com.ucpro.ui.c.a.a((int) R.dimen.player_bottom_img_margin_mini);
        this.a = new FrameLayout(this.q);
        this.a.setBackgroundDrawable(com.ucpro.ui.c.a.a("new_video_full_bottom_bar_bg.xml"));
        this.a.setOnClickListener(null);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.ucpro.ui.c.a.a((int) R.dimen.player_bottom_bar_inner_height));
        layoutParams.gravity = 80;
        this.e = new LinearLayout(this.q);
        this.e.setOrientation(0);
        this.e.setGravity(16);
        this.a.addView(this.e, layoutParams);
        float a = com.ucpro.ui.c.a.a((int) R.dimen.player_bottom_text_size_mini);
        this.f = new TextView(this.q);
        int c = com.ucpro.ui.c.a.c((int) R.dimen.player_bottom_left_time_left_margin);
        int c2 = com.ucpro.ui.c.a.c((int) R.dimen.media_quality_menu_text_left_or_right_margin);
        this.f.setTextSize(0, a);
        this.f.setTextColor(com.ucpro.ui.c.a.c("player_label_text_color"));
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = c2;
        layoutParams2.rightMargin = c;
        this.e.addView(this.f, layoutParams2);
        this.b = new b(this.q, false);
        this.b.setMax(1000);
        this.b.setProgress(0);
        this.b.setEnabled(false);
        this.b.setBarChangeListener(this.j);
        layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.e.addView(this.b, layoutParams2);
        this.g = new TextView(this.q);
        this.g.setTextSize(0, a);
        this.g.setTextColor(com.ucpro.ui.c.a.c("player_label_text_color"));
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        layoutParams3.leftMargin = c2;
        layoutParams3.rightMargin = c;
        this.e.addView(this.g, layoutParams3);
        if (this.k == 2) {
            this.h = new ImageView(this.q);
            this.h.setId(13);
            this.h.setOnClickListener(this.i);
            this.h.setPadding(0, 0, c2 * 2, 0);
            this.h.setImageDrawable(com.ucpro.ui.c.a.a("new_video_enter_fullscreen.svg"));
            this.e.addView(this.h, new LinearLayout.LayoutParams(-2, -1));
        }
        this.r.f().a((p) this);
        this.r.f().a((a) this);
    }

    public final boolean a(int i, b bVar, b bVar2) {
        return false;
    }

    public final boolean b(int i, b bVar, b bVar2) {
        return false;
    }

    protected final void a(List<Class<?>> list) {
    }

    protected final void a(h<Boolean> hVar) {
    }

    protected final void a() {
        this.i = new ar(this);
        this.j = new m(this);
    }

    public final void a(boolean z, boolean z2, boolean z3, int i, int i2, boolean z4) {
        if (!z) {
            this.b.setProgress(0);
            this.f.setVisibility(4);
            this.g.setVisibility(4);
        } else if (i > 0) {
            if (!z2) {
                int i3 = (int) ((((float) i2) / ((float) i)) * 1000.0f);
                if (i3 != this.b.getProgress()) {
                    this.b.setProgress(i3);
                }
            }
            this.f.setVisibility(0);
            this.f.setText(Utils.timeFormat(i2));
            this.g.setVisibility(0);
            this.g.setText(Utils.timeFormat(i));
        }
    }

    public final void a(boolean z) {
        this.b.setEnabled(z);
    }
}
