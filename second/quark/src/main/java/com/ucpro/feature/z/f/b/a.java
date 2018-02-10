package com.ucpro.feature.z.f.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.raizlabs.android.dbflow.a.b.a.b;
import com.raizlabs.android.dbflow.a.b.u;
import com.raizlabs.android.dbflow.a.b.z;
import com.raizlabs.android.dbflow.a.d.f;
import com.ucpro.feature.bookmarkhis.a.a.d;
import com.ucpro.feature.bookmarkhis.bookmark.a.h;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.bookmarkhis.bookmark.a.y;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a implements h {
    String a;

    public final void a(String str, ValueCallback<o> valueCallback) {
        c.a((Object) str);
        c.a((Object) valueCallback);
        this.a = str;
        boolean a = com.ucpro.model.a.a.a.a("setting_no_footmark_mode", false);
        ArrayList arrayList = a ? new ArrayList() : a();
        ArrayList arrayList2 = a ? new ArrayList() : a(str);
        s a2 = s.a();
        ValueCallback iVar = new i(this, arrayList, arrayList2, valueCallback);
        u a3 = z.a(new b[0]).a(m.class).a(y.i.a("%" + str + "%"));
        a3.b.a("OR", y.j.a(r0));
        u a4 = a3.a(y.t.b(Integer.valueOf(1)), y.m.b(Integer.valueOf(5)), y.n.a(Integer.valueOf(0))).a(a2.e());
        a4.d = 100;
        com.raizlabs.android.dbflow.a.c f = a4.f();
        f.a = new h(a2, iVar);
        f.d = new com.ucpro.feature.bookmarkhis.bookmark.a.b(a2);
        ((f) f).a();
    }

    @NonNull
    private static ArrayList<n> a(String str) {
        Object b = d.a().b();
        c.a(b);
        ArrayList<n> arrayList = new ArrayList();
        if (b != null) {
            for (com.ucpro.feature.bookmarkhis.a.a.f fVar : b.a()) {
                if ((fVar.b != null && fVar.b.contains(str)) || (fVar.c != null && fVar.c.contains(str))) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    private ArrayList<m> a() {
        ArrayList a;
        if (TextUtils.isEmpty(this.a)) {
            a = com.ucpro.feature.z.f.a.c.a().a(null, k.b);
        } else {
            a = com.ucpro.feature.z.f.a.c.a().a(new r(this), k.b);
        }
        ArrayList<m> arrayList = new ArrayList();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            com.ucpro.feature.z.f.a.f fVar = (com.ucpro.feature.z.f.a.f) it.next();
            m mVar = new m();
            mVar.a = g.SOURCE_TYPE_INPUT_HISTORY;
            mVar.c = fVar.b;
            mVar.b = f.TITLE_ONLY;
            mVar.d = fVar.c;
            mVar.f = 0;
            mVar.g = this.a.length();
            arrayList.add(mVar);
        }
        return arrayList;
    }
}
