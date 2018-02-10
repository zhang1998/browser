package com.ucpro.feature.video.cache.e;

import com.uc.quark.x;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.feature.video.cache.e.a.a;
import com.ucpro.feature.video.cache.e.a.i;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/* compiled from: ProGuard */
public final class c {
    i a;
    b b;
    HashMap<String, String> c;

    public c(b bVar, a aVar) {
        this.b = bVar;
        com.ucweb.common.util.c.a(this.b.c);
        com.ucweb.common.util.c.a(this.b.h);
        com.ucweb.common.util.c.a(this.b.i);
        com.ucweb.common.util.c.a((Object) aVar);
        this.a = new i(aVar);
        com.ucpro.feature.video.cache.a.a.b(this.b.h);
        com.ucweb.common.util.c.b(new File(this.b.h).exists());
    }

    public static String a() {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            stringBuffer.append(str.charAt(random.nextInt(str.length())));
        }
        return stringBuffer.toString();
    }

    static /* synthetic */ void a(c cVar, ArrayList arrayList) {
        x.a().a(arrayList);
        com.ucpro.feature.video.cache.g.a.a(arrayList.size());
        cVar.b.f = "ts_downloading";
    }
}
