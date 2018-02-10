package com.ucpro.feature.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.uc.weex.component.b;
import com.uc.weex.component.d;
import com.uc.weex.component.e.l;
import com.uc.weex.component.f;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucweb.common.util.h.m;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class r extends b {
    final Map<String, l> a = new HashMap();
    private final Map<String, f> b = new HashMap();
    private d c = new p(this);

    public static r c() {
        return i.a;
    }

    public final d b() {
        return this.c;
    }

    public final f a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.b.containsKey(str)) {
            return (f) this.b.get(str);
        }
        f qVar = new q();
        this.b.put(str, qVar);
        return qVar;
    }

    public final void b(String str) {
        this.b.remove(str);
    }

    public final void a(boolean z) {
        g.a().a(e.bO, Boolean.valueOf(z));
    }

    public final l c(String str) {
        return (l) this.a.get(str);
    }

    public final void a(String str, l lVar) {
        this.a.put(str, lVar);
    }

    public final void a(String str, ImageView imageView) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            m.a(2, new g(this, imageView, str));
        }
    }
}
