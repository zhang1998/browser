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
import com.ucpro.feature.video.player.b.r;
import com.ucpro.feature.video.player.b.y;
import com.ucpro.feature.video.player.e;
import com.ucpro.feature.video.player.f;
import com.ucpro.feature.video.player.p;
import com.ucpro.feature.video.player.q;
import com.ucweb.common.util.c;
import java.util.List;

/* compiled from: ProGuard */
public final class au extends q<Boolean> implements a, f, p {
    public FrameLayout a;
    b b;
    ImageView c;
    public ImageView d;
    public d e = null;
    public j f = null;
    private LinearLayout g;
    private TextView h;
    private TextView i;
    private ImageView j;
    private OnClickListener k;
    private n l;

    public au(Context context, g gVar, com.ucpro.feature.video.player.e.a aVar) {
        super(context, gVar, aVar);
        com.ucpro.ui.c.a.a((int) R.dimen.player_bottom_img_label_size);
        com.ucpro.ui.c.a.a((int) R.dimen.player_bottom_img_label_margin);
        this.a = new FrameLayout(this.q);
        this.a.setId(22);
        this.a.setBackgroundDrawable(com.ucpro.ui.c.a.a("new_video_full_bottom_bar_bg.xml"));
        this.a.setOnClickListener(null);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.ucpro.ui.c.a.a((int) R.dimen.player_bottom_bar_inner_height));
        layoutParams.gravity = 80;
        this.g = new LinearLayout(this.q);
        this.g.setOrientation(0);
        this.g.setGravity(16);
        this.a.addView(this.g, layoutParams);
        float a = com.ucpro.ui.c.a.a((int) R.dimen.player_bottom_bar_time_size);
        this.h = new TextView(this.q);
        int c = com.ucpro.ui.c.a.c((int) R.dimen.player_bottom_left_time_left_margin);
        this.h.setTextSize(0, a);
        this.h.setTextColor(com.ucpro.ui.c.a.c("player_label_text_color"));
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = c;
        layoutParams2.rightMargin = c;
        this.g.addView(this.h, layoutParams2);
        this.b = new b(this.q);
        this.b.setMax(1000);
        this.b.setProgress(0);
        this.b.setEnabled(false);
        this.b.setBarChangeListener(this.l);
        layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.g.addView(this.b, layoutParams2);
        int c2 = com.ucpro.ui.c.a.c((int) R.dimen.media_quality_menu_text_left_or_right_margin);
        this.i = new TextView(this.q);
        this.i.setTextSize(0, a);
        this.i.setTextColor(com.ucpro.ui.c.a.c("player_label_text_color"));
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        layoutParams3.leftMargin = c;
        layoutParams3.rightMargin = c2;
        this.g.addView(this.i, layoutParams3);
        this.c = new ImageView(this.q);
        this.c.setId(27);
        this.c.setVisibility(8);
        this.c.setOnClickListener(this.k);
        this.c.setPadding(c2, 0, c2, 0);
        this.g.addView(this.c, new LinearLayout.LayoutParams(-2, -1));
        this.j = new ImageView(this.q);
        this.j.setId(29);
        this.j.setOnClickListener(this.k);
        this.j.setPadding(c2, 0, c2, 0);
        this.j.setImageDrawable(com.ucpro.ui.c.a.a("new_video_exit_fullscreen.svg"));
        this.g.addView(this.j, new LinearLayout.LayoutParams(-2, -1));
        this.d = new ImageView(this.q);
        this.d.setId(43);
        this.d.setOnClickListener(this.k);
        this.d.setPadding(c2, 0, c, 0);
        this.d.setImageDrawable(com.ucpro.ui.c.a.a("new_video_exit_more.svg"));
        this.g.addView(this.d, new LinearLayout.LayoutParams(-2, -1));
        this.r.f().a((p) this);
        this.r.f().a((a) this);
        e f = this.r.f();
        if (!f.u.contains(this)) {
            f.u.add(this);
        }
    }

    public final boolean a(int i, b bVar, b bVar2) {
        return false;
    }

    public final boolean b(int i, b bVar, b bVar2) {
        return false;
    }

    protected final void a(List<Class<?>> list) {
        list.add(r.class);
        list.add(y.class);
    }

    protected final void a(h<Boolean> hVar) {
        hVar.a(25).b(r.Playing.e, y.f).a(Boolean.valueOf(true)).b(r.Playing.e ^ -1, y.f).a(Boolean.valueOf(false)).a(27).b(r.f, y.RequestSuccess.e).a(Boolean.valueOf(true)).b(r.f, y.RequestFail.e).a(Boolean.valueOf(true)).b(r.f, y.Requesting.e).a(Boolean.valueOf(false)).b(r.f, y.Idle.e).a(Boolean.valueOf(false));
        hVar.a(new ae(this));
    }

    final void b() {
        e f = this.r.f();
        if (this.c.getTag() != null && (this.c.getTag() instanceof Boolean)) {
            if (!((Boolean) this.c.getTag()).booleanValue()) {
                this.c.setVisibility(8);
            } else if (f != null && com.ucpro.feature.video.p.a(f.w, false) != null && f.g > 0) {
                String str = f.w;
                boolean z = true;
                switch (str.hashCode()) {
                    case -1039745817:
                        if (str.equals("normal")) {
                            z = false;
                            break;
                        }
                        break;
                    case 3202466:
                        if (str.equals("high")) {
                            z = true;
                            break;
                        }
                        break;
                    case 109801339:
                        if (str.equals("super")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        this.c.setImageDrawable(com.ucpro.ui.c.a.a("new_video_resolution_normal.svg"));
                        break;
                    case true:
                        this.c.setImageDrawable(com.ucpro.ui.c.a.a("new_video_resolution_high.svg"));
                        break;
                    case true:
                        this.c.setImageDrawable(com.ucpro.ui.c.a.a("new_video_resolution_super.svg"));
                        break;
                }
                this.c.setVisibility(0);
            }
        }
    }

    protected final void a() {
        this.k = new ao(this);
        this.l = new ai(this);
    }

    public final void a(boolean z, boolean z2, boolean z3, int i, int i2, boolean z4) {
        if (!z) {
            this.b.setProgress(0);
            this.h.setVisibility(4);
            this.i.setVisibility(4);
        } else if (i > 0) {
            if (i2 > Integer.MAX_VALUE) {
                i2 = Integer.MAX_VALUE;
            }
            if (i > Integer.MAX_VALUE) {
                i = Integer.MAX_VALUE;
            }
            if (!z2) {
                int i3 = (int) ((((float) i2) / ((float) i)) * 1000.0f);
                if (i3 != this.b.getProgress()) {
                    this.b.setProgress(i3);
                }
            }
            this.h.setVisibility(0);
            this.h.setText(Utils.timeFormat(i2));
            this.i.setVisibility(0);
            this.i.setText(Utils.timeFormat(i));
        }
    }

    public final void a(boolean z) {
        this.b.setEnabled(z);
        b();
    }

    public final void y_() {
        Object f = this.r.f();
        c.a(f);
        c.a(f.w);
        c.a(com.ucpro.feature.video.p.a(f.w, false));
        b();
    }
}
