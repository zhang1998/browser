package com.ucpro.feature.privacymode;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.quark.browser.R;
import com.uc.quark.x;
import com.ucpro.base.a.e;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.privacymode.b.b;
import com.ucpro.feature.privacymode.view.d;
import com.ucpro.feature.privacymode.view.n;
import com.ucpro.feature.privacymode.view.r;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class q extends g implements c, d {
    private m e;
    private r f = new r(getContext());

    public q(Context context, m mVar) {
        super(context);
        this.e = mVar;
        f();
        setWindowCallBacks(this);
        this.f.setBackgroundColor(a.c("default_background_dark"));
        this.f.setOnPrivacyGuideClick(this);
        b(this.f);
        b();
    }

    private void b() {
        if (com.ucpro.feature.privacymode.a.a.e()) {
            this.f.a();
            return;
        }
        n nVar = this.f.a;
        nVar.c.setVisibility(0);
        nVar.b.setVisibility(4);
        this.f.setProgressDesc(a.d((int) R.string.privacymode_guide_resource_loading));
        b rVar = new r(this, a.d((int) R.string.privacymode_guide_resource_loading_tips));
        String a = com.ucpro.business.e.d.g.a().a("privacy_mode_face_res_url", "");
        if (com.ucweb.common.util.n.a.a(a)) {
            a = "http://image.uc.cn/s/uae/g/2i/facerecognition/faceres.zip";
        }
        String a2 = com.ucweb.common.util.l.d.a(a, "");
        String str = com.ucpro.feature.privacymode.a.a.b() + a2;
        com.uc.quark.n nVar2 = new com.uc.quark.n();
        nVar2.a = a;
        nVar2.d = a2;
        nVar2.f = true;
        nVar2.g = false;
        nVar2.l = true;
        nVar2.e = str;
        x.a().a(nVar2.a()).a(rVar.a).k();
    }

    public final void a(boolean z) {
        com.ucpro.base.a.g.a().a(e.cy, Boolean.valueOf(false));
    }

    public final void a(g gVar, byte b) {
        if (b != (byte) 1 && b != (byte) 13 && b == (byte) 4) {
            this.e.a((g) this);
        }
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof q) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        com.ucpro.base.a.g.a().a(e.cy, Boolean.valueOf(true));
        return true;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.e.b((g) view);
        }
        return null;
    }

    public final void a() {
        com.ucpro.base.a.g.a().a(e.cy, Boolean.valueOf(true));
    }

    public final void b_(boolean z) {
        if (z) {
            b();
            return;
        }
        com.ucpro.base.a.g.a().a(e.ct, Boolean.valueOf(true));
        com.ucpro.business.stat.m.a("privacy_mode", "privacy_guide_register", new String[0]);
    }
}
