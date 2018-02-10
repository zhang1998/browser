package com.ucpro.feature.k.a.b;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.base.c.b.m;
import com.ucpro.business.a.a.c;
import com.ucpro.feature.setting.a.h;
import com.ucpro.feature.setting.view.item.f;
import com.ucpro.feature.x.e;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class b implements a {
    private d a;
    private Activity b;
    private m c;

    public b(d dVar, Activity activity, m mVar) {
        this.a = dVar;
        this.b = activity;
        this.c = mVar;
        dVar.setPresenter(this);
        if (e.a()) {
            this.a.a(true);
        } else {
            this.a.a(false);
        }
        if (c.a()) {
            this.a.c();
            this.a.b();
        } else if (a.a()) {
            this.a.d(true);
        } else {
            this.a.d(false);
        }
        com.ucweb.common.util.h.m.a(0, new com.ucpro.feature.x.b());
    }

    public final void a(int i, Object obj) {
        if (h.S == i) {
            if (Boolean.valueOf(String.valueOf(obj)).booleanValue()) {
                if (!a.b() || this.c == null) {
                    this.a.d(true);
                    a(true);
                } else {
                    this.c.b(true);
                }
                g.a().b(com.ucpro.base.a.e.Z);
            } else {
                g.a().b(com.ucpro.base.a.e.aa);
                this.a.d(false);
                a(false);
            }
            com.ucpro.model.a.a.a.b("setting_enable_wallpaper", Boolean.valueOf(String.valueOf(obj)).booleanValue());
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, String.valueOf(obj));
        } else if (h.T == i) {
            com.ucpro.model.a.a.a.b("setting_enable_logo", Boolean.valueOf(String.valueOf(obj)).booleanValue());
            g.a().b(com.ucpro.base.a.e.L, Boolean.valueOf(String.valueOf(obj)));
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, String.valueOf(obj));
        } else if (h.U == i) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.PICK");
                intent.setType("image/*");
                this.b.startActivityForResult(intent, 3);
            } catch (Exception e) {
            }
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
        } else if (h.W == i) {
            Bitmap a = com.uc.util.b.a(d.a().getResources(), e.b(), false);
            if (a != null) {
                e.b(a, com.ucpro.model.a.a.a.a("setting_enable_logo", true));
            }
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
        } else if (h.V == i) {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.quark_lab_wallpaper_coming_soon), 0);
            com.ucpro.feature.setting.e.b.a;
            com.ucpro.feature.setting.e.c.a(i, "none");
        }
    }

    private void a(boolean z) {
        com.ucpro.feature.setting.view.item.h logoSettingView = this.a.getLogoSettingView();
        if ((logoSettingView instanceof f) && Boolean.valueOf(logoSettingView.getValue()).booleanValue() != z) {
            f fVar = (f) logoSettingView;
            if (fVar.a != null) {
                fVar.a.toggle();
            }
        }
    }
}
