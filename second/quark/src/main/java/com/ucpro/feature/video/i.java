package com.ucpro.feature.video;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.ucpro.feature.video.c.d;
import com.ucpro.feature.video.g.a;
import com.ucpro.feature.video.player.a.b;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class i implements d {
    final /* synthetic */ f a;

    i(f fVar) {
        this.a = fVar;
    }

    public final void a(@NonNull ArrayList<String> arrayList) {
        this.a.i = 2;
        if (this.a.a != null) {
            c.b(!TextUtils.isEmpty(this.a.a.b()));
            this.a.g.put(this.a.a.b(), arrayList);
            this.a.a.a((List) arrayList);
            this.a.a.a(10072, b.a().a(16, arrayList), null);
            a.b(this.a.a.b());
        }
    }

    public final void a(com.ucpro.feature.video.c.d.a aVar) {
        this.a.i = 1;
        if (this.a.a != null) {
            this.a.a.a(10071, null, null);
            a.a(this.a.a.b(), aVar.p);
        }
    }
}
