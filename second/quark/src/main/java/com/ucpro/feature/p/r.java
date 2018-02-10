package com.ucpro.feature.p;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.quark.browser.R;
import com.ucpro.base.b.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.i;
import com.ucweb.common.util.c;
import com.ucweb.common.util.i.f;

/* compiled from: ProGuard */
public final class r extends FrameLayout {
    h a;
    h b;
    int c = SecExceptionCode.SEC_ERROR_STA_ENC;
    int d = 10;
    Interpolator e = new DecelerateInterpolator();
    private q f;

    public r(Context context) {
        super(context);
    }

    public final void a() {
        setBackgroundDrawable(new i(a.c((int) R.dimen.mainmenu_bg_radius), a.c("main_menu_content_bg_color")));
        if (this.a != null) {
            this.a.a();
        }
        if (this.b != null) {
            this.b.a();
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getContentHeight());
    }

    public final int getContentHeight() {
        return a.c((int) R.dimen.mainmenu_content_height);
    }

    final h a(g gVar) {
        View hVar = new h(getContext());
        c.a((Object) gVar);
        b bVar = gVar.a;
        if (bVar != null) {
            hVar.c = new ImageView(hVar.getContext());
            hVar.c.setPadding(hVar.g, 0, hVar.g, 0);
            if (f.a(bVar.e)) {
                ((b) com.bumptech.glide.c.b(hVar.getContext())).b(bVar.e).d().a(hVar.c);
            } else {
                hVar.c.setImageDrawable(a.a(bVar.e));
            }
            hVar.c.setId(bVar.a);
            hVar.c.setOnClickListener(hVar);
            hVar.addView(hVar.c);
            hVar.d = new TextView(hVar.getContext());
            hVar.d.setTextSize(0, (float) a.c((int) R.dimen.common_text_size));
            hVar.d.setText(bVar.a());
            hVar.d.setSingleLine();
            hVar.d.setTypeface(Typeface.defaultFromStyle(1));
            hVar.d.setId(bVar.a);
            hVar.d.setOnClickListener(hVar);
            hVar.addView(hVar.d);
            hVar.e = new TextView(hVar.getContext());
            hVar.e.setTextSize(0, (float) a.c((int) R.dimen.common_subtext_size));
            hVar.e.setText(a.d(bVar.d));
            hVar.e.setSingleLine();
            hVar.e.setId(bVar.a);
            hVar.e.setOnClickListener(hVar);
            hVar.addView(hVar.e);
        }
        b bVar2 = gVar.b;
        if (bVar2 != null) {
            hVar.f = new View(hVar.getContext());
            hVar.f.setBackgroundDrawable(a.a(bVar2.e));
            hVar.f.setId(bVar2.a);
            hVar.f.setOnClickListener(hVar);
            hVar.addView(hVar.f);
        }
        hVar.a = hVar.a((b[]) gVar.c.get(0));
        hVar.addView(hVar.a);
        hVar.b = hVar.a((b[]) gVar.c.get(1));
        hVar.addView(hVar.b);
        hVar.a();
        addView(hVar, new LayoutParams(-1, getContentHeight()));
        return hVar;
    }

    public final void setOnItemClickListener(q qVar) {
        this.f = qVar;
        b();
    }

    final void b() {
        if (!(this.a == null || this.f == null)) {
            this.a.setOnItemClickListener(this.f);
        }
        if (this.b != null && this.f != null) {
            this.b.setOnItemClickListener(this.f);
        }
    }
}
