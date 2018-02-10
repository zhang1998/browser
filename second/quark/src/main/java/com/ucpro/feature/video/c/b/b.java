package com.ucpro.feature.video.c.b;

import com.uc.base.b.c.c;
import com.ucpro.feature.video.e.a.a;
import okhttp3.Headers;

/* compiled from: ProGuard */
public final class b implements a {
    com.ucpro.feature.video.c.e.a.a a;
    com.ucpro.feature.video.c.e.b.a b;
    final /* synthetic */ e c;

    public b(e eVar, com.ucpro.feature.video.c.e.a.a aVar, com.ucpro.feature.video.c.e.b.a aVar2) {
        this.c = eVar;
        this.a = aVar;
        this.b = aVar2;
    }

    public final void a(Headers headers) {
        headers.names();
        for (int i = 0; i < headers.size(); i++) {
            c cVar;
            com.ucpro.feature.video.c.e.a.b bVar = new com.ucpro.feature.video.c.e.a.b();
            String name = headers.name(i);
            if (name == null) {
                cVar = null;
            } else {
                cVar = c.a(name);
            }
            bVar.a = cVar;
            name = headers.value(i);
            if (name == null) {
                cVar = null;
            } else {
                cVar = c.a(name);
            }
            bVar.b = cVar;
            this.a.e.add(bVar);
        }
    }

    public final void a(byte[] bArr) {
        if (this.c.b < this.c.c) {
            Object obj = new byte[bArr.length];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            this.a.c = obj;
            this.c.b = this.c.b + 1;
        }
        if (this.c.b >= this.c.c) {
            e.a(this.c, this.b);
        }
    }

    public final void a(int i, String str) {
        if (this.c.b < this.c.c) {
            c cVar;
            com.ucpro.feature.video.c.e.a.a aVar = this.a;
            String str2 = i + ":" + str;
            if (str2 == null) {
                cVar = null;
            } else {
                cVar = c.a(str2);
            }
            aVar.a = cVar;
            this.c.b = this.c.b + 1;
        }
        if (this.c.b >= this.c.c) {
            e.a(this.c, this.b);
        }
    }
}
