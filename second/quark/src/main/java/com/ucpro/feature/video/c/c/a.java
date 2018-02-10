package com.ucpro.feature.video.c.c;

import com.ucpro.business.stat.m;
import com.ucpro.c.b;
import com.ucpro.feature.video.c.d;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class a {
    public final void a(String str, d dVar, com.ucpro.feature.video.c.e.b.a aVar) {
        b.b();
        c.a((CharSequence) str);
        com.ucpro.feature.video.c.b.d.a(aVar, new c(this, str, dVar));
        m.a("video", "resolution_request", new String[0]);
    }

    public final void a(String str, String str2, com.ucpro.feature.video.c.a aVar, com.ucpro.feature.video.c.e.b.a aVar2) {
        c.a((CharSequence) str);
        c.a((CharSequence) str2);
        c.a((Object) aVar);
        com.ucpro.feature.video.c.b.d.a(aVar2, new b(this, str2, aVar));
        m.a("video", "video_url_request", "resolution", str2);
    }
}
