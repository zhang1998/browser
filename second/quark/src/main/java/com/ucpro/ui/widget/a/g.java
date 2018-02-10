package com.ucpro.ui.widget.a;

import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import com.uc.crashsdk.export.LogType;
import com.ucweb.common.util.b;
import java.util.ArrayList;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
final class g extends b<z> {
    public final /* synthetic */ void a(Message message, Object obj) {
        z zVar = (z) obj;
        View view;
        View view2;
        switch (message.what) {
            case 16:
                removeMessages(SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
                removeMessages(LogType.UNEXP);
                if (zVar.u != null) {
                    zVar.u.a();
                }
                zVar.a(zVar.f);
                n nVar = (n) zVar.d;
                zVar.o;
                nVar.a(zVar.q);
                zVar.e = null;
                zVar.o = null;
                zVar.f = -1;
                zVar.q = -1;
                return;
            case LogType.UNEXP /*256*/:
                d dVar = (d) message.obj;
                if (dVar != null) {
                    view = dVar.a;
                    view2 = dVar.b;
                    if (VERSION.SDK_INT >= 14) {
                        view.setTranslationY(0.0f);
                        view2.setTranslationY(0.0f);
                    }
                    if (VERSION.SDK_INT < 14) {
                        view2.clearAnimation();
                    }
                    view.setVisibility(0);
                    view2.setVisibility(4);
                    ((n) zVar.d).a(view, view2);
                    return;
                }
                return;
            case SpdyProtocol.SLIGHTSSL_0_RTT_MODE /*4096*/:
                ArrayList arrayList = (ArrayList) message.obj;
                int size = arrayList.size();
                for (int i = 0; i < size - 1; i++) {
                    view = (View) arrayList.get(i);
                    view2 = (View) arrayList.get(i + 1);
                    if (VERSION.SDK_INT >= 14) {
                        view.setTranslationY(0.0f);
                        view2.setTranslationY(0.0f);
                    } else {
                        if (view.getAnimation() != null) {
                            view.clearAnimation();
                        }
                        if (view2.getAnimation() != null) {
                            view2.clearAnimation();
                        }
                    }
                    if (i == 0) {
                        view.setVisibility(0);
                    }
                    if (i + 1 >= size - 1) {
                        view2.setVisibility(4);
                    }
                    ((n) zVar.d).a(view, view2);
                }
                return;
            default:
                return;
        }
    }
}
