package com.ucpro.feature.inputenhance;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;
import com.ucweb.common.util.h.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class p {
    LinearLayout a;
    d b;
    ArrayList<Animation> c;
    private FrameLayout d;
    private ImageView e;
    private TextView f;
    private ImageView g;
    private LayoutParams h;
    private Context i;
    private boolean j = false;
    private boolean k;
    private boolean l;

    public p(Context context, boolean z, boolean z2, d dVar) {
        this.i = context;
        this.b = dVar;
        this.k = z;
        this.l = z2;
        this.c = new ArrayList();
        this.d = new FrameLayout(this.i);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 16;
        this.a = new LinearLayout(this.i);
        this.a.setOrientation(0);
        this.a.setOnClickListener(new l(this));
        this.e = new ImageView(this.i);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a.c((int) R.dimen.input_enhance_slide_new_guide_icon_width), a.c((int) R.dimen.input_enhance_slide_new_guide_icon_height));
        layoutParams2.setMargins(a.c((int) R.dimen.input_enhance_slide_new_guide_icon_left_margin), 0, 0, 0);
        layoutParams2.gravity = 16;
        this.a.addView(this.e, layoutParams2);
        this.f = new TextView(this.i);
        this.f.setTextSize(1, 13.0f);
        this.f.setTextColor(a.c("input_enhance_slide_new_guide_tip"));
        layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.setMargins(a.c((int) R.dimen.input_enhance_slide_new_guide_tip_left_margin), 0, 0, 0);
        this.a.addView(this.f, layoutParams2);
        this.g = new ImageView(this.i);
        this.g.setImageDrawable(a.a("input_enhance_new_guide_close.png"));
        layoutParams2 = new LinearLayout.LayoutParams(a.c((int) R.dimen.input_enhance_slide_new_guide_close_icon_size), a.c((int) R.dimen.input_enhance_slide_new_guide_close_icon_size));
        layoutParams2.gravity = 16;
        layoutParams2.setMargins(a.c((int) R.dimen.input_enhance_slide_new_guide_close_icon_left_margin), 0, 0, 0);
        this.a.addView(this.g, layoutParams2);
        this.d.addView(this.a, layoutParams);
        this.d.setBackgroundDrawable(a.a("input_enhance_new_guide_bg.9.png"));
        this.h = new LayoutParams(a.c((int) R.dimen.input_enhance_slider_new_guide_width), a.c((int) R.dimen.input_enhance_slider_new_guide_height), 0, 0, -2);
        this.h.flags = 40;
        this.h.type = 2;
        this.h.gravity = 49;
        c();
    }

    private void c() {
        if (this.k) {
            this.h.width = a.c((int) R.dimen.input_enhance_slider_new_guide_width);
            this.e.setImageDrawable(a.a("input_enhance_slide_tip.png"));
            this.f.setText(a.d((int) R.string.input_enhance_slide_new_guide));
        } else if (this.l) {
            this.h.width = a.c((int) R.dimen.input_enhance_long_slider_new_guide_width);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.width = a.c((int) R.dimen.input_enhance_long_slide_new_guide_icon_width);
            layoutParams.height = a.c((int) R.dimen.input_enhance_long_slide_new_guide_icon_height);
            this.e.setLayoutParams(layoutParams);
            this.e.setImageDrawable(a.a("input_enhance_long_slide_tip.png"));
            this.f.setText(a.d((int) R.string.input_enhance_long_slide_new_guide));
        }
    }

    public final void a() {
        this.l = true;
        c();
        this.a.invalidate();
        b();
        m.a(2, new u(this), 5000);
    }

    public final void b() {
        if (this.d != null && this.a != null && this.d.getParent() == null && !this.j) {
            int a = this.b.a();
            this.h.y = (a - ((int) com.ucweb.common.util.a.a.a(this.i, 9.0f))) - a.c((int) R.dimen.input_enhance_slider_new_guide_height);
            ((Activity) this.i).getWindowManager().addView(this.d, this.h);
            m.a(2, new b(this));
            this.j = true;
            if (this.k) {
                this.k = false;
            } else if (this.l) {
                this.l = false;
            }
        }
    }

    public final void a(int i) {
        if (this.d != null && this.a != null && this.d.getParent() != null) {
            boolean z;
            if (i == 0) {
                if (this.f.getText().toString().equals(a.d((int) R.string.input_enhance_slide_new_guide))) {
                    ((Activity) this.i).getWindowManager().removeView(this.d);
                    z = true;
                }
                z = false;
            } else if (i == 1) {
                if (this.f.getText().toString().equals(a.d((int) R.string.input_enhance_long_slide_new_guide))) {
                    ((Activity) this.i).getWindowManager().removeView(this.d);
                    z = true;
                }
                z = false;
            } else {
                if (i == 2) {
                    ((Activity) this.i).getWindowManager().removeView(this.d);
                    z = true;
                }
                z = false;
            }
            if (z) {
                this.j = false;
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    Animation animation = (Animation) it.next();
                    if (!animation.hasEnded()) {
                        animation.cancel();
                    }
                }
                this.c.clear();
            }
        }
    }
}
