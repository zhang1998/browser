package com.taobao.weex.b.c;

import android.mini.support.annotation.Nullable;
import android.text.TextUtils;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.c;
import com.taobao.weex.p;
import com.taobao.weex.q;

/* compiled from: ProGuard */
public class r extends p {
    i a;

    private i d() {
        if (this.a != null) {
            return this.a;
        }
        this.a = q.b();
        return this.a;
    }

    @JSMethod(uiThread = false)
    public void setItem(String str, String str2, @Nullable c cVar) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            j.b(cVar);
            return;
        }
        i d = d();
        if (d == null) {
            j.a(cVar);
        } else {
            d.a(str, str2, new l(this, cVar));
        }
    }

    @JSMethod(uiThread = false)
    public void getItem(String str, @Nullable c cVar) {
        if (TextUtils.isEmpty(str)) {
            j.b(cVar);
            return;
        }
        i d = d();
        if (d == null) {
            j.a(cVar);
        } else {
            d.a(str, new m(this, cVar));
        }
    }

    @JSMethod(uiThread = false)
    public void removeItem(String str, @Nullable c cVar) {
        if (TextUtils.isEmpty(str)) {
            j.b(cVar);
            return;
        }
        i d = d();
        if (d == null) {
            j.a(cVar);
        } else {
            d.b(str, new n(this, cVar));
        }
    }

    @JSMethod(uiThread = false)
    public void length(@Nullable c cVar) {
        i d = d();
        if (d == null) {
            j.a(cVar);
        } else {
            d.a(new o(this, cVar));
        }
    }

    @JSMethod(uiThread = false)
    public void getAllKeys(@Nullable c cVar) {
        i d = d();
        if (d == null) {
            j.a(cVar);
        } else {
            d.b(new p(this, cVar));
        }
    }

    @JSMethod(uiThread = false)
    public void setItemPersistent(String str, String str2, @Nullable c cVar) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            j.b(cVar);
            return;
        }
        i d = d();
        if (d == null) {
            j.a(cVar);
        } else {
            d.b(str, str2, new q(this, cVar));
        }
    }

    public final void a() {
        i d = d();
        if (d != null) {
            d.a();
        }
    }
}
