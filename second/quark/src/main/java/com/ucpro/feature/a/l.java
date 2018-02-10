package com.ucpro.feature.a;

import android.support.annotation.NonNull;
import com.ucpro.feature.video.c.c;
import com.ucpro.feature.video.c.d;
import com.ucpro.feature.video.c.d.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class l implements d {
    final /* synthetic */ String a;
    final /* synthetic */ q b;

    l(q qVar, String str) {
        this.b = qVar;
        this.a = str;
    }

    public final void a(@NonNull ArrayList<String> arrayList) {
        if (arrayList.size() > 0 && this.b.a != null) {
            c.a();
            c.a(this.a, (String) arrayList.get(arrayList.size() - 1), new u(this));
        }
    }

    public final void a(a aVar) {
    }
}
