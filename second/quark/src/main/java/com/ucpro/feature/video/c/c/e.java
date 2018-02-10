package com.ucpro.feature.video.c.c;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.ucpro.c.b;
import com.ucpro.feature.video.c.a;
import com.ucpro.feature.video.c.b.c;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class e implements c {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ d c;

    e(d dVar, String str, a aVar) {
        this.c = dVar;
        this.a = str;
        this.b = aVar;
    }

    public final void a(@NonNull com.ucpro.feature.video.c.e.c.c cVar) {
        com.ucweb.common.util.c.a((Object) cVar);
        if (cVar.a != 0) {
            com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), cVar.c(), this.a, this.b, com.ucpro.feature.video.c.a.a.a(cVar));
            return;
        }
        ArrayList arrayList = cVar.c;
        if (arrayList == null || arrayList.size() == 0) {
            com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), cVar.c(), this.a, this.b, com.ucpro.feature.video.c.d.a.VPS_RESPONSE_VIDEO_LIST_SIZE_ZERO);
            return;
        }
        com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), this.a, com.ucpro.feature.video.c.a.a.a(cVar, this.a), this.b);
    }

    public final void a(@NonNull com.ucpro.feature.video.c.e.b.a aVar, String str) {
        com.ucweb.common.util.c.a((Object) aVar);
        com.ucweb.common.util.c.a(this.b);
        if (b.b()) {
            new StringBuilder("VpsReparseHandleronVpsResponseFail:errorCode=").append(str).append(",resolution=").append(this.a);
        }
        com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), aVar.c(), this.a, this.b, com.ucpro.feature.video.c.d.a.VPS_RESPONSE_VIDEO_LIST_SIZE_ZERO);
    }
}
