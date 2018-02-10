package com.ucpro.feature.webwindow.j;

import android.content.Context;
import android.support.v7.widget.bd;
import android.support.v7.widget.bh;
import android.view.ViewGroup;
import com.ucpro.business.stat.m;
import com.ucpro.feature.setting.e.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class a extends bd<x> implements c {
    List<n> c;
    boolean d;
    private final Context e;
    private r f;

    public final /* synthetic */ void a(bh bhVar, int i) {
        x xVar = (x) bhVar;
        xVar.l.setAdblockRule((n) this.c.get(i));
        xVar.l.setOnRuleDeleteListener(this);
        xVar.l.setEnableMannualAdBlock(this.d);
    }

    public a(Context context, r rVar) {
        this.e = context;
        this.f = rVar;
    }

    public final int a() {
        return this.c.size();
    }

    public final void a(n nVar) {
        r rVar = this.f;
        int indexOf = this.c.indexOf(nVar);
        String str = nVar.a;
        int i = nVar.c;
        int i2 = nVar.b;
        int size = rVar.c.size();
        HashMap hashMap = new HashMap();
        hashMap.put("hostname", str);
        hashMap.put("rule_count", String.valueOf(i));
        hashMap.put("block_count", String.valueOf(i2));
        hashMap.put("total_rule", String.valueOf(size));
        m.a("mannual_ad_block", "delete", hashMap);
        rVar.c.remove(nVar);
        rVar.a().a.a(indexOf);
        bd a = rVar.a();
        a.a.a(indexOf, rVar.c.size());
        com.ucweb.common.util.h.m.a(2, new i(w.a, rVar.b, nVar.a));
        if (rVar.c.isEmpty()) {
            rVar.a.b();
        }
        Map hashMap2 = new HashMap();
        hashMap2.put("click", "delete");
        m.a(g.a, hashMap2);
    }

    public final /* synthetic */ bh a(ViewGroup viewGroup, int i) {
        return new x(this, new h(this.e));
    }
}
