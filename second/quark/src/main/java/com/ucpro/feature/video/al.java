package com.ucpro.feature.video;

import android.content.Context;
import com.uc.media.interfaces.PlayerType;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class al {
    private static aa<an> a = new aa();

    public static an a(Context context, PlayerType playerType, b bVar, Integer num, boolean z) {
        an anVar = null;
        switch (r.a[playerType.ordinal()]) {
            case 1:
                anVar = new VideoViewImpl(context, num, z);
                break;
        }
        if (!(anVar == null || bVar == null)) {
            anVar.a((at) bVar);
            anVar.a((am) bVar);
            anVar.a((ab) bVar);
            anVar.a((v) bVar);
            anVar.a((d) bVar);
            anVar.a((as) bVar);
            anVar.a((w) bVar);
            anVar.a((c) bVar);
            anVar.a((l) bVar);
            anVar.a((aj) bVar);
            anVar.a((af) bVar);
            anVar.a((y) bVar);
            anVar.a((ai) bVar);
        }
        aa aaVar = a;
        while (true) {
            Reference poll = aaVar.b.poll();
            if (poll != null) {
                aaVar.a.remove(poll);
            } else {
                aaVar.a.add(new WeakReference(anVar, aaVar.b));
                return anVar;
            }
        }
    }
}
