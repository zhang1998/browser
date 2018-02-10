package com.ucpro.feature.k.a.b;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.feature.setting.a.b;
import com.ucpro.feature.setting.a.e;
import com.ucpro.feature.setting.a.g;
import com.ucpro.feature.setting.view.c.f;
import com.ucpro.feature.setting.view.d.ac;
import com.ucpro.feature.setting.view.d.i;
import com.ucpro.feature.setting.view.item.h;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public final class c extends ac implements d {
    private a f;
    private com.ucpro.feature.setting.view.c.c g = new f(getContext());
    private b h;
    private g i;
    private TextView j;

    public c(Context context, i iVar) {
        super(context, iVar);
        this.i = iVar;
        this.g.setSettingViewCallback(this);
        a();
        getContentLayer().addView(this.g.getSettingView(), new LayoutParams(-1, -2));
        this.j = new TextView(getContext());
        this.j.setText(a.d((int) R.string.quark_lab_wallpaper_doodle_statement));
        this.j.setTextColor(a.c("default_maintext_gray"));
        this.j.setTextSize(0, (float) a.c((int) R.dimen.quark_lab_wallpaper_doodle_statement_textsize));
        this.j.setGravity(17);
        this.j.setBackgroundDrawable(a.a("quark_lab_doodle_statement_bg.xml"));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, a.c((int) R.dimen.quark_lab_wallpaper_doodle_statement_height));
        layoutParams.leftMargin = a.c((int) R.dimen.quark_lab_wallpaper_doodle_statement_margin_left);
        layoutParams.rightMargin = a.c((int) R.dimen.quark_lab_wallpaper_doodle_statement_margin_left);
        getContentLayer().addView(this.j, layoutParams);
        this.j.setVisibility(8);
        n();
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ((LayoutParams) this.j.getLayoutParams()).topMargin = this.g.getSettingView().getMeasuredHeight();
    }

    public final void a() {
        if (this.g != null) {
            if (this.h == null) {
                this.h = new b(getContext(), this.i);
                b bVar = this.h;
                e a = com.ucpro.feature.setting.a.f.a;
                getContext();
                bVar.a(a.a((byte) 6));
                this.g.setAdapter(this.h);
            }
            this.h.b();
            this.h.d();
            this.h.a();
        }
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        this.f = (a) bVar;
    }

    public final String getTitleText() {
        return a.d((int) R.string.quark_lab_wallper_setting_title);
    }

    public final void a(h hVar, int i, Object obj) {
        if (this.f != null) {
            this.f.a(i, obj);
        }
    }

    public final void a(boolean z) {
        int i = 0;
        if (this.g != null) {
            h a = ((f) this.g).a(com.ucpro.feature.setting.a.h.S);
            if (a != null) {
                a.setViewVisibility(z ? 0 : 8);
            }
            a = ((f) this.g).a(com.ucpro.feature.setting.a.h.T);
            if (a != null) {
                int i2;
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                a.setViewVisibility(i2);
            }
            h a2 = ((f) this.g).a(com.ucpro.feature.setting.a.h.W);
            if (a2 != null) {
                if (!z) {
                    i = 8;
                }
                a2.setViewVisibility(i);
            }
        }
    }

    public final void d(boolean z) {
        if (this.g != null) {
            h a = ((f) this.g).a(com.ucpro.feature.setting.a.h.T);
            if (a != null) {
                a.setStatus(z);
            }
        }
    }

    public final void b() {
        if (this.g != null) {
            h a = ((f) this.g).a(com.ucpro.feature.setting.a.h.S);
            if (a != null) {
                a.setStatus(false);
            }
            a = ((f) this.g).a(com.ucpro.feature.setting.a.h.T);
            if (a != null) {
                a.setStatus(false);
            }
            a = ((f) this.g).a(com.ucpro.feature.setting.a.h.U);
            if (a != null) {
                a.setStatus(false);
            }
            a = ((f) this.g).a(com.ucpro.feature.setting.a.h.V);
            if (a != null) {
                a.setStatus(false);
            }
        }
    }

    public final h getLogoSettingView() {
        if (this.g != null) {
            return ((f) this.g).a(com.ucpro.feature.setting.a.h.T);
        }
        return null;
    }

    public final void c() {
        this.j.setVisibility(0);
    }
}
