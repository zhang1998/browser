package com.ucpro.feature.video.c.c;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.ucpro.feature.video.c.a;
import com.ucpro.feature.video.c.b.c;
import com.ucpro.feature.video.c.b.e;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: ProGuard */
final class b implements c {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ a c;

    b(a aVar, String str, a aVar2) {
        this.c = aVar;
        this.a = str;
        this.b = aVar2;
    }

    public final void a(@NonNull com.ucpro.feature.video.c.e.b.a aVar, String str) {
        if (this.b != null) {
            String str2;
            Handler handler = new Handler(Looper.getMainLooper());
            String c = aVar.c();
            if (aVar.b == null) {
                str2 = null;
            } else {
                str2 = aVar.b.toString();
            }
            com.ucpro.feature.video.c.a.a.a(handler, c, str2, this.b, com.ucpro.feature.video.c.d.a.VPS_VIDEO_LIST_RESPOND_PB_ERROR);
        }
        if (aVar != null) {
            Log.w("VpsStandardHandler", "onVpsResponseFail:errorCode=" + str + ", pageurl=" + aVar.c());
        }
        com.ucweb.common.util.c.a((Object) aVar);
    }

    public final void a(@NonNull com.ucpro.feature.video.c.e.c.c cVar) {
        if (cVar.a != 0) {
            com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), cVar.c(), this.a, this.b, com.ucpro.feature.video.c.a.a.a(cVar));
            return;
        }
        Collection collection = cVar.d;
        if (collection == null || collection.size() <= 0) {
            collection = null;
        }
        if (collection == null || collection.size() <= 0) {
            ArrayList arrayList = cVar.c;
            if (arrayList == null || arrayList.size() == 0) {
                Log.e("hjw", "..." + cVar.b);
                com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), cVar.c(), this.a, this.b, com.ucpro.feature.video.c.d.a.VPS_RESPONSE_VIDEO_LIST_SIZE_ZERO);
                return;
            }
            arrayList = com.ucpro.feature.video.c.a.a.a(cVar, this.a);
            if (this.b == null) {
                return;
            }
            if (arrayList.size() > 0) {
                com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), this.a, arrayList, this.b);
                return;
            } else {
                com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), cVar.c(), this.a, this.b, com.ucpro.feature.video.c.d.a.VPS_RESOLUTION_LIST_SIZE_ZERO);
                return;
            }
        }
        d dVar = new d();
        String c = cVar.c();
        CharSequence charSequence = this.a;
        Object obj = this.b;
        com.ucweb.common.util.c.a(collection);
        com.ucpro.feature.video.c.e.b.a a = com.ucpro.feature.video.c.e.a.a(c, charSequence);
        a.g.addAll(collection);
        com.ucweb.common.util.c.a(charSequence);
        com.ucweb.common.util.c.a(obj);
        new e().a(a, new e(dVar, charSequence, obj));
    }
}
