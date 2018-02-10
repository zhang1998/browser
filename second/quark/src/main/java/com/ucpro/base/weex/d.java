package com.ucpro.base.weex;

import android.content.Context;
import android.os.Build.VERSION;
import com.taobao.weex.a.m;
import com.taobao.weex.common.h;
import com.taobao.weex.q;
import com.taobao.weex.ui.component.b.r;
import com.uc.weex.a;
import com.uc.weex.e;
import com.uc.weex.i.c;
import com.ucpro.a.g;
import com.ucpro.base.system.l;
import com.ucpro.base.weex.component.WXDividingLine;
import com.ucpro.base.weex.component.WXQuarkImage;
import com.ucpro.base.weex.component.WXQuarkVideo;
import com.ucpro.base.weex.component.WXTablayout;
import com.ucpro.base.weex.component.WXTextTable;

/* compiled from: ProGuard */
final class d extends a {
    final /* synthetic */ f a;
    private n b;

    d(f fVar) {
        this.a = fVar;
    }

    public final void a(e eVar) {
        if (g.a().c()) {
            f.a(this.a, eVar);
            return;
        }
        this.b = new n(this.a, eVar);
        g.a().a(this.b);
    }

    public final m a(boolean z) {
        ClassLoader classLoader;
        Context a = com.ucweb.common.util.d.a();
        if (VERSION.SDK_INT < 22) {
            classLoader = null;
        } else if (VERSION.SDK_INT < 23 || (VERSION.SDK_INT == 23 && !"N".equalsIgnoreCase(VERSION.RELEASE))) {
            classLoader = getClass().getClassLoader();
        } else {
            classLoader = g.a().i;
        }
        return new c(a, classLoader, l.a(), z);
    }

    public final void a() throws h {
        super.a();
        try {
            q.a("userTrack", com.ucpro.base.weex.component.a.class);
            q.a("uc-page-lifecycle", com.ucpro.base.weex.component.h.class);
            q.c("tablayout", WXTablayout.class);
            q.c("quark-video", WXQuarkVideo.class);
            q.c("quark-image", WXQuarkImage.class);
            q.c("text-table", WXTextTable.class);
            q.c("dividingline", WXDividingLine.class);
            q.c("qk-list", r.class);
        } catch (Exception e) {
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.a.a = true;
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bP);
            if (this.a.e) {
                this.a.e = false;
                this.a.a(this.a.d);
            }
        }
    }
}
