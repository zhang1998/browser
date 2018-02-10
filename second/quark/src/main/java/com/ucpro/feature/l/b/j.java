package com.ucpro.feature.l.b;

import android.view.View;
import com.quark.browser.R;
import com.uc.apollo.android.GuideDialog;
import com.ucpro.base.a.e;
import com.ucpro.business.stat.m;
import com.ucpro.business.stat.o;
import com.ucpro.feature.l.d.b;
import com.ucpro.feature.navigation.g;
import com.ucpro.ui.c.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class j implements p {
    private k a = null;
    private List<m> b = null;
    private List<m> c = null;
    private g d;
    private o e = null;
    private long f = System.currentTimeMillis();

    public j(k kVar) {
        this.a = kVar;
        kVar.setPresenter(this);
        this.b = l.a();
        this.e = new o(this);
        kVar.getGridView().setAdapter(this.e);
        long currentTimeMillis = System.currentTimeMillis();
        List arrayList = new ArrayList();
        long j = currentTimeMillis + 1;
        arrayList.add(l.a(a.d((int) R.string.qrcode), "ext:navifunc:qrcode", "plug-in-scan.png", currentTimeMillis));
        long j2 = j + 1;
        arrayList.add(l.a(a.d((int) R.string.allinnavi), "ext:navifunc:allinonenavi", "plug-in-discover.png", j));
        arrayList.add(l.a("", "ext:navifunc:more", "plug-in-more.png", j2));
        this.c = arrayList;
        kVar.setPluginData(this.c);
    }

    private g b() {
        if (this.d == null) {
            this.d = new g();
        }
        return this.d;
    }

    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f) >= 500) {
            this.f = currentTimeMillis;
            if (view.getTag() != null && (view.getTag() instanceof m)) {
                m mVar = (m) view.getTag();
                if (mVar == null) {
                    return;
                }
                Map hashMap;
                String str;
                String str2;
                HashMap hashMap2;
                if (mVar.e == 0) {
                    o.a(b.b.c);
                    hashMap = new HashMap();
                    hashMap.put(GuideDialog.TITLE, mVar.a);
                    m.a(b.b, hashMap);
                    b();
                    g.a(mVar.b);
                    str = mVar.a;
                    str2 = mVar.b;
                    hashMap2 = new HashMap();
                    hashMap2.put(GuideDialog.TITLE, str);
                    hashMap2.put("url", str2);
                    m.a("discoverp_page", "dis_cli_lig", hashMap2);
                } else if (!(view instanceof d)) {
                    o.a(b.c.c);
                    hashMap = new HashMap();
                    hashMap.put(GuideDialog.TITLE, mVar.a);
                    m.a(b.c, hashMap);
                    if (com.ucpro.feature.navigation.a.a.b(mVar.b)) {
                        b();
                        g.b(mVar.b);
                    } else {
                        b();
                        g.a(mVar.b);
                    }
                    str = mVar.a;
                    str2 = mVar.b;
                    hashMap2 = new HashMap();
                    hashMap2.put(GuideDialog.TITLE, str);
                    hashMap2.put("url", str2);
                    m.a("discoverp_page", "dis_cli_plu", hashMap2);
                } else if (mVar.f) {
                    if (mVar.b.equals("ext:navifunc:qrcode")) {
                        com.ucpro.base.a.g.a().a(e.K, Boolean.valueOf(false));
                        com.ucpro.model.a.a.a.b("setting_qrcode_enable", false);
                        ((d) view).a(0);
                        mVar.f = false;
                    } else {
                        r9 = (d) view;
                        com.ucpro.base.a.g.a().a(e.e, mVar.b);
                        r9.a(0);
                        mVar.f = false;
                    }
                    str2 = mVar.a;
                    r1 = new HashMap();
                    r1.put(GuideDialog.TITLE, str2);
                    m.a("discoverp_page", "dis_add_plu", r1);
                } else {
                    if (mVar.b.equals("ext:navifunc:qrcode")) {
                        com.ucpro.base.a.g.a().a(e.K, Boolean.valueOf(true));
                        com.ucpro.model.a.a.a.b("setting_qrcode_enable", true);
                        ((d) view).a(1);
                        mVar.f = true;
                    } else {
                        r9 = (d) view;
                        com.ucpro.base.a.g.a().a(e.b, new Object[]{mVar.a, mVar.b, null, new f(this, r9, mVar)});
                    }
                    str2 = mVar.a;
                    r1 = new HashMap();
                    r1.put(GuideDialog.TITLE, str2);
                    m.a("discoverp_page", "dis_rem_plu", r1);
                }
            }
        }
    }

    public final void a() {
        if (this.e != null) {
            this.e.notifyDataSetChanged();
        }
        this.a.setPluginData(this.c);
    }
}
