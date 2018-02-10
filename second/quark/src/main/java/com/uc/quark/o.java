package com.uc.quark;

import android.text.TextUtils;
import com.uc.quark.filedownloader.as;

/* compiled from: ProGuard */
final class o implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ x b;

    o(x xVar, s sVar) {
        this.b = xVar;
        this.a = sVar;
    }

    public final void run() {
        if (this.a != null) {
            String str = null;
            if (x.l != null) {
                str = x.l.a(this.a.g());
            }
            if (!(!TextUtils.isEmpty(str) || TextUtils.isEmpty(this.a.j()) || x.l == null)) {
                str = x.l.a(this.a.j());
            }
            as.a();
            as.a(this.a.g()).a(this.a.h()).a().a(this.a).a(this.a.t()).b(this.a.q()).a(k.b().c()).a("Cookie", str).a("User-Agent", x.l != null ? x.l.b(this.a.j()) : "").a("Referer", this.a.j()).a("Connection", "keep-alive").a(this.a.u()).a("Accept", x.a).a("Accept-Encoding", x.b).a("Accept-Charset", x.c).a("Accept-Language", x.d).a(x.g).c(this.a.a).b(this.a.s()).b(this.a.v()).a(this.a.w()).c(this.a.y()).c();
        }
    }
}
