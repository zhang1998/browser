package com.ucpro.feature.z.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.ucpro.feature.z.f.b.m;
import com.ucpro.feature.z.f.b.q;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
final class l implements q {
    final /* synthetic */ n a;

    l(n nVar) {
        this.a = nVar;
    }

    public final void a(String str, @NonNull List<m> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.a.c)) {
            this.a.a = list;
            Collections.reverse(this.a.a);
            com.ucweb.common.util.h.m.a(2, new c(this));
        }
    }
}
