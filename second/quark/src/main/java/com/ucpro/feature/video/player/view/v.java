package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.uc.webview.export.utility.Utils;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.b.f;
import com.ucpro.feature.video.player.b.h;
import com.ucpro.feature.video.player.e;
import com.ucpro.feature.video.player.e.a;
import com.ucpro.feature.video.player.p;
import com.ucpro.feature.video.player.q;
import com.ucpro.feature.video.player.s;
import java.text.NumberFormat;
import java.util.List;

/* compiled from: ProGuard */
public final class v extends q<Boolean> implements p, s {
    public FrameLayout a = new FrameLayout(this.q);
    public f b = f.MiniScreen;
    private an c;
    private BaseHintView d;
    private final int e = 1;

    public v(Context context, g gVar, a aVar) {
        boolean z = true;
        super(context, gVar, aVar);
        this.a.setId(4);
        Context context2 = this.q;
        if (this.b != f.FullScreen) {
            z = false;
        }
        this.c = new an(context2, z);
        this.c.setVisibility(8);
        this.a.addView(this.c);
        this.d = new BaseHintView(this.q);
        this.a.addView(this.d);
        b();
        this.r.f().a((p) this);
        e f = this.r.f();
        if (!f.s.contains(this)) {
            f.s.add(this);
        }
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

    public final void b() {
        if (this.b == f.FullScreen) {
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_play_btn_size);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_img_size);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_margin);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_img_right_margin);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_text_szie);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_text_width);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_height);
        } else {
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_play_btn_size_mini);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_img_size_mini);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_margin_mini);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_img_right_margin);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_text_szie_mini);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_text_width_mini);
            com.ucpro.ui.c.a.a((int) R.dimen.player_center_hint_height_mini);
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.c.setLayoutParams(layoutParams);
        this.d.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public final void a(boolean z, boolean z2, int i, int i2) {
        if (!z || z2) {
            CharSequence d;
            a(this.c);
            if (i <= 1) {
                i = 1;
            }
            an anVar = this.c;
            String valueOf = String.valueOf(i);
            String str = "%";
            if (!anVar.b) {
                t tVar = anVar.a;
                tVar.c = 0.7f;
                tVar.b.setTextSize(tVar.a.getTextSize() * 0.7f);
                tVar.d = valueOf;
                tVar.e = str;
            }
            String str2 = "";
            if (!z) {
                d = com.ucpro.ui.c.a.d((int) R.string.player_video_is_preparing);
            } else if (i2 < 0) {
                Object obj = str2;
            } else if (1024 > i2) {
                d = i2 + "B/s";
            } else if (1048576 > i2) {
                r1 = NumberFormat.getNumberInstance();
                r1.setMaximumFractionDigits(1);
                d = r1.format((double) (((float) i2) / 1024.0f)) + "KB/s";
            } else {
                r1 = NumberFormat.getNumberInstance();
                r1.setMaximumFractionDigits(1);
                d = r1.format((double) (((float) i2) / 1048576.0f)) + "MB/s";
            }
            this.c.setBottomText(d);
            return;
        }
        b(this.c);
        c();
    }

    public final void a(boolean z, boolean z2, boolean z3, int i, int i2, boolean z4) {
        if (i > 0 && z4) {
            if (z2) {
                Drawable a;
                a(this.d);
                if (z3) {
                    a = com.ucpro.ui.c.a.a("new_video_time_forward.svg");
                } else {
                    a = com.ucpro.ui.c.a.a("new_video_time_back.svg");
                }
                this.d.setImage(a);
                this.d.setText(Utils.timeFormat(i2));
                return;
            }
            c();
        }
    }

    public final void c() {
        super.c();
        b(this.d);
    }

    private void a(View view) {
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.a.getChildAt(i);
            childAt.setVisibility(view == childAt ? 0 : 8);
        }
    }

    private static void b(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
