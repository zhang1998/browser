package com.ucpro.feature.y;

import android.os.Message;
import android.view.View;
import com.ucpro.base.a.j;
import com.ucpro.base.e.e;
import com.ucpro.business.a.a.c;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public class g extends e {
    private y c;
    private c d;

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.I == i) {
            if (this.c == null) {
                this.c = new v(this.b);
                this.d = new j(this.c);
                this.d.d();
                this.c.setPresenter(this.d);
                this.c.setTouchCallback(this.d);
                p.a.b = (View) this.c;
            }
            com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.a, this.c);
            if (c.a() && this.c.getLogo() != null) {
                if (a.a()) {
                    com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.aa);
                    com.ucpro.model.a.a.a.b("setting_has_wallpaper_during_doodle", true);
                }
                com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.cl, new s(this));
                com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.ck, new Object[]{this.c, Boolean.valueOf(false)});
            } else if (!a.a() && !a.b() && com.ucpro.feature.x.e.a() && com.ucpro.model.a.a.a.a("setting_has_wallpaper_during_doodle", false)) {
                com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.Z);
                com.ucpro.model.a.a.a.b("setting_has_wallpaper_during_doodle", false);
            }
        } else if (com.ucpro.base.a.e.K == i) {
            com.ucweb.common.util.c.b(message.obj instanceof Boolean);
            this.c.a(((Boolean) message.obj).booleanValue());
        } else if (com.ucpro.base.a.e.L == i) {
            this.d.d();
        }
    }

    public final void b(int i, Message message) {
        if (i == j.f && this.d != null) {
            this.d.c();
        }
    }
}
