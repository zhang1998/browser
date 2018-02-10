package com.ucpro.feature.z.d;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.system.b;
import com.ucpro.business.stat.m;
import com.ucpro.business.stat.o;
import com.ucpro.feature.z.f.a.f;
import com.ucpro.feature.z.f.a.g;
import com.ucpro.ui.c.a;
import com.ucpro.ui.f.e;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class l implements b {
    List<i> a = new ArrayList();
    public h b = null;
    Context c = null;
    public g d = new n(this);
    private e e = null;
    private int f = 0;
    private int g = a.c((int) R.dimen.search_input_history_margin_left);

    public l(Context context, h hVar) {
        c.a((Object) hVar);
        c.b(hVar instanceof h);
        this.c = context;
        this.b = hVar;
        this.b.setPresenter(this);
        h hVar2 = this.b;
        if (this.e == null) {
            this.e = new e(this);
        }
        hVar2.setAdapter(this.e);
        c();
        com.ucpro.feature.z.f.a.c a = com.ucpro.feature.z.f.a.c.a();
        Object obj = this.d;
        c.a(obj);
        if (!a.a.contains(obj)) {
            a.a.add(obj);
        }
    }

    public final void c() {
        this.a.clear();
        ArrayList a = com.ucpro.feature.z.f.a.c.a().a(null, 10);
        for (int i = 0; i < a.size(); i++) {
            i iVar = new i();
            iVar.a = (f) a.get(i);
            iVar.b = a.c("default_bubble");
            this.a.add(iVar);
        }
        this.e.c();
        int a2 = this.b.a(MeasureSpec.makeMeasureSpec(b.a.f() - (this.g * 2), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(b.a.g(), SectionHeader.SHT_LOUSER));
        if (a2 < this.a.size()) {
            for (a2 = this.a.size() - a2; a2 > 0; a2--) {
                this.a.remove(this.a.size() - 1);
            }
            this.e.c();
        }
    }

    public final void d() {
        this.b.a(false, 0);
    }

    public final boolean b() {
        if (this.a.isEmpty()) {
            return false;
        }
        return true;
    }

    public final void a(int i, String str) {
        if (!e()) {
            if (com.ucweb.common.util.i.f.j(str) == com.ucweb.common.util.i.g.a) {
                com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.ao, com.ucweb.common.util.i.f.k(str.toString()));
            } else {
                com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.an, (Object) str);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("item_content", str);
            hashMap.put("count", String.valueOf(this.a != null ? this.a.size() : 0));
            hashMap.put("from", String.valueOf(i));
            m.a("searchpage", "cli_inp_his", hashMap);
            o.a(com.ucpro.feature.z.h.a.f.c);
            m.a(com.ucpro.feature.z.h.a.f);
        }
    }

    public final void a(int i) {
        if (this.a.size() > i) {
            com.ucpro.feature.z.f.a.c a = com.ucpro.feature.z.f.a.c.a();
            int i2 = ((i) this.a.get(i)).a.b;
            ArrayList arrayList = a.b.b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (fVar.b == i2) {
                    arrayList.remove(fVar);
                    new StringBuilder("delete  ").append(fVar);
                    break;
                }
            }
            a.b();
            this.a.remove(i);
            this.b.a(i);
            f();
            if (!b()) {
                d();
            }
            m.a(com.ucpro.feature.z.h.a.e);
        }
    }

    public final void a() {
        this.a.clear();
        com.ucpro.feature.z.f.a.c.a().c();
        this.b.c();
        f();
        d();
        m.a("searchpage", "cle_inp_h", "from", "ok");
        m.b("searchpage_ut", "cle_inp_h", "from", "ok");
        m.a(com.ucpro.feature.z.h.a.d);
    }

    public final void a(View view) {
        if (this.f != 1) {
            this.f = 1;
            this.b.a(view);
            m.a("searchpage", "ent_del_i_h", new String[0]);
            m.b("searchpage_ut", "ent_del_i_h", new String[0]);
            m.a(com.ucpro.feature.z.h.a.c);
        }
    }

    public final boolean e() {
        return this.f == 1;
    }

    public final void f() {
        if (this.f != 0) {
            this.f = 0;
            this.b.b();
        }
    }
}
