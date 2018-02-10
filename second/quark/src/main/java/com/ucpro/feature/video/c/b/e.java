package com.ucpro.feature.video.c.b;

import com.quark.browser.R;
import com.ucpro.c.b;
import com.ucpro.feature.video.c.e.b.a;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import okhttp3.Headers.Builder;
import okhttp3.Request;

/* compiled from: ProGuard */
public final class e {
    public c a;
    int b;
    public int c;

    public final void a(a aVar, c cVar) {
        this.a = cVar;
        ArrayList arrayList = aVar.g;
        this.c = arrayList.size();
        c.b(this.c > 0);
        if (b.b()) {
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.video_vps_re_request), 0);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            String str;
            com.ucpro.feature.video.c.e.a.a aVar2 = (com.ucpro.feature.video.c.e.a.a) arrayList.get(i);
            com.ucpro.feature.video.e.a.a bVar = new b(this, (com.ucpro.feature.video.c.e.a.a) arrayList.get(i), aVar);
            if (aVar2.b == null) {
                str = null;
            } else {
                str = aVar2.b.toString();
            }
            Builder builder = new Builder();
            builder.add("X-Version", "2.0");
            builder.add("Accept-Encoding", "gzip");
            ArrayList arrayList2 = aVar2.e;
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                builder.add(((com.ucpro.feature.video.c.e.a.b) arrayList2.get(i2)).c(), ((com.ucpro.feature.video.c.e.a.b) arrayList2.get(i2)).e());
            }
            ArrayList arrayList3 = aVar2.d;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                stringBuffer.append(((com.ucpro.feature.video.c.e.a.b) arrayList3.get(i3)).c());
                stringBuffer.append('=');
                stringBuffer.append(((com.ucpro.feature.video.c.e.a.b) arrayList3.get(i3)).e());
                stringBuffer.append(';');
            }
            builder.add("Cookie", stringBuffer.toString());
            Request build = new Request.Builder().url(str).headers(builder.build()).build();
            if (b.b()) {
                new StringBuilder("向").append(str).append("发起高清接口的api请求");
            }
            com.ucpro.feature.video.e.b.a().a(build, bVar);
        }
    }

    static /* synthetic */ void a(e eVar, a aVar) {
        if (b.b()) {
            com.ucpro.ui.b.e.a().a("视频网站API请求结果收集完整, 发起VPS二次请求", 0);
        }
        c.a((Object) aVar);
        c.a(eVar.a);
        d.a(aVar, eVar.a);
    }
}
