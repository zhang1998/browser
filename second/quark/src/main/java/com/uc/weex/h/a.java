package com.uc.weex.h;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.common.q;
import com.taobao.weex.i;
import com.uc.weex.a.n;
import com.uc.weex.c.c;
import com.uc.weex.f;

/* compiled from: ProGuard */
public final class a extends o {
    f a;
    private n i;
    private String j;
    private boolean k;

    public a(Context context) {
        super(context);
    }

    public final void a(n nVar) {
        this.i = nVar;
        if (nVar != null) {
            this.b.s.c = nVar.c;
        }
    }

    public final void a(String str) {
        if (!this.b.i) {
            if (i.c()) {
                this.j = str;
            }
            if (this.d.h == null || !this.d.h.a()) {
                n nVar = this.i;
                if (!(this.d.d == null || nVar == null)) {
                    this.d.d.put("bundleUrl", nVar.a);
                    this.d.d.put("bundleDigest", nVar.f);
                    this.d.d.put("codeCachePath", this.e.getFilesDir() + "/weex-engine");
                }
                this.b.a(this.d.b, str, this.d.d, this.d.f, q.APPEND_ASYNC);
                return;
            }
            j();
        }
    }

    private void j() {
        this.k = true;
        this.b.g();
        this.f.removeAllViews();
        View c = this.d.h != null ? this.d.h.c() : null;
        if (c != null) {
            this.f.addView(c);
        }
    }

    public final void a(ac acVar, String str, String str2) {
        super.a(acVar, str, str2);
        c(str, str2);
    }

    public final void a(String str, String str2) {
        super.a(str, str2);
        c(str, str2);
    }

    public final void a(String str, String str2, String str3) {
        super.a(str, str2, str3);
        c(str2, str3);
    }

    private void c(String str, String str2) {
        if (this.d.h != null) {
            com.uc.weex.c.a aVar = this.d.h;
            c cVar = new c(str, str2);
            if (aVar.b()) {
                j();
            }
        }
        if (this.a != null) {
            this.a.a(this.b.e, str, str2, this.i);
        }
    }

    public final void b() {
        if (this.d.e != null) {
            this.d.e.b();
        }
    }

    public final void i_() {
        if (this.d.e != null) {
            this.d.e.a();
        }
    }

    public final void c() {
        if (!this.b.i && i.c() && !this.k && !TextUtils.isEmpty(this.j)) {
            e();
            this.b.a(this.d.b, this.j, this.d.d, this.d.f, q.APPEND_ASYNC);
        }
    }
}
