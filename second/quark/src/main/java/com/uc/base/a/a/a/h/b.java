package com.uc.base.a.a.a.h;

import android.text.TextUtils;
import com.uc.base.a.a.a.a;
import com.uc.base.a.a.a.c;
import com.uc.base.a.a.a.e.i;

/* compiled from: ProGuard */
public final class b extends a implements d {
    public static a a;

    public final a a() {
        return a;
    }

    public final void a(e eVar) {
        a(new f(this, c.a().b(i.a), eVar, eVar));
    }

    static /* synthetic */ boolean a(a aVar) {
        if (a == null) {
            return true;
        }
        boolean z = TextUtils.equals(aVar.c, a.c) && TextUtils.equals(aVar.d, a.d) && TextUtils.equals(aVar.b, a.b) && TextUtils.equals(aVar.a, a.a) && TextUtils.equals(aVar.g, a.g) && TextUtils.equals(aVar.h, a.h) && aVar.i == a.i;
        if (z) {
            return false;
        }
        return true;
    }
}
