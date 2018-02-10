package com.ucpro.feature.c.d;

import android.support.annotation.NonNull;
import com.ucpro.feature.c.a.b;
import com.ucpro.feature.c.b.a;
import com.ucpro.services.f.g;
import java.io.File;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

/* compiled from: ProGuard */
final class d implements a {
    final /* synthetic */ b a;
    final /* synthetic */ g b;

    d(b bVar, g gVar) {
        this.a = bVar;
        this.b = gVar;
    }

    public final void a(@NonNull String str, @NonNull String str2) {
        File file = new File(this.a.a);
        if (com.ucpro.c.b.b()) {
            new StringBuilder("fileContent length is:").append(file.length());
        }
        if (file.length() == 0) {
            this.b.b("file length is zero..");
            return;
        }
        g.a().newCall(new Builder().url(str).put(RequestBody.create(null, file)).build()).enqueue(new b(this, str2));
    }

    public final void a(@NonNull String str) {
        this.b.b("auth failed:" + str);
    }
}
