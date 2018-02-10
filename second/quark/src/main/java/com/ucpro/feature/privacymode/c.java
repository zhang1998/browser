package com.ucpro.feature.privacymode;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.base.c.b.m;
import com.ucpro.ui.e.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class c extends j implements com.ucpro.base.c.b.c, com.ucpro.ui.e.a.c {
    private a g;
    private m h;

    public c(Context context, m mVar) {
        super(context);
        this.h = mVar;
        f();
        this.e.setBackgroundColor(com.ucpro.ui.c.a.c("default_background_dark"));
        this.f.a.setBackgroundColor(com.ucpro.ui.c.a.c("default_background_dark"));
        this.f.b.setTextColor(com.ucpro.ui.c.a.c("privacymode_title_color"));
        this.f.a();
        if (com.ucpro.model.a.a.a.a("setting_status_bar_type", 1) == 1) {
            setTitlebarMarginTop(com.ucpro.ui.c.a.c((int) R.dimen.privacymode_close_icon_margintop));
        }
        setWindowCallBacks(this);
        this.f.a(com.ucpro.ui.c.a.d((int) R.string.privacymode_setting_title));
        this.f.a(com.ucpro.ui.c.a.a("privacy_mode_back.svg"));
        this.g = new a(getContext(), this);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.privacymode_content_type_margintop);
        this.e.addView(this.g, layoutParams);
        this.g.j();
    }

    public final void a(f fVar, View view, ad adVar) {
        g.a().a(e.cK, Boolean.valueOf(true));
    }

    public final void a(f fVar, View view, w wVar) {
    }

    public final ArrayList<com.ucpro.ui.e.e> getConfig() {
        ArrayList<com.ucpro.ui.e.e> arrayList = new ArrayList();
        arrayList.add(new k(k.b, com.ucpro.ui.c.a.d((int) R.string.privacymode_setting_add_face), this));
        arrayList.add(new k(k.c, com.ucpro.ui.c.a.d((int) R.string.privacymode_setting_change_password), this));
        return arrayList;
    }

    public final void a(boolean z) {
        g.a().a(e.cK, Boolean.valueOf(false));
    }

    public final void a(com.ucpro.base.c.b.g gVar, byte b) {
    }

    public final boolean a(com.ucpro.base.c.b.g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof c) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        g.a().a(e.cK, Boolean.valueOf(true));
        return true;
    }

    public final View a(View view) {
        if (view instanceof com.ucpro.base.c.b.g) {
            return this.h.b((com.ucpro.base.c.b.g) view);
        }
        return null;
    }
}
