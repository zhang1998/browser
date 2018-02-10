package com.ucpro.feature.video.player.c;

import android.os.Bundle;
import android.os.Handler;
import com.uc.apollo.impl.SettingsConst;
import com.uc.media.interfaces.IApolloHelper.Apollo;
import com.uc.media.interfaces.IApolloHelper.ContextUtils;
import com.uc.quark.h;
import com.uc.quark.s;
import com.uc.quark.x;
import com.ucpro.c.b;
import com.ucweb.common.util.d;
import com.ucweb.common.util.e;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.k.a;
import java.io.File;
import java.util.List;

/* compiled from: ProGuard */
public final class k implements h {
    g a;
    Handler b;
    boolean c = false;
    boolean d = false;
    String e = null;
    boolean f;
    int g;
    String h;
    private long i = 0;

    public k(g gVar) {
        this.a = gVar;
        this.b = new e(getClass().getName());
    }

    static s a() {
        String str = ContextUtils.getDataDir(d.a()) + Apollo.Get_DOWNLOADED_LIB();
        List<s> h = x.a().h();
        if (h.isEmpty()) {
            return null;
        }
        for (s sVar : h) {
            if (sVar != null && sVar.h().equals(str)) {
                return sVar;
            }
        }
        return null;
    }

    static void b() {
        String str = ContextUtils.getDataDir(d.a()) + Apollo.Get_DOWNLOADED_LIB();
        s a = a();
        if (a != null) {
            x.a().b(a.a(), true);
        }
        a.c(str);
        a.c(str + ".temp");
    }

    public final void a(s sVar, int i, long j, long j2) {
        if (sVar.b != null && (sVar.b instanceof Bundle)) {
            Bundle bundle = (Bundle) sVar.b;
            if (bundle.getString("key_product_name").equals("product_video_so")) {
                if (!this.c && i == 6) {
                    this.i = System.currentTimeMillis();
                    this.c = true;
                }
                if (!this.d) {
                    Object obj;
                    int a = com.ucweb.common.util.n.a.a(bundle.getString("key_full_size", SettingsConst.FALSE), 0);
                    bundle.getString("key_md5", "");
                    if (sVar.c() <= 0 || a <= 0) {
                        obj = 1;
                    } else {
                        bundle.getString("key_download_mode", "");
                        bundle.getString("key_safe_download_url", "");
                        this.d = true;
                        if (((long) a) != sVar.c()) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                    }
                    if (obj == null) {
                        x.a().b(sVar.a(), true);
                        this.a.d();
                    }
                }
                switch (i) {
                    case -3:
                        if (this.i > 0) {
                            System.currentTimeMillis();
                            this.i = 0;
                        }
                        com.ucpro.model.a.b("2692979B693227B5BAD97907D129C8C8", 0);
                        String str = ContextUtils.getDataDir(d.a()) + sVar.b();
                        if (com.ucweb.common.util.n.a.a(this.e)) {
                            this.e = com.ucpro.model.a.b("447EC9698209622E80A965638A7007D6", "");
                        }
                        File file = new File(str);
                        if (file.exists()) {
                            com.ucweb.common.util.n.a.a(bundle.getString("key_full_size", SettingsConst.FALSE), 0);
                            str = bundle.getString("key_md5", "");
                            bundle.getString("key_download_mode", "");
                            bundle.getString("key_safe_download_url", "");
                            m.a(new q(this, str, file, sVar));
                            return;
                        }
                        this.a.d();
                        return;
                    case -1:
                        return;
                    case 3:
                        long j3;
                        long c = sVar.c();
                        if (!b.b() || c > 0) {
                            j3 = c;
                        } else {
                            j3 = com.ucweb.common.util.n.a.c(bundle.getString("key_full_size", SettingsConst.FALSE));
                        }
                        long d = sVar.d();
                        if (j3 <= 0 || d < 0) {
                            j3 = 0;
                        } else {
                            j3 = (100 * d) / j3;
                        }
                        this.a.a(j3);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
