package com.taobao.android.binding.core;

import android.mini.support.annotation.Nullable;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.c;
import com.taobao.weex.p;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class eb extends p {
    private i a;

    @JSMethod
    @Deprecated
    public final void enableBinding(@Nullable String str, @Nullable String str2) {
        if (this.a == null) {
            this.a = new i();
        }
    }

    @JSMethod
    @Deprecated
    public final void createBinding(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<Map<String, Object>> list, @Nullable c cVar) {
        if (this.a == null) {
            this.a = new i();
        }
        String str4 = str;
        String str5 = str2;
        this.a.a(str4, str5, null, av.a(null, str3), list, cVar, this.b);
    }

    @JSMethod
    @Deprecated
    public final void disableBinding(@Nullable String str, @Nullable String str2) {
        if (this.a != null) {
            this.a.a(str, str2);
        }
    }

    @JSMethod
    @Deprecated
    public final void disableAll() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void a() {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
    }

    public final void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public final void c() {
        if (this.a != null) {
            this.a.c();
        }
    }
}
