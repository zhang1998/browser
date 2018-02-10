package com.ucpro.feature.downloadpage.e;

import android.content.Context;
import com.quark.browser.R;
import com.ucpro.a.g;
import com.ucpro.business.stat.m;
import com.ucpro.feature.downloadpage.a.c;
import com.ucpro.feature.downloadpage.e.b.a;
import com.ucpro.services.download.b;
import com.ucweb.common.util.l.d;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;

/* compiled from: ProGuard */
public final class af {
    WeakReference<Context> a;
    a b;
    c c;

    private af() {
    }

    final void a() {
        boolean z;
        int i;
        boolean z2 = true;
        boolean c = b.c();
        int b = b.b();
        boolean z3 = this.b.f >= 10485760;
        if (c && z3) {
            z = true;
        } else {
            z = false;
        }
        Context context = (Context) this.a.get();
        if (!z) {
            b = 0;
        }
        this.c = new c(context, z, b);
        this.c.v.setImageDrawable(com.ucpro.ui.c.a.a("download_rename.svg"));
        this.c.a(new z(this, c));
        this.c.v.setOnClickListener(new n(this));
        z = g.h();
        String str = this.b.a;
        String str2 = this.b.c;
        String str3 = this.b.d;
        if (z) {
            z2 = false;
        }
        CharSequence a = d.a(str, str2, str3, z2);
        if (z) {
            try {
                a = URLDecoder.decode(a, "utf-8");
            } catch (Exception e) {
            }
        }
        c cVar = this.c;
        if (com.ucpro.base.system.b.a.J()) {
            i = 8;
        } else {
            i = 0;
        }
        cVar.y.setVisibility(i);
        this.c.b.setImageDrawable(com.ucpro.feature.downloadpage.e.b.b.a(d.c(d.a(this.b.a, this.b.c, this.b.d))));
        this.c.w.setText(a);
        c cVar2 = this.c;
        if (this.b.f <= 0) {
            a = com.ucpro.ui.c.a.d((int) R.string.download_no_kown_size);
        } else {
            a = com.ucpro.base.system.b.a.a(this.b.f);
        }
        cVar2.x.setText(a);
        this.c.show();
        m.a("download", "dialog_show", new String[0]);
    }
}
