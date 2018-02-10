package com.ucpro.feature.q;

import com.quark.browser.R;
import com.uc.f;
import com.uc.h;
import com.uc.quark.n;
import com.uc.quark.s;
import com.uc.quark.x;
import com.ucpro.base.system.b;
import com.ucpro.c.c;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import java.io.File;

/* compiled from: ProGuard */
public final class e implements com.uc.e, h, com.uc.quark.h {
    static String b;
    f a;

    public e(String str) {
        b = str;
    }

    public final void a(String str, String str2, String str3, f fVar) {
        this.a = fVar;
        n nVar = new n();
        nVar.a = str;
        nVar.d = str3;
        nVar.e = str2 + File.separator + str3;
        nVar.g = false;
        nVar.f = true;
        nVar.l = true;
        x.a().a(nVar.a()).a((com.uc.quark.h) this).k();
    }

    public final void a(s sVar, int i, long j, long j2) {
        if (i == -3) {
            com.ucpro.ui.b.e.a().a(String.format(d.a().getString(R.string.p2p_play_soloading_tips), new Object[]{" : 100%"}), 0);
            m.a(new b(this, sVar));
        } else if (i == -1) {
            Throwable x = sVar.x();
            String str = "p2p_video";
            String str2 = "xigua_so_error";
            String[] strArr = new String[2];
            strArr[0] = "xigua_so_err_info";
            strArr[1] = x != null ? x.toString() : "null";
            com.ucpro.business.stat.m.a(str, str2, strArr);
        } else if (i == 3) {
            String a = j2 > 0 ? " : " + ((int) ((((float) j) / ((float) j2)) * 100.0f)) + "%" : b.a.a(j);
            com.ucpro.ui.b.e.a().a(String.format(d.a().getString(R.string.p2p_play_soloading_tips), new Object[]{a}), 0);
        }
    }

    public final com.uc.e a() {
        return new e(b);
    }

    public final String b() {
        return c.e();
    }
}
