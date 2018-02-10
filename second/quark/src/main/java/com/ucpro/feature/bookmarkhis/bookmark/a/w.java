package com.ucpro.feature.bookmarkhis.bookmark.a;

import com.raizlabs.android.dbflow.a.c.c;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.a.h;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class w extends c<m> {
    public w(Class<m> cls) {
        super(cls);
    }

    public final void a() {
        h hVar = h.INTEGER;
        String str = "pin_time";
        if (this.a == null) {
            this.a = new ArrayList();
            this.b = new ArrayList();
        }
        this.a.add(new e().b(e.a(str)).b().b(hVar.name()));
        this.b.add(str);
    }
}
