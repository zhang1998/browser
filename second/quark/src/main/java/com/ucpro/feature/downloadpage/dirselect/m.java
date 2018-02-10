package com.ucpro.feature.downloadpage.dirselect;

import android.os.Environment;
import com.uc.quark.x;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.downloadpage.dirselect.a.d;
import com.ucpro.model.a.a;
import com.ucpro.services.download.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class m implements j {
    List<String> a;
    List<d> b;
    String c = "";
    c d;

    public m(c cVar) {
        this.d = cVar;
        this.b = new ArrayList();
    }

    public final void a() {
        String b = b(1);
        if (!b.contains(b(0))) {
            b = b(0);
        }
        a(b);
    }

    public final void a(int i) {
        if (new File(this.c + "/" + ((String) this.a.get(i))).isDirectory()) {
            a("/" + ((String) this.a.get(i)));
        }
    }

    final void a(String str) {
        com.ucweb.common.util.h.m.a(new e(this, str), new g(this));
    }

    final String b(int i) {
        if (i == 0) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        if (i == 1) {
            return b.d();
        }
        return "/storage/" + ((String) this.a.get(i));
    }

    public final void a(boolean z) {
        g.a().a(e.dg, Boolean.valueOf(z));
    }

    public final void c() {
        String str = this.c;
        a.a.b("download_cur_download_path", str);
        x.a(str);
        a(false);
        g.a().a(e.x);
    }

    public final void b() {
        int lastIndexOf = this.c.lastIndexOf("/");
        boolean d = com.ucweb.common.util.n.a.d(this.c, b(0));
        if (!d) {
            this.c = this.c.substring(0, lastIndexOf);
            a("");
        }
        if (d) {
            a(true);
        }
    }

    public final void d() {
        b bVar = new b(this.d.getContext());
        bVar.a(new l(this, bVar));
        bVar.show();
    }
}
