package com.ucpro.base.weex;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.taobao.weex.l;
import com.taobao.weex.m;
import com.taobao.weex.q;
import com.uc.webview.export.WebView;
import com.uc.weex.a.ag;
import com.uc.weex.d;
import com.uc.weex.e;
import com.uc.weex.f.b;
import com.uc.weex.f.c;
import com.uc.weex.g;
import com.uc.weex.h.r;
import com.uc.weex.i;
import com.uc.weex.o;
import com.uc.weex.p;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class f {
    private static f b = new f();
    boolean a;
    private boolean c;
    private String d;
    private boolean e;
    private WeakReference<Context> f;
    private d g = new d(this);

    public static f a() {
        return b;
    }

    public final void a(Context context) {
        if (!this.c) {
            this.c = true;
            this.f = new WeakReference(context);
            Application application = (Application) com.ucweb.common.util.d.a();
            i iVar = new i();
            iVar.a = new b(com.ucweb.common.util.d.a());
            iVar.c = true;
            iVar.b = new m(this);
            d dVar = this.g;
            g.a = application;
            g.b = iVar;
            g.c = dVar;
            g.d = iVar.a();
            g.e = iVar.c;
            ag.a = application;
            ag.b = iVar;
            ag.c = iVar.f;
            ag.d = iVar.g;
            ag.e = ag.b.a();
            c.a = application;
            c.b = iVar;
            c.c = dVar;
            c.d = iVar.b;
            if (com.ucpro.a.g.g()) {
                m.a(l.M40);
            } else if (com.ucpro.a.g.h()) {
                m.a(l.M57);
            }
        }
    }

    public final void a(String str) {
        boolean z = true;
        if (this.a) {
            p a = o.a;
            b bVar = a.b.b;
            if (bVar.d == null || !bVar.d.booleanValue()) {
                z = false;
            }
            if (z) {
                r rVar = a.a;
                if (!TextUtils.isEmpty(str) && com.taobao.weex.i.c()) {
                    com.taobao.weex.i.p = str;
                    q.c();
                    for (com.uc.weex.h.o c : rVar.a) {
                        c.c();
                    }
                    return;
                }
                return;
            }
            return;
        }
        o.a.b.b.a(null);
        this.e = true;
        this.d = str;
    }

    static /* synthetic */ void a(f fVar, e eVar) {
        WebView webView = new WebView((Context) fVar.f.get());
        webView.loadUrl("ext:lp:home");
        webView.evaluateJavascript("function getV8Inited() { return 'v8Inited'; }; getV8Inited()", new h(fVar, eVar, webView));
    }
}
