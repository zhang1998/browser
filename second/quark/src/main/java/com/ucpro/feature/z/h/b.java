package com.ucpro.feature.z.h;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.ucpro.feature.z.c.a;
import com.ucpro.feature.z.d.l;
import com.ucpro.feature.z.e.a.d;
import com.ucpro.feature.z.e.n;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class b implements TextWatcher {
    final /* synthetic */ i a;

    b(i iVar) {
        this.a = iVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() <= 0) {
            this.a.i.g.a();
            n l = this.a.i;
            if (l.a != null) {
                l.a.clear();
                l.c().notifyDataSetChanged();
            }
            l d = this.a.h;
            if (d.b()) {
                d.b.a(0);
            }
            a n = this.a.j;
            if (n.a.d()) {
                n.a.c();
            }
        } else {
            this.a.h.d();
            this.a.i.g.b();
            this.a.j.a.b();
        }
        n l2 = this.a.i;
        l2.c = charSequence.toString();
        l2.b.a(charSequence.toString(), l2.i);
        if (TextUtils.isEmpty(l2.c) || !l2.e.containsKey(l2.c.trim())) {
            if (l2.f != null) {
                l2.g.d();
            }
            l2.f = null;
            return;
        }
        l2.f = (d) l2.e.get(l2.c.trim());
        m.a(2, new com.ucpro.feature.z.e.a(l2), 300);
        com.ucpro.business.stat.m.a("searchpage", "qusou_hit", "key", l2.c);
    }

    public final void afterTextChanged(Editable editable) {
    }
}
