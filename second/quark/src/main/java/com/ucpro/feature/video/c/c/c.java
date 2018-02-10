package com.ucpro.feature.video.c.c;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.ucpro.feature.video.c.d;
import com.ucpro.feature.video.c.e.b.a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class c implements com.ucpro.feature.video.c.b.c {
    final /* synthetic */ String a;
    final /* synthetic */ d b;
    final /* synthetic */ a c;

    c(a aVar, String str, d dVar) {
        this.c = aVar;
        this.a = str;
        this.b = dVar;
    }

    public final void a(@NonNull a aVar, String str) {
        if (this.b != null) {
            com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), this.a, this.b, com.ucpro.feature.video.c.d.a.VPS_RESOLUTION_LIST_RESPOND_PB_ERROR);
        }
        if (aVar != null) {
            Log.e("VpsStandardHandler", "onVpsResponseFail:errorCode=" + str + ", pageurl=" + aVar.c());
        }
        com.ucweb.common.util.c.a((Object) aVar);
    }

    public final void a(@NonNull com.ucpro.feature.video.c.e.c.c cVar) {
        if (cVar.a != 0) {
            com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), this.a, this.b, com.ucpro.feature.video.c.a.a.a(cVar));
            return;
        }
        Log.e("hjw", "........" + cVar.b);
        ArrayList arrayList = cVar.b;
        ArrayList arrayList2 = new ArrayList(3);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.uc.base.b.c.c cVar2 = (com.uc.base.b.c.c) it.next();
                if (cVar2 != null && cVar2.a.length > 0) {
                    arrayList2.add(cVar2.toString());
                }
            }
        }
        if (this.b == null) {
            return;
        }
        if (arrayList2.size() > 0) {
            com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), this.a, arrayList2, this.b);
        } else {
            com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), this.a, this.b, com.ucpro.feature.video.c.d.a.VPS_RESOLUTION_LIST_SIZE_ZERO);
        }
    }
}
