package com.ucpro.feature.webwindow.external;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.uc.browser.a;
import com.uc.browser.b;
import com.ucpro.business.c.a.d;
import com.ucpro.business.e.d.g;
import com.ucpro.business.stat.m;
import java.util.Iterator;

/* compiled from: ProGuard */
public class c {
    public static boolean a = false;
    public static String b;
    private static final String c = c.class.getSimpleName();
    private com.ucpro.business.c.a.c d;
    private com.ucpro.business.c.a.c e;

    public static c a() {
        return b.a;
    }

    private c() {
        this.d = null;
        this.e = null;
        try {
            this.d = (com.ucpro.business.c.a.c) b.a("app_block", "white_list", com.ucpro.business.c.a.c.class);
        } catch (a e) {
        }
        if (this.d == null || this.d.b.size() == 0) {
            this.d = new com.ucpro.business.c.a.c();
            c("taobao.com", "taobao");
            c("tmall.com", "tmall");
            c("alipay.com", "intent");
            c("alipay.com", "alipays");
            b.a("app_block", "white_list", this.d);
        }
        try {
            this.e = (com.ucpro.business.c.a.c) b.a("app_block", "black_list", com.ucpro.business.c.a.c.class);
        } catch (a e2) {
        }
        if (this.e == null) {
            this.e = new com.ucpro.business.c.a.c();
            b.a("app_block", "black_list", this.e);
        }
    }

    private void c(String str, String str2) {
        d dVar = new d();
        dVar.b = str;
        dVar.c = str2;
        this.d.b.add(dVar);
    }

    public static boolean a(Intent intent) {
        String scheme = intent != null ? intent.getData() != null ? intent.getData().getScheme() : "" : "";
        m.a("ext_intent", "call_ext_app", "schema", scheme, "package", intent.getPackage());
        if (com.ucweb.common.util.n.a.d(intent.getPackage(), g.a().a("p2p_video_package_name", "tv.danmaku.ijk.media.demo")) || com.ucweb.common.util.n.a.d(scheme, g.a().a("p2p_video_scheme", "xg"))) {
            return g.a().c("p2p_video_switch");
        }
        return false;
    }

    public static void a(Context context, String str, String str2) {
        m.a("core", "call_ext_app", "schema", str2);
        com.ucpro.base.system.b.a.a(context, str);
    }

    public static boolean a(Context context, Intent intent) {
        if (intent == null || intent.resolveActivityInfo(context.getPackageManager(), 0) == null) {
            return false;
        }
        return true;
    }

    public final boolean a(String str, String str2) {
        Iterator it = this.e.b.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!TextUtils.isEmpty(dVar.b) && !TextUtils.isEmpty(dVar.c) && str.contains(dVar.b) && str2.equals(dVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, String str2) {
        Iterator it = this.d.b.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.contains(dVar.b) && str2.equals(dVar.c)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void a(c cVar, String str, String str2) {
        if (!cVar.b(str, str2)) {
            d dVar = new d();
            dVar.b = str;
            dVar.c = str2;
            cVar.d.b.add(dVar);
            if (com.ucpro.c.b.b()) {
                new StringBuilder("write to white. list:host=").append(str).append(",schema=").append(str2);
            }
            b.a("app_block", "white_list", cVar.d);
        }
    }

    static /* synthetic */ void b(c cVar, String str, String str2) {
        if (!cVar.a(str, str2)) {
            d dVar = new d();
            dVar.b = str;
            dVar.c = str2;
            cVar.e.b.add(dVar);
            if (com.ucpro.c.b.b()) {
                new StringBuilder("write to black list:host=").append(str).append(",schema=").append(str2);
            }
            b.a("app_block", "black_list", cVar.e);
        }
    }
}
