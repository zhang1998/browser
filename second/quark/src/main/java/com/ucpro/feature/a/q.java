package com.ucpro.feature.a;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.uc.apollo.android.GuideDialog;
import com.uc.media.interfaces.IProxyHandler;
import com.uc.weex.component.e;
import com.uc.weex.component.f;
import com.ucpro.base.a.g;
import com.ucpro.feature.video.ac;
import com.ucpro.feature.video.ae;
import com.ucpro.feature.video.au;
import com.ucpro.feature.video.c.c;
import com.ucpro.feature.video.player.a.b;
import com.ucweb.common.util.d;
import java.util.Map;

/* compiled from: ProGuard */
public final class q implements f, au {
    ae a;
    private FrameLayout b;

    public final void a() {
        d();
    }

    public final void a(Map<String, String> map, ValueCallback<View> valueCallback, e eVar) {
        String str = (String) map.get(IProxyHandler.KEY_PAGE_URL);
        this.b = new e(this, d.a().getApplicationContext());
        b a = b.a();
        a.a(19, map.get(GuideDialog.TITLE));
        a.a(20, map.get(IProxyHandler.KEY_PAGE_URL));
        a.a(18, map.get(IProxyHandler.KEY_PAGE_URL));
        a.a(25, Integer.valueOf(0));
        Object obj = new Object[3];
        obj[0] = a;
        obj[1] = this.b;
        g.a().b(com.ucpro.base.a.e.bu, obj);
        if (obj[2] instanceof ae) {
            this.a = (ae) obj[2];
            this.a.a(this);
            if (!(this.a == null || this.a.r() == null)) {
                valueCallback.onReceiveValue(this.b);
                j.a().a(this.b);
            }
        }
        c.a();
        c.a(str, new l(this, str));
        j.a().a = eVar;
        j a2 = j.a();
        ac a3 = ac.a();
        com.ucpro.feature.video.player.a.g gVar = a2.c;
        if (!a3.a.contains(gVar)) {
            a3.a.add(gVar);
        }
    }

    public final void a(e eVar) {
        j.a().a = eVar;
        if (this.a != null) {
            this.a.l();
        }
    }

    public final void b() {
        if (this.a != null) {
            this.a.m();
        }
    }

    public final void c() {
        d();
    }

    final void d() {
        if (this.a != null) {
            g.a().b(com.ucpro.base.a.e.bv, new Object[]{this.a});
        }
        if (!(this.b == null || this.b.getParent() == null)) {
            this.b.removeAllViews();
            ((ViewGroup) this.b.getParent()).removeView(this.a.r());
        }
        j.a().b();
        j.a().a = null;
        j.a().a(null);
        j a = j.a();
        ac a2 = ac.a();
        com.ucpro.feature.video.player.a.g gVar = a.c;
        if (a2.a.contains(gVar)) {
            a2.a.remove(gVar);
        }
    }

    public final void onDestory() {
    }
}
