package com.taobao.weex.ui;

import android.mini.support.annotation.Nullable;
import android.text.TextUtils;
import com.taobao.weex.ac;
import com.taobao.weex.c.p;
import com.taobao.weex.c.q;
import com.taobao.weex.common.w;
import com.taobao.weex.ui.component.ab;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class m {
    public ConcurrentHashMap<String, d> a = new ConcurrentHashMap();
    public j b = new j();

    public final q a(String str) {
        return (q) this.a.get(str);
    }

    @Nullable
    public final ab a(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        q a = a(str);
        if (a != null) {
            return a.a(str2);
        }
        return null;
    }

    public final ac b(String str) {
        d dVar = (d) this.a.get(str);
        if (dVar == null) {
            return null;
        }
        return dVar.b;
    }

    public final void a(Runnable runnable, long j) {
        this.b.postDelayed(w.a(runnable), j);
    }

    public final void a(String str, p pVar) {
        this.b.post(w.a(new l(this, str, pVar)));
    }
}
