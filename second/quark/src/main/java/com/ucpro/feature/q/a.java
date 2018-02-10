package com.ucpro.feature.q;

import android.net.Uri;
import android.os.Message;
import com.uc.l;
import com.ucpro.base.a.g;
import com.ucpro.base.a.j;
import com.ucpro.base.e.e;
import com.ucpro.feature.video.player.a.b;
import com.ucweb.common.util.h.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: ProGuard */
public class a extends e {
    private String c;
    private long d = 0;

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.cU == i) {
            String str = (String) message.obj;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.d >= 800 || !com.ucweb.common.util.n.a.d(this.c, str)) {
                this.d = currentTimeMillis;
                new StringBuilder("time = ").append(System.currentTimeMillis()).append("  url = ").append(this.c);
                m.a(0, new g(this, str));
            }
            com.ucpro.business.stat.m.a("xigua_play", "xg_session");
        } else if (com.ucpro.base.a.e.bw == i) {
            com.ucpro.business.stat.m.b("xigua_play", "xg_session");
            m.a(0, new c(this));
        }
    }

    public final void b(int i, Message message) {
        if (j.r == i) {
            m.a(0, new f(this), 500);
        }
    }

    static /* synthetic */ void a(String str) {
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            Object a = b.a();
            a.a(19, Uri.parse(decode).getLastPathSegment());
            a.a(20, "");
            a.a(18, l.a(str));
            g.a().a(com.ucpro.base.a.e.bp, a);
        } catch (UnsupportedEncodingException e) {
        }
    }
}
