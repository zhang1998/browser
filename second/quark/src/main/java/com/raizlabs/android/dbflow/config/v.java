package com.raizlabs.android.dbflow.config;

import com.ucpro.feature.bookmarkhis.bookmark.a.e;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.w;
import com.ucpro.feature.bookmarkhis.bookmark.a.y;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class v extends c {
    public v(f fVar) {
        a(new y(this), fVar);
        w wVar = new w(m.class);
        List list = (List) this.a.get(Integer.valueOf(2));
        if (list == null) {
            list = new ArrayList();
            this.a.put(Integer.valueOf(2), list);
        }
        list.add(wVar);
    }

    public final Class<?> e() {
        return e.class;
    }

    public final int d() {
        return 2;
    }

    public final String b() {
        return "bookmark";
    }
}
